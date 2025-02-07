package dev.erica.ghostbusters.view;

public class DeleteGhostView {
    public int getGhostDeleteID() {
        UtilsView utilsView = new UtilsView(System.in);
        return utilsView.getIntInput("Ingrese el ID del fantasma a eliminar: ", 1, Integer.MAX_VALUE);
    }
}
