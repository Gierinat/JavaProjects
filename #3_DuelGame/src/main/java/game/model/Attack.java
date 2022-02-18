package game.model;

import static game.model.CharacterClassEnum.MAGE;
import static game.model.CharacterClassEnum.WARRIOR;

public class Attack extends Action {

    @Override
    void calculateResult(Character actionMaker) {
        mana = 0;
        if (actionMaker.className == WARRIOR) {
            hitPoints = (int) ((Math.random() + 1) * 10);
        } else if (actionMaker.className == MAGE) {
            hitPoints = (int) ((Math.random() + 1) * 7);
        } else {
            hitPoints = 0;
        }
    }
}
