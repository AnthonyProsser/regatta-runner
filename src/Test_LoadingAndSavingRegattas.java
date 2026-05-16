import java.util.ArrayList;

public class Test_LoadingAndSavingRegattas {
    public static void main(String[] args) {
        RegattaList regattaList = new RegattaList();
        RuleSet ruleSet = new RuleSet(1, 5, 60, true, new ArrayList<String>());
        Fleet fleet1 = new Fleet("Fleet 1");
        Fleet fleet2 = new Fleet("Fleet 2");
        ArrayList<Fleet> fleets1 = new ArrayList<>();
        fleets1.add(fleet1);
        ArrayList<Fleet> fleets2 = new ArrayList<>();
        fleets2.add(fleet2);
        Regatta regatta = new Regatta("Test Regatta", ruleSet, fleets1);
        Regatta regatta2 = new Regatta("Test Regatta 2", ruleSet, fleets2);
        regattaList.addRegatta(regatta);
        regattaList.addRegatta(regatta2);
        regattaList.saveRegattas();

        // Load the regattas again to verify
        RegattaList loadedRegattaList = new RegattaList();//loads regattas
        for (Regatta loadedRegatta : loadedRegattaList.getRegattas()) {
            System.out.println(loadedRegatta);
        }
    }
}