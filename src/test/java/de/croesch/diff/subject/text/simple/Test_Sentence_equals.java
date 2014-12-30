package de.croesch.diff.subject.text.simple;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Test_Sentence_equals {
  private Sentence exampleSentence1 = new Sentence("The third-rate mind is only happy when it is thinking with the majority");
  private Sentence exampleSentence2 = new Sentence("The second-rate mind is only\nhappy when it is thinking with the minority");

  @Test
  public void should_Not_Be_Equal_To_Null() {
    assertThat(exampleSentence1).isNotEqualTo(null);
  }

  @Test
  public void should_Return_Consistently_False_If_Not_Equals() {
    Sentence sentence1 = exampleSentence1;
    Sentence sentence2 = exampleSentence2;
    assertThat(sentence1).isNotEqualTo(sentence2);
    assertThat(sentence1).isNotEqualTo(sentence2);
  }

  @Test
  public void should_Return_Consistently_True_If_Equals() {
    Sentence sentence1 = exampleSentence1;
    Sentence sentence2 = exampleSentence1;
    assertThat(sentence1).isEqualTo(sentence2);
    assertThat(sentence1).isEqualTo(sentence2);
  }

  @Test
  public void should_Be_Transitive_If_Equals() {
    Sentence sentence1 = exampleSentence1;
    Sentence sentence2 = exampleSentence1;
    Sentence sentence3 = exampleSentence1;
    assertThat(sentence1).isEqualTo(sentence2);
    assertThat(sentence2).isEqualTo(sentence3);

    assertThat(sentence1).isEqualTo(sentence3);
  }

  @Test
  public void should_Be_Transitive_If_Not_Equals() {
    Sentence sentence1 = exampleSentence1;
    Sentence sentence2 = exampleSentence1;
    Sentence sentence3 = exampleSentence2;
    assertThat(sentence1).isEqualTo(sentence2);
    assertThat(sentence2).isNotEqualTo(sentence3);

    assertThat(sentence1).isNotEqualTo(sentence3);
  }

  @Test
  public void should_Be_Symmetric() {
    Sentence sentence1 = exampleSentence1;
    Sentence sentence2 = exampleSentence1;
    assertThat(sentence1).isEqualTo(sentence2);
    assertThat(sentence2).isEqualTo(sentence1);
  }

  @Test
  public void should_Be_Reflexive() {
    Sentence sentence1 = exampleSentence1;
    assertThat(sentence1).isEqualTo(sentence1);
  }
}