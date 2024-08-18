package strategy;

public class PrintExecutor {
    private PrintStrategy printStrategy;

    public PrintExecutor(PrintStrategy printStrategy) {
        this.printStrategy = printStrategy;
    }

    public void printString(String str) {
        System.out.println(printStrategy.formatString(str));

    }

    public void setStrategy(PrintStrategy printStrategy) {
        this.printStrategy = printStrategy;
    }
}
