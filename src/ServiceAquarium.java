import models.Aquarium;
import models.Fish;
import models.Organism;
import models.Weed;

import java.util.List;

public class ServiceAquarium {
    public static void printPopulation(Aquarium aquarium){
        System.out.printf("Population of %s : \n", aquarium.getName());
        for (Organism o : aquarium.getPopulation()) {
            System.out.println("\t• "+o.toString());
        }
    }
    public  static void printNumberWeeds(Aquarium aquarium) {
        System.out.printf("Number of weeds : %d\n", aquarium.countWeeds());
    }
    public  static void printNumberFishs(Aquarium aquarium) {
        System.out.printf("Number of fishs : %d\n", aquarium.countFish());
    }

    public static void printListFishs(List<Fish> fishs){
        System.out.println("LIST OF FISHS :\n---------------- ");
        for (Fish fish : fishs) {
            System.out.println("\t\uD83D\uDC1F " + fish.toString());
        }
    }
    public static void printListWeeds(List<Weed> weeds){
        System.out.println("LIST OF weeds :\n---------------- ");
        for (Weed weed : weeds) {
            System.out.println("\t\uD83C\uDF43 " + weed.toString());
        }
    }


//    print static void printRandomFish(Aquarium aqua){
//
//    }
}
