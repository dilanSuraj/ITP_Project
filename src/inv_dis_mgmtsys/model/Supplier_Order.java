package inv_dis_mgmtsys.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "supplier_order")
public class Supplier_Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int supplier_OrderID;
		
	@Column
	private int supplier_ID;
	
	@Column
	private String Order_Status;
	
	@Column
	private double amount;
	
	@Column
	private int item_code;
	
	@Column
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date Supplier_order_date; 
	
	@Transient 
	private String Itemname;
	
	

	public Date getSupplier_order_date() {
		return Supplier_order_date;
	}

	public void setSupplier_order_date(Date supplier_order_date) {
		Supplier_order_date = supplier_order_date;
	}

	public String getItemname() {
		return Itemname;
	}

	public void setItemname(String itemname) {
		Itemname = itemname;
	}

	public int getItem_code() {
		return item_code;
	}

	public void setItem_code(int item_code) {
		this.item_code = item_code;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getOrder_Status() {
		return Order_Status;
	}

	public void setOrder_Status(String order_Status) {
		Order_Status = order_Status;
	}

	public int getSupplier_OrderID() {
		return supplier_OrderID;
	}

	public void setSupplier_OrderID(int supplier_OrderID) {
		this.supplier_OrderID = supplier_OrderID;
	}

	public int getSupplier_ID() {
		return supplier_ID;
	}

	public void setSupplier_ID(int supplier_ID) {
		this.supplier_ID = supplier_ID;
	}
	
	

}
