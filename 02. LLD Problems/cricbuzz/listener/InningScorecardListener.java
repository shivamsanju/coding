package cricbuzz.listener;

import cricbuzz.over.Ball;
import cricbuzz.scorecard.InningScorecardController;

public class InningScorecardListener implements MatchEventListener{
    private final InningScorecardController inningScorecardController;

    public InningScorecardListener(InningScorecardController inningScorecardController) {
        this.inningScorecardController = inningScorecardController;
    }

    @Override
    public void addBall(Ball ball) {
        inningScorecardController.addBall(ball);
    }

    @Override
    public void completeOver() {
        inningScorecardController.completeOver();
    }
}
