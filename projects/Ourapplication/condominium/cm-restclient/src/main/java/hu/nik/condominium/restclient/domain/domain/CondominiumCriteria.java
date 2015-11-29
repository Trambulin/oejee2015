package hu.nik.condominium.restclient.domain.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by Hidvégi Péter on 2015.11.29..
 */

@XmlRootElement(name = "condominiumcriteria")
public class CondominiumCriteria implements Serializable{

    private static final long serialVersionUID = -5781732904290824240L;

    private String condominiumTypeNameTerm;
    private int minimumFloors;
    private int maximumFloors;

    public CondominiumCriteria() {
        this(null, 0, 0);
    }

    public CondominiumCriteria(String condominiumTypeNameTerm, int minimumFloors, int maximumFloors) {
        this.condominiumTypeNameTerm= condominiumTypeNameTerm;
        this.minimumFloors = minimumFloors;
        this.maximumFloors = maximumFloors;
    }

    @XmlElement(name = "type")
    public String getCondominiumTypeNameTerm() {
        return this.condominiumTypeNameTerm;
    }

    public void setCondominiumTypeNameTerm(String condominiumTypeNameTerm) {
        this.condominiumTypeNameTerm = condominiumTypeNameTerm;
    }

    @XmlElement(name = "minimumfloors")
    public int getMinimumFloors() {
        return this.minimumFloors;
    }

    public void setMinimumFloors(int minimumFloors) {
        this.minimumFloors= minimumFloors;
    }

    @XmlElement(name = "maximumfloors")
    public int getMaximumFloors() {
        return this.maximumFloors;
    }

    public void setMaximumFloors(int maximumFloors) {
        this.maximumFloors = maximumFloors;
    }

    @Override
    public String toString() {
        return "CondominiumCriteria [condominiumTypeNameTerm=" + this.condominiumTypeNameTerm + ", minimumFloors=" + this.minimumFloors + ", maximumFloors=" + this.maximumFloors + "]";
    }
}
