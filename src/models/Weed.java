package models;

import interfaces.WeedCreation;

public class Weed extends Organism implements WeedCreation {
    public Weed(){
        setAge(0);
    }
    public Weed(int age) {
        setAge(0);
    }

    @Override
    public Weed[] createChild() {
        //Returns two children if parent weed is mature
        Weed[] children = new Weed[2];
        if (getHP() >=10){
            loseHp(getHP()/2);
            for (int i = 0; i < children.length - 1; i++) {
                Weed baby = new Weed();
                children[i] = baby;
            }
        }
         return children;
    }

    @Override
    public void endDay() {
        super.endDay();

        if(isAlive()) {
            gainHp(1);
        }
    }
}
