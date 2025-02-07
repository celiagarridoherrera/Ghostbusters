package dev.erica.ghostbusters.model;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.greaterThan;


public class GhostModelTest {

    @Test
    @DisplayName("Test GhostConstructor")
    public void testGhostConstructor() {
        GhostModel ghost = new GhostModel("Marcelino Paxarada", GhostClass.CLASS_II, "Bajo", "Leer la mente", "12-02-2025");
        assertThat(ghost.getID(), greaterThan(0));
        assertThat(ghost.getName(), is("Marcelino Paxarada"));
        assertThat(ghost.getGhostClass(), is(GhostClass.CLASS_II));
        assertThat(ghost.getDangerLvl(), is("Bajo"));
        assertThat(ghost.getAbility(), is("Leer la mente"));
        assertThat(ghost.getCaptureDate(), is("12-02-2025"));
    }
}
