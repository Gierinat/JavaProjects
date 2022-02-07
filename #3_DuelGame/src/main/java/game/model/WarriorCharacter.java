package game.model;

public class WarriorCharater extends AbstractCharacter {

    String className = "Warrior";
    int hitPoints = 200;

    @Override
    int attack() {
        return (int) ((Math.random() + 1) * 10);
    }

    @Override
    int heal() {
        return (int) ((Math.random() + 1) * 10);
    }
}
