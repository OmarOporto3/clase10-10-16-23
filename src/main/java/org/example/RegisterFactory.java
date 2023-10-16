package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class has the function to create all the objects Registered and create specific elements according to the
 * necessity
 *
 * The constructor create an amount of objects of AndineCondor
 * The getCondorLocations group the locations of all the objects previously created
 * The getCondorIds group the Ids of all the objects previously created
 * the getCuantityOnCountry filter and create a list with all the objects from a specify country
 */
public class RegisterFactory {
    Locations locations = new Locations();

    List<AndineCondorRegister> condorList = new ArrayList<>();

    public RegisterFactory() {
        for (int i = 0; i < 10; i++) {
            AndineCondorRegister condor = new AndineCondorRegister(locations);
            condorList.add(condor);
        }
    }

    public List<String> getCondorLocations(){
        return condorList.stream()
            .map(AndineCondorRegister::location)
            .collect(Collectors.toList());
    }

    public List<String> getCondorIds(){
        return condorList.stream()
                .map(AndineCondorRegister::id)
                .collect(Collectors.toList());
    }

    public List<String> getIdsOnCountry(String country){
        return condorList.stream()
                .filter(condor -> condor.location().equals(country))
                .map(AndineCondorRegister::id)
                .collect(Collectors.toList());
    }
}
