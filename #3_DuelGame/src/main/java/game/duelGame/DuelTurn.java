package game.duelGame;

import game.model.Action;
import game.model.Character;
import game.model.Player;
import game.utils.Logger;
import game.utils.Printer;
import game.utils.Receiver;

import java.util.ArrayDeque;
import java.util.List;

public class DuelTurn extends GameBase {

    List<Player> players;
    ArrayDeque<Character> allCharacters = new ArrayDeque<>();

    public DuelTurn(Logger logger, Printer printer, Receiver receiver, List<Player> players) {
        super(logger, printer, receiver);
        this.players = players;
    }

    // TODO: 23.02.2022 refactor so Turn returns result
    void start(int roundCounter, int turnCounter) {
        log("Duel Turn has started");

        for (int i = 0; i < 2; i++) {
            allCharacters.add(players.get(0).characters.get(i));
            allCharacters.add(players.get(1).characters.get(i));
        }

        for (Character character : allCharacters) {
            printer.printTitle("Round " + roundCounter + " - Turn " + turnCounter);
            printer.printSubTitle("Player " + (character.owningPlayerIndex + 1) + ": " +
                    players.get(character.owningPlayerIndex).name +
                    " {Character: " + character.toStringWithStats() + "}");
            printer.sideBySidePlayerDisplay(players);

            printer.printDivider();
            printer.printLine(listActionsToChoose(character));
            receiver.receive(1, character.actions.size());

        }
    }

    private String listActionsToChoose(Character character) {
        StringBuilder actionList = new StringBuilder();
        actionList.append("Choose Action: \n");

        for (Action action : character.actions) {
            actionList.append(character.actions.indexOf(action) + 1).append(". ").append(action.toString()).append("\n");

        }
        return actionList.toString().stripTrailing();
    }
}
