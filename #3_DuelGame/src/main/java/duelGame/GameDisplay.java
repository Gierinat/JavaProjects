package duelGame;

import utils.*;

public abstract class GameDisplay {
    Printable printer = new ConsolePrinter();
    Inputable input = new KeyInputReceiver();
    Loggable logger;

    public GameDisplay(Loggable logger) {
        this.logger = logger;
    }

    void log(String message) {
        logger.log(message, this.toString(), String.valueOf(this.hashCode()));
    }
}
