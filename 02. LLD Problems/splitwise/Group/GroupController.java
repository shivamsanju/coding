package splitwise.Group;

import splitwise.User.User;

import java.util.ArrayList;
import java.util.List;

public class GroupController {
    List<Group> groups;

    public GroupController() {
        this.groups = new ArrayList<>();
    }

    public Group createGroup(String id, String name, List<User> members) {
        Group group = new Group(id, name, members);
        groups.add(group);
        return group;
    }

    public Group getGroup(String groupId) {
        for (Group g : groups) {
            if (g.getId() == groupId) {
                return g;
            }
        }
        return null;
    }
}
