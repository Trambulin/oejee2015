package hu.nik.condominium.ejbservice.domain;


import java.sql.Date;

public class RepairStub {


    private Date date;
    private Long price;
    private CondominiumStub condominium;

    public RepairStub(Date date,Long price,CondominiumStub condominium){
        this.date=date;
        this.price=price;
        this. condominium=condominium;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public CondominiumStub getCondominiumLocation() {
        return condominium;
    }

    public void setCondominiumLocation(CondominiumStub condominium) {
        this.condominium = condominium;
    }
}
