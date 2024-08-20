package splitwise.expense;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import splitwise.split.EqualStrategy;
import splitwise.split.PercentageStrategy;
import splitwise.split.SplitStrategy;
import splitwise.split.SplitType;
import splitwise.split.UnequalStrategy;

public class ExpenseController {
    SplitStrategy strategy;
    List<Expense> expenses;
    ExpenseEventManager expenseEventManager;

    public ExpenseController(ExpenseEventManager expenseEventManager) {
        this.expenses = new ArrayList<>();
        this.expenseEventManager = expenseEventManager;
    }

    public Expense addExpense(AddExpenseRequest request) {
        if (request.splitType == SplitType.EQUAL) {
            this.strategy = new EqualStrategy(request.participants, request.totalAmount);
        } else if (request.splitType == SplitType.UNEQUAL) {
            this.strategy = new UnequalStrategy(request.participants, request.amounts);
        } else {
            this.strategy = new PercentageStrategy(request.participants, request.percentages, request.totalAmount);
        }
        var splitsMap = strategy.split();

        String id = UUID.randomUUID().toString();
        Expense newExpense = new Expense(id, request.name, request.description,
                request.payee, request.totalAmount, splitsMap);
        expenses.add(newExpense);
        expenseEventManager.notify(ExpenseEvent.ADD, newExpense);
        return newExpense;
    }
}
