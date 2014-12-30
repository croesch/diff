package de.croesch.diff.subject.text.documentbased;

import de.croesch.diff.subject.text.linebased.Document;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Test_Document_equals {
  private Document exampleDocument1 = new Document("The third-rate mind is only happy when it is thinking with the " +
      "majority. The second-rate mind is only\nhappy when it is thinking with the minority. The first-rate mind is " +
      "only happy when it is thinking.");
  private Document exampleDocument2 = new Document("Now\rit\nbegins.");

  @Test
  public void should_Not_Be_Equal_To_Null() {
    assertThat(exampleDocument1).isNotEqualTo(null);
  }

  @Test
  public void should_Return_Consistently_False_If_Not_Equals() {
    Document document1 = exampleDocument1;
    Document document2 = exampleDocument2;
    assertThat(document1).isNotEqualTo(document2);
    assertThat(document1).isNotEqualTo(document2);
  }

  @Test
  public void should_Return_Consistently_True_If_Equals() {
    Document document1 = exampleDocument1;
    Document document2 = exampleDocument1;
    assertThat(document1).isEqualTo(document2);
    assertThat(document1).isEqualTo(document2);
  }

  @Test
  public void should_Be_Transitive_If_Equals() {
    Document document1 = exampleDocument1;
    Document document2 = exampleDocument1;
    Document document3 = exampleDocument1;
    assertThat(document1).isEqualTo(document2);
    assertThat(document2).isEqualTo(document3);

    assertThat(document1).isEqualTo(document3);
  }

  @Test
  public void should_Be_Transitive_If_Not_Equals() {
    Document document1 = exampleDocument1;
    Document document2 = exampleDocument1;
    Document document3 = exampleDocument2;
    assertThat(document1).isEqualTo(document2);
    assertThat(document2).isNotEqualTo(document3);

    assertThat(document1).isNotEqualTo(document3);
  }

  @Test
  public void should_Be_Symmetric() {
    Document document1 = exampleDocument1;
    Document document2 = exampleDocument1;
    assertThat(document1).isEqualTo(document2);
    assertThat(document2).isEqualTo(document1);
  }

  @Test
  public void should_Be_Reflexive() {
    Document document1 = exampleDocument1;
    assertThat(document1).isEqualTo(document1);
  }
}