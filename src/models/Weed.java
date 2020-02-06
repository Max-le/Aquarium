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
        if (hp >=10){
            Weed[] children = new Weed[2];
            hp /= 2;
        }

         return children;
    }
}
