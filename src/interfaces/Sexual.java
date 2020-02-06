package interfaces;

import models.Fish;

public interface Sexual {
        //A fish, with it's mate as a parameter, shroud be abbe to return a new fish.
        //Can return null if reproduction was not possible for mose reason ( not compatible )
        Fish createChild(Fish mate);
}
