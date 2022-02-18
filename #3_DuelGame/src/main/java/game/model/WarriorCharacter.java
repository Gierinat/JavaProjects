package game.model;

import static game.model.CharacterClassEnum.WARRIOR;

public class WarriorCharacter extends Character {

    public WarriorCharacter() {
        super(WARRIOR, 200, 20);
        actions.add(new Attack());
        actions.add(new Heal());
    }

}
