package models;

import interfaces.Asexual;

public class Weed extends Organism implements Asexual {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public final String WEED_EMOJI = ANSI_GREEN + "\uD83C\uDF43" + ANSI_RESET;
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
