package hu.nik.condominium.ejbservice.domain;

public class CondominiumInputStub {
    private String location;
    private int floors;
    private String type;
    private String buildYear;

    public CondominiumInputStub() {
        //this(null, null, null, null);
    }

    public CondominiumInputStub(String location, String floors, String type, String buildYear) {
        super();
        this.location = location;
        this.floors = Integer.valueOf(floors);
        this.type = type;
        this.buildYear = buildYear;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBuildYear() {
        return buildYear;
    }

    public void setBuildYear(String buildYear) {
        this.buildYear = buildYear;
    }

}
