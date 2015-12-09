package hu.nik.condominium.ejbservice.domain;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "condominiumGroup")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class CondominiumGroup {
    private String identifier;
    private List<CondominiumSoapStub> condominiumStubs=new ArrayList<>();

    @XmlAttribute(name = "identifier")
    public String getIdentifier() {
        return identifier;
    }
    public boolean hasIdentifier() {
        return this.identifier != null;
    }
    public void add(CondominiumSoapStub stub) {
        this.condominiumStubs.add(stub);
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public List<CondominiumSoapStub> getCondominiumStubs() {
        return condominiumStubs;
    }

    @XmlElement(name = "condominiums")
    public void setCondominiumStubs(List<CondominiumSoapStub> condominiumStubs) {
        this.condominiumStubs = condominiumStubs;
    }

    @Override
    public String toString() {
        String output = "Identifier: "+this.identifier+", items: ";
        for (CondominiumSoapStub s : condominiumStubs) {
            output += ", " + s.toString();
        }
        return output;
    }
}
