package de.croesch.diff.subject.text;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Test_Word_getChildren {

  @Test
  public void should_Be_Empty_If_Word_Is_Empty() {
    assertThat(new Word("").getChildren()).isEmpty();
  }

  @Test
  public void should_Return_One_Child_If_Consists_Of_One_Character() {
    assertThat(new Word("a").getChildren()).containsExactly(new Character('a'));
  }

  @Test
  public void should_Return_One_Child_For_Each_Character_In_Same_Order() {
    assertThat(new Word("abc").getChildren()).containsExactly(new Character('a'), new Character('b'), new Character('c'));
  }
}