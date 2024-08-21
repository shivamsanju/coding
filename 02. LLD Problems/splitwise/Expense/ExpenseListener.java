package splitwise.Expense;

public interface ExpenseListener {
    public void notify(ExpenseEvent event, Expense expense);
}
