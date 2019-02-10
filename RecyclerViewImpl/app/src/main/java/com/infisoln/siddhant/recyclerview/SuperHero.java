package com.infisoln.siddhant.recyclerview;

public class SuperHero {

    String superHeroName;
    String superHeroUniverse;
    String superHeroPower;

    public SuperHero(String superHeroName, String superHeroUniverse, String superHeroPower) {
        this.superHeroName = superHeroName;
        this.superHeroUniverse = superHeroUniverse;
        this.superHeroPower = superHeroPower;
    }

    public String getSuperHeroName() {
        return superHeroName;
    }

    public String getSuperHeroUniverse() {
        return superHeroUniverse;
    }

    public String getSuperHeroPower() {
        return superHeroPower;
    }
}
