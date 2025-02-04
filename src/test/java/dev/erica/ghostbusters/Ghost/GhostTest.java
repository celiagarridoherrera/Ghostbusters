package dev.erica.ghostbusters.Ghost;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.greaterThan;

public class GhostTest {

    @Test
    @DisplayName("Test GhostClass constructor")
    public void testGhostClass() {
        Ghost.GhostClass ghostClass = Ghost.GhostClass.CLASS_I;
        assertThat(ghostClass.getDescription(), is("Clase I - Manifestación menor"));
    }

    @Test
    @DisplayName("Test GhostConstructor")
    public void testGhostConstructor() {
        Ghost ghost = new Ghost("Marcelino Paxarada", Ghost.GhostClass.CLASS_II, "Bajo", "Leer la mente", "12-02-2025");
        assertThat(ghost.getID(), greaterThan(0));
        assertThat(ghost.getName(), is("Marcelino Paxarada"));
        assertThat(ghost.getGhostClass(), is(Ghost.GhostClass.CLASS_II));
        assertThat(ghost.getGender(), is("Bajo"));
        assertThat(ghost.getPower(), is("Leer la mente"));
        assertThat(ghost.getDate(), is("12-02-2025"));
    }
}
