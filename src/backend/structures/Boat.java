package backend.structures;

public class Boat {
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
}