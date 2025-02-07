package dev.erica.ghostbusters.view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
    @DisplayName("Test de la vista para crear un fantasma")
    public void testGetGhostName() {
        createGhostView = createGhostInput("\nFantasma2\n");
        String result = createGhostView.getGhostName();
        assertEquals("Fantasma2", result);
    }
}
