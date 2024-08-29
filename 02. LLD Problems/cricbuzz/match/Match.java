package cricbuzz.match;

import cricbuzz.team.Team;

import java.util.ArrayList;
import java.util.List;

public class Match {
    private final int id;
    private final Team teamA;
    private final Team teamB;
    private MatchFormat format;
    private MatchVenue venue;
    private final List<Inning> innings;
    private Team tossWinner;
    private Team winner;


    public Match(int id, Team A, Team B, MatchFormat format, MatchVenue venue){
        this.id = id;
        this.teamA = A;
        this.teamB = B;
        this.format = format;
        this.venue = venue;
        this.innings = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void addNewInning(Team battingTeam, Team bowlingTeam){
        Inning newInning = new Inning(battingTeam, bowlingTeam, format.getMaxOvers());
        innings.add(newInning);
    }

    public Inning getInning(int inningNumber){
        return innings.get(inningNumber);
    }

    public MatchVenue getVenue() {
        return venue;
    }

    public void setVenue(MatchVenue venue) {
        this.venue = venue;
    }

    public Team getTossWinner() {
        return tossWinner;
    }

    public void setTossWinner(Team tossWinner) {
        this.tossWinner = tossWinner;
    }

    public Team getWinner() {
        return winner;
    }

    public void setWinner(Team winner) {
        this.winner = winner;
    }
}
