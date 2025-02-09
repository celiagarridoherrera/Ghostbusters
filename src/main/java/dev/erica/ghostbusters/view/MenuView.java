package dev.erica.ghostbusters.view;

import dev.erica.ghostbusters.utils.Ansicolors;
import dev.erica.ghostbusters.utils.AsciiArt;

public class MenuView {
     private final UtilsView utilsView;

    public MenuView(UtilsView utilsView) {
        this.utilsView = utilsView;
    }

    public int showMenuAndGetOption() {
        AsciiArt.printAsciiArt("ghost.txt");
        AsciiArt.printAsciiArt("title.txt");
        utilsView.showMessage(Ansicolors.BRIGHT_BLACK + "============================================" + Ansicolors.RESET);
        utilsView.showMessage(Ansicolors.BRIGHT_RED + " ¡Bienvenido a la central de Cazafantasmas!" + Ansicolors.RESET);
        utilsView.showMessage(Ansicolors.RED + " Accediendo al contenedor de almacenamiento de fantasmas..." + Ansicolors.RESET);
        utilsView.showMessage(Ansicolors.BRIGHT_BLACK + "============================================" + Ansicolors.RESET);
        utilsView.showMessage(Ansicolors.BRIGHT_RED + "Seleccione una opción: " + Ansicolors.RESET);
        utilsView.showMessage("1. Añadir un fantasma al sistema de almacenamiento");
        utilsView.showMessage("2. Ver fantasmas capturados");
        utilsView.showMessage("3. Liberar un fantasma");
        utilsView.showMessage("4. Filtrar fantasmas por clase");
        utilsView.showMessage("5. Ver fantasmas capturados en un mes específico");
        utilsView.showMessage("6. Salir");

        return utilsView.getIntInput(Ansicolors.RED + "Seleccione una opción (1-6): " + Ansicolors.RESET, 1, 6 );
    }
}
