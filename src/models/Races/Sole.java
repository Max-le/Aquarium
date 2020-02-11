package models.Races;

import models.Fish;
import models.HerbivoreFish;
import utils.FishUtil;

public class Sole extends HerbivoreFish {

    public Sole(String name, String sex) {
        super(name, sex);
    }

    public Sole(String name) {
        super(name);
    }

    public Fish createChild(Fish mate) {
        FishUtil util = FishUtil.getInstance();
        String childName = util.generateChildName(this, mate);
        return new Sole(childName);
    }
}
