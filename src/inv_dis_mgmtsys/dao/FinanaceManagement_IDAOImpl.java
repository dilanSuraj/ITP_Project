package inv_dis_mgmtsys.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import inv_dis_mgmtsys.model.Finance;
import inv_dis_mgmtsys.model.Item;
import inv_dis_mgmtsys.model.Payment;
import inv_dis_mgmtsys.model.Retailer_Finance;
import inv_dis_mgmtsys.model.Supplier_Finance;
import inv_dis_mgmtsys.model.TransportFinance;

@Repository
public class FinanaceManagement_IDAOImpl implements FinanaceManagement_IDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addFinance(Finance finance) {
		sessionFactory.getCurrentSession().saveOrUpdate(finance);

	}

	@Override
	public void deleteFinance(Finance finance) {

		sessionFactory.getCurrentSession().delete(finance);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Payment> getfinancebyCategory(String paymentCategory) {

		List<Payment> list = null;
		String hql = "from Payment payment where payment.other_income_expense_type LIKE :Other_income_expense_category";

		Query query = sessionFactory.getCurrentSession().createQuery(hql).setParameter("Other_income_expense_category",
				"%" + paymentCategory + "%");

		list = query.list();

		Iterator iterator = list.iterator();
		Payment payment;
		while (iterator.hasNext()) {

			payment = (Payment) iterator.next();

		}
		return list;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Finance> getAllFinanceDetails(String type) {

		String hql = null;
		if (type.equals("payment")) {
			hql = "from Payment";

		} else if (type.equals("transportFinance")) {
			hql = "from TransportFinance";
		}

		else if (type.equals("supplierFinance")) {
			hql = "from Supplier_Finance";
		}

		else if (type.equals("retailerFinance")) {
			hql = "from Retailer_Finance";
		}

		else if (type.equals("item")) {
			hql = "from Item";
		}

		else {
			return null;
		}
		return sessionFactory.getCurrentSession().createQuery(hql).list();
	}

	@Override
	public void editFinance(Finance finance, String type) {

		if (type.equals("payment")) {

			Payment payment = (Payment) finance;
			String hql = "update Payment payment set payment.other_income_expense_amount= ?, payment.other_income_expense_recieved= ?,payment.other_income_expense_paymentstate= ?,payment.other_income_expense_category= ?,payment.other_income_expense_type= ?, payment.other_income_expense_date= ?, payment.other_income_expense_description= ? where payment.other_income_expense_ID= ?";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			query.setParameter(0, payment.getOther_income_expense_amount());
			query.setParameter(1, payment.getOther_income_expense_recieved());
			query.setParameter(2, payment.getOther_income_expense_paymentstate());
			query.setParameter(3, payment.getOther_income_expense_category());
			query.setParameter(4, payment.getOther_income_expense_type());
			query.setParameter(5, payment.getOther_income_expense_date());
			query.setParameter(6, payment.getOther_income_expense_description());
			query.setParameter(7, payment.getOther_income_expense_ID());

			System.out.println("Insided, new payments" + payment.getOther_income_expense_ID());
			int result = query.executeUpdate();
			System.out.println("Results : " + result);
			return;
		}

	}

	@Override
	public Finance getSingleFinanceDetail(int ID, String type) {
		
		if (type.equals("payment")) {
			return (Payment)sessionFactory.getCurrentSession().get(Payment.class,ID);

		} else if (type.equals("transportFinance")) {
			return (TransportFinance)sessionFactory.getCurrentSession().get(TransportFinance.class,ID);
		}

		else if (type.equals("supplierFinance")) {
			return (Supplier_Finance)sessionFactory.getCurrentSession().get(Supplier_Finance.class,ID);
		}

		else if (type.equals("retailerFinance")) {
			return (Retailer_Finance)sessionFactory.getCurrentSession().get(Retailer_Finance.class,ID);
		}

		else if (type.equals("item")) {
			return (Item)sessionFactory.getCurrentSession().get(Item.class,ID);
		}

		else {
			return null;
		}
	}

}
