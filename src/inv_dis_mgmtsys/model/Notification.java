package inv_dis_mgmtsys.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "retailer_notification")
public class Notification {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int retailer_notification_ID;

	@Column
	private String retailer_notification_details;

	@Column
	private int retailer_notification_retailerID;

	public int getRetailer_notification_ID() {
		return retailer_notification_ID;
	}

	public void setRetailer_notification_ID(int retailer_notification_ID) {
		this.retailer_notification_ID = retailer_notification_ID;
	}

	public String getRetailer_notification_details() {
		return retailer_notification_details;
	}

	public void setRetailer_notification_details(String retailer_notification_details) {
		this.retailer_notification_details = retailer_notification_details;
	}

	public int getRetailer_notification_retailerID() {
		return retailer_notification_retailerID;
	}

	public void setRetailer_notification_retailerID(int retailer_notification_retailerID) {
		this.retailer_notification_retailerID = retailer_notification_retailerID;
	}

	
}
