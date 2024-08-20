package splitwise.group;

import java.util.ArrayList;
import java.util.List;

import splitwise.expense.AddExpenseRequest;
import splitwise.expense.Expense;
import splitwise.expense.ExpenseController;
import splitwise.expense.ExpenseEventManager;
import splitwise.user.User;

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
