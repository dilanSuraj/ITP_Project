package inv_dis_mgmtsys.model;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "retailer_order")
public class RetailerOrder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int retailer_OrderID;
	
	@Column
	private int retailer_ID;
	
	@Column
	private String retailer_orderstatus;
	
	@Column(nullable = true)
	private String retailerorder_assigned_manager;
	
	@Column
	private double oder_total;
	
	@Column
	private Date order_date;
	
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

	public String getRetailer_orderstatus() {
		return retailer_orderstatus;
	}

	public void setRetailer_orderstatus(String retailer_orderstatus) {
		this.retailer_orderstatus = retailer_orderstatus;
	}

	public String getRetailerorder_assigned_manager() {
		return retailerorder_assigned_manager;
	}

	public void setRetailerorder_assigned_manager(String retailerorder_assigned_manager) {
		this.retailerorder_assigned_manager = retailerorder_assigned_manager;
	}

	public double getOder_total() {
		return oder_total;
	}

	public void setOder_total(double oder_total) {
		this.oder_total = oder_total;
	}

	public Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}

	
	
	
	
	

}
