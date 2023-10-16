package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<String> getCuantityOnCountry(String country){
        return condorList.stream()
                .filter(condor -> condor.location().equals(country))
                .map(AndineCondorRegister::id)
                .collect(Collectors.toList());
    }
}
