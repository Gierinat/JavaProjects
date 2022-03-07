package game.model;

import static game.model.CharacterClassEnum.MAGE;
import static game.model.CharacterClassEnum.WARRIOR;

public class Heal extends Action {

    @Override
    void calculateResult(Character actionMaker) {

        if (actionMaker.className == WARRIOR) {
            mana = 5;
            hitPoints = (int) ((Math.random() + 1) * 10);
        } else if (actionMaker.className == MAGE) {
            mana = 10;
            hitPoints = (int) ((Math.random() + 1) * 15);
        } else {
            hitPoints = 0;
        }

    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
