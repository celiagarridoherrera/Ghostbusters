package dev.erica.ghostbusters.controller;

import dev.erica.ghostbusters.model.GhostClass;
import dev.erica.ghostbusters.model.GhostModel;
import dev.erica.ghostbusters.model.UserModel;
import dev.erica.ghostbusters.view.CreateGhostView;


public class UserController {
    private final UserModel userModel;
    private final CreateGhostView createGhostView; 

     public UserController(UserModel userModel, CreateGhostView createGhostView) {
        this.userModel = userModel;
        this.createGhostView = createGhostView;
    }

    public void captureGhost() {
        String name = createGhostView.getGhostName();
        GhostClass ghostClass = createGhostView.selectGhostClass();
        String dangerLevel = createGhostView.getDangerLevel();
        String ability = createGhostView.getAbility();
        String captureDate = createGhostView.getCaptureDate();

        GhostModel newGhost = new GhostModel(name, ghostClass, dangerLevel, ability, captureDate);
        userModel.addGhost(newGhost);
        createGhostView.showCaptureSuccess(name);
    }
}
