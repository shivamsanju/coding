package command;

public class Client {
    public static void main(String[] args) {

        Chef chef = new Chef();

        Command cookCommand = new CookingCommand("Spicy paneer masala");

        chef.setCommand(cookCommand);
        chef.executeCommand();

        Command remakeCommand = new RemakeCommand("Not Spicy", "Make more spicy");

        chef.setCommand(remakeCommand);
        chef.executeCommand();
    }
}
