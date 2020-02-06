package models;

public abstract class Fish extends Organism{

    //Attributes
    private final int BITE_DAMAGE = 4;
    private final int HUNGER_LIMIT = 6;//Below this limit, fish is considered hungry.
    private String name;
    private Sexuality sexuality;
    private String sex;
    public Organism targetFood;
    public final String HERBI_FISH_EMOJI = "\uD83D\uDC1F";
    public final String CARNI_FISH_EMOJI = "\uD83E\uDD88";


    //Constructor
    public Fish(String name, int age, Sexuality sexuality) {
        this.name = name;
        setAge(age);
        this.sexuality = sexuality;
        this.sex = "MALE";
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

    //Region Action Methods
    public abstract boolean eat(Organism o);

    public void bite(Fish fish){
        fish.loseHp(BITE_DAMAGE);
    }
    public boolean isHungry(){
        return hp < HUNGER_LIMIT;
    }
    //Endregion
}

