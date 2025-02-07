package dev.erica.ghostbusters.model;

public class GhostModel {

    private static int idCounter = 1;
    private final int id;
    private final String name;
    private final GhostClass ghostClass;
    private final String dangerLvl;
    private final String ability;
    private final String captureDate;

    public GhostModel(String name, GhostClass ghostClass, String dangerLvl, String ability, String captureDate) {

        this.id = idCounter++;
        this.name = name;
        this.ghostClass = ghostClass;
        this.dangerLvl = dangerLvl;
        this.ability = ability;
        this.captureDate = captureDate;
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public GhostClass getGhostClass() {
        return ghostClass;
    }

    public String getDangerLvl() {
        return dangerLvl;
    }

    public String getAbility() {
        return ability;
    }

    public String getCaptureDate() {
        return captureDate;
    }

    @Override
    public String toString() {
        return String.format("%-3d %-20s %-35s %-8s %s",
                id, name, ghostClass.getDescription(), dangerLvl, captureDate);
    }
}
