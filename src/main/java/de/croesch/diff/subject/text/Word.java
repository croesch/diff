package de.croesch.diff.subject.text;

import de.croesch.diff.subject.api.Subject;

import java.util.ArrayList;
import java.util.List;

/** A word is a textual subject that is made up of characters. */
public class Word extends TextualSubject<String> {
  public Word(String content) {
    super(content);
  }

  @Override
  public List<Subject> getChildren() {
    ArrayList<Subject> children = new ArrayList<>();
    for (java.lang.Character c : getContent().toCharArray()) {
      children.add(new Character(c));
    }
    return children;
  }
}
