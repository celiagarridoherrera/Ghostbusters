package dev.erica.ghostbusters.view;

import dev.erica.ghostbusters.utils.Ansicolors;

public class DeleteGhostView {
    UtilsView utilsView = new UtilsView(System.in);
    public int getGhostDeleteID() {
        return utilsView.getIntInput("Ingrese el ID del fantasma a eliminar: ", 1, Integer.MAX_VALUE);
    }

    public void messageRelease() {
        utilsView.showMessage(Ansicolors.MAGENTA + "Fantasma liberado." + Ansicolors.RESET);
    }
    
    public void messageReleaseFailed(int id) {
        utilsView.showMessage(Ansicolors.YELLOW + "No hay fantasmas con el ID " + id + "." + Ansicolors.RESET);
    }
}
