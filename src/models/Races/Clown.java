package models.Races;

import models.CarnivoreFish;
import models.Fish;
import utils.FishUtil;

public class Clown extends CarnivoreFish {

    public Clown(String name) {
        super(name);
    }

    public Clown(String name, String sex) {
        super(name, sex);
    }

    public Fish createChild(Fish mate) {
        FishUtil util = FishUtil.getInstance();
        String childName = util.generateChildName(this, mate);
        return new Clown(childName);
    }
}
