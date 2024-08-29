package cricbuzz.scorecard;

import cricbuzz.over.Run;
import cricbuzz.over.RunType;

import java.util.HashMap;

public class BatterScorecard {
    private final HashMap<RunType, Integer> runsScored;
    private Integer totalRunScored;

    public BatterScorecard() {
        totalRunScored  = 0;
        runsScored = new HashMap<>();
        for(RunType runType: RunType.values()){
            runsScored.put(runType, 0);
        }
    }

    public Integer getRunsScored() {
        return totalRunScored;
    }

    public Integer getRunsScored(RunType runType) {
        return runsScored.get(runType);
    }

    public void addRun(Run run){
        totalRunScored += run.getScore();
        runsScored.compute(run.getRunType(),
                (k, runScoredForThisType) -> (runScoredForThisType != null ? runScoredForThisType : 0) + run.getScore()
        );
    }
}
