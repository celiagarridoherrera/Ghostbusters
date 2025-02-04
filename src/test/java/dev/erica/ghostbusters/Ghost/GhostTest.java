package dev.erica.ghostbusters.Ghost;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class GhostTest {

    @Test
    @DisplayName("Test GhostClass constructor")
    public void testGhostClass() {
        Ghost.GhostClass ghostClass = Ghost.GhostClass.CLASS_I;
        assertThat(ghostClass.getDescription(), is("Clase I - Manifestación menor"));
    }
}
