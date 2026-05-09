package backend.structures;

public class Racer extends Person {
    private ArrayList<Person> parents;

    public Racer(String name, String phoneNumber) {
        super(name, phoneNumber);
        this.parents = new ArrayList<>();
    }

    public void addParent(Person parent) {
        parents.add(parent);
    }
    public ArrayList<Person> getParents() {
        return parents;
    }
}