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
        createGhostView = createGhostInput("Fantasma1\n");
    }
    
    private CreateGhostView createGhostInput(String simulatedInput) {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        return new CreateGhostView(inputStream);
    }

    @Test
    @DisplayName("Test de la vista para obtener el nombre de un fantasma")
    public void testGetGhostName() {
        createGhostView = createGhostInput("\nFantasma2\n");
        String result = createGhostView.getGhostName();
        assertEquals("Fantasma2", result);
    }

    @Test
    @DisplayName("Test de la vista para sleccionar la clase de un fantasma")
    public void testSelectGhostClass() {

        createGhostView = createGhostInput("1\n");

        GhostClass expectedClass = GhostClass.values()[0];
        GhostClass selectedClass = createGhostView.selectGhostClass();

        assertEquals(expectedClass, selectedClass);
    }
}
