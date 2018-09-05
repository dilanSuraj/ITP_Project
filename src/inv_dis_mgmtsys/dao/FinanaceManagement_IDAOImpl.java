package inv_dis_mgmtsys.dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import inv_dis_mgmtsys.model.DataPoint;
import inv_dis_mgmtsys.model.Emp_Month_Salary;
import inv_dis_mgmtsys.model.Finance;
import inv_dis_mgmtsys.model.Item;
import inv_dis_mgmtsys.model.Payment;

import inv_dis_mgmtsys.model.Retailer;
import inv_dis_mgmtsys.model.Retailer_Blacklist;
import inv_dis_mgmtsys.model.Retailer_Finance;
import inv_dis_mgmtsys.model.Retailer_Order;
import inv_dis_mgmtsys.model.Supplier_Finance;
import inv_dis_mgmtsys.model.TransportFinance;
import inv_dis_mgmtsys.model.Vehicle;
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
		String hql = "from Payment payment where payment.other_income_expense_type LIKE :Other_income_expense_type";

		Query query = sessionFactory.getCurrentSession().createQuery(hql).setParameter("Other_income_expense_type",
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Vehicle> getAllVehicleDetails() {

		return sessionFactory.getCurrentSession().createQuery("From Vehicle").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Retailer_Order> getAllRetailerOrderDetails() {

		return sessionFactory.getCurrentSession().createQuery("From Retailer_Order").list();
	}

	@Override
	public Retailer_Order getSingleRetailerOrderDetails(int retailerOrderID) {

		return (Retailer_Order) sessionFactory.getCurrentSession().get(Retailer_Order.class, retailerOrderID);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Emp_Month_Salary> getAllEmpMonthSalary() {

		return sessionFactory.getCurrentSession().createQuery("From Emp_Month_Salary").list();
	}

	@Override
	public Emp_Month_Salary getSingleSalaryDetails(int emp_month_ID) {
		return (Emp_Month_Salary) sessionFactory.getCurrentSession().get(Emp_Month_Salary.class, emp_month_ID);
	}

	@Override
	public void editMonthSalaryDetails(Emp_Month_Salary emp_Month_Salary) {

		String hql = "update Emp_Month_Salary empMonthSal set empMonthSal.emp_month_sal_status=?  where empMonthSal.emp_month_sal_ID=?";

		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		query.setParameter(0, emp_Month_Salary.getEmp_month_sal_status());
		query.setParameter(1, emp_Month_Salary.getEmp_month_sal_ID());

		int result = query.executeUpdate();

	}

	@Override
	public List<Retailer_Blacklist> getBlacklistedRetailerFinanceList() {

		List<Finance> retailerfinanceList = this.getAllFinanceDetails("retailerFinance");

		List<Retailer_Blacklist> blacklist = new ArrayList<>();
		List<Retailer> retailerList = this.getAllRetailers();
		for(Retailer retailer: retailerList) {
			this.editBlacklistedRetailerStatus("No", retailer.getRetailer_ID());
		}
		for (Finance finance : retailerfinanceList) {

			Retailer_Finance retailer_Finance = (Retailer_Finance) finance;
			Date deadLineDate = retailer_Finance.getDeadline_payment_date();

			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate localDate = LocalDate.now();
			

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date currentDate;
			try {
				currentDate = sdf.parse(dtf.format(localDate));
				Retailer_Order retailerOrder = this.getSingleRetailerOrderDetails(retailer_Finance.getRetailer_orderID());
				double amountToPay = retailerOrder.getOder_total() - retailer_Finance.getAmount();
				System.out.println("************");
				System.out.println("Amount to pay : "+amountToPay);
				System.out.println("deadline : "+ deadLineDate);
				System.out.println(currentDate.compareTo(deadLineDate) < 0);
				if ((currentDate.compareTo(deadLineDate) > 0) &&(amountToPay > 0)) {
					System.out.println("Inside");
					
					Retailer retailer = this.getRetailer(retailerOrder.getRetailer_ID());
					
					Retailer_Blacklist blacklistedRetailer = new Retailer_Blacklist();
					blacklistedRetailer.setRetailer(retailer);
					blacklistedRetailer.setRetailer_blacklist_amount(retailer_Finance.getAmount());
					blacklistedRetailer.setRetailer_blacklist_deadlineDate(deadLineDate);
					this.editBlacklistedRetailerStatus("Yes",retailerOrder.getRetailer_ID());
                    blacklist.add(blacklistedRetailer);			
				}
				
			} catch (ParseException e) {
				
				e.printStackTrace();
			}

		}

		return blacklist;
	}

	@Override
	public void editBlacklistedRetailerStatus(String status,int retailerID) {
	
		String hql = "update Retailer retailer set retailer.retailer_blacklistStatus=?  where retailer.retailer_ID=?";
		
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter(0, status);
		query.setParameter(1, retailerID);
		query.executeUpdate();

	}

	@Override
	public Retailer getRetailer(int retailerID) {
	
		return (Retailer) sessionFactory.getCurrentSession().get(Retailer.class, retailerID);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Retailer> getAllRetailers() {
		return sessionFactory.getCurrentSession().createQuery("From Retailer").list();
	}


	public Session getCurrentSession() {
		
		return sessionFactory.getCurrentSession();
	}


}
