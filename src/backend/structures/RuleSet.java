package backend.structures;

public class RuleSet {
    private int racesPerThrowout;
    private int startSequenceLength;
    private int maxTimeLimit;
    private boolean openStartingLine;
    private ArrayList<String> courseTypes;

    public RuleSet(int racesPerThrowout, int startSequenceLength, int maxTimeLimit, boolean openStartingLine, ArrayList<String> courseTypes) {
        this.racesPerThrowout = racesPerThrowout;
        this.startSequenceLength = startSequenceLength;
        this.maxTimeLimit = maxTimeLimit;
        this.openStartingLine = openStartingLine;
        this.courseTypes = courseTypes;
    }
}