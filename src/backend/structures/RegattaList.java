package backend.structures;

import java.util.ArrayList;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

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