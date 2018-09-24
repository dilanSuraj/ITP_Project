package inv_dis_mgmtsys.dao;

import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import inv_dis_mgmtsys.model.Notification;
import inv_dis_mgmtsys.model.Retailer;
import inv_dis_mgmtsys.model.Retailer_Report;

@Repository
public class RetailerManagement_IDAOImpl implements RetailerManagement_IDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addRetailerDetails(Retailer retailer) {

		System.out.println("Inside DAO :" + retailer.getRetailer_address());
		sessionFactory.getCurrentSession().saveOrUpdate(retailer);
	}

	@Override
	public void deleteRetailers(Notification retailer_notification) {
		sessionFactory.getCurrentSession().saveOrUpdate(retailer_notification);
	}

	@Override
	public void deleteRetailerDetails(Retailer retailer) {

		sessionFactory.getCurrentSession().delete(retailer);

	}

	@Override
	public void updateRetailerDetails(Retailer retailer) {

		sessionFactory.getCurrentSession().update(retailer);
		return;
	}

	@Override
	public Retailer getRetailerDetails(int RetailerID) {

		return (Retailer) sessionFactory.getCurrentSession().get(Retailer.class, RetailerID);
	}

	@Override
	public Retailer Login(Retailer Retailer) {

		String hql = "Select retailer. retailer_ID FROM Retailer retailer where retailer.retailer_username=? AND retailer.retailer_password=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter(0, Retailer.getRetailer_username());
		query.setParameter(1, Retailer.getRetailer_password());

		List result = query.list();
		Iterator iterator = result.iterator();

		int RetailerID = 0;
		while (iterator.hasNext()) {
			RetailerID = (int) iterator.next();

			if (!result.isEmpty()) {
				Retailer sessionRetailer = (Retailer) sessionFactory.getCurrentSession().get(Retailer.class,
						RetailerID);
				return sessionRetailer;
			}

		}

		return null;
	}

	@Override
	public void deleteRetailer(int RetailerID) {

		Retailer Retailer = (Retailer) sessionFactory.getCurrentSession().get(Retailer.class, RetailerID);

		sessionFactory.getCurrentSession().delete(Retailer);
	}

	@Override
	public void deleteRetailer_Notification(int retailer_notification_ID) {

		Notification retailer_notification = (Notification) sessionFactory.getCurrentSession().get(Notification.class,
				retailer_notification_ID);

		sessionFactory.getCurrentSession().delete(retailer_notification);
	}

	@Override
	public void updateRetailerDetails1(Retailer Retailer) {
		System.out.println("Retailer ID" + Retailer.getRetailer_name());

		Query query2 = sessionFactory.getCurrentSession().createQuery("from Retailer r where r.Retailer_ID=:id");
		query2.setParameter("id", Retailer.getRetailer_ID());
		System.out.println("Retailer ID : " + Retailer.getRetailer_ID());
		Retailer Retailer1 = (Retailer) query2.list().get(0);

		Retailer1.setRetailer_name(Retailer1.getRetailer_name());
		Retailer1.setRetailer_contactno(Retailer1.getRetailer_contactno());
		Retailer1.setRetailer_regno(Retailer1.getRetailer_regno());
		Retailer1.setRetailer_address(Retailer1.getRetailer_address());
		Retailer1.setRetailer_username(Retailer1.getRetailer_username());
		Retailer1.setRetailer_password(Retailer1.getRetailer_password());
		Retailer1.setRetailer_province(Retailer1.getRetailer_province());

		sessionFactory.getCurrentSession().saveOrUpdate(Retailer1);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void editRetailer(Retailer retailer) {
		String hql = "update Retailer r set r.retailer_name=?, r.retailer_contactno=?, r.retailer_regno=? ,r.retailer_address=? , r.retailer_username=? , r.retailer_password=?, r.retailer_province=? where r.retailer_ID=? ";
		
		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		query.setParameter(0, retailer.getRetailer_name());
		query.setParameter(1, retailer.getRetailer_contactno());
		query.setParameter(2, retailer.getRetailer_regno());
		query.setParameter(3, retailer.getRetailer_address());
		query.setParameter(4, retailer.getRetailer_username());
		query.setParameter(5, retailer.getRetailer_password());
		query.setParameter(6, retailer.getRetailer_province());
		query.setParameter(7, retailer.getRetailer_ID());

		int result = query.executeUpdate();

		}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Notification> getRetailerList1() {
		
		
		return sessionFactory.getCurrentSession().createQuery("From Notification").list();
		
		
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public List<Retailer> getRetailerList() {
		
		return sessionFactory.getCurrentSession().createQuery("From Retailer").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Retailer_Report> getRetailerReport(){
		return (List<Retailer_Report>)sessionFactory.getCurrentSession().createQuery("from Retailer_Report").list();
	}
	
}