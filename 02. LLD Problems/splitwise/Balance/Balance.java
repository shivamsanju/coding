package splitwise.Balance;

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

    public void setAmountDue(double amountDue) {
        this.amountDue = amountDue;
    }

    public double getAmountOwed() {
        return amountOwed;
    }

    public void setAmountOwed(double amountOwed) {
        this.amountOwed = amountOwed;
    }

}
