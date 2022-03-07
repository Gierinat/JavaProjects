package game.duelGame;

import game.utils.Logger;
import game.utils.Printer;
import game.utils.Receiver;

public abstract class GameBase {

    Printer printer;
    Receiver receiver;
    Logger logger;

    public GameBase(Logger logger, Printer printer, Receiver receiver) {
        this.printer = printer;
        this.logger = logger;
        this.receiver = receiver;
    }

    void log(String message) {
        logger.log(message, this.toString(), String.valueOf(this.hashCode()));
    }
}
