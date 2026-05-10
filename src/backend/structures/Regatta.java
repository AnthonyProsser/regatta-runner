package backend.structures;

import java.util.ArrayList;

public class Regatta implements Stringable {
    private String name;
    private RuleSet ruleSet;
    private ArrayList<Fleet> fleets;

    public Regatta(String name, RuleSet ruleSet, ArrayList<Fleet> fleets) {
        this.name = name;
        this.ruleSet = ruleSet;
        this.fleets = fleets;
    }

    @Override
    public String stringify() {
        String object = "{";
        object += "\"name\": \"" + this.name + "\",";
        object += "\"ruleSet\": " + this.ruleSet.stringify() + ",";
        object += "\"fleets\": [";
        for (Fleet fleet : this.fleets) {
            object += fleet.stringify() + ",";
        }
        object = object.substring(0, object.length() - 1); // Remove trailing comma
        object += "]}";
        return object;
    }

    public static Regatta load(String string) {
        int nameIndex = string.indexOf("\"name\": \"") + 9;
        int nameEndIndex = string.indexOf("\"", nameIndex);
        String name = string.substring(nameIndex, nameEndIndex);

        int ruleSetIndex = string.indexOf("\"ruleSet\": ") + 11;
        int ruleSetEndIndex = string.indexOf("},", ruleSetIndex) + 1;
        String ruleSetString = string.substring(ruleSetIndex, ruleSetEndIndex);
        RuleSet ruleSet = RuleSet.load(ruleSetString);

        int fleetsIndex = string.indexOf("\"fleets\": [") + 11;
        int fleetsEndIndex = string.indexOf("]", fleetsIndex);
        String fleetsString = string.substring(fleetsIndex, fleetsEndIndex);
        String[] fleetsArray = fleetsString.split(","); // Split into individual fleet strings
        ArrayList<Fleet> fleets = new ArrayList<>();
        for (String fleetString : fleetsArray) {
            Fleet fleet = Fleet.load(fleetString);
            fleets.add(fleet);
        }
        Regatta regatta = new Regatta(name, ruleSet, fleets);
        return regatta;
    }
}

