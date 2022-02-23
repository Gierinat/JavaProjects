package game.duelGame;

import game.model.Player;
import game.utils.Logger;
import game.utils.Printer;
import game.utils.Receiver;

import java.util.List;

public class DuelRound extends GameBase {

    List<Player> players;

    public DuelRound(Logger logger, Printer printer, Receiver receiver, List<Player> players) {
        super(logger, printer, receiver);
        this.players = players;
    }

    // TODO: 23.02.2022 refactor so it returns result
    void start(int roundNumber) {

        log("Duel has started");
        printer.printTitle("Starting Duel!!! Get ready!!!");
        printer.printSubTitle("Round " + (roundNumber + 1));

        int playerIndicator = 0;
        do {
            new DuelTurn(logger, printer, receiver, players).start(playerIndicator);
            playerIndicator = playerIndicator == 0 ? 1 : 0;
        } while (true);
    }
}
