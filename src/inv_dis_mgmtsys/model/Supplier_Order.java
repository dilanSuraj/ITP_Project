package inv_dis_mgmtsys.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "supplier_order")
public class Supplier_Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int supplier_OrderID;
		
	@Column
	private int supplier_ID;

	public int getSupplier_OrderID() {
		return supplier_OrderID;
	}

	public void setSupplier_OrderID(int supplier_OrderID) {
		this.supplier_OrderID = supplier_OrderID;
	}

	public int getSupplier_ID() {
		return supplier_ID;
	}

	public void setSupplier_ID(int supplier_ID) {
		this.supplier_ID = supplier_ID;
	}
	
	

}
