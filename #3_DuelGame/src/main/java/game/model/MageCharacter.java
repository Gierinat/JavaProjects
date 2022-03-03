package game.model;

import java.util.List;

import static game.model.CharacterClassEnum.MAGE;

public class MageCharacter extends Character {

    public MageCharacter(int owningPlayerIndex) {
        super(MAGE, 100, 50, owningPlayerIndex);
        appendActions();
    }

    private void appendActions() {
        actions.add(new Attack());
        actions.add(new Heal());
    }

}
