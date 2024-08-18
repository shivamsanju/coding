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
        if (participants.size() != percentages.size()) {
            throw new IllegalArgumentException("Participants and percentages lists must have the same size");
        }

        double totalPercentage = percentages.stream().mapToDouble(Double::doubleValue).sum();
        if (totalPercentage != 1.0) {
            throw new IllegalArgumentException("Percentages must sum to 1.0 (100%)");
        }

        this.participants = participants;
        this.percentages = percentages;
        this.totalAmount = totalAmount;
    }

    @Override
    public Map<User, Double> split() {
        Map<User, Double> splitsMap = new HashMap<>();

        for (int i = 0; i < participants.size(); i++) {
            splitsMap.put(participants.get(i), percentages.get(i) * totalAmount);
        }

        return splitsMap;
    }
}
