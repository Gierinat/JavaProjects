package game.model;

import static game.model.CharacterClassEnum.MAGE;

public class MageCharacter extends Character{

    public MageCharacter() {
        super(MAGE, 100, 50);
        actions.add((Action) new Attack());
        actions.add((Action) new Heal());
    }


}