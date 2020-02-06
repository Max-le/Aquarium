package models;

public class CarnivoreFish extends Fish {

    private CarniRace race;
    public enum CarniRace {
        THON, MEROU, CLOWN
    }

    public CarnivoreFish(String name, int age, Sexuality sexuality){
        super(name, age, sexuality);
        this.race = CarniRace.THON;
    }

    @Override
    public String toString() {
        return "I'm an carnivore fish ! "+getName()+" "+
                getSex() + super.toString() + "of race "+race.toString();
    }


    public boolean eat(Organism fish) {
        /**
         * The fish tries to eat.
         * @param fish fish that will be used as new target if the eater has currently no target.
         * @return true if the fish ate something, false otherwise.
         */
        boolean hasEaten = false;
        if (isHungry()){
            if( targetFood == null){
                //Assign new target.
                this.targetFood = fish;
                targetFood.loseHp(4);
                hasEaten = true;
            }
        }
        return hasEaten;
    }

}