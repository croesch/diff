package de.croesch.diff.subject.text.simple;

import de.croesch.diff.subject.text.Character;
import de.croesch.diff.subject.text.Word;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Test_Sentence_getChildren {
  @Test
  public void should_Be_Empty_If_Sentence_Is_Empty() {
    assertThat(new Sentence("").getChildren()).isEmpty();
  }

  @Test
  public void should_Return_One_Child_If_Consists_Of_One_NonWordCharacter() {
    assertThat(new Sentence(" ").getChildren()).containsExactly(new Character(' '));
  }

  @Test
  public void should_Return_One_Child_If_Consists_Of_One_Word() {
    assertThat(new Sentence("super").getChildren()).containsExactly(new Word("super"));
  }

  @Test
  public void should_Add_NewSentence_As_Character() {
    assertThat(new Sentence("super\n").getChildren()).containsExactly(new Word("super"), new Character('\n'));
  }

  @Test
  public void should_Add_White_Spaces_As_Character() {
    assertThat(new Sentence("one word\tis").getChildren()).containsExactly(new Word("one"), new Character(' '), new Word
        ("word"), new Character('\t'), new Word("is"));
  }

  @Test
  public void should_Add_Multiple_White_Spaces_As_Characters() {
    assertThat(new Sentence("one  \tis").getChildren()).containsExactly(new Word("one"), new Character(' '), new
        Character(' '), new Character('\t'), new Word("is"));
  }
}