package cricbuzz.listener;

import cricbuzz.over.Ball;

public interface MatchEventListener {
    public void addBall(Ball ball);
    public void completeOver();
}
