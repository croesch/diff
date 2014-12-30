package de.croesch.diff.subject.text.linebased;

import de.croesch.diff.subject.api.Subject;
import de.croesch.diff.subject.text.TextualSubjectContainerSubject;
import de.croesch.diff.subject.text.Word;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

/**
 * A line is a line as in line feed or line break. It is used to split a text into chunks as most other diff algorithms
 * do.
 */
public class Line extends TextualSubjectContainerSubject {
  private static final Collection<Character> DELIMITERS = new HashSet<>(Arrays.asList(
      new Character(' '),
      new Character('\t'),
      new Character((char) 0x0b),
      new Character('\f'),
      new Character('.'),
      new Character(','),
      new Character('?'),
      new Character('!'),
      new Character('"'),
      new Character('\''),
      new Character(':'),
      new Character(';')
  ));

  public Line(String s) {
    super(s, DELIMITERS);
  }

  @Override
  protected Subject newSubject(String content) {
    return new Word(content);
  }
}
