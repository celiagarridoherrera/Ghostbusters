package dev.erica.ghostbusters.view;

import java.io.InputStream;
import java.util.Scanner;

public class CreateGhostView {
    private final Scanner scanner;

    public CreateGhostView(InputStream inputStream) {
        this.scanner = new Scanner(inputStream);
    }
    public String getGhostName() {
        String pattern = ".*[a-zA-Z]+.*";
        while (true) {
            System.out.print("Ingrese el nombre del fantasma: ");
            String input = scanner.nextLine().trim();
            if (!input.isEmpty() && input.matches(pattern)) {
                return input;
            }
            System.out.println("Entrada inválida. El nombre debe contener al menos una letra y no puede estar vacío.");
        }
    }
}
