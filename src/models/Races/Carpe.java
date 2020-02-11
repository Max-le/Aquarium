package models.Races;

import models.Fish;
import models.HerbivoreFish;
import utils.FishUtil;

public class Carpe extends HerbivoreFish {

    public Carpe(String name) {
        super(name);
    }

    public Carpe(String name, String sex) {
        super(name, sex);
    }

    public Fish createChild(Fish mate) {
        FishUtil util = FishUtil.getInstance();
        String childName = util.generateChildName(this, mate);
        return new Carpe(childName);
    }
}
