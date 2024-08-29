package cricbuzz.scorecard;

import cricbuzz.over.Over;
import cricbuzz.player.Player;
import cricbuzz.team.Team;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* Break into smaller class -> BattingController, Bowling Controller, InningScorecard */
public class InningScorecard {
    private final Team battingTeam;
    private final Team bowlingTeam;
    private final HashMap<Player, BatterScorecard> battingScorecards;
    private final HashMap<Player, BowlerScorecard> bowlingScorecards;
    private int totalOvers;
    private final List<Over> oversBowled;
    private Over currentOver;
    private int runsScored;
    private int wicketsTaken;

    public InningScorecard(int totalOvers, Team battingTeam, Team bowlingTeam) {
        this.totalOvers = totalOvers;
        this.oversBowled = new ArrayList<>(totalOvers);
        this.battingTeam = battingTeam;
        this.bowlingTeam = bowlingTeam;
        this.battingScorecards = new HashMap<>();
        this.bowlingScorecards = new HashMap<>();

        for (Player batsman : battingTeam.getAllPlaying15()) {
            battingScorecards.put(batsman, new BatterScorecard());
        }

        for (Player bowler : bowlingTeam.getAllPlaying15()) {
            bowlingScorecards.put(bowler, new BowlerScorecard());
        }
    }

    public BatterScorecard getBattingScorecard(Player player) {
        return battingScorecards.get(player);
    }

    public BowlerScorecard getBowlingScorecard(Player player) {
        return bowlingScorecards.get(player);
    }

    public HashMap<Player, BatterScorecard> getBattingScorecards() {
        return battingScorecards;
    }

    public HashMap<Player, BowlerScorecard> getBowlingScorecards() {
        return bowlingScorecards;
    }

    public void display() {
        System.out.println("Scorecard -> %d/%d (%d / %d overs)");
    }

    public int getRunsScored() {
        return runsScored;
    }

    public void setRunsScored(int runsScored) {
        this.runsScored = runsScored;
    }

    public int getWicketsTaken() {
        return wicketsTaken;
    }

    public void setWicketsTaken(int wicketsTaken) {
        this.wicketsTaken = wicketsTaken;
    }

    public Over getCurrentOver() {
        return currentOver;
    }

    public void setCurrentOver(Over currentOver) {
        this.currentOver = currentOver;
    }

    public List<Over> getOversBowled() {
        return oversBowled;
    }

}
