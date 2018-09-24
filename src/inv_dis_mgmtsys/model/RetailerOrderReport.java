package inv_dis_mgmtsys.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "retailerorders")
public class RetailerOrderReport {

	
	@Id
	private int retailer_OrderID;
	
	@Column
	private double oder_total;
	
	@Column
	private Date order_date;
	
	@Column
	private String retailer_name;
	
	
	public int getRetailer_OrderID() {
		return retailer_OrderID;
	}
	public void setRetailer_OrderID(int retailer_OrderID) {
		this.retailer_OrderID = retailer_OrderID;
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
	public String getRetailer_name() {
		return retailer_name;
	}
	public void setRetailer_name(String retailer_name) {
		this.retailer_name = retailer_name;
	}
	
	
}
