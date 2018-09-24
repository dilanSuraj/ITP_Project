package inv_dis_mgmtsys.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import inv_dis_mgmtsys.model.Item;

import inv_dis_mgmtsys.model.Supplier;
import inv_dis_mgmtsys.model.Supplier_Order;

@Repository
public class SupplierOderManagment_IDAOImpl implements SupplierOderManagment_IDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	@Override
	public List<Item> getItems() {
		@SuppressWarnings("unchecked")
		List<Item> list = (List<Item>) sessionFactory.getCurrentSession()
				.createQuery("from Item").list();

		for(Item i:list) {
			
			int supplier_ID=i.getItem_supplier_ID();
			
			Query query = sessionFactory.getCurrentSession().createQuery("from Supplier s where s.supplier_ID=:id");
			query.setParameter("id", supplier_ID);
			Supplier supplier= (Supplier)query.list().get(0);
			i.setSupplier_Name(supplier.getSupplier_name());
		}
		return list;
	}


	@Override
	public void placeTheOrder(Supplier_Order supplyItem) {
		
		Date date=new Date();
		supplyItem.setSupplier_order_date(date);
		sessionFactory.getCurrentSession().saveOrUpdate(supplyItem);
		
	}


	
	@Override
	public List<Supplier_Order> getSupplierOrders(int StorManagerID) {

		Query query = sessionFactory.getCurrentSession().createQuery("from Supplier_Order s where s.Store_Manager_ID=:id");
		query.setParameter("id", StorManagerID);
		
		
		@SuppressWarnings("unchecked")
		List<Supplier_Order> orders= (List<Supplier_Order>)query.list();
		
		return orders;
	}


	@Override
	public Item getItem(int ItemId) {
		Query query = sessionFactory.getCurrentSession().createQuery("from Item i where i.item_itemcode=:id");
		query.setParameter("id", ItemId);
		
		return (Item)query.list().get(0); 
	}


	@Override
	public Supplier_Order getSupplierOrder(int orderId) {
	
		Query query = sessionFactory.getCurrentSession().createQuery("from Supplier_Order s where s.Supplier_Order_id=:id");
		query.setParameter("id", orderId);
		
		return (Supplier_Order)query.list().get(0); 
	}


	@Override
	public Supplier getSupplier(int supplierId) {
		
		Query query = sessionFactory.getCurrentSession().createQuery("from Supplier s where s.supplier_ID=:id");
		query.setParameter("id", supplierId);
		
		return (Supplier)query.list().get(0); 
		
	}


	@Override
	public void UpdateSupplierOrder(Supplier_Order supplerOrder) {
		
		sessionFactory.getCurrentSession().saveOrUpdate(supplerOrder);
	}
	
	

	
}
