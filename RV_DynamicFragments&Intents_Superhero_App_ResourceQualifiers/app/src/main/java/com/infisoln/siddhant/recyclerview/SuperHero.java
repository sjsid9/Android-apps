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

    String getSuperHeroName() {
        return superHeroName;
    }

    String getSuperHeroUniverse() {
        return superHeroUniverse;
    }

    private String getSuperHeroPower() {
        return superHeroPower;
    }
}
