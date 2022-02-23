package game.model;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractCharacter {

    CharacterClassEnum className;
    int hitPoints;
    int manaPoints;
    int currentHitPoints;
    int currentManaPoints;
    List<Action> actions = new ArrayList<>();

    public AbstractCharacter(CharacterClassEnum characterClass, int hitPoints, int manaPoints) {
        this.className = characterClass;
        this.hitPoints = this.currentHitPoints = hitPoints;
        this.manaPoints = this.currentManaPoints = manaPoints;
    }

    public String toStringWithStats() {
        return className.toString()
                + " HP:" + currentHitPoints + "/" + hitPoints
                + " M:" + currentManaPoints + "/" + manaPoints;
    }

    @Override
    public String toString() {
        return className.toString();
    }

}
