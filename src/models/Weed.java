package models;

public class Weed extends Organism {
    private final String WEED_EMOJI = "\uD83C\uDF43";
    public Weed(){
        this.age = 0;
    }
    public Weed(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return WEED_EMOJI+" "+super.toString();
    }
}
