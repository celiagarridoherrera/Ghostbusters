package dev.erica.ghostbusters;

import dev.erica.ghostbusters.controller.UserController;
import dev.erica.ghostbusters.model.UserModel;
import dev.erica.ghostbusters.view.CreateGhostView;
import dev.erica.ghostbusters.view.DeleteGhostView;
import dev.erica.ghostbusters.view.FilterByMonthView;
import dev.erica.ghostbusters.view.GhostView;
import dev.erica.ghostbusters.view.MenuView;
import dev.erica.ghostbusters.view.UtilsView;

public final class App {
    private App() {
    }

    /**
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        UtilsView utilsView = new UtilsView(System.in);
        MenuView menuView = new MenuView(utilsView);
        CreateGhostView createGhostView = new CreateGhostView(System.in);
        GhostView ghostView = new GhostView();
        DeleteGhostView deleteGhostView = new DeleteGhostView();
        FilterByMonthView filterByMonthView = new FilterByMonthView();
        UserModel userModel = new UserModel();
        UserController userController = new UserController(userModel,createGhostView, ghostView, deleteGhostView, filterByMonthView, menuView);

        userController.start();
    }
}
