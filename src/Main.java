import models.*;

public class Main {

    public static void main(String[] args) {
        Aquarium aqua1 = new Aquarium("Aqualand",100 );
        aqua1.addOrganism(new HerbivoreFish("Robert", 3, Fish.Sexuality.FIXED));
        aqua1.addOrganism(new HerbivoreFish("Flipper", 18, Fish.Sexuality.OPPORTUNIST ));
        aqua1.addOrganism(new CarnivoreFish("BabyShark", 1, Fish.Sexuality.AGING));
        aqua1.addOrganism(new CarnivoreFish("Billy", 2, Fish.Sexuality.AGING));
        aqua1.addOrganism(new CarnivoreFish("Albert", 11, Fish.Sexuality.AGING));
        aqua1.addOrganism(new Weed(5));
        aqua1.addOrganism(new Weed());
        aqua1.addOrganism(new Weed(2));
        ServiceAquarium.printPopulation(aqua1);
        ServiceAquarium.printNumberWeeds(aqua1);
        ServiceAquarium.printNumberFishs(aqua1);
        ServiceAquarium.printListFishs(aqua1.getFishs());
        ServiceAquarium.printListWeeds(aqua1.getWeeds());
        aqua1.nextTurn();
        ServiceAquarium.printPopulation(aqua1);
    }
}
