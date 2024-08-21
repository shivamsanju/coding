package splitwise.Split;

import splitwise.User.User;

import java.util.Map;

public interface SplitStrategy {
    public Map<User, Double> split();
}
