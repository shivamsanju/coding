package command;

public class CookingCommand implements Command {
    String cookingInstructions;

    public CookingCommand(String instructions) {
        this.cookingInstructions = instructions;
    }

    public void execute() {
        System.out.println("Food ready based on these cooking instructions: " + cookingInstructions);
    }
}
