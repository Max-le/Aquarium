import models.*;
import models.Races.Carpe;
import models.Races.Thon;

public class Main {

    public static void main(String[] args) {
        ServiceAquarium serviceAqua = ServiceAquarium.getInstance();


        Aquarium aqua1 = new Aquarium("Aqualand",100 );

        while (aqua1.getCurrentDay() < 11){
            System.out.println("Day "+aqua1.getCurrentDay());
            serviceAqua.printPopulation(aqua1);
            aqua1.nextTurn();
        }
    }
}
