package command;

public class RemakeCommand implements Command {
    public String reason;
    public String remakeInstruction;

    public RemakeCommand(String reason, String remakeInstructions) {
        this.reason = reason;
        this.remakeInstruction = remakeInstructions;
    }

    public void execute() {
        System.out.println("Food ready based on these remake instructions: " + remakeInstruction);
    }
}
