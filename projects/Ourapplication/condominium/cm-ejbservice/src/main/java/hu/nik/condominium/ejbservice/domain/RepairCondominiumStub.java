package hu.nik.condominium.ejbservice.domain;


public class RepairCondominiumStub {
    private Long name;
    private Double price;

    public Long getName() {
        return name;
    }

    public void setName(Long name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public RepairCondominiumStub(Long name, Double price) {
        this.name = name;
        this.price = price;
    }
    public RepairCondominiumStub(Double price)
    {
        this.price=price;
        this.name=-1L;
    }
}
