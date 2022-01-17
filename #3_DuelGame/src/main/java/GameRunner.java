import utils.Logger;
import utils.StandardOutputLogger;

public class GameRunner {
    public static Logger logger = new StandardOutputLogger();

    public static void main(String[] args) {
        DuelGame duelGame = new DuelGame();
        logger.setObject(duelGame);
        duelGame.setLogger(logger);
        duelGame.run();
    }
}
