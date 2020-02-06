package models;

public class Weed extends Organism {
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
}
