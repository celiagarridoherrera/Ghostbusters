package dev.erica.ghostbusters.view;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import dev.erica.ghostbusters.model.GhostClass;

public class CreateGhostViewTest {
    private CreateGhostView createGhostView;

    private void setInput(String simulatedInput) {
        createGhostView = new CreateGhostView(new ByteArrayInputStream(simulatedInput.getBytes()));
    }

    @BeforeEach
    public void setUp() {
        setInput("Fantasma\n");
    }

    @Test
    @DisplayName("Test de la vista para obtener el nombre de un fantasma")
    public void testGetGhostName() {
        assertEquals("Fantasma", createGhostView.getGhostName());
    }

    @Test
    @DisplayName("Test de la vista para seleccionar la clase de un fantasma")
    public void testSelectGhostClass() {
        setInput("1\n");
        assertEquals(GhostClass.values()[0], createGhostView.selectGhostClass());
    }

    @Test
    @DisplayName("Test de la vista para añadir el nivel de peligrosidad del fantasma")
    public void testGetDangerLevel() {
        setInput("invalid\nmedio\n");
        assertEquals("medio", createGhostView.getDangerLevel());
    }

    @Test
    @DisplayName("Test de la vista para añadir la habilidad del fantasma")
    public void testGetAbility() {
        setInput("invisibilidad\n");
        assertEquals("invisibilidad", createGhostView.getAbility());
    }

    @Test
    @DisplayName("Test de la vista para añadir la fecha de captura del fantasma")
    public void testGetCaptureDate() {
        setInput("2023/03/12\n03-03-2025\n");
        assertEquals("03-03-2025", createGhostView.getCaptureDate());
    }
}
