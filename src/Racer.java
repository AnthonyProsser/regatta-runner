package backend.structures;

import java.util.ArrayList;

public class Racer extends Person implements Stringable {
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

    @Override
    public String stringify() {
        String object = "{";
        object += "\"name\": \"" + this.name + "\",";
        object += "\"phoneNumber\": \"" + this.phoneNumber + "\",";
        object += "\"parents\": [";
        for (Person parent : this.parents) {
            object += parent.stringify() + ",";
        }
        object = object.substring(0, object.length() - 1); // Remove trailing comma
        object += "]}";
        return object;
    }

    public static Racer load(String string) {
        int nameIndex = string.indexOf("\"name\": \"") + 9;
        int nameEndIndex = string.indexOf("\"", nameIndex);
        String name = string.substring(nameIndex, nameEndIndex);

        int phoneNumberIndex = string.indexOf("\"phoneNumber\": \"") + 16;
        int phoneNumberEndIndex = string.indexOf("\"", phoneNumberIndex);
        String phoneNumber = string.substring(phoneNumberIndex, phoneNumberEndIndex);

        int parentsIndex = string.indexOf("\"parents\": [") + 10;
        int parentsEndIndex = string.indexOf("]", parentsIndex);
        String parentsString = string.substring(parentsIndex, parentsEndIndex);
        String[] parentsArray = parentsString.split(","); // Split into individual person strings
        ArrayList<Person> parents = new ArrayList<>();
        for (String personString : parentsArray) {
            Person person = Person.load(personString);
            parents.add(person);
        }
        Racer racer = new Racer(name, phoneNumber);
        for (Person parent : parents) {
            racer.addParent(parent);
        }
        return racer;
    }
}