package strategy;

public class Client {

    public static void main(String[] args) {

        PrintExecutor executor = new PrintExecutor(new UppercaseStrategy());
        executor.printString("Hello World");

        executor.setStrategy(new LowercaseStrategy());
        executor.printString("Hello World");

        executor.setStrategy(new RemoveWhitespaceStrategy());
        executor.printString("Hello World");
    }
}
