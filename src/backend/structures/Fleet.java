package backend.structures;

import java.util.arrayList;

public class Fleet {
    private String name;
    private ArrayList<Boat> boats;

    public Fleet(String name) {
        this.name = name;
        this.boats = new ArrayList<>();
    }

    public void addBoat(Boat boat) {
        boats.add(boat);
    }

    public String getName() {
        return name;
    }
}