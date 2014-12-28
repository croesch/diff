package de.croesch.diff.subject.text;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Test_Character_equals {

  @Test
  public void should_Not_Be_Equal_To_Null() {
    assertThat(new Character('c')).isNotEqualTo(null);
  }

  @Test
  public void should_Return_Consistently_False_If_Not_Equals() {
    Character character1 = new Character('c');
    Character character2 = new Character('d');
    assertThat(character1).isNotEqualTo(character2);
    assertThat(character1).isNotEqualTo(character2);
  }

  @Test
  public void should_Return_Consistently_True_If_Equals() {
    Character character1 = new Character('c');
    Character character2 = new Character('c');
    assertThat(character1).isEqualTo(character2);
    assertThat(character1).isEqualTo(character2);
  }

  @Test
  public void should_Be_Transitive_If_Equals() {
    Character character1 = new Character('c');
    Character character2 = new Character('c');
    Character character3 = new Character('c');
    assertThat(character1).isEqualTo(character2);
    assertThat(character2).isEqualTo(character3);

    assertThat(character1).isEqualTo(character3);
  }

  @Test
  public void should_Be_Transitive_If_Not_Equals() {
    Character character1 = new Character('c');
    Character character2 = new Character('c');
    Character character3 = new Character('d');
    assertThat(character1).isEqualTo(character2);
    assertThat(character2).isNotEqualTo(character3);

    assertThat(character1).isNotEqualTo(character3);
  }

  @Test
  public void should_Be_Symmetric() {
    Character character1 = new Character('c');
    Character character2 = new Character('c');
    assertThat(character1).isEqualTo(character2);
    assertThat(character2).isEqualTo(character1);
  }

  @Test
  public void should_Be_Reflexive() {
    Character character1 = new Character('c');
    assertThat(character1).isEqualTo(character1);
  }
}