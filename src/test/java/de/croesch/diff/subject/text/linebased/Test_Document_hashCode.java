package de.croesch.diff.subject.text.linebased;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Test_Document_hashCode {
  private Document exampleDocument1 = new Document("The third-rate mind is only happy when it is thinking with the " +
      "majority. The second-rate mind is only\nhappy when it is thinking with the minority. The first-rate mind is " +
      "only happy when it is thinking.");
  private Document exampleDocument2 = new Document("Now\rit\nbegins.");

  @Test
  public void should_Always_Return_Same_Integer() {
    assertThat(exampleDocument1.hashCode()).isEqualTo(exampleDocument1.hashCode());
  }

  @Test
  public void should_Return_Same_Integer_For_Same_Word() {
    Document document1 = new Document("Now\rit\nbegins.");
    Document document2 = new Document("Now\rit\nbegins.");
    assertThat(document1.hashCode()).isEqualTo(document2.hashCode());
  }

  @Test
  public void should_Return_Different_Integer_For_Different_Word() {
    assertThat(exampleDocument1.hashCode()).isNotEqualTo(exampleDocument2.hashCode());
  }
}