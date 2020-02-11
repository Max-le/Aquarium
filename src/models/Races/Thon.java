package models.Races;

import models.CarnivoreFish;
import models.Fish;
import utils.FishUtil;

public class Thon extends CarnivoreFish {

    public Thon(String name) {
        super(name);
    }

    public Thon(String name, String sex) {
        super(name, sex);
    }

    public Fish createChild(Fish mate) {
        FishUtil util = FishUtil.getInstance();
        String childName = util.generateChildName(this, mate);
        return new Thon(childName);
    }
}
