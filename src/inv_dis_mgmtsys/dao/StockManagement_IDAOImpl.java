package inv_dis_mgmtsys.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import inv_dis_mgmtsys.model.Finance;
import inv_dis_mgmtsys.model.Item;
import inv_dis_mgmtsys.model.Payment;
import inv_dis_mgmtsys.model.PermanentEmployee;
import inv_dis_mgmtsys.model.Stock;
import inv_dis_mgmtsys.model.Store;
import inv_dis_mgmtsys.model.StoreMangerReport;
import inv_dis_mgmtsys.model.Supplier;
import inv_dis_mgmtsys.model.TransportFinance;
import inv_dis_mgmtsys.services.StockManagement_IServices;
import inv_dis_mgmtsys.services.StockManagement_IServicesImpl;

@Repository
public class StockManagement_IDAOImpl implements StockManagement_IDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Autowired
	private StockManagement_IServices stockManagement_IServices;

	@Override
	public void addStockDetails(Stock stock) {

		sessionFactory.getCurrentSession().saveOrUpdate(stock);
	}

	@Override

	public void deleteStockDetails(Stock stock) {

		sessionFactory.getCurrentSession().delete(stock);

	}

	@Override
	public Stock getSingleStockDetails(int stock_ID) {
		return (Stock) sessionFactory.getCurrentSession().get(Stock.class, stock_ID);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Stock> getAllStockDetails() {

		return sessionFactory.getCurrentSession().createQuery("From Stock").list();
	}

	// Update Method stock
	@Override
	public void updateStockDetails(Stock stock) {

		// Stock stock= (Stock) stock;
		String hql = "update Stock stock set stock.stock_amount= ?, stock.stock_store_ID= ? where stock.itemcode=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter(0, stock.getStock_amount());
		query.setParameter(1, stock.getStock_itemcode());
		query.setParameter(2, stock.getStock_store_ID());

		int result = query.executeUpdate();
		System.out.println("Results : " + result);
		return;

	}

	
	// Item Details
	@Override
	public List<Item> getAllItemDetails() {

		@SuppressWarnings("unchecked")
		List<Item> itemList = sessionFactory.getCurrentSession().createQuery("From Item").list();

		return itemList;

	}

	public void addItemDetails(Item item) {

		sessionFactory.getCurrentSession().save(item);
	}

	@Override
	public void deleteItemDetails(Item item) {

		sessionFactory.getCurrentSession().delete(item);

	}
	
	@Override
	public void updateItemDetails(Item item) {
		  
		String hql = "update Item item set item.item_type= ?,item.item_name= ? where item.item_itemcode=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter(0, item.getItem_type());
		query.setParameter(1, item.getItem_name());
		query.setParameter(2, item.getItem_itemcode());
		
		
		int result = query.executeUpdate();
		System.out.println("Results : " + result);
		return;

		
		
		
	}

	@Override
	public Item getSingleItemDetails(int item_itemcode) {
		return (Item) sessionFactory.getCurrentSession().get(Item.class, item_itemcode);

	}

	//all store details

	@Override
	public void addStoreDetails(Store store) {

		sessionFactory.getCurrentSession().save(store);
		
	}
	
	@Override
	public void deleteStoreDetails(Store store) {

		sessionFactory.getCurrentSession().delete(store);

	}

	@Override
	public void updateStoreDetails(Store store) {
     
		String hql = "update Store store set store.store_address= ? ,store.store_staff_emp_ID=? where store.store_ID=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		query.setParameter(0, store.getStore_address());
		query.setParameter(1, store.getStore_staff_emp_ID());
		query.setParameter(2, store.getStore_ID());

		
		//query.setParameter(2, store.getStore_staff_emp_ID());
		
		int result = query.executeUpdate();
		System.out.println("Results : " + result);
		return;
  
	
		
		
		
	}

	@Override
	public List<Store> getAllStoreDetails() {
		@SuppressWarnings("unchecked")
		List<Store> storeList = sessionFactory.getCurrentSession().createQuery("From Store").list();
		for(Store s: storeList) {
        	PermanentEmployee emp=stockManagement_IServices.getEmployee(s.getStore_staff_emp_ID());
			s.setStaff_name(emp.getFullname());
        	/*List<PermanentEmployee> perEmp = stockManagement_IServices.getEmployeeList();
        	int empID=s.getStore_staff_emp_ID();
        	for(PermanentEmployee p: perEmp) {
        		
        		if(p.getId()== empID) {
        			s.setStaff_name(p.getFullname());
        			System.out.println("Staff Name"+ s.getStaff_name());
        		}
        	
        	}
        */
			
		}
		

		return storeList;
	}

	
	@Override
	public Store getSingleStoreDetails(int store_ID) {
		return (Store) sessionFactory.getCurrentSession().get(Store.class, store_ID);
	}

	//Supplier List
	@Override
	public List<Supplier> getSupplierList() {
		@SuppressWarnings("unchecked")
		List<Supplier> supplierList = sessionFactory.getCurrentSession().createQuery("From Supplier").list();

		return supplierList;
	}

	@Override
	public Supplier getSupplier(int supplierID) {
		
		return (Supplier) sessionFactory.getCurrentSession().get(Supplier.class, supplierID);
	}

	@Override
	public List<Store> getStoreList() {
		@SuppressWarnings("unchecked")
		List<Store> storeList = sessionFactory.getCurrentSession().createQuery("From Store").list();
        
		return storeList;
	}

	@Override
	public List<Item> getItemList() {
		@SuppressWarnings("unchecked")
		List<Item> itemList = sessionFactory.getCurrentSession().createQuery("From Item").list();

		return itemList;
	}

	@Override
	public PermanentEmployee getEmployee(int id) {
		String hql = "from PermanentEmployee E  where E.id=:id";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("id", id);
		System.out.println(id);
		PermanentEmployee permanentEmployee = (PermanentEmployee)query.list().get(0);
		return permanentEmployee ;
		
	}

	@Override
	public List<PermanentEmployee> getEmployeeList() {
		
		@SuppressWarnings("unchecked")
		List<PermanentEmployee> employeeList = sessionFactory.getCurrentSession().createQuery("From PermanentEmployee").list();

		return  employeeList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StoreMangerReport> getAllStoreReportViewDetails() {
		return sessionFactory.getCurrentSession().createQuery("From StoreMangerReport").list();
	} 

	
	

	
}
