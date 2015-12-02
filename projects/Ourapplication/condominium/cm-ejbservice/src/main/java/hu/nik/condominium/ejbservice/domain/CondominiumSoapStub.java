package hu.nik.condominium.ejbservice.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;


@XmlRootElement(name = "condominium")
@XmlAccessorType(XmlAccessType.FIELD)
public class CondominiumSoapStub {

    @XmlAttribute(name = "id")
    private Long id;
    @XmlAttribute(name = "buildYear")
    private Date buildYear;
    @XmlAttribute(name = "floors")
    private Integer floors;
    @XmlAttribute(name = "typeName")
    private String typeName;
    @XmlAttribute(name = "location")
    private String location;


    public CondominiumSoapStub(Long id, Date buildYear, Integer floors, String typeName, String location) {
        this.id = id;
        this.buildYear = buildYear;
        this.floors = floors;
        this.typeName = typeName;
        this.location = location;
    }

    public CondominiumSoapStub() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getBuildYear() {
        return this.buildYear;
    }

    public Integer getFloors() {
        return this.floors;
    }

    public String getLocation() {
        return this.location;
    }

    public String getTypeName() {
        return this.typeName;
    }


    @Override
    public String toString() {
        return "CondominiumStub [type=" + this.typeName + ", id: " + this.id + ", floors: " + this.floors + " build year: " + this.buildYear + " location: " + this.location + "]";
    }
}