package strategy;

public class LowercaseStrategy implements PrintStrategy {

    @Override
    public String formatString(String str) {
        return str.toLowerCase();
    }
}
