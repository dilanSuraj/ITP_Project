 package inv_dis_mgmtsys.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import inv_dis_mgmtsys.model.DeliveryDetails_View;
import inv_dis_mgmtsys.model.ExtraStock_Distribution;
import inv_dis_mgmtsys.model.IncomeView;
import inv_dis_mgmtsys.model.Item;
import inv_dis_mgmtsys.model.Payment;
import inv_dis_mgmtsys.model.PermanentEmployee;
import inv_dis_mgmtsys.model.Retailer;
import inv_dis_mgmtsys.model.Retailer_Order;
import inv_dis_mgmtsys.model.Vehicle;

@Repository
public class DistributionManagement_IDAOImpl implements DistributionManagement_IDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addExtraStockDetails(ExtraStock_Distribution extraStock) {
		
		sessionFactory.getCurrentSession().saveOrUpdate(extraStock);
	}

	@Override
	public List<ExtraStock_Distribution> getAllExtraStock() {
		
		@SuppressWarnings("unchecked")
		List<ExtraStock_Distribution> list = (List<ExtraStock_Distribution>)sessionFactory.getCurrentSession().createQuery("from ExtraStock_Distribution").list();
		
		
		return list;
	}

	@Override
	public void deleteExtraStockDetails(int extrastockID) {
		 
		ExtraStock_Distribution extraStock_Distribution = this.getExtraStockDetails(extrastockID);
		sessionFactory.getCurrentSession().delete(extraStock_Distribution);
		
	}

	@Override
	public void updateExtraStockDetails(ExtraStock_Distribution extraStock) {
		
		
		String hql = "update ExtraStock_Distribution extraStock set extraStock.extra_stock_quantity= ?, extraStock.extra_stock_itemcode= ?,extraStock.extra_stock_vehicle_ID= ? where extraStock.extra_stock_ID= ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter(0, extraStock.getExtra_stock_quantity());
		query.setParameter(1, extraStock.getExtra_stock_itemcode());
		query.setParameter(2, extraStock.getExtra_stock_vehicle_ID());
		query.setParameter(3,extraStock.getExtra_stock_ID());
			
		int result = query.executeUpdate();
		System.out.println("Results : " + result);
		return;
		 
	}

	@Override
	public ExtraStock_Distribution getExtraStockDetails(int extrastockID) {
		
		return (ExtraStock_Distribution)sessionFactory.getCurrentSession().get(ExtraStock_Distribution.class,extrastockID);
		// TODO Auto-generated method stub
	
	}
	
	@Override
	public List<Item> getAllItems() {
		
		@SuppressWarnings("unchecked")
		List<Item> list = (List<Item>)sessionFactory.getCurrentSession().createQuery("from Item").list();
		
		
		return list;
	}

	@Override
	public List<Vehicle> getAllVehicle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item getSingleItemDetails(int itemCode) {
		return (Item)sessionFactory.getCurrentSession().get(Item.class,itemCode);
	}
	
	@Override
	public List<Retailer_Order> getAllRetailerOrders() {
		
		String hql = "from Retailer_Order where retailer_orderstatus = ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter(0,"Complete");		
		@SuppressWarnings("unchecked")
		List<Retailer_Order> list= query.list();		
		
		
		return list;
	}
	
	@Override
	public List<PermanentEmployee> getAllDistributionManagers() {
		
		@SuppressWarnings("unchecked")
		List<PermanentEmployee> list = (List<PermanentEmployee>)sessionFactory.getCurrentSession().createQuery("from PermanentEmployee").list();
		
		
		return list;
	}
	
	@Override
	public List<Retailer> getAllRetailers() {
		
		@SuppressWarnings("unchecked")
		List<Retailer> list = (List<Retailer>)sessionFactory.getCurrentSession().createQuery("from Retailer").list();
		
		
		return list;
	}
	
	@Override
	public void updateDeliveryDetails(Retailer_Order deliveryOrders) {
	
		
		String hql = "update Retailer_Order deliveryOrders set deliveryOrders.SR_ID= ? where deliveryOrders.retailer_OrderID= ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter(0,deliveryOrders.getSR_ID());
		query.setParameter(1,deliveryOrders.getRetailer_OrderID());
		
		int result = query.executeUpdate();
		System.out.println("Results : " + result);
		return;
		 
	}

	public Retailer_Order getSingleRetailerOrderDetails(int id) {
		return (Retailer_Order)sessionFactory.getCurrentSession().get(Retailer_Order.class,id);
	}
	
	
	public List<PermanentEmployee> getAllSalesRepresentativeList() {
		
		
		String hql = "from PermanentEmployee pe where pe.role=? ";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter(0, "SR");			
		@SuppressWarnings("unchecked")
		List<PermanentEmployee> list = query.list();
		
		return list;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<DeliveryDetails_View> getAllIncomeViewDetails() {

		return sessionFactory.getCurrentSession().createQuery("From DeliveryDetails_View").list();
	}

}
