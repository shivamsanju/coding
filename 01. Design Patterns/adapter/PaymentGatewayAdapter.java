package adapter;

public class PaymentGatewayAdapter implements PaymentGateway {
    private NewPaymentGateway newPaymentGateway;

    public PaymentGatewayAdapter(NewPaymentGateway newPaymentGateway) {
        this.newPaymentGateway = newPaymentGateway;
    }

    // Adapting to legacy interface
    @Override
    public void processPayment(double amountInInr) {
        double amountInDollars = amountInInr / 80;
        newPaymentGateway.makePayment(amountInDollars);

    }
}
