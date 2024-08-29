package cricbuzz.player;

public class Player {
    private final String id;
    private final String name;
    private int age;
    private PlayerType type;
    private int preferredBattingPosition;

    public Player(String id, String name, int age, PlayerType type) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public PlayerType getType() {
        return type;
    }

    public void setType(PlayerType type) {
        this.type = type;
    }

    public int getPreferredBattingPosition() {
        return preferredBattingPosition;
    }

    public void setPreferredBattingPosition(int preferredBattingPosition) {
        this.preferredBattingPosition = preferredBattingPosition;
    }
}
