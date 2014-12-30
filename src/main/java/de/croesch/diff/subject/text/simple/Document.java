package de.croesch.diff.subject.text.simple;

import de.croesch.diff.subject.api.Subject;
import de.croesch.diff.subject.text.TextualSplittableSubject;

import java.util.List;
import java.util.Stack;

/**
 * This is a document is a full text that is simple in terms of just plain text. It consists of paragraphs, sentences,
 * words and characters.
 */
public class Document extends TextualSplittableSubject {
  public static final Character CARRIAGE_RETURN = new Character('\r');
  public static final Character LINE_FEED = new Character('\n');

  public Document(String s) {
    super(s);
  }

  @Override
  protected boolean shouldSplitAt(int i, Character character) {
    boolean isCarriageReturn = character.equals(CARRIAGE_RETURN);
    return (isCarriageReturn || character.equals(LINE_FEED)) && containsBreakTillNextNonWhitespace(i + 1,
        isCarriageReturn);
  }

  private boolean containsBreakTillNextNonWhitespace(int begin, boolean isCarriageReturn) {
    for (int i = begin; i < getContent().length(); ++i) {
      Character character = new Character(getContent().charAt(i));
      if (character.equals(CARRIAGE_RETURN)) {
        return true;
      }
      if (character.equals(LINE_FEED) && (i > begin || !isCarriageReturn)) {
        return true;
      }
      if (String.valueOf(character.charValue()).matches("\\S")) {
        return false;
      }
    }
    return false;
  }

  @Override
  protected Subject newSubject(String content) {
    return new Sentence(content);
  }

  @Override
  protected void endReached(List<Subject> children, int begin, Character cc) {
    Stack<Character> whitespaces = new Stack<>();
    for (int i = getContent().length() - 1; i >= begin; --i) {
      Character character = new Character(getContent().charAt(i));
      if (String.valueOf(character.charValue()).matches("\\s")) {
        whitespaces.push(character);
      } else {
        break;
      }
    }
    addSubject(children, begin, getContent().length() - whitespaces.size());
    while (!whitespaces.isEmpty()) {
      children.add(new de.croesch.diff.subject.text.Character(whitespaces.pop()));
    }
  }

  @Override
  protected int addDivider(List<Subject> children, int begin, Character cc) {
    int inserted = 0;
    for (int i = begin; i < getContent().length(); ++i) {
      Character character = new Character(getContent().charAt(i));
      if (String.valueOf(character.charValue()).matches("\\s")) {
        children.add(new de.croesch.diff.subject.text.Character(character));
        ++inserted;
      } else {
        break;
      }
    }

    return inserted;
  }
}
