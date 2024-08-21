package splitwise.Split;

import splitwise.User.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EqualStrategy implements SplitStrategy {
    List<User> participants;
    Double totalAmount;

    public EqualStrategy(List<User> participants, Double totalAmount) {
        this.participants = participants;
        this.totalAmount = totalAmount;
    }

    @Override
    public Map<User, Double> split() {
        Map<User, Double> splitsMap = new HashMap<>();

        Double perHeadExpense = totalAmount / participants.size();
        for (User participant : participants) {
            splitsMap.put(participant, perHeadExpense);
        }

        return splitsMap;
    }
}
