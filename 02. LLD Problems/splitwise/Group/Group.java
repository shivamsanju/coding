package splitwise.Group;

import splitwise.Expense.AddExpenseRequest;
import splitwise.Expense.Expense;
import splitwise.Expense.ExpenseController;
import splitwise.Expense.ExpenseEventManager;
import splitwise.User.User;

import java.util.ArrayList;
import java.util.List;

public class Group {
    String id;
    String name;
    List<User> members;
    List<Expense> expenses;
    ExpenseController expenseController;

    Group(String id, String name, List<User> members) {
        this.id = id;
        this.name = name;
        this.expenses = new ArrayList<>();
        this.members = members;
        this.expenseController = new ExpenseController(ExpenseEventManager.getExpenseEventManager());

    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void addMember(User user) {
        if (!members.contains(user)) {
            members.add(user);
        }
    }

    public void removeMember(User user) {
        if (members.contains(user)) {
            members.remove(user);
        }
    }

    public void addExpense(AddExpenseRequest expenseRequest) {
        Expense expense = expenseController.addExpense(expenseRequest);
        expenses.add(expense);
    }
}
