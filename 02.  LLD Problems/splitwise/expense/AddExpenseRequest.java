package splitwise.expense;

import java.util.List;

import splitwise.split.SplitType;
import splitwise.user.User;

public class AddExpenseRequest {
    SplitType splitType;
    Double totalAmount;
    User payee;
    String name;
    String description;
    List<User> users;
    List<Double> percentages;
    List<Double> amounts;

    // Can use method overloading for each split type
    public AddExpenseRequest(SplitType splitType, Double totalAmount, User payee, String name,
            String description, List<User> users, List<Double> percentages, List<Double> amounts) {
        this.splitType = splitType;
        this.totalAmount = totalAmount;
        this.payee = payee;
        this.name = name;
        this.description = description;
        this.users = users;
        this.percentages = percentages;
        this.amounts = amounts;
    }
}