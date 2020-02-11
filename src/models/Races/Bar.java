package models.Races;

import models.Fish;
import models.HerbivoreFish;
import utils.FishUtil;

public class Bar extends HerbivoreFish {
    public Bar(String name) {
        super(name);
    }

    public Bar(String name, String sex) {
        super(name, sex);
    }

    @Override
    public Fish createChild(Fish mate) {
        FishUtil util = FishUtil.getInstance();
        String childName = util.generateChildName(this, mate);
        return new Bar(childName);
    }


//    @Override
//    public void endDay() {
//        super.endDay();
//
//        if(isAlive() && getAge() % 3 == 0) {
//            changeSex();
//        }
//    }
}
