package dev.erica.ghostbusters.model;

import java.util.ArrayList;
import java.util.List;

public class UserModel {
    private final List<GhostModel> ghosts = new ArrayList<>();

    public void  addGhost(GhostModel ghost) {
        if (ghost != null) {
            ghosts.add(ghost);
        }    
    }

    public List<GhostModel> getGhosts() {
        return new ArrayList<>(ghosts);
    }
}
