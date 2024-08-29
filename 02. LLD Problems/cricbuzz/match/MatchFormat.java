package cricbuzz.match;

public enum MatchFormat {
    T20(20), ODI(50), TEST(500);
    private final int maxOvers;

    MatchFormat(int overs) {
        this.maxOvers = overs;
    }

    public int getMaxOvers() {
        return maxOvers;
    }
}
