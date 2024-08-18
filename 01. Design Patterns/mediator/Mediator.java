package mediator;

import java.util.ArrayList;

public class Mediator {
    ArrayList<GroupChatUser> users = new ArrayList<>();

    public void addUser(GroupChatUser user) {
        users.add(user);
    }

    public void sendMessage(String message, GroupChatUser sender) {
        for (GroupChatUser user : users) {
            if (user != sender) {
                user.receive(message);
            }
        }
    }
}
