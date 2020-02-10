import models.*;

import java.util.List;

public class ServiceAquarium {


    private static ServiceAquarium instance;

     synchronized public static ServiceAquarium getInstance() {
        if (instance == null )
            instance = new ServiceAquarium();
         System.out.println("Singleton loaded ! ");
        return instance;
    }

    private ServiceAquarium () {}

    //TODO : Faire une classe statique : singleton
    public  void printAquaStats(Aquarium aquarium){
        Fish f = new CarnivoreFish("EmojiGetter",0,"MALE");
        Weed w = new Weed();
        System.out.printf("Stats of population : %s/%s x %d  %s x %d\n",
                f.CARNI_FISH_EMOJI, f.HERBI_FISH_EMOJI,
                aquarium.countFish(),
                w.WEED_EMOJI, aquarium.countWeeds());
    }

    public  void printPopulation(Aquarium aquarium){
        System.out.printf("Population of %s @ day %d: \n", aquarium.getName(), aquarium.getCurrentDay());
        for (Organism o : aquarium.getPopulation()) {
            System.out.println("\t"+o.toString());
        }
    }
    public   void printNumberWeeds(Aquarium aquarium) {
        System.out.printf("Number of weeds : %d\n", aquarium.countWeeds());
    }
    public   void printNumberFishs(Aquarium aquarium) {
        System.out.printf("Number of fishs : %d\n", aquarium.countFish());
    }

    public  void printListFishs(List<Fish> fishs){
        System.out.println("LIST OF FISHS :\n---------------- ");
        for (Fish fish : fishs) {
            System.out.println("\t\uD83D\uDC1F " + fish.toString());
        }
    }
    public  void printListWeeds(List<Weed> weeds){
        System.out.println("LIST OF weeds :\n---------------- ");
        for (Weed weed : weeds) {
            System.out.println("\t" + weed.toString());
        }
    }
    public    void printDead(List<Organism> oList){
        for (Organism o : oList){
            if (!o.isAlive()) System.out.println(o.toString());
        }
    }


//    print static void printRandomFish(Aquarium aqua){
//
//    }
}
