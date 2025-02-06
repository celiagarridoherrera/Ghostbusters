package dev.erica.ghostbusters.model;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GhostClassTest {
    @Test
    @DisplayName("Test GhostClass")
    public void testGetDescription() {
        GhostClass ghostClass = GhostClass.CLASS_I;
        assertThat(ghostClass.getDescription(), is("Clase I - Manifestación menor"));
    }

}
