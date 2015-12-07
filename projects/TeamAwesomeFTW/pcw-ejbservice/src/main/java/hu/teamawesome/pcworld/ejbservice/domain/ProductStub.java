package hu.teamawesome.pcworld.ejbservice.domain;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "product")
public class ProductStub
{
    private Long id;
	private TypeStub type;
	private String name;
	private String description;
	private Integer warranty;
	private Integer price;
	private ManufacturerStub manufacturer;
	private Integer shippingDays;
    
    
    public ProductStub() {
        this(0L, null, null, null, 0, 0, null, 0);
    }
    public ProductStub(Long id, TypeStub type, String name, String description, Integer warranty, Integer price, ManufacturerStub manufacturer, Integer shippingDays)
    {
        super();
        this.id = id;
        this.type = type;
        this.name = name;
        this.description = description;
    	this.warranty = warranty;
    	this.price = price;
    	this.manufacturer = manufacturer;
    	this.shippingDays = shippingDays;
    }
    
    
    @XmlElement(name = "id")
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    
    @XmlElement(name = "type")
    public TypeStub getProductType() {
        return type;
    }
    public void setProductType(TypeStub type) {
        this.type = type;
    }
    
    @XmlElement(name = "name")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    @XmlElement(name = "description")
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    
    @XmlElement(name = "warranty")
    public Integer getWarranty() {
        return warranty;
    }
    public void setWarranty(Integer warranty) {
        this.warranty = warranty;
    }
    
    @XmlElement(name = "price")
    public Integer getPrice() {
        return price;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }
    
    @XmlElement(name = "manufacturer")
    public ManufacturerStub getManufacturer() {
        return manufacturer;
    }
    public void setManufacturer(ManufacturerStub manufacturer) {
        this.manufacturer = manufacturer;
    }
    
    @XmlElement(name = "shippingdays")
    public Integer getShippingDays() {
        return shippingDays;
    }
    public void setShippingDays(Integer shippingDays) {
        this.shippingDays = shippingDays;
    }
	
    
    
    @Override
    public String toString() {
        return "ProductStub [id=" + id +
        		", productType=" + type +
        		", name=" + name +
        		", description=" + description +
        		", warranty=" + warranty +
        		", price=" + price +
        		", manufacturer=" + manufacturer +
        		", shippingDays=" + shippingDays + "]";
    }

}
