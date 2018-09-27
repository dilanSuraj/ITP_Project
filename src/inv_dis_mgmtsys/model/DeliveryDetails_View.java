package inv_dis_mgmtsys.model;



import java.text.DateFormat;
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
@Table(name = "deliverydetails_view")
public class DeliveryDetails_View {
				
	@Id
	private int retailerOrderID;
	
	@Column
	private String retailerName;
	
	@Column
	private int retailerContactNo;
	
	@Column
	private String retailerAddress;
	
	@Column
	private int orderTotal;
	
	@Column
	private String orderDate;
	
	@Column
	private int SRID;

	public int getRetailer_ID() {
		return retailerOrderID;
	}

	public void setRetailer_ID(int retailer_ID) {
		this.retailerOrderID = retailer_ID;
	}

	public String getRetailerName() {
		return retailerName;
	}

	public void setRetailerName(String retailerName) {
		this.retailerName = retailerName;
	}

	public int getRetailerContactNo() {
		return retailerContactNo;
	}

	public void setRetailerContactNo(int retailerContactNo) {
		this.retailerContactNo = retailerContactNo;
	}

	public String getRetailerAddress() {
		return retailerAddress;
	}

	public void setRetailerAddress(String retailerAddress) {
		this.retailerAddress = retailerAddress;
	}

	public int getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(int orderTotal) {
		this.orderTotal = orderTotal;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public int getSRID() {
		return SRID;
	}

	public void setSRID(int sRID) {
		SRID = sRID;
	}
	
	
}
	
	
