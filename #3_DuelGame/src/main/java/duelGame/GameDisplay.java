package duelGame;

import utils.Logger;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public abstract class GameDisplay {
    String logLevel;
    Logger logger;
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
