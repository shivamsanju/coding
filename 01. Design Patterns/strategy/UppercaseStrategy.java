package strategy;

public class UppercaseStrategy implements PrintStrategy {
    @Override
    public String formatString(String str) {
        return str.toUpperCase();
    }
}
