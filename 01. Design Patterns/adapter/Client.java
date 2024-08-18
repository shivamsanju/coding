package adapter;

public class Client {
    public static void main(String[] args) {
        NewPaymentGateway newPg = new NewPaymentGateway();
        PaymentGateway pg = new PaymentGatewayAdapter(newPg);
        PaymentGateway oldPg = new OldPaymentGateway();

        oldPg.processPayment(2000);
        pg.processPayment(2000);
    }
}
