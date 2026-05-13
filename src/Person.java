import java.util.ArrayList;

public class Person implements Stringable {
    protected String name;
    protected String phoneNumber;

    public Person(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String stringify() {
        return "{"
                + "\"name\": \"" + this.name + "\","
                + "\"phoneNumber\": \"" + this.phoneNumber + "\""
                + "}";
    }

    public static Person load(String string) {
        int nameIndex = string.indexOf("\"name\": \"") + 9;
        int nameEndIndex = string.indexOf("\"", nameIndex);
        String name = string.substring(nameIndex, nameEndIndex);

        int phoneNumberIndex = string.indexOf("\"phoneNumber\": \"") + 16;
        int phoneNumberEndIndex = string.indexOf("\"", phoneNumberIndex);
        String phoneNumber = string.substring(phoneNumberIndex, phoneNumberEndIndex);

        return new Person(name, phoneNumber);
    }
}