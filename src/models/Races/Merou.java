package models.Races;

import models.CarnivoreFish;
import models.Fish;
import utils.FishUtil;

public class Merou extends CarnivoreFish {
    public Merou(String name) {
        super(name);
    }

    public Merou(String name, String sex) {
        super(name, sex);
    }

    public Fish createChild(Fish mate) {
        FishUtil util = FishUtil.getInstance();
        String childName = util.generateChildName(this, mate);
        return new Merou(childName);
    }
}
