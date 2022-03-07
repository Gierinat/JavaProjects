package game.model;

import java.util.List;

public class Player {
    public String name;
    int ordinalNumber;
    public List<Character> characters;

    public Player(String name, int ordinalNumber, List<Character> characters) {
        this.name = name.toUpperCase();
        this.ordinalNumber = ordinalNumber;
        this.characters = characters;
    }

    @Override
    public String toString() {
        return "Player " + (ordinalNumber + 1) + ": " + name +
                " (" + characters.toString() + ")";
    }
}
