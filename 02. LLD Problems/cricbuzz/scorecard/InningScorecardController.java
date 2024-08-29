package cricbuzz.scorecard;

import cricbuzz.over.Ball;
import cricbuzz.over.Over;
import cricbuzz.player.Player;

public class InningScorecardController {
    InningScorecard inningScorecard;

    public InningScorecardController(InningScorecard inningScorecard) {
        this.inningScorecard = inningScorecard;
    }

    public void addBall(Ball ball) {
        Player batter = ball.getBatsman();
        Player bowler = ball.getBowler();

        BatterScorecard batterScorecard = inningScorecard.getBattingScorecard(batter);
        batterScorecard.addRun(ball.getRun());

        BowlerScorecard bowlerScorecard = inningScorecard.getBowlingScorecard(bowler);
        bowlerScorecard.addRun(ball.getRun());


        inningScorecard.setRunsScored(inningScorecard.getRunsScored() + ball.getRun().getScore());

        if (ball.isWicket()) {
            inningScorecard.setWicketsTaken(inningScorecard.getWicketsTaken() + 1);
            bowlerScorecard.addDismissal(ball.getDismissal());
        }

        inningScorecard.getCurrentOver().addBall(ball);
    }

    public void completeOver(){
        var oversBowled = inningScorecard.getOversBowled();
        Over newOver = new Over(oversBowled.size() + 1);
        oversBowled.add(newOver);

    }
}
