package org.example;
public class AndineCondorRegister extends AnimalRegister
{
    private final String idAC;
    private static Integer specimens = 5200;

    public AndineCondorRegister(Locations locations)
    {
        super(locations);
        idAC = "AC" +Integer.toString(specimens);
        newSpecimen();
    }
    private void newSpecimen()
    {
        specimens++;
    }

    @Override
    public String id()
    {
        return idAC;
    }

    @Override
    public String location()
    {
        return getLocation("andineCondor");
    }

}
