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
        return HERBI_FISH_EMOJI+getLifeSymbol()+" "+getName()+" "+
                getSex() + super.toString() + " Race "+race.toString();
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


}
