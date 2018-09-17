package inv_dis_mgmtsys.model;



import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "supplier_finance_view")
public class SupplierFinance_View {
	
	@Id
	private int id;
	
	@Column
	private double amount;
	
	@Column
	private Date payment_date;
	
	@Column
	private String	item_name;
	
	@Column
	private String	supplier_companyname;
	
	@Column
	private int supplier_order_item_Amount;
	
	@Column
	private double item_grossprice;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getPayment_date() {
		return payment_date;
	}

	public void setPayment_date(Date payment_date) {
		this.payment_date = payment_date;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public String getSupplier_companyname() {
		return supplier_companyname;
	}

	public void setSupplier_companyname(String supplier_companyname) {
		this.supplier_companyname = supplier_companyname;
	}

	public int getSupplier_order_item_Amount() {
		return supplier_order_item_Amount;
	}

	public void setSupplier_order_item_Amount(int supplier_order_item_Amount) {
		this.supplier_order_item_Amount = supplier_order_item_Amount;
	}

	public double getItem_grossprice() {
		return item_grossprice;
	}

	public void setItem_grossprice(double item_grossprice) {
		this.item_grossprice = item_grossprice;
	}	
	
	
}
