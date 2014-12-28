package de.croesch.diff.subject;

import de.croesch.diff.subject.api.Subject;

/**
 * The basic implementation of a Subject, contains code that all Subjects share.
 *
 * @param <CT> the type of the content this subject represents
 */
public abstract class BasicSubject<CT extends Object> implements Subject {
  /** the representation of the value/content of this subject. */
  private CT content;

  public BasicSubject(CT ct) {
    content = ct;
  }

  @Override
  public int hashCode() {
    return content.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof BasicSubject)) {
      return false;
    }
    return content.equals(((BasicSubject) obj).content);
  }

  protected CT getContent() {
    return content;
  }
}
