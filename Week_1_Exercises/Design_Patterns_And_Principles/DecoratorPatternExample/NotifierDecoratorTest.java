package Design_Patterns_And_Principles.DecoratorPatternExample;

// Component Interface
interface Notifier {
    void send(String message);
}

// Concrete Component
class EmailNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("Sending email notification: " + message);
    }
}

// Abstract Decorator class
abstract class NotifierDecorator implements Notifier {
    protected Notifier notifier;

    public NotifierDecorator(Notifier notifier) {
        this.notifier = notifier;
    }

    @Override
    public void send(String message) {
        notifier.send(message);
    }
}

// Concrete Decorator class for SMS notifications
class SMSNotifierDecorator extends NotifierDecorator {
    public SMSNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        System.out.println("Sending SMS notification: " + message);
    }
}

// Concrete Decorator class for Slack notifications
class SlackNotifierDecorator extends NotifierDecorator {
    public SlackNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        System.out.println("Sending Slack notification: " + message);
    }
}

// Test class to demonstrate the Decorator implementation
public class NotifierDecoratorTest {
    public static void main(String[] args) {
        // Base notifier
        Notifier emailNotifier = new EmailNotifier();

        // Decorated notifiers
        Notifier smsNotifier = new SMSNotifierDecorator(emailNotifier);
        Notifier slackNotifier = new SlackNotifierDecorator(emailNotifier);

        // Sending notifications via different channels
        emailNotifier.send("Hello!");
        System.out.println();

        smsNotifier.send("Hello via SMS!");
        System.out.println();

        slackNotifier.send("Hello via Slack!");
    }
}
