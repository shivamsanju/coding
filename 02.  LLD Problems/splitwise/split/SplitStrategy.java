package splitwise.split;

import java.util.Map;

import splitwise.user.User;

public interface SplitStrategy {
    public Map<User, Double> split();
}
