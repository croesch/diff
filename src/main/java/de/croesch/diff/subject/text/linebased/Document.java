package de.croesch.diff.subject.text.linebased;

import de.croesch.diff.subject.api.Subject;
import de.croesch.diff.subject.text.TextualSubjectContainerSubject;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

/** This is a document is a full text that is line based. */
public class Document extends TextualSubjectContainerSubject {
  private static final Collection<Character> DELIMITERS = new HashSet<>(Arrays.asList(
      new Character('\r'),
      new Character('\n')
  ));

  public Document(String s) {
    super(s, DELIMITERS);
  }

  @Override
  protected Subject newSubject(String content) {
    return new Line(content);
  }
}
