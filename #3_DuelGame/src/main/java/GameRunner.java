import utils.Logger;
import utils.ConsoleLogger;

public class GameRunner {
    public static Logger logger = new ConsoleLogger();

    public static void main(String[] args) {
        DuelGame duelGame = new DuelGame();
        logger.setObject(duelGame);
        duelGame.setLogger(logger);
        duelGame.run();
    }
}
