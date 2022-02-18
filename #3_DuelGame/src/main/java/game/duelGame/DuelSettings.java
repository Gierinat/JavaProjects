package game.duelGame;

import game.DuelOptionsEnum;
import game.model.Character;
import game.model.*;
import game.utils.Logger;
import game.utils.Printer;
import game.utils.Receiver;

import java.util.ArrayList;
import java.util.List;

import static game.DuelOptionsEnum.BACK;
import static game.DuelOptionsEnum.fromNumber;
import static game.model.CharacterClassEnum.WARRIOR;

public class DuelSettings extends GameBase {

    List<Player> players = new ArrayList<>();

    DuelSettings(Printer printer, Receiver receiver, Logger logger) {
        super(logger, printer, receiver);
        initializePlayers();
    }

    void run() {
        log("New Duel settings entered");


        DuelOptionsEnum menuChoice;
        do {
            printer.printTitle("Duel Settings");
            printer.printSubTitle(players.toString().replace("null", "SET_PLAYER"));
            displayMenu();

            int inputChoice = input.receive(1, DuelOptionsEnum.values().length);
            menuChoice = fromNumber(inputChoice);

            switch (menuChoice) {
                case SET_PLAYER_1: {
                    setPlayer(0);
                    break;
                }
                case SET_PLAYER_2: {
                    setPlayer(1);
                    break;
                }
                case START_DUEL: {
                    log("Duel Started");
                    if (!players.contains(null)) {
                        printer.printLine("Starting Duel!!! Get ready!!!");
                    } else {
                        printer.printLine("Setup players first.");
                    }
                    break;
                }
                case BACK: {
                    log("Back chosen.");
                    break;
                }
                default: {
                    log("Not implemented option chosen.");
                    printer.printLine("No such option, please choose again.\n");
                }
            }

        } while (!menuChoice.equals(BACK));
    }

    private void initializePlayers() {
        for (int i = 0; i < 2; i++) {
            players.add(null);
        }
    }

    private void setPlayer(int playerNumber) {
        log("Setting Player_" + (playerNumber + 1));
        printer.printLine("Set Player " + (playerNumber + 1) + " name: ");
        String name = input.receive();
        List<Character> characters = setCharacter(2);
        players.set(playerNumber, new Player(name, playerNumber, characters));
    }

    private List<Character> setCharacter(int numberOfCharacters) {

        List<Character> characters = new ArrayList<>();
        for (int i = 0; i < numberOfCharacters; i++) {
            log("Setting Character_" + i);
            printer.printLine("Pick a Character " + (i + 1) + "/" + numberOfCharacters + ": ");
            displayCharacters();
            CharacterClassEnum characterClass = CharacterClassEnum.fromNumber(input.receive(1, CharacterClassEnum.values().length));
            Character character;

            if (characterClass == WARRIOR) {
                character = new WarriorCharacter();
            } else {
                character = new MageCharacter();
            }
            characters.add(character);
        }
        return characters;
    }

    private void displayMenu() {
        for (DuelOptionsEnum option : DuelOptionsEnum.values()) {
            printer.printLine(option.toString());
        }
    }

    private void displayCharacters() {
        for (CharacterClassEnum option : CharacterClassEnum.values()) {
            printer.printLine(option.toStringWithNumber());
        }
    }
}