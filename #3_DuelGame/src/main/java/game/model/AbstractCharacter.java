package game.model;

public abstract class AbstractCharacter {

    String className;
    int hitPoints;
    int manaPoints;

    public AbstractCharacter(String className, int hitPoints, int manaPoints) {
        this.className = className;
        this.hitPoints = hitPoints;
        this.manaPoints = manaPoints;
    }

    abstract int attack();
    abstract int heal();

    @Override
    public String toString() {
        return className;
    }

}
