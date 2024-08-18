package mediator;

public class Client {

    public static void main(String[] args) {
        Mediator mediator = new Mediator();
        GroupChatUser rick = new GroupChatUser("Rick", mediator);
        GroupChatUser morty = new GroupChatUser("Morty", mediator);
        GroupChatUser john = new GroupChatUser("John", mediator);

        mediator.addUser(rick);
        mediator.addUser(morty);
        mediator.addUser(john);

        rick.send("Hello");
    }
}