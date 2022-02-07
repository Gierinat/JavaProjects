package game.duelGame;

import game.utils.*;

public abstract class GameBase {
    Printable printer = new ConsolePrinter();
    Inputable input;
    Loggable logger;

    public GameBase(Loggable logger) {
        this.logger = logger;
        this.input = new KeyInputReceiver(logger);
    }

    void log(String message) {
        logger.log(message, this.toString(), String.valueOf(this.hashCode()));
    }
}
