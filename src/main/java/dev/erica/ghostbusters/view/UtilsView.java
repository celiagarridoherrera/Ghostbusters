package dev.erica.ghostbusters.view;

import java.io.InputStream;
import java.util.Scanner;

import dev.erica.ghostbusters.utils.Ansicolors;

public class UtilsView {

    private final Scanner scanner;

    public UtilsView(InputStream inputStream) {
        this.scanner = new Scanner(inputStream);
    }

    public int getIntInput(String prompt, int min, int max) {
        int value;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                value = scanner.nextInt();
                scanner.nextLine();
                if (value >= min && value <= max) {
                    return value;
                }
            } else {
                scanner.next();
            }
            System.out.println(Ansicolors.YELLOW + "Entrada inválida. Por favor, ingrese un número entre " + min + " y " + max + "." + Ansicolors.RESET);
        }
    }
    
    public void showMessage(String message) {
        System.out.println(message);
    }
}