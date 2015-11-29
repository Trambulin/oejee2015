package hu.nik.condominium.restclient.domain.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created by Hidvégi Péter on 2015.11.29..
 */

@XmlRootElement(name = "condominium")
public class CondominiumStub {

    private Long id;
    private java.sql.Date buildYear;
    private Integer floors;
    private String typeName;
    private String location;


    @XmlElement(name = "location")
    public String getLocation() {
        return this.location;
    }


    public void setLocation(String location) {
        this.location = location;
    }

    @XmlElement(name = "typeName")
    public String getTypeName() {
        return this.typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public CondominiumStub(Long id, java.sql.Date buildYear, Integer floors, String typeName, String location) {
        this.id = id;
        this.buildYear = buildYear;
        this.floors = floors;
        this.typeName = typeName;
        this.location = location;
    }

    // alt+shift+s,r
    @XmlElement(name = "id")
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @XmlElement(name = "buildyear")
    public java.sql.Date getBuildYear() {
        return this.buildYear;
    }

    public void setBuildYear(java.sql.Date buildYear) {
        this.buildYear = buildYear;
    }

    @XmlElement(name = "floors")
    public Integer getFloors() {
        return this.floors;
    }

    public void setFloors(Integer floors) {
        this.floors = floors;
    }

    @Override
    public String toString() {
        //return "ID: " + this.id + " floors: " + this.floors + " build year: " + this.buildYear;
        return "CondominiumStub [type="+this.typeName+ ", id: " + this.id + ", floors: "+ this.floors +" build year: " + this.buildYear+ " location: " + this.location +"]";

    }
}