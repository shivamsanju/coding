package cricbuzz.match;

import cricbuzz.scorecard.InningScorecard;
import cricbuzz.team.Team;

public class Inning {
    private final Team battingTeam;
    private final Team bowlingTeam;
    private final InningScorecard inningScorecard;

    public Inning(Team battingTeam, Team bowlingTeam, int maxOvers) {
        this.battingTeam = battingTeam;
        this.bowlingTeam = bowlingTeam;
        this.inningScorecard = new InningScorecard(maxOvers, battingTeam, bowlingTeam);
    }

    public Team getBattingTeam() {
        return battingTeam;
    }

    public Team getBowlingTeam() {
        return bowlingTeam;
    }

    public InningScorecard getScorecard() {
        return inningScorecard;
    }
}
