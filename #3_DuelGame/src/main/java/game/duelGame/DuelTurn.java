package game.duelGame;

import game.model.Player;
import game.utils.Logger;
import game.utils.Printer;
import game.utils.Receiver;

import java.util.List;

public class DuelTurn extends GameBase{

    List<Player> players;
    public DuelTurn(Logger logger, Printer printer, Receiver receiver, List<Player> players) {
        super(logger, printer, receiver);
        this.players = players;
    }

    // TODO: 23.02.2022 refactor so Turn returns result
    void start(int playerIndicator) {
        log("Duel has started");
        printer.printTitle("Player " + (playerIndicator + 1) + " turn");
        printer.sideBySidePlayerDisplay(players);
        receiver.receive();
    }
}
