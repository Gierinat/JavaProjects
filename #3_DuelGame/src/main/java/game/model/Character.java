package game.model;

import java.util.ArrayList;
import java.util.List;

public class Character extends AbstractCharacter {

    int currentHp;
    int currentMana;
    List<Action> actions = new ArrayList<>();

    public Character(CharacterClassEnum className, int hitPoints, int manaPoints) {
        super(className, hitPoints, manaPoints);
    }

}
