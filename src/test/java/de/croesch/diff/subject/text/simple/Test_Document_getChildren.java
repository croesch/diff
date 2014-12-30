package de.croesch.diff.subject.text.simple;

import de.croesch.diff.subject.text.Character;
import de.croesch.diff.subject.text.linebased.*;
import de.croesch.diff.subject.text.linebased.Document;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Test_Document_getChildren {
  @Test
  public void should_Be_Empty_If_Document_Is_Empty() {
    assertThat(new de.croesch.diff.subject.text.linebased.Document("").getChildren()).isEmpty();
  }

  @Test
  public void should_Return_One_Child_If_Consists_Of_One_CarriageReturn() {
    assertThat(new de.croesch.diff.subject.text.linebased.Document("\r").getChildren()).containsExactly(new Character('\r'));
  }

  @Test
  public void should_Return_One_Child_If_Consists_Of_One_LineFeed() {
    assertThat(new de.croesch.diff.subject.text.linebased.Document("\n").getChildren()).containsExactly(new Character('\n'));
  }

  @Test
  public void should_Return_One_Child_If_Consists_Of_One_Line() {
    assertThat(new de.croesch.diff.subject.text.linebased.Document("super").getChildren()).containsExactly(new Line("super"));
  }

  @Test
  public void should_Add_NewLine_As_Character() {
    assertThat(new de.croesch.diff.subject.text.linebased.Document("super\n").getChildren()).containsExactly(new Line("super"), new Character('\n'));
  }

  @Test
  public void should_Add_CarriageReturn_As_Character() {
    assertThat(new de.croesch.diff.subject.text.linebased.Document("super\r").getChildren()).containsExactly(new Line("super"), new Character('\r'));
  }

  @Test
  public void should_Add_CarriageReturn_LineFeed_As_Characters() {
    assertThat(new Document("one\r\nis").getChildren()).containsExactly(new Line("one"), new Character('\r'), new
        Character('\n'), new Line("is"));
  }
}