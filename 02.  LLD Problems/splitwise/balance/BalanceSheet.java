package splitwise.balance;

import java.util.HashMap;
import java.util.Map;

import splitwise.user.User;

public class BalanceSheet {

    Map<User, Balance> balances;
    double totalOwed;
    double totalDue;
    double totalSpent;

    public BalanceSheet() {
        this.balances = new HashMap<>();
        totalSpent = 0;
        totalDue = 0;
        totalOwed = 0;
    }

    public Map<User, Balance> getBalances() {
        return balances;
    }

    public void addAmountOwed(User friend, Double amountOwed) {
        Balance existingBalance = balances.get(friend);
        if (existingBalance == null) {
            balances.put(friend, new Balance(0, amountOwed));
        } else {
            existingBalance.setAmountOwed(existingBalance.getAmountOwed() + amountOwed);
        }
        totalOwed += amountOwed;
        addSpend(amountOwed);
    }

    public void addAmountDue(User friend, Double amountDue) {
        Balance existingBalance = balances.get(friend);
        if (existingBalance == null) {
            balances.put(friend, new Balance(amountDue, 0));
        } else {
            existingBalance.setAmountDue(existingBalance.getAmountDue() + amountDue);
        }
        totalDue += amountDue;
    }

    public void addSpend(Double amount) {
        totalSpent += amount;
    }

    public String display() {
        System.out.println("Total Spent: " + totalSpent);
        System.out.println("Total You Get Back: " + totalDue);
        System.out.println("Total Your Owe: " + totalOwed + "\n");

        for (Map.Entry<User, Balance> entry : balances.entrySet()) {
            String userName = entry.getKey().getName();
            Balance balance = entry.getValue();
            System.out.println("Friend: " + userName +
                    " | You Get Back: " + balance.getAmountDue() +
                    " | You Owe: " + balance.getAmountOwed());
        }

        return "Total owed: " + totalOwed + "\nTotal due: " + totalDue + "\n" + balances.toString();
    }
}
