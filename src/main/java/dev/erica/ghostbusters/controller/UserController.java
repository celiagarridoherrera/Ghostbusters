package dev.erica.ghostbusters.controller;

import java.util.List;

import dev.erica.ghostbusters.model.GhostClass;
import dev.erica.ghostbusters.model.GhostModel;
import dev.erica.ghostbusters.model.UserModel;
import dev.erica.ghostbusters.view.CreateGhostView;
import dev.erica.ghostbusters.view.DeleteGhostView;
import dev.erica.ghostbusters.view.GhostView;


public class UserController {
    private final UserModel userModel;
    private final CreateGhostView createGhostView; 
    private final GhostView ghostView;
    private final DeleteGhostView deleteGhostView;

     public UserController(UserModel userModel, CreateGhostView createGhostView, GhostView ghostView, DeleteGhostView deleteGhostView) {
        this.userModel = userModel;
        this.createGhostView = createGhostView;
        this.ghostView = ghostView;
        this.deleteGhostView = deleteGhostView;
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

    public void showCapturedGhosts() {
        List<GhostModel> ghosts = userModel.getGhosts();
        ghostView.showGhosts(ghosts);
    }

    public void releaseGhost() {
        int id = deleteGhostView.getGhostDeleteID();
        boolean success = userModel.deleteGhost(id);
        if (success) {
            deleteGhostView.messageRelease();
        } else {
            deleteGhostView.messageReleaseFailed(id);
        }
    }

    public void filterGhostsByClass() {
        GhostClass ghostClass = createGhostView.selectGhostClass();
        List<GhostModel> filtered = userModel.filterByClass(ghostClass);
        ghostView.showGhosts(filtered);
    }
}

