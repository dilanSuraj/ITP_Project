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
	
	@Column
	private int retailerorder_assigned_manager;
	
	@Column
	private String retailer_orderstatus;
	
	@Column
	private double oder_total;
	
	
	

	public int getRetailerorder_assigned_manager() {
		return retailerorder_assigned_manager;
	}

	public void setRetailerorder_assigned_manager(int retailerorder_assigned_manager) {
		this.retailerorder_assigned_manager = retailerorder_assigned_manager;
	}

	public String getRetailer_orderstatus() {
		return retailer_orderstatus;
	}

	public void setRetailer_orderstatus(String retailer_orderstatus) {
		this.retailer_orderstatus = retailer_orderstatus;
	}

	public double getOder_total() {
		return oder_total;
	}

	public void setOder_total(double oder_total) {
		this.oder_total = oder_total;
	}

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
