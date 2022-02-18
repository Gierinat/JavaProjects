package game.model;

import java.util.Arrays;
import java.util.List;

public class Player {
    String name;
    int ordinal;
    List<Character> characters;

    public Player(String name, int ordinal, List<Character> characters) {
        this.name = name;
        this.ordinal = ordinal;
        this.characters = characters;
    }

    @Override
    public String toString() {
        return "Player " + (ordinal + 1) + ": " + name +
                " (" + characters.toString() + ")";
    }
}
