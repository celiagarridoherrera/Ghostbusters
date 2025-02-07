package dev.erica.ghostbusters.view;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dev.erica.ghostbusters.model.GhostClass;

public class CreateGhostView {
    
    private final Scanner scanner;
    UtilsView utilsView;

    public CreateGhostView(InputStream inputStream) {
        this.scanner = new Scanner(inputStream);
        this.utilsView = new UtilsView(inputStream);
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

    public GhostClass selectGhostClass() {
        GhostClass[] classes = GhostClass.values();
        System.out.println("Seleccione la clase del fantasma:");
        for (int i = 0; i < classes.length; i++) {
            System.out.println((i + 1) + ". " + classes[i].getDescription());
        }
        int choice = utilsView.getIntInput("Seleccione una opción: ", 1, classes.length);
        return classes[choice - 1];
    }

    public String getDangerLevel() {
        List<String> validOptions = Arrays.asList("bajo", "medio", "alto", "crítico");
        String input;
        do {
            System.out.print("Ingrese el nivel de peligro (Bajo, Medio, Alto, Crítico): ");
            input = scanner.nextLine().trim().toLowerCase();
            if (!validOptions.contains(input)) {
                System.out.println("Entrada inválida. Por favor, ingrese una de las siguientes opciones: " + String.join(", ", validOptions) + ".");
            }
        } while (!validOptions.contains(input));
        return input;
    }

    public String getAbility() {
        String pattern = ".*[a-zA-Z]+.*";
        while (true) {
            System.out.print("Ingrese la habilidad del fantasma: ");
            String input = scanner.nextLine().trim();
            if (!input.isEmpty() && input.matches(pattern)) {
                return input;
            }
            System.out.println("Entrada inválida. La habilidad debe contener al menos una letra y no puede estar vacía.");
        }
    }

    public String getCaptureDate() {
        String input;
        String pattern = "\\d{2}-\\d{2}-\\d{4}";
        do {
            System.out.print("Ingrese la fecha de captura (DD-MM-AAAA): ");
            input = scanner.nextLine().trim();
            if (!input.matches(pattern)) {
                System.out.println("Formato de fecha inválido. Use el formato DD-MM-AAAA.");
            }
        } while (!input.matches(pattern));
        return input;
    }

    public void showCaptureSuccess(String name) {
        utilsView.showMessage("\n¡Fantasma \"" + name + "\" capturado!");
    }
}
