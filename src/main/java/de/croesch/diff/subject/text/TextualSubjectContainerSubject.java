package de.croesch.diff.subject.text;

import de.croesch.diff.subject.api.Subject;

import java.lang.Character;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * This is a more high level subject that is based on a string which can be split at several positions, dividing this
 * subject into sub-subjects and the sub-subject dividers.
 */
public abstract class TextualSubjectContainerSubject extends TextualSubject<String> {
  private final Collection<Character> delimiters;

  public TextualSubjectContainerSubject(String s, Collection<Character> delimiters) {
    super(s);
    this.delimiters = delimiters;
  }

  @Override
  public final List<Subject> getChildren() {
    List<Subject> children = new ArrayList<>();

    int begin = 0;
    for (int i = 0; i < getContent().length(); ++i) {
      java.lang.Character character = new java.lang.Character(getContent().charAt(i));
      if (delimiters.contains(character)) {
        addSubject(children, begin, i);
        addCharacter(children, character);
        begin = i + 1;
      } else if (i + 1 == getContent().length()) {
        addSubject(children, begin, getContent().length());
      }
    }

    return children;
  }


  private void addCharacter(List<Subject> children, Character character) {
    children.add(new de.croesch.diff.subject.text.Character(character));
  }

  private void addSubject(List<Subject> children, int begin, int end) {
    if (end > begin) {
      children.add(newSubject(getContent().substring(begin, end)));
    }
  }

  protected abstract Subject newSubject(String content);
}
