package game.model;

public class MageCharacter extends AbstractCharacter{

    public MageCharacter() {
        super("Mage", 100, 50);
    }

    @Override
    int attack() {
        return (int) ((Math.random() + 1) * 7);
    }

    @Override
    int heal() {
        return (int) ((Math.random() + 1) * 15);
    }
}
