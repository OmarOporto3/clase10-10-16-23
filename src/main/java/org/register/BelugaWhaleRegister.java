package org.register;

public class BelugaWhaleRegister extends AnimalRegister{
    private final String idBW;
    private Integer specimens = 92000;

    public BelugaWhaleRegister(Locations locations)
    {
        super(locations);
        idBW = "BW" +Integer.toString(specimens);
    }
    private void newSpecimen(){
        specimens++;
    }

    @Override
    public String id()
    {
        return idBW;
    }

    @Override
    public String location() {
        return getLocation("BelugaWhale");
    }

}

