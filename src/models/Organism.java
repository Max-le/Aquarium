package models;

public abstract  class Organism  {
    private final int MAX_HEALTH  = 10;
    private int hp ; //Health points
    private int age;

    public Organism() {
        this.hp = MAX_HEALTH;
    }

    public int getAge() {
        return age;
    }

    protected int getHP(){
        return hp;
    }

    public void loseHp(int hp){
        if (hp >= 0){
            this.hp -= hp;
        }
    }
    public void gainHp(int hp){
        if (hp >= 0){
            this.hp+=hp;
        }
        if (this.hp > MAX_HEALTH) this.hp = MAX_HEALTH;
    }
    protected void growOld(){
        age++;
    }

    public void setAge(int age){
        if (age < 0 || age > 20 ){
            throw new IllegalArgumentException("Age must be between 0 and 20.");
        }
        else{
            this.age = age;
        }
    }
    public boolean isAlive(){
        return hp > 0 || age < 21 ;
    }
    @Override
    public String toString() {
        return getClass().getSimpleName()+" "+ hp+"hp, "+age+" year(s) old ";
    }

    public void endDay() {
        growOld();
    }
}

