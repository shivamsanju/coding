package splitwise.split;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import splitwise.user.User;

public class UnequalStrategy implements SplitStrategy {
    List<User> participants;
    List<Double> amounts;

    public UnequalStrategy(List<User> participants, List<Double> amounts) {
        this.participants = participants;
        this.amounts = amounts;
    }

    @Override
    public Map<User, Double> split() {
        Map<User, Double> splitsMap = new HashMap<>();

        for (int i = 0; i < participants.size(); i++) {
            splitsMap.put(participants.get(i), amounts.get(i));
        }

        return splitsMap;
    }
}
