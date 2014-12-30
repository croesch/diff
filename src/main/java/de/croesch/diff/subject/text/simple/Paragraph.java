package de.croesch.diff.subject.text.simple;

import de.croesch.diff.subject.api.Subject;
import de.croesch.diff.subject.text.TextualSubjectContainerSubject;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/** A paragraph is a bunch of sentences. Multiple paragraphs are usually separated by more than one line feed. */
public class Paragraph extends TextualSubjectContainerSubject {
  private static final Collection<Character> DELIMITERS = new HashSet<>(Arrays.asList(
      new Character('.'),
      new Character('?'),
      new Character('!')
  ));

  public Paragraph(String s) {
    super(s, DELIMITERS);
  }

  @Override
  protected Subject newSubject(String content) {
    return new Sentence(content);
  }

  @Override
  protected int addDivider(List<Subject> children, int begin, Character cc) {
    int inserted = 0;
    for (int i = begin; i < getContent().length(); ++i) {
      Character character = new Character(getContent().charAt(i));
      if (String.valueOf(character.charValue()).matches("\\s") || DELIMITERS.contains(character)) {
        children.add(new de.croesch.diff.subject.text.Character(character));
        ++inserted;
      } else {
        break;
      }
    }

    return inserted;
  }
}
