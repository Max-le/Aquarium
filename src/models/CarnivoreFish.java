package models;

import java.util.Random;

public class CarnivoreFish extends Fish {


    private enum CarniRace{
        THON, MEROU, CLOWN
    }

    private CarniRace race;

    public String getRace(){
        return this.race.toString();
    }


    public CarnivoreFish(String name, int age, String sex){
        super(name, age, sex);
        this.race = CarniRace.THON;
    }

    @Override
    public String toString() {
        return CARNI_FISH_EMOJI+getLifeSymbol()+" "+getName()+" "+
                getSex() + super.toString() + "of race "+race.toString();
    }


        /**
         * The fish tries to eat.
         * @param fish fish that will be used as new target if the eater has currently no target.
         * @return true if the fish ate something, false otherwise.
         */
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

}
