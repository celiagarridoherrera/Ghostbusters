package dev.erica.ghostbusters;

import java.util.Scanner;

import dev.erica.ghostbusters.controller.UserController;
import dev.erica.ghostbusters.model.UserModel;
import dev.erica.ghostbusters.utils.AsciiArt;
import dev.erica.ghostbusters.view.CreateGhostView;
import dev.erica.ghostbusters.view.GhostView;

public class App {
    public static void main(String[] args) {
        CreateGhostView createGhostView;
        try (Scanner scanner = new Scanner(System.in)) {
            GhostView ghostView = new GhostView();
            UserModel userModel = new UserModel();
            createGhostView = new CreateGhostView(System.in);
            UserController userController = new UserController(userModel, createGhostView, ghostView, null, null);
            boolean exit = false;
            while (!exit) {
                AsciiArt.printAsciiArt("ghost.txt");
                System.out.println("============================================");
                System.out.println(" ¡Bienvenido a la central de Cazafantasmas!");
                System.out.println(" Accediendo al contenedor de almacenamiento de fantasmas...");
                System.out.println("============================================");
                System.out.println("Seleccione una opción: ");
                System.out.println("1. Añadir un fantasma al sistema de almacenamiento");
                System.out.println("2. Ver fantasmas capturados");
                System.out.println("3. Liberar un fantasma");
                System.out.println("4. Filtrar fantasmas por clase");
                System.out.println("5. Ver fantasmas capturados en un mes específico");
                System.out.println("6. Salir");
                System.out.print("\nSeleccione una opción (1-6): ");
                
                int option;
                if (scanner.hasNextInt()) {
                    option = scanner.nextInt();
                    scanner.nextLine();
                } else {
                    scanner.nextLine();
                    System.out.println("Por favor, introduzca un número entre 1 y 6.");
                    continue;
                }

                switch (option) {
                    case 1 -> userController.captureGhost();
                    case 2 -> userController.showCapturedGhosts();
                    case 3 -> userController.releaseGhost();
                    case 4 -> userController.filterGhostsByClass();
                    case 5 -> userController.filterGhostsByMonth();
                    case 6 -> {
                        System.out.println("============================================");
                        System.out.println(" ¡Gracias por proteger Asturias!");
                        System.out.println(" ¡Nos vemos en la próxima cacería paranormal!");
                        System.out.println("============================================");
                        exit = true;
                    }
                    default -> System.out.println("Inténtelo de nuevo.");
                }
            }
        }
    }
}
