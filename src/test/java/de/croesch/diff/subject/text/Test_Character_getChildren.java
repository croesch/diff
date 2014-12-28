package de.croesch.diff.subject.text;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Test_Character_getChildren {

  @Test
  public void should_Be_Empty() {
    assertThat(new Character('.').getChildren()).isEmpty();
    assertThat(new Character('M').getChildren()).isEmpty();
  }
}