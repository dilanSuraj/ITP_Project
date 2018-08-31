package inv_dis_mgmtsys.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "supplier_order_items")
public class SupplierOrderItems {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int supplier_order_ItemID;
	
	@Column
	private int supplier_order_ID;
	
	@Column
	private String supplier_order_item_Name;
	
	@Column
	private int supplier_order_item_Amount;

	public int getSupplier_order_ItemID() {
		return supplier_order_ItemID;
	}

	public void setSupplier_order_ItemID(int supplier_order_ItemID) {
		this.supplier_order_ItemID = supplier_order_ItemID;
	}

	public int getSupplier_order_ID() {
		return supplier_order_ID;
	}

	public void setSupplier_order_ID(int supplier_order_ID) {
		this.supplier_order_ID = supplier_order_ID;
	}

	public String getSupplier_order_item_Name() {
		return supplier_order_item_Name;
	}

	public void setSupplier_order_item_Name(String supplier_order_item_Name) {
		this.supplier_order_item_Name = supplier_order_item_Name;
	}

	public int getSupplier_order_item_Amount() {
		return supplier_order_item_Amount;
	}

	public void setSupplier_order_item_Amount(int supplier_order_item_Amount) {
		this.supplier_order_item_Amount = supplier_order_item_Amount;
	}


}
