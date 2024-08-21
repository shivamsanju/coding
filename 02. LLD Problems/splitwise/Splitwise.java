package splitwise;

import splitwise.Expense.AddExpenseRequest;
import splitwise.Expense.ExpenseController;
import splitwise.Expense.ExpenseEvent;
import splitwise.Expense.ExpenseEventManager;
import splitwise.Group.Group;
import splitwise.Group.GroupController;
import splitwise.Split.SplitType;
import splitwise.User.User;
import splitwise.User.UserController;
import splitwise.User.UserExpenseListener;

import java.util.List;

public class Splitwise {
    UserController userController;
    GroupController groupController;
    ExpenseController expenseController;
    ExpenseEventManager expenseEventManager;

    public Splitwise() {
        userController = new UserController();
        groupController = new GroupController();
        expenseEventManager = ExpenseEventManager.getExpenseEventManager();
        expenseEventManager.addListener(ExpenseEvent.ADD, new UserExpenseListener());
        expenseController = new ExpenseController(expenseEventManager);
    }

    public void init() {
        userController.addUser(new User("1", "User 1"));
        userController.addUser(new User("2", "User 2"));
        userController.addUser(new User("3", "User 3"));
        userController.addUser(new User("4", "User 4"));
    }

    public void displayBalanceSheet(User user) {
        System.out.printf("----------- Balance sheet for %s -----------\n", user.getName());
        user.getBalanceSheet().display();
        System.out.println("-------------------------------------------------\n");
    }

    public void demo() {
        User user1 = userController.getUser("1");
        User user2 = userController.getUser("2");
        User user3 = userController.getUser("3");
        User user4 = userController.getUser("4");

        // Add expense 1 -> Paid by user 3 , equally for all users
        System.out.println("Adding expense for user 3 of INR120 distributed equally among all users");
        List<User> participants = userController.getUsers();
        AddExpenseRequest expense1 = new AddExpenseRequest(SplitType.EQUAL, 120.0, user3,
                "Expense 1", "Description 1", participants, null, null);
        expenseController.addExpense(expense1);

        // Add expense 2 -> Paid by user 2 , for user 1, 2, 4
        System.out.println("Adding expense for user 2  of INR200 for user 1, 2, 4");
        List<User> participants2 = List.of(user1, user2, user4);
        List<Double> amounts = List.of(50.0, 50.0, 100.0);
        AddExpenseRequest expense2 = new AddExpenseRequest(SplitType.UNEQUAL, 200.0, user2, "Expense 2",
                "Description 2", participants2, null, amounts);
        expenseController.addExpense(expense2);

        // Adding expense in a group
        List<User> members = List.of(user1, user3, user4);
        groupController.createGroup("G1", "Bike Trip", members);
        Group g1 = groupController.getGroup("G1");

        List<Double> percentages = List.of(20.0, 30.0, 50.0);
        AddExpenseRequest expense3 = new AddExpenseRequest(SplitType.PERCENTAGE, 500.0, user4, "Expense 3",
                "Description 3", members, percentages, null);
        g1.addExpense(expense3);

        displayBalanceSheet(user1);
        displayBalanceSheet(user2);
        displayBalanceSheet(user3);
        displayBalanceSheet(user4);

    }

}
