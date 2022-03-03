package game.model;

import static game.model.CharacterClassEnum.WARRIOR;

public class WarriorCharacter extends Character {

    public WarriorCharacter(int owningPlayerNumber) {
        super(WARRIOR, 200, 20, owningPlayerNumber);
        appendActions();
    }

    private void appendActions() {
        actions.add(new Attack());
        actions.add(new Heal());
    }
}
