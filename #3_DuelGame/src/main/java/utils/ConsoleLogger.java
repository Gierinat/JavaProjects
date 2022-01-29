package utils;


import java.io.PrintStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ConsoleLogger implements Logger {
    private final PrintStream printStream;
    private final String logLevel;
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd'T'HH:mm:ss:SSS");

    public ConsoleLogger(String logLevel, PrintStream printStream) {
        this.printStream = printStream;
        this.logLevel = logLevel;
    }

    @Override
    public void log(String message, String objectToString, String objectHash) {
        if("DEBUG".equals(logLevel)) {
            debug(message, objectToString, objectHash);
        } else {
            info(message);
        }
    }

    private void info(String message) {
        printStream.println(dateTimeFormatter.format(LocalDateTime.now()) + " INFO " + message);
    }

    private void debug(String message, String objectToString, String objectHash) {
        printStream.println(dateTimeFormatter.format(LocalDateTime.now()) + " DEBUG " + message +
                " #SOURCE: " + objectToString + "#hashCode: " + objectHash);
    }
}
