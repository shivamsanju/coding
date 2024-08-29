package cricbuzz.scorecard;

import cricbuzz.over.Dismissal;
import cricbuzz.over.Run;

import java.util.ArrayList;
import java.util.List;

public class BowlerScorecard {
    private final List<Dismissal> wicketsTaken;
    private Integer runConceded;

    public BowlerScorecard() {
        wicketsTaken = new ArrayList<>();
        runConceded = 0;
    }

    public void addDismissal(Dismissal dismissal){
        wicketsTaken.add(dismissal);
    }

    public void addRun(Run run){
        runConceded += run.getScore();
    }

    public List<Dismissal> getWicketsTaken(){
        return wicketsTaken;
    }
}
