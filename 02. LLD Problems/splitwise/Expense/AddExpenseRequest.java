package splitwise.Expense;

import splitwise.Split.SplitType;
import splitwise.User.User;

import java.util.List;

public class AddExpenseRequest {
    SplitType splitType;
    Double totalAmount;
    User payee;
    String name;
    String description;
    List<User> participants;
    List<Double> percentages;
    List<Double> amounts;

    // Can use method overloading for each split type
    public AddExpenseRequest(SplitType splitType, Double totalAmount, User payee, String name,
                             String description, List<User> participants, List<Double> percentages, List<Double> amounts) {

        if (splitType == SplitType.UNEQUAL) {
            if (participants.size() != amounts.size()) {
                throw new IllegalArgumentException("Participants and amounts lists must have the same size");
            }
        }

        if (splitType == SplitType.PERCENTAGE) {
            if (participants.size() != percentages.size()) {
                throw new IllegalArgumentException("Participants and percentages lists must have the same size");
            }
            double totalPercentage = percentages.stream().mapToDouble(Double::doubleValue).sum();
            if (totalPercentage != 100.0) {
                throw new IllegalArgumentException("Percentages must sum to 100.0");
            }
        }

        this.splitType = splitType;
        this.totalAmount = totalAmount;
        this.payee = payee;
        this.name = name;
        this.description = description;
        this.participants = participants;
        this.percentages = percentages;
        this.amounts = amounts;
    }
}