package de.croesch.diff.subject.text.simple;

import de.croesch.diff.subject.api.Subject;
import de.croesch.diff.subject.text.TextualSubjectContainerSubject;
import de.croesch.diff.subject.text.Word;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

/** A sentence is a couple of words. It is used to split a text into logical chunks. */
public class Sentence extends TextualSubjectContainerSubject {
  private static final Collection<Character> DELIMITERS = new HashSet<>(Arrays.asList(
      new Character(' '),
      new Character('\r'),
      new Character('\n'),
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

  public Sentence(String s) {
    super(s, DELIMITERS);
  }

  @Override
  protected Subject newSubject(String content) {
    return new Word(content);
  }
}
