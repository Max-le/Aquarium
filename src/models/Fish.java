package models;

import interfaces.Sexual;

import java.util.Random;

public abstract class Fish extends Organism implements Sexual {

    //region Fields
    private final int BITE_DAMAGE = 4;
    private final int HUNGER_LIMIT = 6;//Below this limit, fish is considered hungry.
    private String name;
    private Sexuality sexuality;
    private String sex;
    public Organism targetFood;
    public final String HERBI_FISH_EMOJI = "\uD83D\uDC1F";
    public final String CARNI_FISH_EMOJI = "\uD83E\uDD88";
    //endregion


    //Constructor
    public Fish(String name, int age, String sex) {
        this.name = name;
        setAge(age);
        this.sex = sex;
    }

    /**
     * Obtient le type de sexualité du poisson d'après sa race, cas" sur le tableau de l'énoncé.
     */
    //TODO : extract this method
    public void computeSexuality(){
        switch(this.getRace().toString()){
            case "CARPE":
            case "THON":
                this.sexuality = Sexuality.FIXED;
                break;
            case "BAR":
            case "MEROU":
                this.sexuality = Sexuality.AGING;
                break;
            case "SOLE":
            case "CLOWN":
                this.sexuality = Sexuality.OPPORTUNIST;
                break;
            default:
                throw new RuntimeException("Couldn't compute the sexuality of "+this.toString());
        }
    }
    private String generateChildName(Fish parent1, Fish parent2){
        return parent1.getName()+parent2.getName();
    }
    private String generateRandomSex(){
        Random rd = new Random();
        return rd.nextBoolean() ? "MALE":"FEMALE";
    }
    private boolean opportunistSex(Fish mate){
        if (this.getSexuality() == Sexuality.OPPORTUNIST ||
                mate.getSexuality() == Sexuality.OPPORTUNIST){
            return true;
        }
        return false;
    }
    public Fish createChild(Fish mate){
        Random herbi = new Random();
        Fish child = null;
        boolean sexCompatible = !mate.getSex().equals(getSex());
        if (opportunistSex(mate)) sexCompatible = true;
        boolean raceCompatible = mate.getRace().equals(getRace());
        if (!isHungry() && sexCompatible && raceCompatible){
            String childName = generateChildName(this, mate);
            String childSex = generateRandomSex();
            if (herbi.nextBoolean()){
                child = new HerbivoreFish(childName,0, childSex);
            }
            else{
                child = new CarnivoreFish(childName,0, childSex);
            }
        }
        return child;
    }


    private void checkSexAging(){
        if (getSexuality() == Sexuality.AGING){
            if (getAge() < 10){
                sex = "MALE";
            }
            else{
                sex="FEMALE";
            }
        }
    }

    @Override
    public void growOld(){
        checkSexAging();
        super.growOld();
    }
    @Override
    public String toString() {
        return super.toString();
    }

    //region Enum Gender & Race
    public enum Sexuality {
        FIXED,
        AGING,
        OPPORTUNIST
    }
    //endregion

    //region Getters
    public Sexuality getSexuality() {
        return sexuality;
    }
    public String getSex(){
        return sex;
    }
    public String getName() {
        return name;
    }
    public abstract String getRace();
    //endregion
    //region Setters
    public void setName(String name) {
        this.name = name;
    }
    public void assignSex(String sex){
        sex = sex.toUpperCase();
        if (sex.equals("MALE") || sex.equals("FEMALE")){
            this.sex = sex;
        }
        else {
            throw new IllegalArgumentException(
                    "Sex type is invalid ( Set \"male\" or \"female\"");
        }
    }
    public void setTarget(Organism o){
        targetFood = o ;
    }
    //endregion

    //region Action Methods
    public abstract boolean eat(Organism o);

    public void bite(Fish fish){
        fish.loseHp(BITE_DAMAGE);
    }
    public boolean isHungry(){
        return hp < HUNGER_LIMIT;
    }
    //endregion
}
