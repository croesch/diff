package de.croesch.diff.subject.text;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Test_Character_hashCode {

  @Test
  public void should_Always_Return_Same_Integer() {
    Character character = new Character('c');
    assertThat(character.hashCode()).isEqualTo(character.hashCode());
  }

  @Test
  public void should_Return_Same_Integer_For_Same_Character() {
    assertThat(new Character('c').hashCode()).isEqualTo(new Character('c').hashCode());
    assertThat(new Character('c').hashCode()).isEqualTo(new Character(new java.lang.Character('c')).hashCode());
    assertThat(new Character(new java.lang.Character('c')).hashCode()).isEqualTo(new Character(new java.lang.Character('c')).hashCode());
  }

  @Test
  public void should_Return_Different_Integer_For_Different_Character() {
    assertThat(new Character('c').hashCode()).isNotEqualTo(new Character('C').hashCode());
  }
}