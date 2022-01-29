package duelGame;

import utils.Logger;

import java.io.PrintStream;

public abstract class GameDisplay {
    String logLevel;
    Logger logger;
    PrintStream logPrintStream;

    void log(String message) {
        logger.log(message, this.toString(), String.valueOf(this.hashCode()));
    }
}
