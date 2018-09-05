package inv_dis_mgmtsys.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.method.annotation.SessionAttributesHandler;

import inv_dis_mgmtsys.dao.FinanaceManagement_IDAOImpl;
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

@Service
public class FinanaceManagement_IServicesImpl implements FinanaceManagement_IServices {

	@Autowired
	FinanaceManagement_IDAOImpl finanaceManagerIDAO;
	
	@Autowired
	HttpSession httpsession;

	@Override
	public void addPaymentDetails(Finance finance) {

		finanaceManagerIDAO.addFinance(finance);
	}

	@Override
	public List<Payment> getPayments(String paymentCategory) {
		if (paymentCategory != null) {
			List<Payment> payments = finanaceManagerIDAO.getfinancebyCategory(paymentCategory);
			return payments;
		}
		else {
			return null;
		}
	}

	@Override
	public List<Finance> getAllPaymentDetails(String type) {

		return finanaceManagerIDAO.getAllFinanceDetails(type);

	}

	@Override
	public void deletePaymentDetails(String type, int paymentID) {

		Finance finance = finanaceManagerIDAO.getSingleFinanceDetail(paymentID, type);

		finanaceManagerIDAO.deleteFinance(finance);
		return;
	}

	@Override
	public void updatePaymentDetails(Finance finance, String type) {
		finanaceManagerIDAO.editFinance(finance, type);

		return;
	}

	@Override
	public Finance getPaymentDetails(int paymentId, String type) {

		return finanaceManagerIDAO.getSingleFinanceDetail(paymentId, type);

	}

	@Override
	public Item getSingleItemDetail(int ID) {
		return finanaceManagerIDAO.getSingleItemDetail(ID);
	}

	@Override
	public List<Item> getAllItemDetails() {
		System.out.println("In Services");
		return finanaceManagerIDAO.getAllItemDetails();
	}

	@Override
	public void editItemPrice(Item item) {

		double itemSalePrice = item.getItem_saleprice();
		double itemGrossPrice = item.getItem_grossprice();
		double profit = itemSalePrice - itemGrossPrice;
		double calPriceProfitPercentage = (profit) / itemGrossPrice;
		DecimalFormat twoDForm = new DecimalFormat("#.##");

		item.setItem_percentageProfit(Double.valueOf(twoDForm.format(calPriceProfitPercentage)) * 100);
		finanaceManagerIDAO.editItemPrice(item);
	}

	
	
