package cricbuzz.team;

import cricbuzz.player.Player;

import java.util.Arrays;


public class Team {
    private String name;
    Player[] playing11;
    Player[] bench;

    public Team(String name, Player[] playing11, Player[] bench) {
        this.name = name;
        this.playing11 = playing11;
        this.bench = bench;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Player[] getPlaying11() {
        return playing11;
    }

    public Player[] getBench() {
        return bench;
    }

    public Player[] getAllPlaying15() {
        Player[] playing15 = new Player[playing11.length + bench.length];
        System.arraycopy(playing11, 0, playing15, 0, playing11.length);
        System.arraycopy(bench, 0, playing15, playing11.length, bench.length);
        return playing15;
    }
}
