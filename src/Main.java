import models.*;

public class Main {

    public static void main(String[] args) {
        Aquarium aqua1 = new Aquarium("Aqualand",100 );
        aqua1.addOrganism(new HerbivoreFish("Robert", 3, Fish.Sexuality.FIXED));
        aqua1.addOrganism(new HerbivoreFish("Flipper", 18, Fish.Sexuality.OPPORTUNIST ));
        aqua1.addOrganism(new CarnivoreFish("BabyShark", 1, Fish.Sexuality.AGING));
        aqua1.addOrganism(new CarnivoreFish("Billy", 2, Fish.Sexuality.AGING));
        aqua1.addOrganism(new CarnivoreFish("Albert", 11, Fish.Sexuality.AGING));
        aqua1.addOrganism(new CarnivoreFish("Roger"));
        aqua1.addOrganism(new CarnivoreFish("Mathias"));
        aqua1.addOrganism(new HerbivoreFish("Paul", 4, Fish.Sexuality.FIXED));
        aqua1.addOrganism(new CarnivoreFish("Barney"));
        aqua1.addOrganism(new CarnivoreFish("Robin"));
        aqua1.addOrganism(new CarnivoreFish("Lily"));
        aqua1.addOrganism(new Weed(5));
        aqua1.addOrganism(new Weed());

        aqua1.addOrganism(new Weed(2));
        while (aqua1.getCurrentDay() < 22){
            System.out.println("Day "+aqua1.getCurrentDay());
            ServiceAquarium.printPopulation(aqua1);
            aqua1.nextTurn();
        }
    }
}
