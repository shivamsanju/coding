package cricbuzz.over;

public class Run {
    private final RunType runType;
    private final int score;


    public Run(RunType ballType, int score) {
        this.runType = ballType;
        this.score = score;
    }

    public RunType getRunType() {
        return runType;
    }

    public int getScore() {
        return score;
    }
}
