package game.model;

import java.util.List;

import static game.model.CharacterClassEnum.MAGE;

public class MageCharacter extends Character {

    public MageCharacter() {
        super(MAGE, 100, 50);
        appendActions();
    }

    private void appendActions() {
        actions.add(new Attack());
        actions.add(new Heal());
    }

}
