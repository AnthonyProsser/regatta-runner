package backend.structures;

import java.util.ArrayList;

public class Boat implements Stringable {
    private String name;
    private Racer skipper;
    private ArrayList<Racer> crew;

    public Boat(Racer skipper) {
        this.skipper = skipper;
        this.crew = new ArrayList<>();
        this.name = skipper.getName();
    }
    public Boat(String name, Racer skipper) {
        this.name = name;
        this.skipper = skipper;
        this.crew = new ArrayList<>();
    }
    public void addCrew(Racer racer) {
        crew.add(racer);
    }

    @Override
    public String stringify() {
        String object = "{";
        object += "\"name\": \"" + this.name + "\",";
        object += "\"skipper\": " + this.skipper.stringify() + ",";
        object += "\"crew\": [";
        for (Racer racer : this.crew) {
            object += racer.stringify() + ",";
        }
        object = object.substring(0, object.length() - 1); // Remove trailing comma
        object += "]}";
        return object;
    }

    public static Boat load(String string) {
        int nameIndex = string.indexOf("\"name\": \"") + 9;
        int nameEndIndex = string.indexOf("\"", nameIndex);
        String name = string.substring(nameIndex, nameEndIndex);

        int skipperIndex = string.indexOf("\"skipper\": ") + 11;
        int skipperEndIndex = string.indexOf("},", skipperIndex) + 1;
        String skipperString = string.substring(skipperIndex, skipperEndIndex);
        Racer skipper = Racer.load(skipperString);

        int crewIndex = string.indexOf("\"crew\": [") + 8;
        int crewEndIndex = string.indexOf("]", crewIndex);
        String crewString = string.substring(crewIndex, crewEndIndex);
        String[] crewArray = crewString.split(","); // Split into individual racer strings
        ArrayList<Racer> crew = new ArrayList<>();
        for (String racerString : crewArray) {
            Racer racer = Racer.load(racerString);
            crew.add(racer);
        }
        Boat boat = new Boat(name, skipper);
        for (Racer racer : crew) {
            boat.addCrew(racer);
        }
        return boat;
    }
}