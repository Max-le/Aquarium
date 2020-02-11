package utils;


import models.Aquarium;
import models.Fish;
import models.Organism;
import models.Weed;

import java.util.List;
import java.util.Random;

public class AquariumUtil {

    //region Singleton pattern
    private static AquariumUtil instance;
    private AquariumUtil(){};
    synchronized public static AquariumUtil getInstance(){
        if (instance == null){
            instance = new AquariumUtil();
        }
        return instance;
    }
    //endregion


    public void compatibleReproduction(Fish fish1, Fish fish2){
        boolean fishsNotHungry = !fish1.isHungry() && !fish2.isHungry();
        boolean raceCompatible = fish1.getClass().equals(fish2.getClass());
        boolean oppositeSex = !(fish1.getSex().equals(fish2.getSex()));
        if (fishsNotHungry && raceCompatible && oppositeSex){
            
        }
    }

    public int countFish(Aquarium aquarium){
        return aquarium.getPopulation().size() - countWeeds(aquarium);
    }
    public int countWeeds(Aquarium aquarium){
        int numberWeeds = 0;
        for (Organism o : aquarium.getPopulation()) {
            if (o instanceof Weed) numberWeeds++;
        }
        return numberWeeds;
    }

    public Fish getRandomFish(Aquarium aquarium) {
        Random r = new Random();
        int max =  aquarium.getFishs().size();
        int index = r.nextInt(max);
        return aquarium.getFishs().get(index);
    }
    public Weed getRandomWeed(Aquarium aquarium) {
        List<Weed> weeds = aquarium.getWeeds();
        if (weeds.size() == 0) return null;
        Random r = new Random();
        int max =  weeds.size();
        if (max == 0){
            return null;
        }
        int index = r.nextInt(max);
        return weeds.get(index);
    }
    public Organism getRandomOrganism(Aquarium aquarium){
        Random rd = new Random();
        if (rd.nextBoolean()){
            return getRandomFish(aquarium);
        }
        else {
            return getRandomWeed(aquarium);
        }
    }
}
