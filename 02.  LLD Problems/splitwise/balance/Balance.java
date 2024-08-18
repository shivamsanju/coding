package splitwise.balance;

public class Balance {
    double amountDue;
    double amountOwed;

    public Balance(double amountDue, double amountOwed) {
        this.amountDue = amountDue;
        this.amountOwed = amountOwed;
    }

    public double getAmountDue() {
        return amountDue;
    }

    public double getAmountOwed() {
        return amountOwed;
    }

    public void setAmountOwed(double amountOwed) {
        this.amountOwed = amountOwed;
    }

    public void setAmountDue(double amountDue) {
        this.amountDue = amountDue;
    }

}
