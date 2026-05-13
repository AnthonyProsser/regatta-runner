import java.util.ArrayList;

public class RegattaList {
    private ArrayList<Regatta> regattas;

    public RegattaList() {
        loadRegattas();
    }

    public void addRegatta(Regatta regatta) {
        regattas.add(regatta);
    }

    private void loadRegattas() {
        regattas = new ArrayList<>();
        
    }
    public void saveRegattas() {
        //write to files
    }
}