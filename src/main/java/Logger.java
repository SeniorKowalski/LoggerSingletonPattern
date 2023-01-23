import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {

    private int counter = 1;
    private static final Logger logger = new Logger();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
    LocalDateTime dateTime = LocalDateTime.now();

    private Logger() {
    }

    void log(String msg) {
        System.out.println("[" + dateTime.withNano(0).format(formatter) + " " + counter++ + "] " + msg);
    }

    public static synchronized Logger getInstance() {
        return logger;
    }
}