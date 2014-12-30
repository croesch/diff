package de.croesch.diff.subject.text.simple;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Test_Paragraph_equals {
  private Paragraph exampleParagraph1 = new Paragraph("The third-rate mind is only happy when it is thinking with the " +
      "majority. The second-rate mind is only\nhappy when it is thinking with the minority. The first-rate mind is " +
      "only happy when it is thinking.");
  private Paragraph exampleParagraph2 = new Paragraph("Now\rit\nbegins.");

  @Test
  public void should_Not_Be_Equal_To_Null() {
    assertThat(exampleParagraph1).isNotEqualTo(null);
  }

  @Test
  public void should_Return_Consistently_False_If_Not_Equals() {
    Paragraph paragraph1 = exampleParagraph1;
    Paragraph paragraph2 = exampleParagraph2;
    assertThat(paragraph1).isNotEqualTo(paragraph2);
    assertThat(paragraph1).isNotEqualTo(paragraph2);
  }

  @Test
  public void should_Return_Consistently_True_If_Equals() {
    Paragraph paragraph1 = exampleParagraph1;
    Paragraph paragraph2 = exampleParagraph1;
    assertThat(paragraph1).isEqualTo(paragraph2);
    assertThat(paragraph1).isEqualTo(paragraph2);
  }

  @Test
  public void should_Be_Transitive_If_Equals() {
    Paragraph paragraph1 = exampleParagraph1;
    Paragraph paragraph2 = exampleParagraph1;
    Paragraph paragraph3 = exampleParagraph1;
    assertThat(paragraph1).isEqualTo(paragraph2);
    assertThat(paragraph2).isEqualTo(paragraph3);

    assertThat(paragraph1).isEqualTo(paragraph3);
  }

  @Test
  public void should_Be_Transitive_If_Not_Equals() {
    Paragraph paragraph1 = exampleParagraph1;
    Paragraph paragraph2 = exampleParagraph1;
    Paragraph paragraph3 = exampleParagraph2;
    assertThat(paragraph1).isEqualTo(paragraph2);
    assertThat(paragraph2).isNotEqualTo(paragraph3);

    assertThat(paragraph1).isNotEqualTo(paragraph3);
  }

  @Test
  public void should_Be_Symmetric() {
    Paragraph paragraph1 = exampleParagraph1;
    Paragraph paragraph2 = exampleParagraph1;
    assertThat(paragraph1).isEqualTo(paragraph2);
    assertThat(paragraph2).isEqualTo(paragraph1);
  }

  @Test
  public void should_Be_Reflexive() {
    Paragraph paragraph1 = exampleParagraph1;
    assertThat(paragraph1).isEqualTo(paragraph1);
  }
}