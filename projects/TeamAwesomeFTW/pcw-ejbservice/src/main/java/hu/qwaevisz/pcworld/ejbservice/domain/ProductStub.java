package hu.qwaevisz.pcworld.ejbservice.domain;

public class ProductStub
{
    private Long id;
	private ProductTypeStub productType;
	private String name;
	private String description;
	private Integer warranty;
	private Integer price;
	private ProductManufacturerStub manufacturer;
	private Integer shippingDays;
    
    

    public ProductStub() {
        this(0L, null, null, null, 0, 0, null, 0);
    }
    
    

    public ProductStub(Long id, ProductTypeStub productType, String name, String description, Integer warranty, Integer price, ProductManufacturerStub manufacturer, Integer shippingDays)
    {
        super();
        this.id = id;
        this.productType = productType;
        this.name = name;
        this.description = description;
    	this.warranty = warranty;
    	this.price = price;
    	this.manufacturer = manufacturer;
    	this.shippingDays = shippingDays;
    }
    
    
    // ID
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    
    // ProductType
    public ProductTypeStub getProductType() {
        return productType;
    }
    public void setProductType(ProductTypeStub productType) {
        this.productType = productType;
    }
    
    // Name
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    // Description
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    
    // Warranty
    public Integer getWarranty() {
        return warranty;
    }
    public void setWarranty(Integer warranty) {
        this.warranty = warranty;
    }
    
    // Price
    public Integer getPrice() {
        return price;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }
    
    // Manufacturer
    public ProductManufacturerStub getManufacturer() {
        return manufacturer;
    }
    public void setManufacturer(ProductManufacturerStub manufacturer) {
        this.manufacturer = manufacturer;
    }
    
    // ShippingDays
    public Integer getShippingDays() {
        return shippingDays;
    }
    public void setShippingDays(Integer shippingDays) {
        this.shippingDays = shippingDays;
    }
	


    @Override
    public String toString() {
        return ""; // "BookStub [isbn=" + isbn + ", author=" + author + ", title=" + title + ", category=" + category + ", price=" + price + ", numberOfPages=" + numberOfPages + "]";
    }

}
