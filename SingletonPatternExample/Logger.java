public class Logger {
    // Static variable reference of single_instance of type Logger
    private static Logger instance;

    // Private constructor to restrict instantiation of the class from other classes
    private Logger() {
        System.out.println("Logger Initialized");
    }

    // Static method to create instance of Singleton class
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    // Example log method
    public void log(String message) {
        System.out.println("Log: " + message);
    }
}