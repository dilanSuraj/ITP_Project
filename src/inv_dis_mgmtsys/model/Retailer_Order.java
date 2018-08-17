package inv_dis_mgmtsys.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "retailer_order")
public class Retailer_Order {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int retailer_OrderID;
		
	@Column
	private int retailer_ID;

	public int getRetailer_OrderID() {
		return retailer_OrderID;
	}

	public void setRetailer_OrderID(int retailer_OrderID) {
		this.retailer_OrderID = retailer_OrderID;
	}

	public int getRetailer_ID() {
		return retailer_ID;
	}

	public void setRetailer_ID(int retailer_ID) {
		this.retailer_ID = retailer_ID;
	}
	
	

}
