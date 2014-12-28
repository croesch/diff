package de.croesch.diff.subject.api;

import java.util.List;

/** A subject is a part of the diff that can be uniquely identified and that might be split up into smaller subjects. */
public interface Subject {
  /**
   * Returns the sub-subjects. These children/sub-subjects built this subject.
   *
   * @return a {@link java.util.List} of {@link Subject}s that might be empty but never {@code null}.
   */
  public List<Subject> getChildren();
}
