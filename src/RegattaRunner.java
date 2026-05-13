import javax.swing.JFrame;

public class RegattaRunner {
    public static void main(String[] args) {
        RegattaList regattaList = new RegattaList();
        JFrame myFrame = new JFrame("Regatta Runner");
        myFrame.add(new HighDensityChip());
        myFrame.setSize(1300, 700);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setLocationRelativeTo(null); 
        myFrame.setVisible(true);  
    }
}
