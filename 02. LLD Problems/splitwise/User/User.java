package splitwise.User;

import splitwise.Balance.BalanceSheet;

public class User {
    String id;
    String name;
    BalanceSheet balanceSheet;

    public User(String id, String name) {
        this.id = id;
        this.name = name;
        this.balanceSheet = new BalanceSheet();
    }

    public BalanceSheet getBalanceSheet() {
        return balanceSheet;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}