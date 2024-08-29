package cricbuzz.match;
import java.util.HashMap;

public class MatchRepository {
    private final HashMap<Integer, Match> matches;


    public MatchRepository() {
        this.matches = new HashMap<>();
    }

    public void addMatch(Match match){
        matches.put(match.getId(), match);
    }

    public Match getMatch(int id){
        return matches.get(id);
    }
}
