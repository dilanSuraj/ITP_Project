package inv_dis_mgmtsys.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import inv_dis_mgmtsys.dao.StockManagement_IDAO;
import inv_dis_mgmtsys.dao.StockManagement_IDAOImpl;
import inv_dis_mgmtsys.model.ExpenseView;
import inv_dis_mgmtsys.model.Finance;
import inv_dis_mgmtsys.model.Item;
import inv_dis_mgmtsys.model.PermanentEmployee;
import inv_dis_mgmtsys.model.Stock;
import inv_dis_mgmtsys.model.Store;
import inv_dis_mgmtsys.model.StoreMangerReport;
import inv_dis_mgmtsys.model.Supplier;

import org.springframework.stereotype.Service;

@Service
public class StockManagement_IServicesImpl implements StockManagement_IServices {

	@Autowired
	StockManagement_IDAOImpl StockManagerIDAO;
	
	

	// All details of the Stock
	@Override
	public void addStockDetails(Stock stock) {

		StockManagerIDAO.addStockDetails(stock);

	}

	@Override
	public void deleteStockDetails(int stock_ID) {
		Stock stock = StockManagerIDAO.getSingleStockDetails(stock_ID);
		StockManagerIDAO.deleteStockDetails(stock);
		return;

	}

	@Override
	public Stock getSingleStockDetail(int stockID) {

		return StockManagerIDAO.getSingleStockDetails(stockID);
	}

	@Override
	public List<Stock> getAllStockDetail() {

		List<Stock> listOfStocks = StockManagerIDAO.getAllStockDetails();
		
		for(Stock stock:listOfStocks) {
			int itemCode = stock.getStock_itemcode();
			
			List<Item> itemList = StockManagerIDAO.getItemList();
			for(Item item : itemList) {
				if(itemCode == item.getItem_itemcode())
					stock.setItemName(item.getItem_name());
			}
			
		}
		return listOfStocks;
	}

	@Override
	public void updateStockDetails(Stock stock) {

		StockManagerIDAO.updateStockDetails(stock);
	}

	// All details of the Item
	@Override
	public void addItemDetails(Item item) {

		StockManagerIDAO.addItemDetails(item);

	}

	@Override
	public void deleteItemDetails(int item_itemcode) {

		Item item = StockManagerIDAO.getSingleItemDetails(item_itemcode);
		StockManagerIDAO.deleteItemDetails(item);
		return;

	}
	@Override
	public void updateItemDetails(Item item) {

		StockManagerIDAO.updateItemDetails(item);

	}
	
	public List<Item> getAllItemDetails() {
		return StockManagerIDAO.getAllItemDetails();
	}
	
	public Item getSingleItemDetails(int item_itemcode) {

		return StockManagerIDAO.getSingleItemDetails(item_itemcode);

	}

	
	
	//All Details of the Store

	@Override
	public void addStoreDetails(Store store) {

		StockManagerIDAO.addStoreDetails(store);
	}

	@Override
	public void deleteStoreDetails(int store_ID) {

		Store store = StockManagerIDAO.getSingleStoreDetails(store_ID);
		StockManagerIDAO.deleteStoreDetails(store);
		return;

	}

	@Override
	public void updateStoreDetails(Store store) {

		
		
		StockManagerIDAO.updateStoreDetails(store);
		
	}

	@Override
	public List<Store> getAllStoreDetails() {

		return StockManagerIDAO.getAllStoreDetails();
	}

	@Override
	public Store getSingleStoreDetails(int store_ID) {

		return StockManagerIDAO.getSingleStoreDetails(store_ID);

	}

	@Override
	public List<Supplier> getSupplierList() {
		
		return StockManagerIDAO.getSupplierList();
	}
	
	@Override
	public Supplier getSupplier(int supplierID) {
		
		return StockManagerIDAO.getSupplier(supplierID);
	}

	@Override
	public List<Store> getStoreList() {
		
		return StockManagerIDAO.getStoreList(); 
	}

	@Override
	public List<Item> getItemList() {
		
		return StockManagerIDAO.getItemList(); 
	}

	@Override
	public PermanentEmployee getEmployee(int id) {
		
		return StockManagerIDAO.getEmployee(id);
	}

	@Override
	public List<PermanentEmployee> getEmployeeList() {
		
		return StockManagerIDAO.getEmployeeList();
	}
	
	//report 
	
	public List<Map<String, Object>> getAllStoreReportViewDetails() {

		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		List<StoreMangerReport> expenseViewList = StockManagerIDAO.getAllStoreReportViewDetails();

		for (StoreMangerReport expenseView : expenseViewList) {
			Map<String, Object> map = new HashMap<>();
			map.put("StockID", expenseView.getStockID());
			map.put("SupplierName", expenseView.getSupplierName());
			map.put("StoreName", expenseView.getStoreName());
			map.put("StockAmount", expenseView.getStockAmount());
			map.put("ItemType", expenseView.getItemType());
			map.put("ItemName", expenseView.getItemName());

			list.add(map);

		}
		return list;
	}
	

}
