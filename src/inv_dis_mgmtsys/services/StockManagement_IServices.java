package inv_dis_mgmtsys.services;

import java.util.List;

import inv_dis_mgmtsys.model.Item;
import inv_dis_mgmtsys.model.PermanentEmployee;
import inv_dis_mgmtsys.model.Stock;
import inv_dis_mgmtsys.model.Store;
import inv_dis_mgmtsys.model.Supplier;

public interface StockManagement_IServices {

	// Stock details
	public void addStockDetails(Stock stock);

	public void deleteStockDetails(int stock_ID);

	public void updateStockDetails(Stock stock);

	public List<Stock> getAllStockDetail();

	public Stock getSingleStockDetail(int stockID);

	// item Details
	public void addItemDetails(Item item);

	public void deleteItemDetails(int item_itemcode);

	public void updateItemDetails(Item item);

	public Item getSingleItemDetails(int item_itemcode);

	public List<Item> getAllItemDetails();
	
	public List<Item> getItemList();

	// Store Details

	public void addStoreDetails(Store store);

	public void deleteStoreDetails(int store_ID);

	public void updateStoreDetails(Store store);

	public Store getSingleStoreDetails(int store_ID);

	public List<Store> getAllStoreDetails();

	public List<Supplier> getSupplierList();

	public Supplier getSupplier(int supplierID);

	public List<Store> getStoreList();
	
	public PermanentEmployee getEmployee(int id);
	
	// new Edited Store View Staff Name
	
	public List<PermanentEmployee> getEmployeeList();

	
	//Report GEneration

}
