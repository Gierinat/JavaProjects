package game.model;

import java.util.List;

public class Player {
    String name;
    int ordinalNumber;
    List<Character> characters;

    public Player(String name, int ordinalNumber, List<Character> characters) {
        this.name = name;
        this.ordinalNumber = ordinalNumber;
        this.characters = characters;
    }

    @Override
    public String toString() {
        return "Player " + (ordinalNumber + 1) + ": " + name +
                " (" + characters.toString() + ")";
    }
}
