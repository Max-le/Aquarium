package models;

import interfaces.Subscriber;

public class AquaLogger implements Subscriber {

    @Override
    public void update(String msg) {
        System.out.printf("Updated received ! \n --> %s\n", msg);
    }
}
