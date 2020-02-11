package models;


import utils.EmojiCodes;

public abstract class CarnivoreFish extends Fish {

    public CarnivoreFish(String name) {
        super(name);
    }

    public CarnivoreFish(String name, String sex) {
        super(name, sex);
    }

    public boolean eat(Organism fish) {
        boolean hasEaten = false;
        if (isHungry()){
            if( targetFood == null){
                //Assign new target.
                this.targetFood = fish;
            }
            targetFood.loseHp(4);
            gainHp(5);
            hasEaten = true;
        }
        return hasEaten;
    }
    public String toString() {
        return EmojiCodes.CARNIVORE.code()+" "+super.toString();
    }

}
