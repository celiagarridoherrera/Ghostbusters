package dev.erica.ghostbusters.view;

import java.util.List;

import dev.erica.ghostbusters.model.GhostModel;
import dev.erica.ghostbusters.utils.Ansicolors;

public class GhostView {

    public void showGhosts(List<GhostModel> ghosts) {
        if (ghosts.isEmpty()) {
            System.out.println(Ansicolors.YELLOW + "No hay fantasmas capturados" + Ansicolors.RESET);
        } else {
            System.out.println(Ansicolors.BRIGHT_RED + "\nFantasmas capturados" + Ansicolors.RESET);
            System.out.println("====================================================");
            System.out.println(Ansicolors.RED + "ID   Nombre                          Clase                Peligrosidad  Fecha" + Ansicolors.RESET);
            System.out.println("------------------------------------------------------------------------------");
            ghosts.forEach(System.out::println);
            System.out.println("------------------------------------------------------------------------------");
            System.out.println(Ansicolors.CYAN + "Total: " + ghosts.size() + Ansicolors.RESET);
        }
    }
}
