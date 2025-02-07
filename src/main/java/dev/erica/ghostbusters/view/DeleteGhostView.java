package dev.erica.ghostbusters.view;

public class DeleteGhostView {
    UtilsView utilsView = new UtilsView(System.in);
    public int getGhostDeleteID() {
        return utilsView.getIntInput("Ingrese el ID del fantasma a eliminar: ", 1, Integer.MAX_VALUE);
    }

    public void messageRelease() {
        utilsView.showMessage("Fantasma liberado.");
    }
    
    public void messageReleaseFailed(int id) {
        utilsView.showMessage("No hay fantasmas con el ID " + id + ".");
    }
}
