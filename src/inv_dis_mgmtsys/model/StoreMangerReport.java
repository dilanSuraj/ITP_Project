package inv_dis_mgmtsys.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "storemanagerreport")
public class StoreMangerReport {
	
	@Id
	private int StockID;
	@Column
	private String  SupplierName;
	@Column
	private String StoreName;
	@Column
	private double StockAmount;
	@Column
	private String ItemType;
	@Column
	private String ItemName;
	@Column
	private double ItemSalePrice;
	public String getSupplierName() {
		return SupplierName;
	}
	public void setSupplierName(String supplierName) {
		SupplierName = supplierName;
	}
	public String getStoreName() {
		return StoreName;
	}
	public void setStoreName(String storeName) {
		StoreName = storeName;
	}
	public double getStockAmount() {
		return StockAmount;
	}
	public void setStockAmount(double stockAmount) {
		StockAmount = stockAmount;
	}
	public String getItemType() {
		return ItemType;
	}
	public void setItemType(String itemType) {
		ItemType = itemType;
	}
	public String getItemName() {
		return ItemName;
	}
	public void setItemName(String itemName) {
		ItemName = itemName;
	}
	public double getItemSalePrice() {
		return ItemSalePrice;
	}
	public void setItemSalePrice(double itemSalePrice) {
		ItemSalePrice = itemSalePrice;
	}
	public int getStockID() {
		return StockID;
	}
	public void setStockID(int stockID) {
		StockID = stockID;
	}
	

}
