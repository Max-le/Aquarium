package models;

import interfaces.FishCreator;
import utils.FishUtil;

public abstract class Fish extends Organism implements FishCreator {

    //region Fields
    private int hungerLimit;//Below this limit, fish is considered hungry.
    private String name;
    private Sexuality sexuality;
    private String sex;
    public Organism targetFood;

    //Constructor
    public Fish(String name) {
        this(name, FishUtil.getInstance().generateRandomSex());
    }
    public Fish(String name, String sex) {
        this.name = name;
        this.sex = sex;
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
    //endregion
    //region Setters
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
    public void changeSex(){
        if (sex.equals("MALE")) {
            assignSex("FEMALE");
        } else {
            assignSex("MALE");
        }
    }
    public void setTarget(Organism o){
        targetFood = o ;
    }
    //endregion

    /**
     * The fish tries to eat.
     * @param o the prey that will be used as new target
     * @return true if the fish ate something, false otherwise.
     */
    public abstract boolean eat(Organism o);

    public boolean isHungry(){
        return getHP() < hungerLimit;
    }
    //endregion


    @Override
    public void endDay() {
        super.endDay();

        if(isAlive()) {
            loseHp(1);
        }
    }

    @Override
    public String toString() {
        return " "+getName().toLowerCase()+" "+
                getSex()+" "+super.toString();
    }
}
