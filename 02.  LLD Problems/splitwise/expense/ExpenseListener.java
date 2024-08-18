package splitwise.expense;

public interface ExpenseListener {
    public void notify(ExpenseEvent event, Expense expense);
}
