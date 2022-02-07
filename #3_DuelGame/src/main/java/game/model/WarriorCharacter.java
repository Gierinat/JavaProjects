package game.model;

public class WarriorCharacter extends AbstractCharacter {

    public WarriorCharacter() {
        super("Warrior", 200, 20);
    }

    @Override
    int attack() {
        return (int) ((Math.random() + 1) * 10);
    }

    @Override
    int heal() {
        return (int) ((Math.random() + 1) * 10);
    }
}
