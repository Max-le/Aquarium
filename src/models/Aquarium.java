package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    //region Methods
    public void addOrganism(Organism newcomer){
        population.add(newcomer);
    }

    //region Getters
    public String getName(){
        return name;
    }
    public int countWeeds(){
        int numberWeeds = 0;
        for (Organism o : getPopulation()) {
            if (o instanceof Weed) numberWeeds++;
        }
        return numberWeeds;
    }
    public List<Organism> getPopulation(){
        /**
         * Returns a COPY of the population
         */
        List<Organism> copy = new ArrayList<>(this.population);
        return copy;
    }
    public List<Fish> getFishs(){
        /**
         * Renvoie une liste contenant l'ensemble des poissons de l'aquarium.
         */
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
    public int countFish(){
        return population.size() - countWeeds();
    }
    //endregion


    //region Action turn on organisms
    private  void growWeeds(){
        /**
         * Adds +1 HP to every weed in the aquarium.
         */
        population.stream().filter( o -> o instanceof Weed).forEach(weed -> weed.gainHp(1));

    }
    private void mealTimeFishs(){
        for (Fish fish : getFishs()){
            if (fish instanceof CarnivoreFish){
                fish.eat(getRandomFish());
            }
            else{
                fish.eat(getRandomWeed());
            }
        }
    }

    public int getCurrentDay() {
        return day;
    }

    //endregion
    public void nextTurn(){
        /**
         * Fait s'écouler un tour ; exécute une action sur chaque organisme dans la population.
         */
        growWeeds();
        hungerHurts();
        mealTimeFishs();
        populationReproduce();
        populationGrowsOld();
        day++;
    }

    private void hungerHurts() {
        /**
         * Every fish loses HP due to hunger.
         */
        for (Fish fish : getFishs()){
            fish.loseHp(1);
        }
    }
    private void populationReproduce(){
        /**
         * Weeds reproduce by spliting themselves.
         * Fishs need to copulate.
         */


    }

    public Fish getRandomFish() {
        //TODO : Refactor GetRandomWeed() and GetRandomWish() into one method redundancy
        Random r = new Random();
        int max =  getFishs().size();
        int index = r.nextInt(max);
        return getFishs().get(index);
    }
    public Weed getRandomWeed() {
        Random r = new Random();
        int max =  getWeeds().size();
        int index = r.nextInt(max);
        return getWeeds().get(index);
    }
    //endregion

}
