package splitwise.user;

import java.util.ArrayList;

public class UserController {
    ArrayList<User> users;

    public UserController() {
        this.users = new ArrayList<>();
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public User getUser(String id) {
        for (User user : users) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    public void addUser(User user) {
        if (!users.contains(user)) {
            users.add(user);
        }
    }

    public void removeUser(User user) {
        if (!users.contains(user)) {
            users.remove(user);
        }
    }
}
