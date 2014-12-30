package de.croesch.diff.subject.text;

import de.croesch.diff.subject.api.Subject;

import java.lang.Character;
import java.util.Collection;
import java.util.List;

/**
 * This is a more high level subject that is based on a string which can be split at several positions, dividing this
 * subject into sub-subjects and the sub-subject dividers.
 */
public abstract class TextualSubjectContainerSubject extends TextualSplittableSubject {
  private final Collection<Character> delimiters;

  public TextualSubjectContainerSubject(String s, Collection<Character> delimiters) {
    super(s);
    this.delimiters = delimiters;
  }

  @Override
  protected boolean shouldSplitAt(int i, Character character) {
    return delimiters.contains(character);
  }

  @Override
  protected int addDivider(List<Subject> children, int begin, Character character) {
    children.add(new de.croesch.diff.subject.text.Character(character));
    return 1;
  }

  @Override
  protected void endReached(List<Subject> children, int begin, Character character) {
    addSubject(children, begin, getContent().length());
  }
}
