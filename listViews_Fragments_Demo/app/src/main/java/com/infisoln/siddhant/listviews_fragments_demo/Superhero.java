package com.infisoln.siddhant.listviews_fragments_demo;

public class Superhero {

    String superHeroName;
    String Universe;
    String superPower;

    public Superhero(String superHeroName, String universe, String superPower) {
        this.superHeroName = superHeroName;
        Universe = universe;
        this.superPower = superPower;
    }

    public String getSuperHeroName() {
        return superHeroName;
    }

    public void setSuperHeroName(String superHeroName) {
        this.superHeroName = superHeroName;
    }

    public String getUniverse() {
        return Universe;
    }

    public void setUniverse(String universe) {
        Universe = universe;
    }

    public String getSuperPower() {
        return superPower;
    }

    public void setSuperPower(String superPower) {
        this.superPower = superPower;
    }
}
