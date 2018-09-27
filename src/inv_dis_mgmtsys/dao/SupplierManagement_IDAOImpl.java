package inv_dis_mgmtsys.dao;



import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import inv_dis_mgmtsys.model.Deleted_stakeholders;
import inv_dis_mgmtsys.model.Item;
import inv_dis_mgmtsys.model.Supplier;
import inv_dis_mgmtsys.model.Supplier_Finance;
import inv_dis_mgmtsys.model.Supplier_Order;
import inv_dis_mgmtsys.model.Supplier_Report;


@Repository("supplierManagement_IDAO")
public class SupplierManagement_IDAOImpl implements SupplierManagement_IDAO {
	
	
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addSupplierDetails(Supplier supplier) {
		
		sessionFactory.getCurrentSession().saveOrUpdate(supplier);
		
	}

	@Override
	public List<Supplier> getSupplierDetails(String suppliertitle) {
		
		@SuppressWarnings("unchecked")
		List<Supplier> list = (List<Supplier>)sessionFactory.getCurrentSession().createQuery("from Supplier").list();
		
		return list;
	}

	@Override
	public void deleteSupplier(int supplierID) {
		
		Supplier supplier = (Supplier) sessionFactory.getCurrentSession().get(Supplier.class, supplierID);
		
		Deleted_stakeholders supplier1 =new Deleted_stakeholders();
		
		supplier1.setDeleted_stakeholder_name(supplier.getSupplier_name()); 
		supplier1.setDeleted_stakeholder_contact(supplier.getSupplier_contactno());
		supplier1.setDeleted_stakeholder_role("Supplier");
		
		sessionFactory.getCurrentSession().saveOrUpdate(supplier1);
		sessionFactory.getCurrentSession().delete(supplier);
	}

	@Override
	public Supplier getSupplierDetails(int supplier_ID) {
		
		return (Supplier)sessionFactory.getCurrentSession().get(Supplier.class, supplier_ID);
	}

	@Override
	public void updateSupplierDetails(Supplier supplier) {
		
		
	
		System.out.println("Supplier ID"+ supplier.getSupplier_name());
		
		
		Query query2 = sessionFactory.getCurrentSession().createQuery("from Supplier s where s.supplier_ID=:id");
		query2.setParameter("id", supplier.getSupplier_ID());
		System.out.println("Suppplier ID : "+ supplier.getSupplier_ID());
		Supplier sup = (Supplier)query2.list().get(0);
		 
		
		sup.setSupplier_name(supplier.getSupplier_name());
		sup.setSupplier_companyname(supplier.getSupplier_companyname());
		sup.setSupplier_address(supplier.getSupplier_address());
		sup.setSupplier_contactno(supplier.getSupplier_contactno());
		sup.setSupplier_regNo(supplier.getSupplier_regNo());
		sup.setSupplier_password(supplier.getSupplier_password2());
		
		
		sessionFactory.getCurrentSession().saveOrUpdate(sup);
		
		
		
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Supplier Login(Supplier supplier) {
	
		String hql = "Select supplier. supplier_ID FROM Supplier supplier where supplier.supplier_username=? AND supplier.supplier_password=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter(0, supplier.getSupplier_username());
		query.setParameter(1, supplier.getSupplier_password());
		
		List result = query.list();

        Iterator iterator = result.iterator();
        
        int supplierID = 0;
        while(iterator.hasNext()){
           supplierID  = (int) iterator.next();
           
           if(!result.isEmpty()) {
        	   Supplier sessionSupplier = (Supplier)sessionFactory.getCurrentSession().get(Supplier.class, supplierID);
        	   
        	   System.out.println(sessionSupplier.getSupplier_name());
        	   return sessionSupplier;
           }
        	   
        }

		
		return null;
	}

	@Override
	public Supplier_Order getOderDetails(int supplier_ID) {

		String hql = " FROM Supplier_Order supplier_order where supplier_order.Supplier_ID=:supplier_ID ";
		
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		query.setParameter("supplier_ID", supplier_ID);
		
		System.out.println(supplier_ID);
		
		
		
		
		Supplier_Order supplier_Order = (Supplier_Order)query.list().get(0);

		return supplier_Order;
		
		
	}
	

	@Override
	public Supplier_Finance getFinanceDetails1(int order_ID) {
		
		Supplier_Finance supplier_Finance   ;
		String hql = " FROM Supplier_Finance supplier_Finance where supplier_Finance.supplier_orderID=:supplier_orderID";
		
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		query.setParameter("supplier_orderID", order_ID);
		
		supplier_Finance = (Supplier_Finance) query.list().get(0);
	
		return supplier_Finance;	
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Supplier_Finance> getFinanceDetails2(int order_ID) {
		
		String hql = " FROM Supplier_Finance supplier_Finance where supplier_Finance.supplier_orderID=:supplier_orderID and supplier_Finance.paymentState='not paid' ";
		
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		query.setParameter("supplier_orderID", order_ID);
		
		List<Supplier_Finance> supplier_Finance = (List<Supplier_Finance>)query.list();
		
		return supplier_Finance;
		
	}
	public Session getCurrentSession() {
		
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Supplier_Finance> getAllFinanceDetails(int supplier_orderID) {
		
		
		String hql = "from Supplier_Finance supplier_Finance where supplier_Finance.supplier_orderID=:supplier_orderID";
		
		
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		query.setParameter("supplier_orderID", supplier_orderID);
		
		List<Supplier_Finance> supplier_Finance = (List<Supplier_Finance>)query.list();
		
		return supplier_Finance;
		
		
		
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Supplier_Order> getSupplierOrder(int supplier_ID) {
        String hql = " FROM Supplier_Order supplier_order where supplier_order.Supplier_ID=:supplier_ID ";
		
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		query.setParameter("supplier_ID", supplier_ID);
		
		System.out.println(supplier_ID);
		
		List<Supplier_Order> supplier_Order = (List<Supplier_Order>)query.list();

		return supplier_Order;
	}
	
	@Override
	public Item getSupplierOrderItem(int itemcode) {
		
		
		
			
		
		Query query2 = sessionFactory.getCurrentSession().createQuery("from Item s where s.item_itemcode=:id");
		query2.setParameter("id", itemcode);
		Item itemList = (Item)query2.list().get(0);
		
		System.out.println("Item name"+itemList.getItem_name());
		
		return itemList;
		
		

		
		
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Item> getSupplierOrderItemList(int supplier_ID) {
		try {
			
			
			Query query2 = sessionFactory.getCurrentSession().createQuery("from Item s where s.item_supplier_ID=:id");
			query2.setParameter("id", supplier_ID);
			List<Item> itemList = (List<Item>)query2.list();
			
			
			
			return itemList;
			}
			catch (Exception e) {
				return null;
			}
	}
	
	
	@Override
	
	public List<Supplier_Report> getSupplierReport() {
			
			@SuppressWarnings("unchecked")
			List<Supplier_Report> itemList = (List<Supplier_Report>)sessionFactory.getCurrentSession().createQuery("from Supplier_Report").list();
			

			return itemList;
	}
			

	


}
