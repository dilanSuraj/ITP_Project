package inv_dis_mgmtsys.model;

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
	private int retailerorder_assigned_manager;
	
	@Column
	private String retailer_orderstatus;
	
	@Column
	private double oder_total;
	
	@Column
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date order_date;
	
	
	@Transient
	private String DateInString;
	
	@Transient
	private String retailerorder_assigned_manager_Name;
	
	@Column
	private int  SR_ID; 
	
	@Transient
	private Retailer retailer;
	

	@Transient
	private String SalesRepresentative_Name;
	
	
	public String getSalesRepresentative_Name() {
		return SalesRepresentative_Name;
	}

	public void setSalesRepresentative_Name(String salesRepresentative_Name) {
		SalesRepresentative_Name = salesRepresentative_Name;
	}
	
	
	public String getRetailerorder_assigned_manager_Name() {
		return retailerorder_assigned_manager_Name;
	}

	public void setRetailerorder_assigned_manager_Name(String retailerorder_assigned_manager_Name) {
		this.retailerorder_assigned_manager_Name = retailerorder_assigned_manager_Name;
	}

	public Retailer getRetailer() {
		return retailer;
	}

	public void setRetailer(Retailer retailer) {
		this.retailer = retailer;
	}

	public int getSR_ID() {
		return SR_ID;
	}

	public void setSR_ID(int sR_ID) {
		SR_ID = sR_ID;
	}

	public String getDateInString() {
		return DateInString;
	}

	public void setDateInString(String dateInString) {
		DateInString = dateInString;
	}

	public Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}

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
