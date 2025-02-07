package dev.erica.ghostbusters.view;

import java.util.List;

import dev.erica.ghostbusters.model.GhostModel;

public class GhostView {

    public void showGhosts(List<GhostModel> ghosts) {
        if (ghosts.isEmpty()) {
            System.out.println("No hay fantasmas capturados");
        } else {
            System.out.println("\nFantasmas capturados");
            System.out.println("====================================================");
            System.out.println("ID   Nombre                          Clase                Peligrosidad  Fecha");
            System.out.println("------------------------------------------------------------------------------");
            ghosts.forEach(System.out::println);
            System.out.println("------------------------------------------------------------------------------");
            System.out.println("Total: " + ghosts.size());
        }
    }
}
