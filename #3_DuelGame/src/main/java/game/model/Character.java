package game.model;

import java.util.List;

public class Character extends AbstractCharacter {

    public int owningPlayerIndex;

    public Character(CharacterClassEnum className, int hitPoints, int manaPoints, int owningPlayerIndex) {
        super(className, hitPoints, manaPoints);
        this.owningPlayerIndex = owningPlayerIndex;
    }

}
