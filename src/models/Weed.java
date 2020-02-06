package models;

import interfaces.Asexual;

public class Weed extends Organism implements Asexual {
    private final String WEED_EMOJI = "\uD83C\uDF43";
    public Weed(){
        setAge(0);
    }
    public Weed(int age) {
        setAge(0);
    }

    @Override
    public String toString() {
        return WEED_EMOJI+ getLifeSymbol()+" "+super.toString();
    }

    @Override
    public Weed[] createChild() {
        //Returns two children if parent weed is mature
        Weed[] children = new Weed[2];
        if (hp >=10){
            hp /= 2;
            for (int i = 0; i < children.length - 1; i++) {
                Weed baby = new Weed();
                children[i] = baby;
            }
        }
         return children;
    }
}
