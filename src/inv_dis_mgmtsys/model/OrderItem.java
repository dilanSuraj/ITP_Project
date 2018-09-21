package inv_dis_mgmtsys.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "orderitem")
public class OrderItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderItem_ID;
	
	@Column
	private int orderItem_itemcode;
	
	@Column
	private int orderItem_unitscount;
	
	@Column
	private double oderitem_totalcost;

	@Column
	private int ordertItem_order_ID;
	
	@Transient
	private String itemName;
	
	@Transient
	private double  unitPrice;
	
	
	
	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getOrderItem_ID() {
		return orderItem_ID;
	}

	public void setOrderItem_ID(int orderItem_ID) {
		this.orderItem_ID = orderItem_ID;
	}

	public int getOrdertItem_order_ID() {
		return ordertItem_order_ID;
	}

	public void setOrdertItem_order_ID(int ordertItem_order_ID) {
		this.ordertItem_order_ID = ordertItem_order_ID;
	}

	public int getOrderItem_itemcode() {
		return orderItem_itemcode;
	}

	public void setOrderItem_itemcode(int orderItem_itemcode) {
		this.orderItem_itemcode = orderItem_itemcode;
	}

	public int getOrderItem_unitscount() {
		return orderItem_unitscount;
	}

	public void setOrderItem_unitscount(int orderItem_unitscount) {
		this.orderItem_unitscount = orderItem_unitscount;
	}

	public double getOderitem_totalcost() {
		return oderitem_totalcost;
	}

	public void setOderitem_totalcost(double oderitem_totalcost) {
		this.oderitem_totalcost = oderitem_totalcost;
	} 
	
	
	
	
}
