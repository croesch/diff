package de.croesch.diff.subject.text;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Test_Word_hashCode {

  @Test
  public void should_Always_Return_Same_Integer() {
    Word word = new Word("abc");
    assertThat(word.hashCode()).isEqualTo(word.hashCode());
  }

  @Test
  public void should_Return_Same_Integer_For_Same_Word() {
    assertThat(new Word("abc").hashCode()).isEqualTo(new Word("abc").hashCode());
  }

  @Test
  public void should_Return_Different_Integer_For_Different_Word() {
    assertThat(new Word("abc").hashCode()).isNotEqualTo(new Word("ABC").hashCode());
  }
}