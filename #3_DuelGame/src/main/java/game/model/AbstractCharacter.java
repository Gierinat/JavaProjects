package game.model;

public abstract class AbstractCharacter {

    CharacterClassEnum className;
    int hitPoints;
    int manaPoints;

    public AbstractCharacter(CharacterClassEnum characterClass, int hitPoints, int manaPoints) {
        this.className = characterClass;
        this.hitPoints = hitPoints;
        this.manaPoints = manaPoints;
    }


    @Override
    public String toString() {
        return className.toString();
    }

}
