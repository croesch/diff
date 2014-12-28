package de.croesch.diff.subject.text;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Test_Word_equals {

  @Test
  public void should_Not_Be_Equal_To_Null() {
    assertThat(new Word("abc")).isNotEqualTo(null);
  }

  @Test
  public void should_Return_Consistently_False_If_Not_Equals() {
    Word word1 = new Word("abc");
    Word word2 = new Word("ABC");
    assertThat(word1).isNotEqualTo(word2);
    assertThat(word1).isNotEqualTo(word2);
  }

  @Test
  public void should_Return_Consistently_True_If_Equals() {
    Word word1 = new Word("abc");
    Word word2 = new Word("abc");
    assertThat(word1).isEqualTo(word2);
    assertThat(word1).isEqualTo(word2);
  }

  @Test
  public void should_Be_Transitive_If_Equals() {
    Word word1 = new Word("abc");
    Word word2 = new Word("abc");
    Word word3 = new Word("abc");
    assertThat(word1).isEqualTo(word2);
    assertThat(word2).isEqualTo(word3);

    assertThat(word1).isEqualTo(word3);
  }

  @Test
  public void should_Be_Transitive_If_Not_Equals() {
    Word word1 = new Word("abc");
    Word word2 = new Word("abc");
    Word word3 = new Word("ABC");
    assertThat(word1).isEqualTo(word2);
    assertThat(word2).isNotEqualTo(word3);

    assertThat(word1).isNotEqualTo(word3);
  }

  @Test
  public void should_Be_Symmetric() {
    Word word1 = new Word("abc");
    Word word2 = new Word("abc");
    assertThat(word1).isEqualTo(word2);
    assertThat(word2).isEqualTo(word1);
  }

  @Test
  public void should_Be_Reflexive() {
    Word word1 = new Word("abc");
    assertThat(word1).isEqualTo(word1);
  }
}