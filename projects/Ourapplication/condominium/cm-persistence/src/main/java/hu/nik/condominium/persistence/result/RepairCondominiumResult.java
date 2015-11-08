package hu.nik.condominium.persistence.result;

public class RepairCondominiumResult {
    private final Long name;
    private final Double price;

    public RepairCondominiumResult(Long name, Double price) {
        this.name = name;
        this.price = price;
    }
    public RepairCondominiumResult(Double price){
        this.name=-1L;
        this.price=price;
    }
    public Long getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

}
