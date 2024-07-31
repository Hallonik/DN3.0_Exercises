package Design_Patterns_And_Principles.StrategyPatternExample;

interface PaymentStrategy {
    void pay(double amount);
}

class CreditCardPayment implements PaymentStrategy {
    private String name;
    private String cardNumber;

    public CreditCardPayment(String name, String cardNumber) {
        this.name = name;
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using Credit Card.");
    }
}

 class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using PayPal.");
    }
}

 class PaymentContext {
    private PaymentStrategy paymentStrategy;

    public PaymentContext(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void executePayment(double amount) {
        paymentStrategy.pay(amount);
    }
}

public class StrategyPatternDemo {
    public static void main(String[] args) {
        // Create different payment strategies
        PaymentStrategy creditCard = new CreditCardPayment("John Doe", "1234-5678-9012-3456");
        PaymentStrategy paypal = new PayPalPayment("john.doe@example.com");

        // Create PaymentContext and set strategy
        PaymentContext paymentContext = new PaymentContext(creditCard);
        System.out.println("Using Credit Card Payment:");
        paymentContext.executePayment(100.00);
        
        System.out.println();

        // Change strategy to PayPal
        paymentContext = new PaymentContext(paypal);
        System.out.println("Using PayPal Payment:");
        paymentContext.executePayment(200.00);
    }
}



