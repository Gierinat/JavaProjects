package game.model;

import java.util.Arrays;

public class Player {
    String name;
    int ordinal;
    AbstractCharacter[] characters;

    public Player(String name, int ordinal, AbstractCharacter[] characters) {
        this.name = name;
        this.ordinal = ordinal;
        this.characters = characters;
    }

    @Override
    public String toString() {
        return "Player " + (ordinal + 1) + ": " + name +
                " (" + Arrays.toString(characters) + ")";
    }
}
