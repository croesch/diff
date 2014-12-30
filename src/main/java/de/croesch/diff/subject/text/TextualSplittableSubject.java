package de.croesch.diff.subject.text;

import de.croesch.diff.subject.api.Subject;

import java.lang.Character;
import java.util.ArrayList;
import java.util.List;

/**
 * This is a more high level subject that is based on a string which can be split at several positions, dividing this
 * subject into sub-subjects and the sub-subject dividers.
 */
public abstract class TextualSplittableSubject extends TextualSubject<String> {
  public TextualSplittableSubject(String s) {
    super(s);
  }

  @Override
  public final List<Subject> getChildren() {
    List<Subject> children = new ArrayList<>();

    int begin = 0;
    for (int i = 0; i < getContent().length(); ++i) {
      Character character = new Character(getContent().charAt(i));
      if (shouldSplitAt(i, character)) {
        addSubject(children, begin, i);
        int dividerSize = addDivider(children, i, character);
        begin = i + dividerSize;
        i += dividerSize - 1;
      } else if (i + 1 == getContent().length()) {
        endReached(children, begin, character);
      }
    }

    return children;
  }

  protected final void addSubject(List<Subject> children, int begin, int end) {
    if (end > begin) {
      children.add(newSubject(getContent().substring(begin, end)));
    }
  }

  protected abstract boolean shouldSplitAt(int i, Character character);

  protected abstract Subject newSubject(String content);

  protected abstract void endReached(List<Subject> children, int begin, Character character);

  protected abstract int addDivider(List<Subject> children, int begin, Character character);
}
