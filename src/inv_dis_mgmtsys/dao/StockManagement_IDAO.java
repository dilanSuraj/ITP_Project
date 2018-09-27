package inv_dis_mgmtsys.dao;

import java.util.List;

import inv_dis_mgmtsys.model.Item;
import inv_dis_mgmtsys.model.PermanentEmployee;
import inv_dis_mgmtsys.model.Stock;
import inv_dis_mgmtsys.model.Store;
import inv_dis_mgmtsys.model.StoreMangerReport;
import inv_dis_mgmtsys.model.Supplier;

public interface StockManagement_IDAO {

	// stock details part
	public void addStockDetails(Stock stock);

	public void deleteStockDetails(Stock stock);

	public void updateStockDetails(Stock stock);

	public List<Stock> getAllStockDetails();

	public Stock getSingleStockDetails(int stock_ID);

	// item details part
	public Item getSingleItemDetails(int item_itemcode);

	public void addItemDetails(Item item);

	public void deleteItemDetails(Item item);

	public void updateItemDetails(Item item);

	public List<Item> getAllItemDetails();
	
	public List<Item> getItemList();

	// store details part
	public void addStoreDetails(Store store);

	public void deleteStoreDetails(Store store);

	public void updateStoreDetails(Store store);

	public Store getSingleStoreDetails(int store_ID);

	public List<Store> getAllStoreDetails();

	public List<Supplier> getSupplierList();
	
	public List<Store> getStoreList();

	public Supplier getSupplier(int supplierID);
	
	// nEw edited Store View Empployee
	
	public List<PermanentEmployee> getEmployeeList();
	
	
	//
	public PermanentEmployee getEmployee(int id);
	
	//Report Generation
	
	public List<StoreMangerReport> getAllStoreReportViewDetails();
	
	
}
