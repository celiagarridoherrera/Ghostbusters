package dev.erica.ghostbusters.view;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import dev.erica.ghostbusters.model.GhostClass;

public class CreateGhostViewTest {

    private CreateGhostView createGhostView;

    @BeforeEach
    public void setUp() {
        createGhostView = createGhostInput("Fantasma\n");
    }
    
    private CreateGhostView createGhostInput(String simulatedInput) {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        return new CreateGhostView(inputStream);
    }

    @Test
    @DisplayName("Test de la vista para obtener el nombre de un fantasma")
    public void testGetGhostName() {
        String result = createGhostView.getGhostName();
        assertEquals("Fantasma", result);
    }

    @Test
    @DisplayName("Test de la vista para sleccionar la clase de un fantasma")
    public void testSelectGhostClass() {

        createGhostView = createGhostInput("1\n");

        GhostClass expectedClass = GhostClass.values()[0];
        GhostClass selectedClass = createGhostView.selectGhostClass();

        assertEquals(expectedClass, selectedClass);
    }

    @Test
    @DisplayName("Test de la vista para añadir el nivel de peligrosidad")
    public void testGetDangerLevel() {
        createGhostView = createGhostInput("invalid\nmedio\n");
        String result = createGhostView.getDangerLevel();
        assertEquals("medio", result);
    }
}
