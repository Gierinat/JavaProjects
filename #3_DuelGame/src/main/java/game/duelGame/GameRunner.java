package game.duelGame;

import game.utils.ConsolePrinter;
import game.utils.LoggerPrintStream;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class GameRunner {

    public static void main(String[] args) {

        String logLevel = prepareLogLevel(args);
        PrintStream logPrintStream = null;
        {
            try {
                logPrintStream = new PrintStream("logFile.txt");
            } catch (FileNotFoundException e) {
                System.out.println("Game could not start.\n" +
                        "Due to log file generation problem.\n");
                e.printStackTrace(System.out);
            }
        }

        if (logPrintStream != null) {
            new DuelGame(
                    new LoggerPrintStream(logLevel, logPrintStream),
                    new ConsolePrinter()).run();
        }
    }

    private static String prepareLogLevel(String[] args) {

        String logLevel;
        if (args.length > 0) {
            if ("-logDEBUG".equals(args[0])) {
                logLevel = "DEBUG";
            } else {
                logLevel = "INFO";
            }
        } else logLevel = "INFO";

        return logLevel;
    }
}
