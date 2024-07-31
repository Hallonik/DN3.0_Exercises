package Design_Patterns_And_Principles.AdapterPatternExample;

// Target Interface
interface PaymentProcessor {
    void processPayment(double amount);
}

// Adaptee Class for PayPal
class PayPal {
    void sendPayment(double amount) {
        System.out.println("Payment of $" + amount + " processed via PayPal.");
    }
}

// Adaptee Class for Stripe
class Stripe {
    void makePayment(double amount) {
        System.out.println("Payment of $" + amount + " processed via Stripe.");
    }
}

// Adapter Class for PayPal
class PayPalAdapter implements PaymentProcessor {
    private PayPal payPal;

    public PayPalAdapter(PayPal payPal) {
        this.payPal = payPal;
    }

    @Override
    public void processPayment(double amount) {
        payPal.sendPayment(amount);
    }
}

// Adapter Class for Stripe
class StripeAdapter implements PaymentProcessor {
    private Stripe stripe;

    public StripeAdapter(Stripe stripe) {
        this.stripe = stripe;
    }

    @Override
    public void processPayment(double amount) {
        stripe.makePayment(amount);
    }
}

// Test class to demonstrate the Adapter implementation
public class PaymentAdapterTest {
    public static void main(String[] args) {
        // Using PayPal via the adapter
        PayPal payPal = new PayPal();
        PaymentProcessor payPalAdapter = new PayPalAdapter(payPal);
        payPalAdapter.processPayment(100.0);

        // Using Stripe via the adapter
        Stripe stripe = new Stripe();
        PaymentProcessor stripeAdapter = new StripeAdapter(stripe);
        stripeAdapter.processPayment(150.0);
    }
}
