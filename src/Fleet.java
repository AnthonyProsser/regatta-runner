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
        object = this.boats.isEmpty() ? object + "]" : object.substring(0, object.length() - 1) + "]";
        object += "}";
        return object;
    }

    public static Fleet load(String string) {
        int nameIndex = string.indexOf("\"name\": \"") + 9;
        int nameEndIndex = string.indexOf("\"", nameIndex);
        String name = string.substring(nameIndex, nameEndIndex);

        int boatsIndex = string.indexOf("\"boats\": [") + 10;
        int boatsEndIndex = string.indexOf("]", boatsIndex);
        String boatsString = string.substring(boatsIndex, boatsEndIndex);
        ArrayList<Boat> boats = new ArrayList<>();
        if (!boatsString.isBlank()) {
            boats.add(Boat.load(boatsString));
        }
        Fleet fleet = new Fleet(name);
        for (Boat boat : boats) {
            fleet.addBoat(boat);
        }
        return fleet;
    }
}