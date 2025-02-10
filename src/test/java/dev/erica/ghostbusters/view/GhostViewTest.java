package dev.erica.ghostbusters.view;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.matchesPattern;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import dev.erica.ghostbusters.model.GhostClass;
import dev.erica.ghostbusters.model.GhostModel;

public class GhostViewTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private GhostView ghostView;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
        ghostView = new GhostView();
    }

    @AfterEach
    void setOut() {
        System.setOut(originalOut);
    }

    @Test
    @DisplayName("Test de la lista de fantasmas capturados")
    void testShowGhosts() {
        GhostModel ghost1 = new GhostModel("Pepito", GhostClass.CLASS_I, "Alto", "Invisible", "01-01-2025");
        GhostModel ghost2 = new GhostModel("Menganito", GhostClass.CLASS_II, "Medio", "Telequinesis", "02-01-2025");
        List<GhostModel> ghosts = List.of(ghost1, ghost2);

        ghostView.showGhosts(ghosts);

        String output = outputStreamCaptor.toString();

        assertThat(output, containsString("Fantasmas capturados"));
        assertThat(output, containsString("ID   Nombre                          Clase                Peligrosidad  Fecha"));
        assertThat(output, matchesPattern("(?s).*1\\s+Pepito\\s+Clase I - Manifestación menor\\s+Alto\\s+01-01-2025.*"));
        assertThat(output, matchesPattern("(?s).*2\\s+Menganito\\s+Clase II - Aparición móvil\\s+Medio\\s+02-01-2025.*"));
        assertThat(output, containsString("Total: 2"));
    }

    @Test
    @DisplayName("Test para lista vacía de fantasmas")
    void testShowGhostsEmptyList() {
        ghostView.showGhosts(Collections.emptyList());

        String output = outputStreamCaptor.toString().trim();

        assertThat(output, containsString("No hay fantasmas capturados"));
    }

}
