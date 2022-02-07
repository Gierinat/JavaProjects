package game.duelGame;

import game.DuelOptionsEnum;
import game.model.AbstractCharacter;
import game.model.Player;
import game.model.WarriorCharacter;
import game.utils.Logger;
import game.utils.Printer;
import game.utils.Receiver;

import java.util.Arrays;

import static game.DuelOptionsEnum.BACK;
import static game.DuelOptionsEnum.fromNumber;

public class DuelSettings extends GameBase {

    Player[] players = new Player[2];

    DuelSettings(Printer printer, Receiver input, Logger logger) {
        super(logger, printer, input);
    }

    void run() {
        log("New Duel settings entered");


        DuelOptionsEnum menuChoice;
        do {
            printer.printTitle("Duel Settings");
            printer.printSubTitle(Arrays.toString(players).replace("null", "SETUP_PLAYER"));
            displayMenu();

            int inputChoice = input.receive(1, DuelOptionsEnum.values().length);
            menuChoice = fromNumber(inputChoice);

            switch (menuChoice) {
                case SET_PLAYER_1: {
                    log("Setting Player_1");
                    setPlayer(0);
                    break;
                }
                case SET_PLAYER_2: {
                    log("Setting Player_2");
                    setPlayer(1);
                    break;
                }
                case START_DUEL: {
                    log("Duel Started");
                    // TODO: 07.02.2022 Start Duel, but first validate if two players exist 
                    break;
                }
                case BACK: {
                    log("Back chosen.");
                    break;
                }
                default: {
                    log("Not implemented option chosen.");
                    printer.printLine("Option not yet implemented.\n");
                }
            }

        } while (!menuChoice.equals(BACK));
    }

    private void setPlayer(int playerNumber) {
        printer.printLine("Set Player " + (playerNumber + 1) + " name: ");
        String name = input.receive();
        AbstractCharacter[] characters = setCharacter(1);
        players[playerNumber] = new Player(name, playerNumber, characters);
    }

    private AbstractCharacter[] setCharacter(int numberOfCharacters) {

        AbstractCharacter[] characters = new AbstractCharacter[numberOfCharacters];
        for (int i = 0; i < numberOfCharacters; i++) {
            // TODO: 08.02.2022 Character Class selection
            characters[i] = new WarriorCharacter();
        }
        return characters;
    }

    private void displayMenu() {
        for (DuelOptionsEnum option : DuelOptionsEnum.values()) {
            printer.printLine(option.toString());
        }
    }
}
