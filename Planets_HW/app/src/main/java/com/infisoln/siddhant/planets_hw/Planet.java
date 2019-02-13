package com.infisoln.siddhant.planets_hw;

public class Planet {

    private String planetName, planetUrl, planetDescription;

    public Planet(String planetName, String planetUrl, String planetDescription) {
        this.planetName = planetName;
        this.planetUrl = planetUrl;
        this.planetDescription = planetDescription;
    }

    public String getPlanetName() {
        return planetName;
    }

    public String getPlanetUrl() {
        return planetUrl;
    }

    public String getPlanetDescription() {
        return planetDescription;
    }

}
