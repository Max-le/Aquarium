import models.Aquarium;
import models.Organism;

public class ServiceAquarium {


    private static ServiceAquarium instance;

     synchronized public static ServiceAquarium getInstance() {
        if (instance == null )
            instance = new ServiceAquarium();
        return instance;
    }
    private ServiceAquarium () {}
    public  void printPopulation(Aquarium aquarium){
        System.out.printf("Population of %s @ day %d: \n", aquarium.getName(), aquarium.getCurrentDay());
        for (Organism o : aquarium.getPopulation()) {
            System.out.println("\t"+o.toString());
        }
    }
}
