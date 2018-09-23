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

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int retailer_ID;

	@Column
	private String retailer_name;

	@Column
	private int retailer_contactno;

	@Column
	private String retailer_regno;

	@Column
	private String retailer_address;

	@Column
	private String retailer_username;

	@Column
	private String retailer_password;

	@Column
	private String retailer_province;

	public int getRetailer_ID() {
		return retailer_ID;
	}

	public void setRetailer_ID(int retailer_ID) {
		this.retailer_ID = retailer_ID;
	}

	public String getRetailer_name() {
		return retailer_name;
	}

	public void setRetailer_name(String retailer_name) {
		this.retailer_name = retailer_name;
	}

	public int getRetailer_contactno() {
		return retailer_contactno;
	}

	public void setRetailer_contactno(int retailer_contactno) {
		this.retailer_contactno = retailer_contactno;
	}

	public String getRetailer_regno() {
		return retailer_regno;
	}

	public void setRetailer_regno(String retailer_regno) {
		this.retailer_regno = retailer_regno;
	}

	public String getRetailer_address() {
		return retailer_address;
	}

	public void setRetailer_address(String retailer_address) {
		this.retailer_address = retailer_address;
	}

	public String getRetailer_username() {
		return retailer_username;
	}

	public void setRetailer_username(String retailer_username) {
		this.retailer_username = retailer_username;
	}

	public String getRetailer_password() {
		return retailer_password;
	}

	public void setRetailer_password(String retailer_password) {
		this.retailer_password = retailer_password;
	}

	public String getRetailer_province() {
		return retailer_province;
	}

	public void setRetailer_province(String retailer_province) {
		this.retailer_province = retailer_province;
	}

}
