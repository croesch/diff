package de.croesch.diff.subject.text.simple;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Test_Sentence_hashCode {
  private Sentence exampleSentence1 = new Sentence("The third-rate mind is only happy when it is thinking with the majority");
  private Sentence exampleSentence2 = new Sentence("The second-rate mind is only\nhappy when it is thinking with the minority");

  @Test
  public void should_Always_Return_Same_Integer() {
    assertThat(exampleSentence1.hashCode()).isEqualTo(exampleSentence1.hashCode());
  }

  @Test
  public void should_Return_Same_Integer_For_Same_Word() {
    Sentence sentence1 = new Sentence("The third-rate mind is only happy when it is thinking with the majority");
    Sentence sentence2 = new Sentence("The third-rate mind is only happy when it is thinking with the majority");
    assertThat(sentence1.hashCode()).isEqualTo(sentence2.hashCode());
  }

  @Test
  public void should_Return_Different_Integer_For_Different_Word() {
    assertThat(exampleSentence1.hashCode()).isNotEqualTo(exampleSentence2.hashCode());
  }
}