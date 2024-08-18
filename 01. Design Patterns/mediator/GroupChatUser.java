package mediator;

public class GroupChatUser {
    private String name;
    private Mediator mediator;

    public GroupChatUser(String name, Mediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }

    public void send(String text) {
        System.out.println(name + " sent: " + text);
        mediator.sendMessage(text, this);
    }

    public void receive(String text) {
        System.out.println(name + " received: " + text);
    }

}
