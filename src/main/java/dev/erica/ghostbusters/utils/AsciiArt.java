package dev.erica.ghostbusters.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AsciiArt {
    public static void printAsciiArt(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error al cargar el arte ASCII: " + e.getMessage());
        }
    }
}
