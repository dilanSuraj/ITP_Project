package inv_dis_mgmtsys.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cart")
public class cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cart_ID;
	
	@Column
	private double cart_amount;
	
	@Column
	private int cart_retailer_ID;
	
	@Column
	private int cart_itemcode;
	

	public int getCart_ID() {
		return cart_ID;
	}

	public void setCart_ID(int cart_ID) {
		this.cart_ID = cart_ID;
	}

	public double getCart_amount() {
		return cart_amount;
	}

	public void setCart_amount(double cart_amount) {
		this.cart_amount = cart_amount;
	}

	public int getCart_retailer_ID() {
		return cart_retailer_ID;
	}

	public void setCart_retailer_ID(int cart_retailer_ID) {
		this.cart_retailer_ID = cart_retailer_ID;
	}

	public int getCart_itemcode() {
		return cart_itemcode;
	}

	public void setCart_itemcode(int cart_itemcode) {
		this.cart_itemcode = cart_itemcode;
	}

	
}
