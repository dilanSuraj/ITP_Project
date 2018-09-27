package inv_dis_mgmtsys.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;



@Entity
@Table(name = "stock")
public class Stock{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int stock_ID;
	
	@Column
	private double stock_amount;
	
	@Column
	private int stock_store_ID;
	
	@Transient
	private String itemName;
	
	///
	@Column
	private int stock_itemcode;


	public int getStock_ID() {
		return stock_ID;
	}


	public void setStock_ID(int stock_ID) {
		this.stock_ID = stock_ID;
	}


	public double getStock_amount() {
		return stock_amount;
	}


	public void setStock_amount(double stock_amount) {
		this.stock_amount = stock_amount;
	}


	public int getStock_store_ID() {
		return stock_store_ID;
	}


	public void setStock_store_ID(int stock_store_ID) {
		this.stock_store_ID = stock_store_ID;
	}





	public String getItemName() {
		return itemName;
	}


	public void setItemName(String itemName) {
		this.itemName = itemName;
	}


	public int getStock_itemcode() {
		return stock_itemcode;
	}


	public void setStock_itemcode(int stock_itemcode) {
		this.stock_itemcode = stock_itemcode;
	}
  
	
	
	
	
	
	
	

}
