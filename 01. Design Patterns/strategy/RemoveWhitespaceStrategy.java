package strategy;

public class RemoveWhitespaceStrategy implements PrintStrategy {

    @Override
    public String formatString(String str) {
        return str.replaceAll("\\s", "");
    }
}
