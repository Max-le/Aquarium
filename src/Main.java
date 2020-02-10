import models.*;

public class Main {

    public static void main(String[] args) {
        ServiceAquarium serviceAquarium = ServiceAquarium.getInstance();
        Aquarium aqua1 = new Aquarium("Aqualand",100 );
        aqua1.addOrganism(new HerbivoreFish("Patricia", 3, "FEMALE"));
        aqua1.addOrganism(new HerbivoreFish("Jasmina", 18,"FEMALE"));
        aqua1.addOrganism(new CarnivoreFish("BabyShark", 0,"MALE"));
        aqua1.addOrganism(new CarnivoreFish("Camilla", 2, "FEMALE"));
        aqua1.addOrganism(new CarnivoreFish("Alice", 11,"FEMALE"));
        aqua1.addOrganism(new CarnivoreFish("Roger", 0, "MALE" ));
        aqua1.addOrganism(new HerbivoreFish("Paul", 4, "MALE"));
        aqua1.addOrganism(new Weed(5));
        aqua1.addOrganism(new Weed());
        aqua1.addOrganism(new Weed(2));

        AquaLogger logger = new AquaLogger();
        aqua1.getFishs().stream().forEach(fish -> fish.addSubscriber(logger));

        while (aqua1.getCurrentDay() < 22){
            System.out.println("Day "+aqua1.getCurrentDay());
            serviceAquarium.printPopulation(aqua1);
            aqua1.nextTurn();
        }
    }
}
