package inv_dis_mgmtsys.dao;

import java.sql.ResultSet;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import inv_dis_mgmtsys.model.DataPoint;
import inv_dis_mgmtsys.model.Finance;
import inv_dis_mgmtsys.model.Item;
import inv_dis_mgmtsys.model.Payment;
import inv_dis_mgmtsys.model.Retailer_Finance;
import inv_dis_mgmtsys.model.Supplier_Finance;
import inv_dis_mgmtsys.model.TransportFinance;
import inv_dis_mgmtsys.services.FinanaceManagement_IServicesImpl;

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

			int result = query.executeUpdate();
			System.out.println("Results : " + result);
			return;
		}

		else if (type.equals("transportFinance")) {

			TransportFinance transportFinance = (TransportFinance) finance;
			String hql = "update TransportFinance tf set tf.transportpayment_amount = ?,tf.transportpayment_category=?,tf.transportpayment_date=?, tf.transportpayment_description=?,tf.transportpayment_state=?,tf.transportpayment_vehicleID=? where tf.transportpayment_ID=?";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			query.setParameter(0, transportFinance.getTransportpayment_amount());
			query.setParameter(1, transportFinance.getTransportpayment_category());
			query.setParameter(2, transportFinance.getTransportpayment_date());
			query.setParameter(3, transportFinance.getTransportpayment_description());
			query.setParameter(4, transportFinance.getTransportpayment_state());
			query.setParameter(5, transportFinance.getTransportpayment_vehicleID());
			query.setParameter(6, transportFinance.getTransportpayment_ID());

			int result = query.executeUpdate();
			System.out.println("Results : " + result);
			return;

		}

		else if (type.equals("retailerFinance")) {

			Retailer_Finance retailer_Finance = (Retailer_Finance) finance;

			String hql = "update Retailer_Finance rf set rf.deadline_payment_date = ?,rf.payment_date=?,rf.amount=?, rf.paymentState=?,rf.retailer_orderID=? where rf.retailer_finance_id=?";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			query.setParameter(0, retailer_Finance.getDeadline_payment_date());
			query.setParameter(1, retailer_Finance.getPayment_date());
			query.setParameter(2, retailer_Finance.getAmount());
			query.setParameter(3, retailer_Finance.getPaymentState());
			query.setParameter(4, retailer_Finance.getRetailer_orderID());
			query.setParameter(5, retailer_Finance.getRetailer_finance_id());

			int result = query.executeUpdate();
			System.out.println("Results : " + result);
			return;
		}

		else if (type.equals("supplierFinance")) {

			Supplier_Finance supplier_Finance = (Supplier_Finance) finance;

			String hql = "update Supplier_Finance sf set sf.payment_date=?,sf.amount=?, sf.paymentState=?,sf.supplier_orderID=? where sf.supplier_finance_id=?";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);

			query.setParameter(0, supplier_Finance.getPayment_date());
			query.setParameter(1, supplier_Finance.getAmount());
			query.setParameter(2, supplier_Finance.getPaymentState());
			query.setParameter(3, supplier_Finance.getSupplier_orderID());
			query.setParameter(4, supplier_Finance.getSupplier_finance_id());

			int result = query.executeUpdate();
			System.out.println("Supplier ID : " + supplier_Finance.getSupplier_finance_id());
			System.out.println("Results : " + result);
			return;
		}

	}

	@Override
	public Finance getSingleFinanceDetail(int ID, String type) {

		if (type.equals("payment")) {
			return (Payment) sessionFactory.getCurrentSession().get(Payment.class, ID);

		} else if (type.equals("transportFinance")) {
			return (TransportFinance) sessionFactory.getCurrentSession().get(TransportFinance.class, ID);
		}

		else if (type.equals("supplierFinance")) {
			return (Supplier_Finance) sessionFactory.getCurrentSession().get(Supplier_Finance.class, ID);
		}

		else if (type.equals("retailerFinance")) {
			return (Retailer_Finance) sessionFactory.getCurrentSession().get(Retailer_Finance.class, ID);
		}

		else {
			return null;
		}
	}

	@Override
	public Item getSingleItemDetail(int ID) {
		return (Item) sessionFactory.getCurrentSession().get(Item.class, ID);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Item> getAllItemDetails() {

		String hql = "FROM Item item JOIN item.supplier";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Item> itemList = query.list();
		System.out.println("In DAo");
		return itemList;
	}

	@Override
	public void editItemPrice(Item item) {

		String hql = "update Item item set item.item_saleprice=?,item.item_grossprice=?,item.item_percentageProfit=?  where item.item_itemcode=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		query.setParameter(0, item.getItem_saleprice());
		query.setParameter(1, item.getItem_grossprice());
		query.setParameter(2, item.getItem_percentageProfit());
		query.setParameter(3, item.getItem_itemcode());

		int result = query.executeUpdate();
		System.out.println("Supplier ID : " + item.getItem_itemcode());
		System.out.println("Results : " + result);

	}

	@SuppressWarnings("null")
	@Override
	public List<DataPoint> getDataPoints(int initial_year) {
		List<DataPoint> dataPoints = null;

		double income = 0;
		double income_Payment = 0;
		double expense_Payment = 0;
		int year = initial_year;

		Calendar cal = Calendar.getInstance();

		DataPoint[] paymentPoint = new DataPoint[5];

		paymentPoint[0] = new DataPoint();
		paymentPoint[0].setYear(initial_year);

		paymentPoint[1] = new DataPoint();
		paymentPoint[1].setYear(initial_year - 1);

		paymentPoint[2] = new DataPoint();
		paymentPoint[2].setYear(initial_year - 2);

		paymentPoint[3] = new DataPoint();
		paymentPoint[3].setYear(initial_year - 3);

		paymentPoint[4] = new DataPoint();
		paymentPoint[4].setYear(initial_year - 4);

		List<Payment> paymentList = this.getfinancebyCategory("payment");
				
		List<Finance> list = this.getAllFinanceDetails("transportFinance");
		
		@SuppressWarnings("unchecked")
		List<TransportFinance> transportList= (List<TransportFinance>)(List<?>) list;
		
		@SuppressWarnings("unchecked")
		List<Supplier_Finance> supplierList= (List<Supplier_Finance>)(List<?>) list;
		
		@SuppressWarnings("unchecked")
		List<Re_Finance> supplierList= (List<Supplier_Finance>)(List<?>) list;

		for (Payment payment : paymentList) {

			cal.setTime(payment.getOther_income_expense_date());

			double paymentAmt = payment.getOther_income_expense_amount();

			year = cal.get(Calendar.YEAR);

			if (payment.getOther_income_expense_type().equals("income")) {

				if (year == initial_year) {
					income_Payment += paymentAmt;

					paymentPoint[0].setIncome(income_Payment);
				}

				if (year == initial_year - 1) {
					income_Payment += paymentAmt;

					paymentPoint[1].setIncome(income_Payment);
				}

				if (year == initial_year - 2) {
					income_Payment += paymentAmt;

					paymentPoint[3].setIncome(income_Payment);
				}
				if (year == initial_year - 3) {
					income_Payment += paymentAmt;

					paymentPoint[3].setIncome(income_Payment);
				}
				if (year == initial_year - 4) {
					income_Payment += paymentAmt;

					paymentPoint[4].setIncome(income_Payment);
				}

			} else if (payment.getOther_income_expense_type().equals("expense")) {

				if (year == initial_year) {
					expense_Payment += paymentAmt;

					paymentPoint[0].setExpense(expense_Payment);
				}

				if (year == initial_year - 1) {
					expense_Payment += paymentAmt;

					paymentPoint[1].setExpense(expense_Payment);
				}

				if (year == initial_year - 2) {
					expense_Payment += paymentAmt;

					paymentPoint[3].setExpense(expense_Payment);
				}
				if (year == initial_year - 3) {
					expense_Payment += paymentAmt;

					paymentPoint[3].setExpense(expense_Payment);
				}
				if (year == initial_year - 4) {
					expense_Payment += paymentAmt;

					paymentPoint[4].setExpense(expense_Payment);
				}

			}
		}

		
		for (TransportFinance finance : transportList) {

			
			cal.setTime(finance.getTransportpayment_date());

			double paymentAmt = finance.getTransportpayment_amount();
		    year = cal.get(Calendar.YEAR);
		    
		    if (year == initial_year) {
				expense_Payment += paymentAmt;

				paymentPoint[0].setExpense(expense_Payment);
			}

			if (year == initial_year - 1) {
				expense_Payment += paymentAmt;

				paymentPoint[1].setExpense(expense_Payment);
			}

			if (year == initial_year - 2) {
				expense_Payment += paymentAmt;

				paymentPoint[3].setExpense(expense_Payment);
			}
			if (year == initial_year - 3) {
				expense_Payment += paymentAmt;

				paymentPoint[3].setExpense(expense_Payment);
			}
			if (year == initial_year - 4) {
				expense_Payment += paymentAmt;

				paymentPoint[4].setExpense(expense_Payment);
			}

		}

		dataPoints.add(paymentPoint[0]);
		dataPoints.add(paymentPoint[1]);
		dataPoints.add(paymentPoint[2]);
		dataPoints.add(paymentPoint[3]);
		dataPoints.add(paymentPoint[4]);
		return dataPoints;
	}

}
