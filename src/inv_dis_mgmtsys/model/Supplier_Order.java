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
@Table(name = "suppler_order")
public class Supplier_Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Supplier_Order_id;
		
	@Column
	private int Supplier_ID;
	
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
	
	@Column
	private int Store_Manager_ID;
	
	@Transient
	private String SupplierName;
	
	

	public String getSupplierName() {
		return SupplierName;
	}

	public void setSupplierName(String supplierName) {
		SupplierName = supplierName;
	}

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

	

	public int getSupplier_Order_id() {
		return Supplier_Order_id;
	}

	public void setSupplier_Order_id(int supplier_Order_id) {
		Supplier_Order_id = supplier_Order_id;
	}

	public int getSupplier_ID() {
		return Supplier_ID;
	}

	public void setSupplier_ID(int supplier_ID) {
		Supplier_ID = supplier_ID;
	}

	public int getStore_Manager_ID() {
		return Store_Manager_ID;
	}

	public void setStore_Manager_ID(int store_Manager_ID) {
		Store_Manager_ID = store_Manager_ID;
	}

	
	
	

}
