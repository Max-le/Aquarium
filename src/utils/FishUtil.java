package utils;

import models.Fish;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public  class FishUtil {

    private static FishUtil instance;
    private FishUtil(){};
    public static FishUtil getInstance(){
        if (instance == null){
            instance = new FishUtil();
        }
        return instance;
    }


    @NotNull
    private String[] splitInHalf(String s){
        String[] parts = new String[2];
        int middle = s.length()/2;
        parts[0] = s.substring(0,middle);
        parts[1] = s.substring(middle, s.length());
        return parts;
    }
    public  String generateChildName(Fish parent1, Fish parent2) {
        String part1 = splitInHalf(parent1.getName())[0];
        String part2 = splitInHalf(parent2.getName())[1];
        return part1 + part2;
    }
    public  String generateRandomSex(){
        Random rd = new Random();
        return rd.nextBoolean() ? "MALE":"FEMALE";
    }

    /**
     * Obtient le type de sexualité du poisson d'après sa race, cas sur le tableau de l'énoncé.
     */
    public  void computeSexuality(Fish fish){

        switch(fish.getClass().toString()){
            case "CARPE":
            case "THON":

                break;
            case "BAR":
            case "MEROU":

                break;
            case "SOLE":
            case "CLOWN":

                break;
            default:
                throw new RuntimeException("Couldn't compute the sexuality of "+ fish.toString());
        }
    }
}
