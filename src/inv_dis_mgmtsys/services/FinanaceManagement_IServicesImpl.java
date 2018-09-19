package inv_dis_mgmtsys.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

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
import inv_dis_mgmtsys.model.Retailer_Finance_View;
import inv_dis_mgmtsys.model.Retailer_Order;
import inv_dis_mgmtsys.model.Supplier;
import inv_dis_mgmtsys.model.SupplierFinance_View;
import inv_dis_mgmtsys.model.SupplierOrderItems;
import inv_dis_mgmtsys.model.Supplier_Finance;
import inv_dis_mgmtsys.model.Supplier_Order;
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
		} else {
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
			System.out.println("Payment amount Line 151 :" + paymentAmt);

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
	public Emp_Month_Salary getSingleSalaryDetails(int emp_month_ID) {

		return finanaceManagerIDAO.getSingleSalaryDetails(emp_month_ID);
	}
	
	@Override
	public Emp_Month_Salary getSingleSalaryDetailsFortheGivenYearMonth(int year, int month) {

		return finanaceManagerIDAO.getSingleSalaryDetailsFortheGivenYearMonth(year, month);
	}
	
	@Override
	public List<Emp_Month_Salary> getAllSalaryDetailsFortheGivenYearMonth(int year, int month) {

		return finanaceManagerIDAO.getAllSalaryDetailsFortheGivenYearMonth(year, month);
	}

	@Override
	public void editMonthSalaryDetails(Emp_Month_Salary emp_Month_Salary) {

		
		System.out.println(emp_Month_Salary.getEmp_month_sal_year());
		System.out.println(emp_Month_Salary.getEmp_month_sal_month());
      
		finanaceManagerIDAO.editMonthSalaryDetails(emp_Month_Salary);
       

	}

	@Override
	public Retailer getRetailer(int retailerID) {

		return finanaceManagerIDAO.getRetailer(retailerID);
	}

	@Override
	public List<Retailer_Blacklist> getBlacklistedRetailerFinanceList() {
		List<Retailer_Blacklist> retailer_blacklist = finanaceManagerIDAO.getBlacklistedRetailerFinanceList();

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
		for (Payment payment : paymentList) {

			if (payment.getOther_income_expense_type().equals("income")) {
				income += payment.getOther_income_expense_recieved();
			}
		}

		List<Finance> list_retailer = finanaceManagerIDAO.getAllFinanceDetails("retailerFinance");
		@SuppressWarnings("unchecked")
		List<Retailer_Finance> retailerList = (List<Retailer_Finance>) (List<?>) list_retailer;

		for (Retailer_Finance finance : retailerList) {
			income += finance.getAmount();
		}
		System.out.println("Total Income : " + income);

		return income;
	}

	public double gettotalIncome_currentMonth() {

		List<Finance> payment_List = finanaceManagerIDAO.getAllFinanceDetails("payment");
		@SuppressWarnings("unchecked")
		List<Payment> paymentList = (List<Payment>) (List<?>) payment_List;

		double income = 0;

		Calendar cal = Calendar.getInstance();

		int year = 0;
		int month = 0;

		Calendar c = Calendar.getInstance();

		int year_current = c.get(Calendar.YEAR);
		int month_current = c.get(Calendar.MONTH);

		System.out.println("Current year " + year_current + " , current month : " + month_current);

		for (Payment payment : paymentList) {

			cal.setTime(payment.getOther_income_expense_date());
			year = cal.get(Calendar.YEAR);
			month = cal.get(Calendar.MONTH);
			System.out.println("Year got " + year + "Month : " + month);

			if (payment.getOther_income_expense_type().equals("income") && (year == year_current)
					&& (month == month_current)) {
				income += payment.getOther_income_expense_recieved();
			}
		}

		List<Finance> list_retailer = finanaceManagerIDAO.getAllFinanceDetails("retailerFinance");
		@SuppressWarnings("unchecked")
		List<Retailer_Finance> retailerList = (List<Retailer_Finance>) (List<?>) list_retailer;

		for (Retailer_Finance finance : retailerList) {

			cal.setTime(finance.getPayment_date());
			year = cal.get(Calendar.YEAR);
			month = cal.get(Calendar.MONTH);
			System.out.println("Year got " + year + "Month : " + month);

			if ((year == year_current) && (month == month_current)) {

				income += finance.getAmount();
			}
		}
		System.out.println("Total Income : " + income);

		return income;
	}

	
	public double gettotalExpense_currentMonth() {

		double expense = 0;

		List<Finance> payment_List = finanaceManagerIDAO.getAllFinanceDetails("payment");
		@SuppressWarnings("unchecked")
		List<Payment> paymentList = (List<Payment>) (List<?>) payment_List;

		Calendar cal = Calendar.getInstance();

		int year = 0;
		int month = 0;

		Calendar c = Calendar.getInstance();

		int year_current = c.get(Calendar.YEAR);
		int month_current = c.get(Calendar.MONTH);

		System.out.println("Current year " + year_current + " , current month : " + month_current);

		for (Payment payment : paymentList) {

			cal.setTime(payment.getOther_income_expense_date());
			year = cal.get(Calendar.YEAR);
			month = cal.get(Calendar.MONTH);
			System.out.println("Year got " + year + "Month : " + month);

			if (payment.getOther_income_expense_type().equals("expense") && (year == year_current)
					&& (month == month_current)) {
				expense += payment.getOther_income_expense_recieved();
			}
		}
		List<Finance> list_transport = finanaceManagerIDAO.getAllFinanceDetails("transportFinance");
		@SuppressWarnings("unchecked")
		List<TransportFinance> transportList = (List<TransportFinance>) (List<?>) list_transport;

		for (TransportFinance finance : transportList) {

			cal.setTime(finance.getTransportpayment_date());
			year = cal.get(Calendar.YEAR);
			month = cal.get(Calendar.MONTH);
			System.out.println("Year got " + year + "Month : " + month);

			if ((year == year_current) && (month == month_current)) {
				expense += finance.getTransportpayment_amount();
			}
		}
		List<Finance> list_supplier = finanaceManagerIDAO.getAllFinanceDetails("supplierFinance");
		@SuppressWarnings("unchecked")
		List<Supplier_Finance> supplierList = (List<Supplier_Finance>) (List<?>) list_supplier;

		for (Supplier_Finance finance : supplierList) {

			cal.setTime(finance.getPayment_date());
			year = cal.get(Calendar.YEAR);
			month = cal.get(Calendar.MONTH);
			System.out.println("Year got " + year + "Month : " + month);

			if ((year == year_current) && (month == month_current)) {
				expense += finance.getAmount();
			}
		}
		
		List<Emp_Month_Salary> empSalaryList = finanaceManagerIDAO.getAllEmpMonthSalary();
		
		for(Emp_Month_Salary emp_Month_Salary:empSalaryList) {
			if(emp_Month_Salary.getEmp_month_sal_status().equals("Paid") &&(emp_Month_Salary.getEmp_month_sal_year() == year_current) &&(emp_Month_Salary.getEmp_month_sal_month() == month_current)) {
				expense += emp_Month_Salary.getEmp_month_sal_amount();
			}
		}
		System.out.println("Total Expense : " + expense);

		return expense;
	}

	@Override
	public double totalExpense() {

		double expense = 0;

		List<Finance> payment_List = finanaceManagerIDAO.getAllFinanceDetails("payment");
		@SuppressWarnings("unchecked")
		List<Payment> paymentList = (List<Payment>) (List<?>) payment_List;

		for (Payment payment : paymentList) {

			if (payment.getOther_income_expense_type().equals("expense")) {
				expense += payment.getOther_income_expense_recieved();
			}
		}
		List<Finance> list_transport = finanaceManagerIDAO.getAllFinanceDetails("transportFinance");
		@SuppressWarnings("unchecked")
		List<TransportFinance> transportList = (List<TransportFinance>) (List<?>) list_transport;

		for (TransportFinance finance : transportList) {
			expense += finance.getTransportpayment_amount();
		}
		List<Finance> list_supplier = finanaceManagerIDAO.getAllFinanceDetails("supplierFinance");
		@SuppressWarnings("unchecked")
		List<Supplier_Finance> supplierList = (List<Supplier_Finance>) (List<?>) list_supplier;

		for (Supplier_Finance finance : supplierList) {
			expense += finance.getAmount();
		}
		
        List<Emp_Month_Salary> empSalaryList = finanaceManagerIDAO.getAllEmpMonthSalary();
		
		for(Emp_Month_Salary emp_Month_Salary:empSalaryList) {
			if(emp_Month_Salary.getEmp_month_sal_status().equals("Paid")) {
				expense += emp_Month_Salary.getEmp_month_sal_amount();
			}
		}
		System.out.println("Total Expense : " + expense);

		return expense;
	}

	@Override
	public double profitPercentage() {

		double profit = this.gettotalIncome_currentMonth() - this.gettotalExpense_currentMonth();

		if (profit <= 0)
			profit = 0;

		System.out.println("Profit  : " + profit);
		double profit_percentage = (profit / this.gettotalIncome_currentMonth()) * 100;

		System.out.println("Profit Percentage : " + profit_percentage);
		return profit_percentage;
	}

	public void saveSessionObjects(HttpSession httpSession) {

		Session session = finanaceManagerIDAO.getCurrentSession();

		if (session == null) {
			System.out.println("Session is null");
		}

		Double income = this.totalIncome();
		Double expense = this.totalExpense();

		Double income_currentmonth = this.gettotalIncome_currentMonth();
		Double expense_currentmonth = this.gettotalExpense_currentMonth();

		Double profitPercent = this.profitPercentage();
		int blacklist = this.blacklistedRetailerList();

		DecimalFormat twoDForm = new DecimalFormat("#.##");

		String income_string = new DecimalFormat("#,###.00").format(income_currentmonth);
		String expense_string = new DecimalFormat("#,###.00").format(expense_currentmonth);

		httpsession.setAttribute("Income", income_string);
		httpsession.setAttribute("Expense", expense_string);
		httpsession.setAttribute("ProfitPercent", twoDForm.format(profitPercent));
		httpsession.setAttribute("Blacklist", blacklist);
	}

	public int blacklistedRetailerList() {

		int numberOfBlcklisted = 0;
		List<Retailer_Blacklist> blacklist = finanaceManagerIDAO.getBlacklistedRetailerFinanceList();

		List<Retailer> retailerList = finanaceManagerIDAO.getAllRetailers();

		if (retailerList == null) {
			return 0;
		}
		for (Retailer retailer : retailerList) {

			if (retailer.getRetailer_blacklistStatus().equals("Yes")) {
				numberOfBlcklisted++;
			}
		}
		System.out.println("Blacklisted : " + numberOfBlcklisted);
		return numberOfBlcklisted;
	}

	@Override
	public Retailer getRetailerByOrderID(int retailerorderID) {
		Retailer_Order order = finanaceManagerIDAO.getSingleRetailerOrderDetails(retailerorderID);
		int retailerID = order.getRetailer_ID();
		Retailer retailer = finanaceManagerIDAO.getRetailer(retailerID);
		return retailer;
	}

	@Override
	public Supplier getSupplierByOrderID(int supplierorderID) {

		SupplierOrderItems order = finanaceManagerIDAO.getSingleSupplierOrderDetails(supplierorderID);

		int supplierID = order.getSupplier_order_Item_supplierID();
		Supplier supplier = finanaceManagerIDAO.getSupplier(supplierID);
		return supplier;

	}

	@Override
	public Supplier getSupplier(int supplierID) {

		return finanaceManagerIDAO.getSupplier(supplierID);
	}

	@Override
	public List<SupplierOrderItems> getAllSupplierOrders() {
		return finanaceManagerIDAO.getAllSupplierOrderDetails();
	}

	@Override
	public SupplierOrderItems getSingleSupplierOrderItem(int supplierOrderID) {

		return finanaceManagerIDAO.getSingleSupplierOrderDetails(supplierOrderID);
	}

	public List<Emp_Month_Salary> getAllEmpMonthSalary() {
		return finanaceManagerIDAO.getAllEmpMonthSalary();
	}

    public List<Map<String, Object>> getSupplierFinanceViewDetails(){
		
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		List<SupplierFinance_View> listOfSupplierFinanceView = finanaceManagerIDAO.getAllSupplierFinanceViewDetails();
		
		for(SupplierFinance_View financeView : listOfSupplierFinanceView) {
			Map<String, Object> map = new HashMap<>();
			map.put("supplier_companyname", financeView.getSupplier_companyname());
			map.put("supplier_order_item_Amount", financeView.getSupplier_order_item_Amount());
			map.put("item_name",financeView.getItem_name());
			map.put("payment_date", financeView.getPayment_date());
			map.put("amount", financeView.getAmount());
			map.put("item_grossprice", financeView.getItem_grossprice());
			list.add(map);
						
		}
		return  list;
	}
    
        public List<Map<String, Object>> getRetailerFinanceViewDetails(){
		
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		List<Retailer_Finance_View> listOfRetailerFinanceView = finanaceManagerIDAO.getAllRetailerFinanceViewDetails();
		
		for(Retailer_Finance_View financeView : listOfRetailerFinanceView) {
			Map<String, Object> map = new HashMap<>();
			map.put("retailer_name", financeView.getRetailer_name());
			map.put("paymentAmt", financeView.getPaymentAmt());
			map.put("oder_total",financeView.getOder_total());
			map.put("payment_date", financeView.getPayment_date());
			map.put("deadline_payment_date", financeView.getDeadline_payment_date());
			
			list.add(map);
						
		}
		return  list;
	}


}
