package models;

public class Weed extends Organism {

    public Weed(){
        this.age = 0;
    }
    public Weed(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "I'm a weed ! "+super.toString();
    }
}
