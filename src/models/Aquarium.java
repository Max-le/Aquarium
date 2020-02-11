package models;

import interfaces.FishCreator;
import interfaces.WeedCreation;
import utils.AquariumUtil;
import utils.FishUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Aquarium {

    private List<Organism> population ;
    private int capacity;
    private String name;
    private int day;

    //region Constructor
    public Aquarium(String name, int capacity) {
       population = new ArrayList<Organism>();
       this.capacity = capacity;
       this.name = name;
       day = 1;
    }
    //endregion

    /**
     * Fait s'écouler un tour ; exécute une action sur chaque organisme dans la population.
     */
    public void nextTurn(){
//        growWeeds();
//        hungerHurts();
        mealTimeFishs();
        populationReproduce();
//        populationGrowsOld();
        endOfDay();
        cleanDead();
        day++;
    }

    private void endOfDay() {
        population.stream().forEach(org -> org.endDay());
    }

    public void addOrganism(Organism newcomer){
        if (population.size() < capacity && newcomer !=null){
            population.add(newcomer);
        }
    }
    //region Getters
    public String getName(){
        return name;
    }

    public List<Organism> getPopulation(){
        return new ArrayList<>(this.population);
    }
    public List<Fish> getFishs(){
        List<Fish> fishs = new ArrayList<>();
        for (Organism o : population){
            if (o instanceof Fish) fishs.add((Fish) o);
        }
        return fishs;
    }
    public List<Weed> getWeeds(){
        List<Weed> weeds = new ArrayList<>();
        for (Organism o : population){
            if (o instanceof Weed ) weeds.add((Weed)o);
        }
        return weeds;
    }
    //endregion

    private  void growWeeds(){
        population.stream().filter( o -> o instanceof Weed).forEach(weed -> weed.gainHp(1));
    }
    private void mealTimeFishs(){
        AquariumUtil util = AquariumUtil.getInstance();
        for (Fish fish : getFishs()){
            fish.eat(util.getRandomOrganism(this));
        }
    }
    private void populationGrowsOld() {
        for (Organism o : population){
            o.growOld();
        }//lol max
    }
    private void hungerHurts() {
        for (Fish fish : getFishs()){
            fish.loseHp(1);
        }
    }
    private void populationReproduce(){
        AquariumUtil util = AquariumUtil.getInstance();
        ArrayList<Organism> newcomers = new ArrayList<>();
        for (Organism o : population){
            Organism child = null;
            if (o instanceof Fish){
                FishCreator fish = (Fish)o;
                Fish newFish = fish.createChild(util.getRandomFish(this));
                newcomers.add((Organism)newFish);
            }
            else if (o instanceof Weed) {
                WeedCreation weed = (Weed)o;
                Weed[] newWeeds = weed.createChild();
                newcomers.addAll(Arrays.asList(newWeeds));
            }
        }
        for (Organism o : newcomers){
            addOrganism(o);
        }
    }
    private void cleanDead(){
        population.removeIf(o -> !o.isAlive());
    }

    public int getCurrentDay() {
        return day;
    }
}
