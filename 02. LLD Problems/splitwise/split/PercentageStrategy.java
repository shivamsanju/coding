package splitwise.split;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import splitwise.user.User;

public class PercentageStrategy implements SplitStrategy {
    List<User> participants;
    List<Double> percentages;
    Double totalAmount;

    public PercentageStrategy(List<User> participants, List<Double> percentages, Double totalAmount) {
        this.participants = participants;
        this.percentages = percentages;
        this.totalAmount = totalAmount;
    }

    @Override
    public Map<User, Double> split() {
        Map<User, Double> splitsMap = new HashMap<>();

        for (int i = 0; i < participants.size(); i++) {
            splitsMap.put(participants.get(i), (percentages.get(i) * totalAmount) / 100);
        }

        return splitsMap;
    }
}
