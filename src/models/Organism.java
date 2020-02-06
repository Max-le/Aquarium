package models;

public abstract   class Organism {
    private final int MAX_HEALTH  = 10;
    public int hp ; //Health points
    private int age;
    private boolean isAlive;



    public String getLifeSymbol(){
        final String LIFE_STATUS_SYMBOL = " (\u271D) ";
        return isAlive() ? "": LIFE_STATUS_SYMBOL;
    }
    public Organism() {
        this.hp = MAX_HEALTH;
        isAlive = true;
    }

    public void loseHp(int hp){
        if (hp > 0){
            this.hp-= hp;
        }
        if (hp<= 0){
            dies();
        }
    }
    public void gainHp(int hp){
        if (hp > 0){
            this.hp+=hp;
        }
        if (this.hp > MAX_HEALTH) this.hp = MAX_HEALTH;
    }
    public void growOld(){
        age++;
        if (age >= 20){
            dies();
        }
    }

    public void dies(){
        isAlive = false;
    }

    public int getAge(){
        return age;
    }
    public void setAge(int age){
        if (age < 0 || age > 20 ){
            throw new IllegalArgumentException("Age must be between 0 and 20.");
        }
        else{
            this.age = age;
        }
    }
    public boolean isAlive(){return isAlive;}
    @Override
    public String toString() {
        return " "+hp+" hp, "+age+" year(s) old ";
    }
}

