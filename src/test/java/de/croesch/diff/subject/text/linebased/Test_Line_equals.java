package de.croesch.diff.subject.text.linebased;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Test_Line_equals {
  private Line exampleLine1 = new Line("The third-rate mind is only happy when it is thinking with the majority. The " +
      "second-rate mind is only\n");
  private Line exampleLine2 = new Line("happy when it is thinking with the minority. The first-rate mind is only " +
      "happy when it is thinking.");

  @Test
  public void should_Not_Be_Equal_To_Null() {
    assertThat(exampleLine1).isNotEqualTo(null);
  }

  @Test
  public void should_Return_Consistently_False_If_Not_Equals() {
    Line line1 = exampleLine1;
    Line line2 = exampleLine2;
    assertThat(line1).isNotEqualTo(line2);
    assertThat(line1).isNotEqualTo(line2);
  }

  @Test
  public void should_Return_Consistently_True_If_Equals() {
    Line line1 = exampleLine1;
    Line line2 = exampleLine1;
    assertThat(line1).isEqualTo(line2);
    assertThat(line1).isEqualTo(line2);
  }

  @Test
  public void should_Be_Transitive_If_Equals() {
    Line line1 = exampleLine1;
    Line line2 = exampleLine1;
    Line line3 = exampleLine1;
    assertThat(line1).isEqualTo(line2);
    assertThat(line2).isEqualTo(line3);

    assertThat(line1).isEqualTo(line3);
  }

  @Test
  public void should_Be_Transitive_If_Not_Equals() {
    Line line1 = exampleLine1;
    Line line2 = exampleLine1;
    Line line3 = exampleLine2;
    assertThat(line1).isEqualTo(line2);
    assertThat(line2).isNotEqualTo(line3);

    assertThat(line1).isNotEqualTo(line3);
  }

  @Test
  public void should_Be_Symmetric() {
    Line line1 = exampleLine1;
    Line line2 = exampleLine1;
    assertThat(line1).isEqualTo(line2);
    assertThat(line2).isEqualTo(line1);
  }

  @Test
  public void should_Be_Reflexive() {
    Line line1 = exampleLine1;
    assertThat(line1).isEqualTo(line1);
  }
}