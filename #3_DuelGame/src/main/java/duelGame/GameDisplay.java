package duelGame;

import utils.ConsolePrinter;
import utils.Loggable;
import utils.Printable;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public abstract class GameDisplay {
    Printable printer = new ConsolePrinter();
    String logLevel;
    Loggable logger;
    PrintStream logPrintStream;
    {
        try {
            logPrintStream = new PrintStream("logFile.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    void log(String message) {
        logger.log(message, this.toString(), String.valueOf(this.hashCode()));
    }
}
