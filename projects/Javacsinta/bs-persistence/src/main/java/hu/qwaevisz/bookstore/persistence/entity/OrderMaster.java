package hu.qwaevisz.bookstore.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import hu.qwaevisz.bookstore.persistence.entity.trunk.DeliveryStatus;
import hu.qwaevisz.bookstore.persistence.entity.trunk.PaymentMethod;
import hu.qwaevisz.bookstore.persistence.parameter.OrderMasterParameter;
import hu.qwaevisz.bookstore.persistence.query.OrderMasterQuery;

@Entity
@Table(name = "order_master")
@NamedQueries(value = { //
		@NamedQuery(name = OrderMasterQuery.GET_BY_ID, query = "SELECT b FROM OrderMaster b WHERE b.id=:" + OrderMasterParameter.ID),
		@NamedQuery(name = OrderMasterQuery.GET_BY_CUSTOMER_ID, query = "SELECT b FROM OrderMaster b WHERE b.customer_id=:" + OrderMasterParameter.CUSTOMER_ID),
		@NamedQuery(name = OrderMasterQuery.GET_BY_EMPLOYEE_ID, query = "SELECT b FROM OrderMaster b WHERE b.employee_id=:" + OrderMasterParameter.EMPLOYEE_ID),
		@NamedQuery(name = OrderMasterQuery.GET_BY_TOTAL_PRICE, query = "SELECT b FROM OrderMaster b WHERE b.total_price=:" + OrderMasterParameter.TOTAL_PRICE),
		@NamedQuery(name = OrderMasterQuery.GET_ALL, query = "SELECT b FROM OrderMaster b ORDER BY b.id")
		//
})
public class OrderMaster implements Serializable {

	private static final long serialVersionUID = 1525352421414297015L;

	@Id
	@Column(name = "order_master_id", nullable = false, updatable = false, insertable = true)
	private Long id;
	
	
	@Column(name = "order_master_customer_id", nullable = false, updatable = false, insertable = true)
	private Long customer_id;
	
	
	@Column(name = "order_master_employee_id", nullable = false, updatable = false, insertable = true)
	private Long employee_id;

	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "order_master_delivery_status_id", nullable = false)
	private DeliveryStatus deliverytStatus;
	
	@Column(name = "total_price", nullable = false, updatable = true, insertable = true)
	private Float total_price;
	
	
	@Override
	public String toString() {
		return "OrderMaster [id=" + id + ", customer_id=" + customer_id + ", employee_id=" + employee_id +
				 ", delivery_status_id=" + deliverytStatus + ", total_price=" + total_price + "]";
	}

}
