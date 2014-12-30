package de.croesch.diff.subject.text.linebased;

import de.croesch.diff.subject.text.Character;
import de.croesch.diff.subject.text.Word;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Test_Line_getChildren {
  @Test
  public void should_Be_Empty_If_Line_Is_Empty() {
    assertThat(new Line("").getChildren()).isEmpty();
  }

  @Test
  public void should_Return_One_Child_If_Consists_Of_One_NonWordCharacter() {
    assertThat(new Line(" ").getChildren()).containsExactly(new Character(' '));
  }

  @Test
  public void should_Return_One_Child_If_Consists_Of_One_Word() {
    assertThat(new Line("super").getChildren()).containsExactly(new Word("super"));
  }

  @Test
  public void should_Add_White_Spaces_As_Character() {
    assertThat(new Line("one word\tis").getChildren()).containsExactly(new Word("one"), new Character(' '), new Word
        ("word"), new Character('\t'), new Word("is"));
  }

  @Test
  public void should_Add_Multiple_White_Spaces_As_Characters() {
    assertThat(new Line("one  \tis").getChildren()).containsExactly(new Word("one"), new Character(' '), new
        Character(' '), new Character('\t'), new Word("is"));
  }
}