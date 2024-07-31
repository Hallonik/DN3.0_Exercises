package Design_Patterns_And_Principles.SingletonPatternExample;

 class Logger {
    private static Logger instance;

    // Private constructor to prevent instantiation from outside
    private Logger() {
        // Initialization code if needed
    }

    // Public method to get the instance of Logger class
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("[LOG] " + message);
    }
}
public class LoggerTest {
    public static void main(String[] args) {
        // Get the instance of Logger
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        // Verify that logger1 and logger2 point to the same instance
        System.out.println("Logger instance equality: " + (logger1 == logger2));

        // Log messages using the logger
        logger1.log("This is a log message.");
        logger2.log("Another log message.");
    }
}