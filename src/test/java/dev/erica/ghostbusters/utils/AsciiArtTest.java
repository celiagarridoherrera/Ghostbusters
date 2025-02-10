package dev.erica.ghostbusters.utils;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AsciiArtTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    @DisplayName("Test de impresión de Ascii Art")
    void testPrintAsciiArt() throws IOException {
        File testFile = File.createTempFile("ascii_art", ".txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(testFile))) {
            writer.write("Hola");
        }

        AsciiArt.printAsciiArt(testFile.getAbsolutePath());

        String output = outputStreamCaptor.toString().trim();
        String expectedOutput = "Hola";
        assertEquals(expectedOutput, output);

        testFile.delete();
    }

    @Test
    @DisplayName("Test de archivo inexistente")
    void testPrintAsciiArtError() {
        AsciiArt.printAsciiArt("archivo_inexistente.txt");

        String output = outputStreamCaptor.toString().trim();
        assertEquals("Error al cargar el arte ASCII: archivo_inexistente.txt (El sistema no puede encontrar el archivo especificado)", output);
    }
}
