package hu.oe.pancakestore.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

//import hu.oe.pancakestore.persistence.entity.trunk.PaymentMethod;
import hu.oe.pancakestore.persistence.parameter.PancakeParameter;
import hu.oe.pancakestore.persistence.query.PancakeQuery;

@Entity
@Table(name = "pancake")
@NamedQueries(value = { //
		@NamedQuery(name = PancakeQuery.GET_BY_NAME, query = "SELECT b FROM Pancake b WHERE b.name=:" + PancakeParameter.NAME),
		@NamedQuery(name = PancakeQuery.GET_BY_ID, query = "SELECT b FROM Pancake b WHERE b.id=:" + PancakeParameter.ID),
		@NamedQuery(name = PancakeQuery.GET_BY_PRICE, query = "SELECT b FROM Pancake b WHERE b.price=:" + PancakeParameter.PRICE),
		@NamedQuery(name = PancakeQuery.GET_ALL, query = "SELECT b FROM Pancake b ORDER BY b.name"),
		@NamedQuery(name = PancakeQuery.COUNT_BY_ID, query = 
				"SELECT COUNT(p) FROM Pancake p WHERE p.id=:" + PancakeParameter.ID),
//		@NamedQuery(name = PancakeQuery.COUNT_BY_NAME, query = 
//		"SELECT COUNT(p) FROM Pancake p WHERE i.name=:" + PancakeParameter.NAME),
		@NamedQuery(name = PancakeQuery.REMOVE_BY_ID, query = "DELETE FROM Pancake p WHERE p.id=:" + PancakeParameter.ID)
		 
		//
})
public class Pancake implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2550410032106161290L;

	public Pancake(){
		this(null,null,0,null);
	}
	
	public Pancake(String name, int price, String description) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
	}
	public Pancake(Long pancakeId, String name, int price, String description) {
		super();
		this.id = pancakeId;
		this.name = name;
		this.description = description;
		this.price = price;
	}

	@Id
	@SequenceGenerator(name = "generatorPancake", sequenceName = "pancake_pancake_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorPancake")
	@Column(name = "pancake_id", nullable = false, updatable = false, insertable = true)
	private Long id;
	
	@Column(name = "pancake_name", nullable = false)
	private String name;

	@Column(name = "pancake_description", nullable = true)
	private String description;
	
	@Column(name = "pancake_price", nullable = false)
	private int price;
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "Pancake [id=" + id + ", name=" + name + ", price=" + price + ", description=" + description + "]";
	}

}
