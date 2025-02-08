package dev.erica.ghostbusters.view;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.matchesPattern;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import dev.erica.ghostbusters.model.GhostClass;
import dev.erica.ghostbusters.model.GhostModel;

public class GhostViewTest {

    @Test
    @DisplayName("Test de la lista de fantasmas capturados")
    public void testShowGhosts() {
        GhostModel ghost1 = new GhostModel("Pepito", GhostClass.CLASS_I, "Alto", "Invisible", "01-01-2025");
        GhostModel ghost2 = new GhostModel("Menganito", GhostClass.CLASS_II, "Medio", "Telequinesis", "02-01-2025");
        List<GhostModel> ghosts = Arrays.asList(ghost1, ghost2);

        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
    
        GhostView ghostView = new GhostView();
        ghostView.showGhosts(ghosts);
    
        assertThat(outputStreamCaptor.toString(), containsString("Fantasmas capturados"));
        assertThat(outputStreamCaptor.toString(), containsString("ID   Nombre                          Clase                Peligrosidad  Fecha"));
        assertThat(outputStreamCaptor.toString(), matchesPattern("(?s).*1\\s+Pepito\\s+Clase I - Manifestación menor\\s+Alto\\s+01-01-2025.*"));
        assertThat(outputStreamCaptor.toString(), matchesPattern("(?s).*2\\s+Menganito\\s+Clase II - Aparición móvil\\s+Medio\\s+02-01-2025.*"));
        assertThat(outputStreamCaptor.toString(), containsString("Total: 2"));
        System.setOut(System.out);
    }
}
