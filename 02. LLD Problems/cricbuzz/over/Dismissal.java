package cricbuzz.over;

import cricbuzz.player.Player;

public class Dismissal {
    private final Player playerDismissed;
    private final DismissalType type;

    public Dismissal(Player playerDismissed, DismissalType type) {
        this.playerDismissed = playerDismissed;
        this.type = type;
    }

    public Player getPlayerDismissed() {
        return playerDismissed;
    }

    public DismissalType getType() {
        return type;
    }
}
