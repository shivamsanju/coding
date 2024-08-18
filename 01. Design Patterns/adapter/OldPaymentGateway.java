package adapter;

// Legacy code implementing legacy interface
public class OldPaymentGateway implements PaymentGateway {
    @Override
    public void processPayment(double amountInInr) {
        System.out.println("Processing payment of INR " + amountInInr + " through old payment gateway.");
    }
}
