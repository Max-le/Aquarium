package interfaces;


import models.Weed;

public interface Asexual {
    // A Weed should be able to return an array of weeds.
    Weed[] createChild();
}
