package cricbuzz.over;

import java.util.LinkedList;
import java.util.List;

public class Over {
    private int overNumber;
    private List<Ball> balls;

    private int runScored;
    private int wicketsFell;


    public Over(int overNumber) {
        this.balls = new LinkedList<>();
        this.overNumber = overNumber;
    }

    public int getOverNumber(){
        return overNumber;
    }

    public void addBall(Ball ball){
        balls.add(ball);
    }

    public int getRunScored() {
        return runScored;
    }

    public void setRunScored(int runScored) {
        this.runScored = runScored;
    }

    public int getWicketsFell() {
        return wicketsFell;
    }

    public void setWicketsFell(int wicketsFell) {
        this.wicketsFell = wicketsFell;
    }
}
