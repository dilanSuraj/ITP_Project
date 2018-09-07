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
	private int supplier_order_Item_ID;

	@Column
	private String supplier_order_item_status;
	@Column
	private int supplier_order_item_itemcode;
	
	@Column
	private int supplier_order_item_Amount;

	@Column
	private int supplier_order_Item_supplierID;

	public int getSupplier_order_Item_ID() {
		return supplier_order_Item_ID;
	}

	public void setSupplier_order_Item_ID(int supplier_order_Item_ID) {
		this.supplier_order_Item_ID = supplier_order_Item_ID;
	}

	public String getSupplier_order_item_status() {
		return supplier_order_item_status;
	}

	public void setSupplier_order_item_status(String supplier_order_item_status) {
		this.supplier_order_item_status = supplier_order_item_status;
	}

	public int getSupplier_order_item_itemcode() {
		return supplier_order_item_itemcode;
	}

	public void setSupplier_order_item_itemcode(int supplier_order_item_itemcode) {
		this.supplier_order_item_itemcode = supplier_order_item_itemcode;
	}

	public int getSupplier_order_item_Amount() {
		return supplier_order_item_Amount;
	}

	public void setSupplier_order_item_Amount(int supplier_order_item_Amount) {
		this.supplier_order_item_Amount = supplier_order_item_Amount;
	}

	public int getSupplier_order_Item_supplierID() {
		return supplier_order_Item_supplierID;
	}

	public void setSupplier_order_Item_supplierID(int supplier_order_Item_supplierID) {
		this.supplier_order_Item_supplierID = supplier_order_Item_supplierID;
	}
	
}