package splitwise.user;

import java.util.Map;

import splitwise.expense.Expense;
import splitwise.expense.ExpenseEvent;
import splitwise.expense.ExpenseListener;

public class UserExpenseListener implements ExpenseListener {
    @Override
    public void notify(ExpenseEvent event, Expense expense) {
        if (event == ExpenseEvent.ADD) {
            addExpense(expense);
        }
    }

    private void addExpense(Expense expense) {
        Map<User, Double> splits = expense.getSplit();
        User payee = expense.getPayee();

        for (Map.Entry<User, Double> entry : splits.entrySet()) {
            User participant = entry.getKey();
            Double amount = entry.getValue();

            if (participant != payee) {
                participant.balanceSheet.addAmountOwed(payee, amount);
                payee.balanceSheet.addAmountDue(participant, amount);
            } else {
                payee.balanceSheet.addSpend(amount);
            }
        }
    }
}
