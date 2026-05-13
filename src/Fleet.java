import java.util.ArrayList;

public class Fleet implements Stringable {
    private String name;
    private ArrayList<Boat> boats;

    public Fleet(String name) {
        this.name = name;
        this.boats = new ArrayList<>();
    }

    public void addBoat(Boat boat) {
        boats.add(boat);
    }

    @Override
    public String stringify() {
        String object = "{";
        object += "\"name\": \"" + this.name + "\",";
        object += "\"boats\": [";
        for (Boat boat : this.boats) {
            object += boat.stringify() + ",";
        }
        object = object.substring(0, object.length() - 1); // Remove trailing comma
        object += "]}";
        return object;
    }

    public static Fleet load(String string) {
        int nameIndex = string.indexOf("\"name\": \"") + 9;
        int nameEndIndex = string.indexOf("\"", nameIndex);
        String name = string.substring(nameIndex, nameEndIndex);

        int boatsIndex = string.indexOf("\"boats\": [") + 11;
        int boatsEndIndex = string.indexOf("]", boatsIndex);
        String boatsString = string.substring(boatsIndex, boatsEndIndex);
        String[] boatsArray = boatsString.split(","); // Split into individual boat strings
        ArrayList<Boat> boats = new ArrayList<>();
        for (String boatString : boatsArray) {
            Boat boat = Boat.load(boatString);
            boats.add(boat);
        }
        Fleet fleet = new Fleet(name);
        for (Boat boat : boats) {
            fleet.addBoat(boat);
        }
        return fleet;
    }
}