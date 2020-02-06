package models;

public abstract   class Organism {
    private final int MAX_HEALTH  = 10;
    int hp ; //Health points
    int age;
    private boolean isAlive;


    public Organism() {
        this.hp = MAX_HEALTH;
        isAlive = true;
    }

    public void loseHp(int hp){
        if (hp > 0){
            this.hp-= hp;
        }
    }
    public void gainHp(int hp){
        if (hp > 0){
            this.hp+=hp;
        }
        if (this.hp > MAX_HEALTH) this.hp = MAX_HEALTH;
    }
    public void dies(){
        isAlive = false;
    }
    public boolean isAlive(){return isAlive;}
    @Override
    public String toString() {
        return " "+hp+" hp, "+age+" year(s) old ";
    }
}

