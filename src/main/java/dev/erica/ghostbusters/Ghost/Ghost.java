package dev.erica.ghostbusters.Ghost;

public class Ghost {

    

    public enum GhostClass {
        CLASS_I("Clase I - Manifestación menor"),
        CLASS_II("Clase II - Aparición móvil"),
        CLASS_III("Clase III - Entidad inteligente"),
        CLASS_IV("Clase IV - Fantasma histórico"),
        CLASS_V("Clase V - Espíritu antropomorfo"),
        CLASS_VI("Clase VI - Espíritu demoníaco"),
        CLASS_VII("Clase VII - Entidad ultraterrena");

        private final String description;

        GhostClass(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }

    }

    private static int idCounter = 1;
    private final int id;
    private final String name;
    private final GhostClass ghostClass;
    private final String dangerLvl;
    private final String ability;
    private final String captureDate;

    public Ghost(String name, GhostClass ghostClass, String dangerLvl, String ability, String captureDate) {

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

}
