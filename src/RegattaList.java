import java.util.ArrayList;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class RegattaList {
    private ArrayList<Regatta> regattas;
    private static final String FILE_PATH = "regattas.txt";

    public RegattaList() {
        loadRegattas();
    }

    public void addRegatta(Regatta regatta) {
        regattas.add(regatta);
    }
    public ArrayList<Regatta> getRegattas() {
        return regattas;
    }

    private void loadRegattas() {
        regattas = new ArrayList<>();
        if (!Files.exists(Paths.get(FILE_PATH))) {
            return; //No Regattas Saved
        }
        try {
            List<String> lines = Files.readAllLines(Paths.get(FILE_PATH));
            for (String line : lines) {
                regattas.add(Regatta.load(line));
            }
        } catch (Exception e) {
            System.err.println("Error loading regattas: " + e.getMessage());
        }
    }
    public void saveRegattas() {
        List<String> lines = new ArrayList<>();
        for (Regatta regatta : regattas) {
            lines.add(regatta.stringify());
        }
        try {
            Files.write(Paths.get(FILE_PATH), lines);
        } catch (Exception e) {
            System.err.println("Error saving regattas: " + e.getMessage());
        }
    }
}