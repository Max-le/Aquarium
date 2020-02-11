package models;

import utils.EmojiCodes;

public abstract class HerbivoreFish extends Fish{

    public HerbivoreFish(String name) {
        super(name);
    }

    public HerbivoreFish(String name, String sex) {
        super(name, sex);
    }

    @Override
    public boolean eat(Organism o) {
        boolean hasEaten = false;
        if (isHungry()){
            Weed w = (Weed) o;
            if (targetFood == null) {
                targetFood = w;
            }
            targetFood.loseHp(2);
            gainHp(3);
            hasEaten=true;
        }
    return hasEaten;
    }

    @Override
    public String toString() {
        return EmojiCodes.HERBIVORE.code()+" "+super.toString();
    }
}
