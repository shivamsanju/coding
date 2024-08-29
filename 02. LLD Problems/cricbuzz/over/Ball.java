package cricbuzz.over;

import cricbuzz.player.Player;

public class Ball {
    private final Player bowler;
    private final Player batsman;
    private BallType ballType;
    private Run run;
    private boolean wicket;
    private Dismissal dismissal;


    public Ball(Player bowler, Player batsman) {
        this.bowler = bowler;
        this.batsman = batsman;
    }


    public BallType getBallType() {
        return ballType;
    }

    public void setBallType(BallType ballType) {
        this.ballType = ballType;
    }

    public Run getRun() {
        return run;
    }

    public void setRun(Run run) {
        this.run = run;
    }

    public boolean isWicket() {
        return wicket;
    }

    public void setWicket(boolean wicket) {
        this.wicket = wicket;
    }

    public Dismissal getDismissal() {
        return dismissal;
    }

    public void setDismissalType(Dismissal dismissal) {
        this.dismissal = dismissal;
    }

    public Player getBowler() {
        return bowler;
    }

    public Player getBatsman() {
        return batsman;
    }
}