	@Override
	public List<DataPoint> getDataPoints(int initial_year) {
		List<DataPoint> dataPoints = new ArrayList<>();

		double income_Payment = 0;
		double expense_Payment = 0;
		int year = initial_year;
		System.out.println("Payment amount Line 112 :");
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

		List<Finance> payment_List = finanaceManagerIDAO.getAllFinanceDetails("payment");
		@SuppressWarnings("unchecked")
		List<Payment> paymentList = (List<Payment>) (List<?>) payment_List;


		List<Finance> list_transport = finanaceManagerIDAO.getAllFinanceDetails("transportFinance");
		@SuppressWarnings("unchecked")
		List<TransportFinance> transportList = (List<TransportFinance>) (List<?>) list_transport;

		List<Finance> list_supplier = finanaceManagerIDAO.getAllFinanceDetails("supplierFinance");
		@SuppressWarnings("unchecked")
		List<Supplier_Finance> supplierList = (List<Supplier_Finance>) (List<?>) list_supplier;

		List<Finance> list_retailer = finanaceManagerIDAO.getAllFinanceDetails("retailerFinance");
		@SuppressWarnings("unchecked")
		List<Retailer_Finance> retailerList = (List<Retailer_Finance>) (List<?>) list_retailer;

		System.out.println("Payment amount Line 146 :");
		
		for (Payment payment : paymentList) {

			cal.setTime(payment.getOther_income_expense_date());
			System.out.println("Payment amount Line 150 :");
			double paymentAmt = payment.getOther_income_expense_amount();
			System.out.println("Payment amount Line 151 :"+paymentAmt);

			year = cal.get(Calendar.YEAR);

			if (payment.getOther_income_expense_type().equals("income")) {

				System.out.println("Inside, income");
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

		for (Supplier_Finance supplier_Finance : supplierList) {

			cal.setTime(supplier_Finance.getPayment_date());

			double paymentAmt = supplier_Finance.getAmount();
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

		for (Retailer_Finance retailer_Finance : retailerList) {

			cal.setTime(retailer_Finance.getPayment_date());

			double paymentAmt = retailer_Finance.getAmount();
			year = cal.get(Calendar.YEAR);

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

		}

		dataPoints.add(paymentPoint[0]);
		dataPoints.add(paymentPoint[1]);
		dataPoints.add(paymentPoint[2]);
		dataPoints.add(paymentPoint[3]);
		dataPoints.add(paymentPoint[4]);
		return dataPoints;
	}

	@Override
	public List<Vehicle> getAllVehicleDetails() {
		
		return finanaceManagerIDAO.getAllVehicleDetails();
	}

	@Override
	public List<Retailer_Order> getAllRetailerOrders() {
		return finanaceManagerIDAO.getAllRetailerOrderDetails();
	}
	
	public Retailer_Order getSingleRetailerOrder(int retailerOrderID) {
		return finanaceManagerIDAO.getSingleRetailerOrderDetails(retailerOrderID);
	}

	@Override
	public List<Emp_Month_Salary> getAllEmpMonthSalary() {
		return finanaceManagerIDAO.getAllEmpMonthSalary();
	}

	@Override
	public Emp_Month_Salary getSingleSalaryDetails(int emp_month_ID) {
	
		return finanaceManagerIDAO.getSingleSalaryDetails(emp_month_ID);
	}

	@Override
	public void editMonthSalaryDetails(Emp_Month_Salary emp_Month_Salary) {
		
		finanaceManagerIDAO.editMonthSalaryDetails(emp_Month_Salary);
		
	}

	@Override
	public Retailer getRetailer(int retailerID) {
		
		return finanaceManagerIDAO.getRetailer(retailerID);
	}

	@Override
	public List<Retailer_Blacklist> getBlacklistedRetailerFinanceList() {
		List <Retailer_Blacklist> retailer_blacklist =  finanaceManagerIDAO.getBlacklistedRetailerFinanceList();
		
		
		return retailer_blacklist;
	}

	@Override
	public void editBlacklistedRetailerStatus(String status, int retailerID) {
		
		finanaceManagerIDAO.editBlacklistedRetailerStatus(status, retailerID);
	}

	@Override
	public double totalIncome() {
		
		List<Finance> payment_List = finanaceManagerIDAO.getAllFinanceDetails("payment");
		@SuppressWarnings("unchecked")
		List<Payment> paymentList = (List<Payment>) (List<?>) payment_List;
		
		double income = 0;
		for(Payment payment: paymentList) {
			
			if (payment.getOther_income_expense_type().equals("income")) {
				income += payment.getOther_income_expense_recieved();
			}
		}

		List<Finance> list_retailer = finanaceManagerIDAO.getAllFinanceDetails("retailerFinance");
		@SuppressWarnings("unchecked")
		List<Retailer_Finance> retailerList = (List<Retailer_Finance>) (List<?>) list_retailer;
		
		for(Retailer_Finance finance: retailerList) {
			income += finance.getAmount(); 
		}
		System.out.println("Total Income : "+ income);
		
		
		return income;
	}

	@Override
	public double totalExpense() {
		
		double expense = 0;
		
		List<Finance> payment_List = finanaceManagerIDAO.getAllFinanceDetails("payment");
		@SuppressWarnings("unchecked")
		List<Payment> paymentList = (List<Payment>) (List<?>) payment_List;

		
		for(Payment payment: paymentList) {
			
			if (payment.getOther_income_expense_type().equals("expense")) {
				expense += payment.getOther_income_expense_recieved();
			}
		}
		List<Finance> list_transport = finanaceManagerIDAO.getAllFinanceDetails("transportFinance");
		@SuppressWarnings("unchecked")
		List<TransportFinance> transportList = (List<TransportFinance>) (List<?>) list_transport;

		for(TransportFinance finance: transportList) {
			expense += finance.getTransportpayment_amount();
		}
		List<Finance> list_supplier = finanaceManagerIDAO.getAllFinanceDetails("supplierFinance");
		@SuppressWarnings("unchecked")
		List<Supplier_Finance> supplierList = (List<Supplier_Finance>) (List<?>) list_supplier;

		for(Supplier_Finance finance: supplierList) {
			expense += finance.getAmount();
		}
		System.out.println("Total Expense : "+ expense);

		return expense;
	}

	@Override
	public double profitPercentage() {
		
		double profit = this.totalIncome() -  this.totalExpense();
		
		if(profit <= 0)
			profit = 0;
		
		double profit_percentage = (profit/this.totalIncome())*100;
		
		System.out.println("Profit Percentage : "+ profit_percentage);
		return profit_percentage;
	}

	public void saveSessionObjects(HttpSession httpSession) {
		
		Session session = finanaceManagerIDAO.getCurrentSession();
		
		if(session == null) {
			System.out.println("Session is null");
		}
		
		Double income = this.totalIncome();
		Double expense = this.totalExpense();
		Double profitPercent = this.profitPercentage();
		
		DecimalFormat twoDForm = new DecimalFormat("#.##");
	   
	    httpsession.setAttribute("Income", income);
	    httpsession.setAttribute("Expense", expense);
	    httpsession.setAttribute("ProfitPercent", twoDForm.format(profitPercent));
	}

}
