package game.duelGame;

import game.utils.*;

public abstract class GameBase {

    Printer printer = new ConsolePrinter();
    Receiver input;
    Logger logger;

    public GameBase(Logger logger) {
        this.logger = logger;
        this.input = new InputReceiver(logger);
    }

    void log(String message) {
        logger.log(message, this.toString(), String.valueOf(this.hashCode()));
    }
}
