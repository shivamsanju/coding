package decorator;

public class Client {
    public static void main(String[] args) {
        Notifier notifier = new BasicNotifier();
        notifier.send("Hello");

        // Add sms functionality
        Notifier smsNotifier = new SMSNotifierDecorator(notifier);
        smsNotifier.send("Hello all");

        // Add slack along with sms
        Notifier slackNotifier = new SlackNotifierDecorator(smsNotifier);
        slackNotifier.send("Hello to everyone");

        // Only slack notification with email
        Notifier onlySlackNotifier = new SlackNotifierDecorator(notifier);
        onlySlackNotifier.send("hey");
    }
}
