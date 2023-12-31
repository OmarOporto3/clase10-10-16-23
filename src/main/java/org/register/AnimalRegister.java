package org.register;
import java.time.LocalDate;
import java.util.Random;

/**
 * This class is the map for the construction of all the other register classes specifics for each specie
 * contains all the necessary information that should be necessary for their derivatives
 */
public abstract class AnimalRegister
{
    private final String[] MadurityArray = {"Young", "Adult", "Old"};
    protected Locations allLocations;

    Random random = new Random();

    public AnimalRegister(Locations locations) {
        this.allLocations = locations;
    }

    public abstract String id();
    public abstract String location();
    protected String getLocation(String specie)
    {
        int selectedLocation = random.nextInt(allLocations.getLocations(specie).size());
        return allLocations.getLocations(specie).get(selectedLocation);
    }

    private LocalDate getDate()
    {
        int lastYear = LocalDate.now().getYear() -1;
        int dayOfYear = random.nextInt(LocalDate.of(lastYear, 12, 31).getDayOfYear()) + 1;
        return LocalDate.ofYearDay(lastYear, dayOfYear);
    }
    protected String getMaturity()
    {
        return MadurityArray[random.nextInt(MadurityArray.length)];
    }

    protected Boolean getLifeStatus()
    {
        return random.nextBoolean();
    }

    public LocalDate date()
    {
        return getDate();
    }
}