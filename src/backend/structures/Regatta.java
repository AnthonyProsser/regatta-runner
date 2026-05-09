package backend.structures;

import java.util.arrayList;

public class Regatta implements Serializable {
    private String name;
    private RuleSet ruleSet;
    private ArrayList<Fleet> fleets;

    public Regatta(String name, RuleSet ruleSet, ArrayList<Fleet> fleets) {
        this.name = name;
        this.ruleSet = ruleSet;
        this.fleets = fleets;
    }

    public void save() {

    }
}
