package de.croesch.diff.subject.text.linebased;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Test_Line_hashCode {
  private Line exampleLine1 = new Line("The third-rate mind is only happy when it is thinking with the majority. The " +
      "second-rate mind is only\n");
  private Line exampleLine2 = new Line("happy when it is thinking with the minority. The first-rate mind is only " +
      "happy when it is thinking.");

  @Test
  public void should_Always_Return_Same_Integer() {
    assertThat(exampleLine1.hashCode()).isEqualTo(exampleLine1.hashCode());
  }

  @Test
  public void should_Return_Same_Integer_For_Same_Word() {
    Line line1 = new Line("The third-rate mind is only happy when it is thinking with the majority. The " +
        "second-rate mind is only\n");
    Line line2 = new Line("The third-rate mind is only happy when it is thinking with the majority. The " +
        "second-rate mind is only\n");
    assertThat(line1.hashCode()).isEqualTo(line2.hashCode());
  }

  @Test
  public void should_Return_Different_Integer_For_Different_Word() {
    assertThat(exampleLine1.hashCode()).isNotEqualTo(exampleLine2.hashCode());
  }
}