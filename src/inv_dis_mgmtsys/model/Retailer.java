package inv_dis_mgmtsys.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "retailer")
public class Retailer {
	
	public int getRetailer_ID() {
		return retailer_ID;
	}

	public void setRetailer_ID(int retailer_ID) {
		this.retailer_ID = retailer_ID;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int retailer_ID;
		
	@Column
	private String retailer_name;
	
	
	@Column
	private String retailer_blacklistStatus;


	public String getRetailer_blacklistStatus() {
		return retailer_blacklistStatus;
	}

	public void setRetailer_blacklistStatus(String retailer_blacklistStatus) {
		this.retailer_blacklistStatus = retailer_blacklistStatus;
	}

	public String getRetailer_name() {
		return retailer_name;
	}

	public void setRetailer_name(String retailer_name) {
		this.retailer_name = retailer_name;
	}
	
	

}
