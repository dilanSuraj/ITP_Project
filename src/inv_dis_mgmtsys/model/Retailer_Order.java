package inv_dis_mgmtsys.model;

import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "retailer_order")
public class Retailer_Order {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int retailer_OrderID;
		
	@Column
	private int retailer_ID;
	
	@Column
	private String retailer_orderstatus;

	@Column
	private int retailerorder_assigned_manager;
	
	@Column
	private double oder_total;
	
	@Column
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date order_date;
	
	@Transient
	private String DateInString;
	
	public int getRetailer_OrderID() {
		return retailer_OrderID;
	}

	public String getRetailer_orderstatus() {
		return retailer_orderstatus;
	}

	public void setRetailer_orderstatus(String retailer_orderstatus) {
		this.retailer_orderstatus = retailer_orderstatus;
	}

	public int getRetailerorder_assigned_manager() {
		return retailerorder_assigned_manager;
	}

	public void setRetailerorder_assigned_manager(int retailerorder_assigned_manager) {
		this.retailerorder_assigned_manager = retailerorder_assigned_manager;
	}

	public double getOder_total() {
		return oder_total;
	}

	public void setOder_total(double oder_total) {
		this.oder_total = oder_total;
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

	public Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Date localDate) {
		this.order_date = localDate;
	}

	public String getDateInString() {
		return DateInString =DateFormat.getDateInstance().format(this.order_date);
	}

	public void setDateInString(String dateInString) {
		DateInString = dateInString;
	}
	
	

}
