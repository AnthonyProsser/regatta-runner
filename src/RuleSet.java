import java.util.ArrayList;

public class RuleSet implements Stringable {
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

    @Override
    public String stringify() {
        String object = "{";
        object += "\"racesPerThrowout\": " + this.racesPerThrowout + ",";
        object += "\"startSequenceLength\": " + this.startSequenceLength + ",";
        object += "\"maxTimeLimit\": " + this.maxTimeLimit + ",";
        object += "\"openStartingLine\": " + this.openStartingLine + ",";
        object += "\"courseTypes\": [";
        for (String courseType : this.courseTypes) {
            object += "\"" + courseType + "\",";
        }
        object = object.substring(0, object.length() - 1); // Remove trailing comma
        object += "]}";
        return object;
    }

    public static RuleSet load(String string) {
        int racesPerThrowoutIndex = string.indexOf("\"racesPerThrowout\": ") + 21;
        int racesPerThrowoutEndIndex = string.indexOf(",", racesPerThrowoutIndex);
        int racesPerThrowout = Integer.parseInt(string.substring(racesPerThrowoutIndex, racesPerThrowoutEndIndex));
        
        int startSequenceLengthIndex = string.indexOf("\"startSequenceLength\": ") + 23;
        int startSequenceLengthEndIndex = string.indexOf(",", startSequenceLengthIndex);
        int startSequenceLength = Integer.parseInt(string.substring(startSequenceLengthIndex, startSequenceLengthEndIndex));

        int maxTimeLimitIndex = string.indexOf("\"maxTimeLimit\": ") + 17;
        int maxTimeLimitEndIndex = string.indexOf(",", maxTimeLimitIndex);
        int maxTimeLimit = Integer.parseInt(string.substring(maxTimeLimitIndex, maxTimeLimitEndIndex));

        int openStartingLineIndex = string.indexOf("\"openStartingLine\": ") + 20;
        int openStartingLineEndIndex = string.indexOf(",", openStartingLineIndex);
        boolean openStartingLine = Boolean.parseBoolean(string.substring(openStartingLineIndex, openStartingLineEndIndex));

        int courseTypesIndex = string.indexOf("\"courseTypes\": [") + 14;
        int courseTypesEndIndex = string.lastIndexOf("]");
        ArrayList<String> courseTypes = new ArrayList<>();
        String courseTypesString = string.substring(courseTypesIndex, courseTypesEndIndex);
        String[] courseTypeArray = courseTypesString.split("\",\"");
        for (String courseType : courseTypeArray) {
            courseTypes.add(courseType.replace("\"", ""));
        }

        return new RuleSet(racesPerThrowout, startSequenceLength, maxTimeLimit, openStartingLine, courseTypes);
    }
}