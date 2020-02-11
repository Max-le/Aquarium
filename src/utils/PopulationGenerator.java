package utils;

import interfaces.FishCreator;
import models.Aquarium;
import models.Fish;
import models.Races.*;
import models.Weed;

public class PopulationGenerator {

        public void populate(Aquarium aquarium){
            aquarium.addOrganism(new Thon("Toto"));
            aquarium.addOrganism(new Carpe("Caroline"));
            aquarium.addOrganism(new Carpe("Patricia"));
            aquarium.addOrganism(new Merou("Francesca"));
            aquarium.addOrganism(new Carpe("Olivia", "FEMALE"));
            aquarium.addOrganism(new Sole("Paul", "MALE"));
            aquarium.addOrganism(new Clown("Will", "MALE"));

            aquarium.addOrganism(new Weed());
            aquarium.addOrganism(new Weed());
            aquarium.addOrganism(new Weed());
        }
        }

