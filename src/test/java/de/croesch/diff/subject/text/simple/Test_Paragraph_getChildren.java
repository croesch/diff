package de.croesch.diff.subject.text.simple;

import de.croesch.diff.subject.text.Character;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Test_Paragraph_getChildren {
  @Test
  public void should_Be_Empty_If_Paragraph_Is_Empty() {
    assertThat(new Paragraph("").getChildren()).isEmpty();
  }

  @Test
  public void should_Return_One_Child_If_Consists_Of_One_ExclamationMark() {
    assertThat(new Paragraph("!").getChildren()).containsExactly(new Character('!'));
  }

  @Test
  public void should_Return_One_Child_If_Consists_Of_One_QuestionMark() {
    assertThat(new Paragraph("?").getChildren()).containsExactly(new Character('?'));
  }

  @Test
  public void should_Return_One_Child_If_Consists_Of_One_Period() {
    assertThat(new Paragraph(".").getChildren()).containsExactly(new Character('.'));
  }

  @Test
  public void should_Return_One_Child_If_Consists_Of_One_Sentence() {
    assertThat(new Paragraph("super").getChildren()).containsExactly(new Sentence("super"));
  }

  @Test
  public void should_Add_ExclamationMark_As_Character() {
    assertThat(new Paragraph("super!").getChildren()).containsExactly(new Sentence("super"), new Character('!'));
  }

  @Test
  public void should_Add_QuestionMark_As_Character() {
    assertThat(new Paragraph("super?").getChildren()).containsExactly(new Sentence("super"), new Character('?'));
  }

  @Test
  public void should_Add_Whitespace_Between_Sentences_As_Characters() {
    assertThat(new Paragraph("one. is").getChildren()).containsExactly(new Sentence("one"), new Character('.'), new
        Character(' '), new Sentence("is"));
  }
}