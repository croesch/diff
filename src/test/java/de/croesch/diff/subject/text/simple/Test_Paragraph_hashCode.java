package de.croesch.diff.subject.text.simple;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Test_Paragraph_hashCode {
  private Paragraph exampleParagraph1 = new Paragraph("The third-rate mind is only happy when it is thinking with the " +
      "majority. The second-rate mind is only\nhappy when it is thinking with the minority. The first-rate mind is " +
      "only happy when it is thinking.");
  private Paragraph exampleParagraph2 = new Paragraph("Now\rit\nbegins.");

  @Test
  public void should_Always_Return_Same_Integer() {
    assertThat(exampleParagraph1.hashCode()).isEqualTo(exampleParagraph1.hashCode());
  }

  @Test
  public void should_Return_Same_Integer_For_Same_Word() {
    Paragraph paragraph1 = new Paragraph("Now\rit\nbegins.");
    Paragraph paragraph2 = new Paragraph("Now\rit\nbegins.");
    assertThat(paragraph1.hashCode()).isEqualTo(paragraph2.hashCode());
  }

  @Test
  public void should_Return_Different_Integer_For_Different_Word() {
    assertThat(exampleParagraph1.hashCode()).isNotEqualTo(exampleParagraph2.hashCode());
  }
}