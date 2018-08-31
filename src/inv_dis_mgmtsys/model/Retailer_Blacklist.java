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


public class Retailer_Blacklist {
	
	
		
	
	private int retailer_blacklist_retailerID;
	
	
	private double retailer_blacklist_amount;
	
	
	private Retailer retailer;
	
	
	
	public Retailer getRetailer() {
		return retailer;
	}

	public void setRetailer(Retailer retailer) {
		this.retailer = retailer;
	}

	
	private Date retailer_blacklist_deadlineDate;

	
	public int getRetailer_blacklist_retailerID() {
		return retailer_blacklist_retailerID;
	}

	public void setRetailer_blacklist_retailerID(int retailer_blacklist_retailerID) {
		this.retailer_blacklist_retailerID = retailer_blacklist_retailerID;
	}

	public double getRetailer_blacklist_amount() {
		return retailer_blacklist_amount;
	}

	public void setRetailer_blacklist_amount(double retailer_blacklist_amount) {
		this.retailer_blacklist_amount = retailer_blacklist_amount;
	}

	public Date getRetailer_blacklist_deadlineDate() {
		return retailer_blacklist_deadlineDate;
	}

	public void setRetailer_blacklist_deadlineDate(Date retailer_blacklist_deadlineDate) {
		this.retailer_blacklist_deadlineDate = retailer_blacklist_deadlineDate;
	}
	
				


}
