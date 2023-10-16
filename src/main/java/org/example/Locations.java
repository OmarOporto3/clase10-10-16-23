package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Locations {
    public Locations()
    {
        addSpecies("andineCondor", Arrays.asList("Colombia", "Venezuela", "Bolivia", "Ecuador", "Peru"));
    }
    private final Map<String, List<String>> locationsMap = new HashMap<>();

    public void addSpecies(String species, List<String> locations)
    {
        locationsMap.put(species,locations);
    }

    public List<String> getLocations(String species)
    {
        return locationsMap.get(species);
    }
}
