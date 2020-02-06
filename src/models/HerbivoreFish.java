package models;

public class HerbivoreFish extends Fish{
    public enum  HerbiRace {
        SOLE, BAR, CARPE
    }

    private HerbiRace race;

    public HerbivoreFish(String name, int age, Sexuality sexuality){
        super(name, age, sexuality);
        this.race = HerbiRace.SOLE;
    }

    @Override
    public String toString() {
        return "I'm an herbivore fish ! "+getName()+" "+
                getSex() + super.toString() + " Race "+race.toString();
    }

    @Override
    public boolean eat(Organism o) {
        return false;
    }


}
