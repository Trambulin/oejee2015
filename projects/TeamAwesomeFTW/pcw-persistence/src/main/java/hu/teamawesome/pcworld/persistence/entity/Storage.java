package hu.teamawesome.pcworld.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import hu.teamawesome.pcworld.persistence.parameter.StorageParameter;
import hu.teamawesome.pcworld.persistence.query.StorageQuery;

@Entity
@Table(name = "storage")
@NamedQueries(value = {
		//
		@NamedQuery(name = StorageQuery.GET_BY_ID, query = "SELECT s FROM Storage s WHERE supplier.id=:" + StorageParameter.ID),
		@NamedQuery(name = StorageQuery.GET_BY_TYPE, query = "SELECT s FROM Storage s WHERE supplier.type.id=:" + StorageParameter.Type),
		@NamedQuery(name = StorageQuery.GET_ALL, query = "SELECT s FROM Storage s ORDER BY supplier.type.id, supplier.name"),
		@NamedQuery(name = StorageQuery.COUNT, query = "SELECT COUNT(s) FROM Storage s WHERE supplier.id=:" + StorageParameter.ID),
		@NamedQuery(name = StorageQuery.REMOVE_BY_PID, query = "DELETE FROM Storage s WHERE supplier.id=:" + StorageParameter.ID)
		//
})
public class Storage implements Serializable
{
	private static final long serialVersionUID = 1525352421414297015L;
	
	
	@Id
	@SequenceGenerator(name = "generatorStorage", sequenceName = "storage_stg_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorStorage")
	@Column(name = "stg_id", nullable = false, updatable = false, insertable = false)
	private Long id;
	
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "stg_pid", referencedColumnName = "sup_id", nullable = false)
	private Supplier supplier;
	
	
	@Column(name = "stg_price", nullable = false)
	private Integer price;
	
	@Column(name = "stg_quantity", nullable = false)
	private Integer quantity;
	
	@Column(name = "stg_quantity_reserved", nullable = false)
	private Integer quantityReserved;
	
	
	public Storage() {

	}
	
	// shortcut to ID
	public Long getId() {
		return this.id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public Supplier getSupplier()
	{
		return supplier;
	}
	public void setSupplier(Supplier supplier)
	{
		this.supplier = supplier;
	}
	
	public Integer getPrice()
	{
		return this.price;
	}
	public void setPrice(Integer price)
	{
		this.price = price;
	}
	
	public Integer getQuantity()
	{
		return this.quantity;
	}
	public void setQuantity(Integer quantity)
	{
		this.quantity = quantity;
	}
	
	public Integer getQuantityReserved()
	{
		return this.quantityReserved;
	}
	public void setQuantityReserved(Integer quantityReserved)
	{
		this.quantityReserved = quantityReserved;
	}
	
	
	
	@Override
	public String toString() {
		return "Product [supplier=" + this.supplier +
						", price=" + this.price +
						", quantity=" + this.quantity +
						", quantityReserved=" + this.quantityReserved + "]";
	}
}
