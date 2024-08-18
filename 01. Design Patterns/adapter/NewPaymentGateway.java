package adapter;

// Adaptee class
public class NewPaymentGateway {
    public void makePayment(double amountInDollars) {
        System.out.println("Processing payment of $" + amountInDollars + " through new payment gateway.");
    }
}