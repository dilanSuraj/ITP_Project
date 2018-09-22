package inv_dis_mgmtsys.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "extra_stock")
public class ExtraStock_Distribution {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int extra_stock_ID;
	
	@Column
	private int extra_stock_quantity;
	
	@Column
	private int extra_stock_itemcode;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
	
	@Column
	private String extra_stock_vehicle_ID;
	
	@Transient
	private String itemName;

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	

	public int getExtra_stock_quantity() {
		return extra_stock_quantity;
	}

	public void setExtra_stock_quantity(int extra_stock_quantity) {
		this.extra_stock_quantity = extra_stock_quantity;
	}

	public int getExtra_stock_itemcode() {
		return extra_stock_itemcode;
	}

	public void setExtra_stock_itemcode(int extra_stock_itemcode) {
		this.extra_stock_itemcode = extra_stock_itemcode;
	}

	public String getExtra_stock_vehicle_ID() {
		return extra_stock_vehicle_ID;
	}

	public void setExtra_stock_vehicle_ID(String extra_stock_vehicle_ID) {
		this.extra_stock_vehicle_ID = extra_stock_vehicle_ID;
	}
	

	public int getExtra_stock_ID() {
		return extra_stock_ID;
	}

	public void setExtra_stock_ID(int extra_stock_ID) {
		this.extra_stock_ID = extra_stock_ID;
	}

}
