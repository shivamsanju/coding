package splitwise.expense;

import java.util.Map;

import splitwise.user.User;

public class Expense {
    String id;
    String name;
    String description;
    User payee;
    double totalAmount;
    Map<User, Double> split;

    public Expense(String id, String name, String description, User payee, double totalAmount,
            Map<User, Double> split) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.totalAmount = totalAmount;
        this.payee = payee;
        this.split = split;
    }

    public Map<User, Double> getSplit() {
        return split;
    }

    public User getPayee() {
        return payee;
    }

    public double getTotalAmount() {
        return totalAmount;
    }
}
