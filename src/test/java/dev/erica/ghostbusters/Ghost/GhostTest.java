package dev.erica.ghostbusters.Ghost;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.DisplayName;

public class GhostTest {
    @Test
    @DisplayName("Test class Ghost constructor")
    public void testGhostCreate() {
        
        public void testGhostClass() {
            Ghost.GhostClass ghostClass = Ghost.GhostClass.CLASS_I;
            assertThat(ghostClass.getDescription(), is("Clase I - Manifestación menor"));
        }
    }
}
