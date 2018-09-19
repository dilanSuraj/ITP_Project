package inv_dis_mgmtsys.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import inv_dis_mgmtsys.dao.FinanaceManagement_IDAOImpl;
import inv_dis_mgmtsys.model.Emp_Month_Salary;
import inv_dis_mgmtsys.model.Finance;
import inv_dis_mgmtsys.model.Item;
import inv_dis_mgmtsys.model.Payment;

import inv_dis_mgmtsys.model.Retailer;
import inv_dis_mgmtsys.model.Retailer_Blacklist;
import inv_dis_mgmtsys.model.Retailer_Finance;
import inv_dis_mgmtsys.model.Retailer_Order;
import inv_dis_mgmtsys.model.Supplier;
import inv_dis_mgmtsys.model.SupplierOrderItems;
import inv_dis_mgmtsys.model.Supplier_Finance;
import inv_dis_mgmtsys.model.Supplier_Order;
import inv_dis_mgmtsys.model.TransportFinance;
import inv_dis_mgmtsys.model.Vehicle;

import inv_dis_mgmtsys.services.FinanaceManagement_IServicesImpl;

@Controller
@Transactional

public class Finance_ManagementController {

	@Autowired
	private FinanaceManagement_IServicesImpl finanaceManagement_IServices;

	public Finance_ManagementController() {

		System.out.println("Inside Finanace Management Controller");

	}

	@RequestMapping("/Finance_Manager")
	public ModelAndView FinanceManagerDashboardView(HttpSession session) {

		finanaceManagement_IServices.saveSessionObjects(session);
		ModelAndView modelAndView = new ModelAndView();

		try {

			Gson gsonObj = new Gson();
			modelAndView.setViewName("/Dashboards/FinanceManager");
			modelAndView.addObject("title", "Render Data From Database");

			modelAndView.addObject("dataPoints", gsonObj.toJson(finanaceManagement_IServices.getDataPoints(2018)));
		} catch (Exception e) {

		}
		return modelAndView;
	}

	@RequestMapping("/Supplier_Finance")
	public ModelAndView SupplierFinanaceView() {

		ModelAndView model = new ModelAndView();
		List<Finance> payment_List = finanaceManagement_IServices.getAllPaymentDetails("supplierFinance");

		@SuppressWarnings("unchecked")
		List<Supplier_Finance> supplierList = (List<Supplier_Finance>) (List<?>) payment_List;

		int itemCode = 0;

		for (Supplier_Finance finance : supplierList) {

			int supplierOrderID = finance.getSupplier_orderID();
			Supplier supplier = finanaceManagement_IServices.getSupplierByOrderID(supplierOrderID);
			finance.setSupplier(supplier);

			SupplierOrderItems order = finanaceManagement_IServices.getSingleSupplierOrderItem(supplierOrderID);

			itemCode = order.getSupplier_order_item_itemcode();
			Item item = finanaceManagement_IServices.getSingleItemDetail(itemCode);
			finance.setItem(item);

			double totalAmount = item.getItem_grossprice() * order.getSupplier_order_item_Amount();
			finance.setTotalAmount(totalAmount);

		}

		model.addObject("paymentlist", supplierList);
		model.setViewName("/FinanceManagement/Supplier_Finance_Management/Supplier_Finance");

		System.out.println("Supplier Finanace");
		return model;
	}

	@RequestMapping(value = "/Edit_Supplier_Finance", method = RequestMethod.GET)
	public ModelAndView SupplierFinanaceGET(@RequestParam("id") int id) {

		System.out.println("Supplier Finanace");
		ModelAndView model = new ModelAndView();
		Supplier_Finance supplier_Finance = (Supplier_Finance) finanaceManagement_IServices.getPaymentDetails(id,
				"supplierFinance");
		model.addObject("supplierfinance", supplier_Finance);
		model.setViewName("/FinanceManagement/Supplier_Finance_Management/Edit_Supplier_Finance");

		return model;
	}

	@RequestMapping(value = "/Edit_Supplier_Finance_POST", method = RequestMethod.POST)
	public ModelAndView SupplierFinanacePOST(@ModelAttribute("supplierfinance") Supplier_Finance supplier_Finance) {

		System.out.println("Supplier Finanace");
		System.out.println("Supplier UPDATE ID " + supplier_Finance.getSupplier_finance_id());
		finanaceManagement_IServices.updatePaymentDetails(supplier_Finance, "supplierFinance");
		return new ModelAndView("redirect:/Supplier_Finance");

	}

	@RequestMapping("/Delete_Supplier_Finance")
	public ModelAndView SupplierFinanaceDelete(@RequestParam("id") int id) {

		System.out.println("Supplier Finanace");
		finanaceManagement_IServices.deletePaymentDetails("supplierFinance", id);

		return new ModelAndView("redirect:/Supplier_Finance");
	}

	@RequestMapping(value = "/Add_Supplier_Finance", method = RequestMethod.GET)
	public ModelAndView SupplierFinanaceInsert_GET(
			@ModelAttribute("supplier_finance") Supplier_Finance supplier_finance) {

		ModelAndView modelAndView = new ModelAndView();
		List<SupplierOrderItems> orderList = finanaceManagement_IServices.getAllSupplierOrders();
		modelAndView.addObject("orderList", orderList);
		modelAndView.setViewName("/FinanceManagement/Supplier_Finance_Management/Add_Supplier_Finance");
		return modelAndView;
	}

	@RequestMapping(value = "/Add_Supplier_Finance_POST", method = RequestMethod.POST)
	public ModelAndView SupplierFinanaceInsert_POST(
			@ModelAttribute("supplier_finance") Supplier_Finance supplier_finance) {

		finanaceManagement_IServices.addPaymentDetails(supplier_finance);
		return new ModelAndView("redirect:/Supplier_Finance");
	}

	@RequestMapping("/Sale_Price")
	public ModelAndView SalePriceView() {

		ModelAndView model = new ModelAndView();
		List<Item> itemlist = finanaceManagement_IServices.getAllItemDetails();
		model.setViewName("/FinanceManagement/Sale_Price_Management/Sale_Price");

		System.out.println("In Controller");
		model.addObject("itemlist", itemlist);
		return model;

	}

	@RequestMapping(value = "/Edit_Sale_Price_GET", method = RequestMethod.GET)
	public ModelAndView SalePriceEdit_GET(@RequestParam("id") int id) {

		ModelAndView model = new ModelAndView();
		Item item = (Item) finanaceManagement_IServices.getSingleItemDetail(id);
		List<Item> itemList = finanaceManagement_IServices.getAllItemDetails();
		item.setItemList(itemList);
		model.addObject("item", item);

		model.setViewName("/FinanceManagement/Sale_Price_Management/Edit_Sale_Price");

		return model;
	}

	@RequestMapping(value = "/Edit_Sale_Price_POST", method = RequestMethod.POST)
	public ModelAndView SalePriceEdit_POST(@ModelAttribute("item") Item item) {

		finanaceManagement_IServices.editItemPrice(item);
		return new ModelAndView("redirect:/Sale_Price");
	}

	@RequestMapping("/Salary_Finace")
	public ModelAndView SalaryFinanceView() {

		ModelAndView model = new ModelAndView();
		List<Emp_Month_Salary> SalaryList = finanaceManagement_IServices.getAllEmpMonthSalary();
		model.setViewName("/FinanceManagement/Salary_Finance_Management/Salary_Finance");

		System.out.println("In Controller");
		model.addObject("salarylist", SalaryList);
		return model;

	}

	@RequestMapping(value = "/Edit_Salary_Finace_GET", method = RequestMethod.GET)
	public ModelAndView SalaryFinanceEdit_GET(@RequestParam("year") int year,@RequestParam("month") int month) {

		System.out.println("Salary Finance");
		ModelAndView model = new ModelAndView();

		Emp_Month_Salary emp_Month_Salary = (Emp_Month_Salary) finanaceManagement_IServices.getSingleSalaryDetailsFortheGivenYearMonth(year, month);
		if(emp_Month_Salary == null)
			System.out.println("NULL");
		
		emp_Month_Salary.setEmp_month_sal_year(year);
		emp_Month_Salary.setEmp_month_sal_month(month);
		model.addObject("empSalary", emp_Month_Salary);
		model.setViewName("/FinanceManagement/Salary_Finance_Management/EditSalary");

		return model;

	}

	@RequestMapping(value="/Edit_Salary_Finace_POST", method = RequestMethod.POST)
	public ModelAndView SalaryFinanceEdit_POST(@ModelAttribute("empSalary") Emp_Month_Salary empsalary) {

		System.out.println("Salary Finance");
		System.out.println(empsalary.getEmp_month_sal_status());
		finanaceManagement_IServices.editMonthSalaryDetails(empsalary);
		return new ModelAndView("redirect:/Salary_Finace");
	}

	@RequestMapping("/Retailer_Blacklist")
	public ModelAndView RetailerBlacklistView() {

		List<Retailer_Blacklist> blacklists = finanaceManagement_IServices.getBlacklistedRetailerFinanceList();
		ModelAndView model = new ModelAndView();
		model.addObject("blacklist", blacklists);
		model.setViewName("/FinanceManagement/Retailer_Finance_Management/Retailer_Blacklist");
		return model;
	}

	@RequestMapping("/Retailer_Finance")
	public ModelAndView RetailerFinanceView() {

		ModelAndView model = new ModelAndView();
		List<Finance> payment_List = finanaceManagement_IServices.getAllPaymentDetails("retailerFinance");

		@SuppressWarnings("unchecked")
		List<Retailer_Finance> retailerList = (List<Retailer_Finance>) (List<?>) payment_List;

		for (Retailer_Finance finance : retailerList) {
			int retailerOrderID = finance.getRetailer_orderID();
			Retailer retailer = finanaceManagement_IServices.getRetailerByOrderID(retailerOrderID);
			Retailer_Order order = finanaceManagement_IServices.getSingleRetailerOrder(retailerOrderID);
			finance.setTotalAmount(order.getOder_total());
			finance.setRetailer(retailer);
		}

		model.addObject("paymentlist", retailerList);
		model.setViewName("/FinanceManagement/Retailer_Finance_Management/Retailer_Finance");

		System.out.println("Retailer Finance");
		return model;
	}

	@RequestMapping(value = "/Edit_Retailer_Finance", method = RequestMethod.GET)
	public ModelAndView EditRetailerFinanceGET(@RequestParam("id") int id) {

		System.out.println("Retailer Finance");
		ModelAndView model = new ModelAndView();
		Retailer_Finance retailer_Finance = (Retailer_Finance) finanaceManagement_IServices.getPaymentDetails(id,
				"retailerFinance");
		model.addObject("retailerfinance", retailer_Finance);
		model.setViewName("/FinanceManagement/Retailer_Finance_Management/Edit_Retailer_Finance");

		return model;
	}

	@RequestMapping(value = "/Edit_Retailer_Finance_POST", method = RequestMethod.POST)
	public ModelAndView EditRetailerFinancePOST(@ModelAttribute("retailerfinance") Retailer_Finance retailer_Finance) {

		System.out.println("Retailer Finance");
		finanaceManagement_IServices.updatePaymentDetails(retailer_Finance, "retailerFinance");
		return new ModelAndView("redirect:/Retailer_Finance");
	}

	@RequestMapping("/Delete_Retailer_Finance")
	public ModelAndView RetailerFinanceDelete(@RequestParam("id") int id) {

		System.out.println("Retailer Finance");
		finanaceManagement_IServices.deletePaymentDetails("retailerFinance", id);
		return new ModelAndView("redirect:/Retailer_Finance");
	}

	@RequestMapping(value = "/Add_Retailer_Finance", method = RequestMethod.GET)
	public ModelAndView AddRetailerFinanceGET(@ModelAttribute("retailerfinance") Retailer_Finance retailer_Finance) {

		ModelAndView model = new ModelAndView();

		List<Retailer_Order> retailerOrderList = finanaceManagement_IServices.getAllRetailerOrders();
		model.addObject("retailerOrderList", retailerOrderList);
		model.setViewName("/FinanceManagement/Retailer_Finance_Management/Add_Retailer_Finance");
		System.out.println("Retailer Finance");
		return model;
	}

	@RequestMapping(value = "/Add_Retailer_Finance_POST", method = RequestMethod.POST)
	public ModelAndView AddRetailerFinancePOST(@ModelAttribute("retailerfinance") Retailer_Finance retailer_Finance) {

		System.out.println("Inside POST");
		int retailerOrderID = retailer_Finance.getRetailer_orderID();
		Retailer_Order retailer_Order = finanaceManagement_IServices.getSingleRetailerOrder(retailerOrderID);
		double totalAmt = retailer_Order.getOder_total();
		int retailer_ID = retailer_Order.getRetailer_ID();
		Retailer retailer = finanaceManagement_IServices.getRetailer(retailer_ID);
		retailer_Finance.setRetailer(retailer);
		retailer_Finance.setTotalAmount(totalAmt);

		finanaceManagement_IServices.addPaymentDetails(retailer_Finance);
		return new ModelAndView("redirect:/Retailer_Finance");
	}

	@RequestMapping("/Profit")
	public ModelAndView ProfitView(ModelMap model) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/FinanceManagement/Profit_Management/Profit");

		return modelAndView;
	}

	@RequestMapping("/Payment_Manage")
	public ModelAndView Payment_ManageView() {

		System.out.println("Payment_Manage");
		return new ModelAndView("/FinanceManagement/Payment_Management/Payment_Manage");
	}

	@RequestMapping("/Expenses")
	public ModelAndView ExpensesView() {

		ModelAndView model = new ModelAndView();
		List<Payment> paymentList = finanaceManagement_IServices.getPayments("expense");
		model.addObject("paymentlist", paymentList);
		System.out.println("Expenses");
		model.setViewName("/FinanceManagement/Payment_Management/Expenses");
		return model;
	}

	@RequestMapping("/Income")
	public ModelAndView IncomeView() {

		ModelAndView model = new ModelAndView();
		List<Payment> paymentList = finanaceManagement_IServices.getPayments("income");

		model.addObject("paymentlist", paymentList);
		model.setViewName("/FinanceManagement/Payment_Management/Income");
		System.out.println("Income");

		return model;
	}

	// Transport Financial details

	@RequestMapping("/Transport_Finance")
	public ModelAndView TransportFinanceView() {

		ModelAndView model = new ModelAndView();
		List<Finance> paymentList = finanaceManagement_IServices.getAllPaymentDetails("transportFinance");

		model.addObject("paymentlist", paymentList);
		model.setViewName("/FinanceManagement/Payment_Management/Transport_Finance");
		System.out.println("Transport Finance");
		return model;
	}

	@RequestMapping(value = "/AddTransport_Finance", method = RequestMethod.GET)
	public ModelAndView AddTransportFinanceGET(@ModelAttribute("transportfinance") TransportFinance transportFinance) {

		List<Vehicle> vehicleList = finanaceManagement_IServices.getAllVehicleDetails();
		ModelAndView model = new ModelAndView();
		model.setViewName("/FinanceManagement/Payment_Management/Add_Transport_Finance");
		model.addObject("vehicleList", vehicleList);
		return model;
	}

	@RequestMapping(value = "/AddTransport_Finance_POST", method = RequestMethod.POST)
	public ModelAndView AddTransportFinancePOST(@ModelAttribute("transportfinance") TransportFinance transportFinance) {

		System.out.println("Add Transport Finance");
		finanaceManagement_IServices.addPaymentDetails(transportFinance);
		return new ModelAndView("redirect:/Transport_Finance");
	}

	@RequestMapping(value = "/UpdateTransport_Finance", method = RequestMethod.GET)
	public ModelAndView UpdateTransportFinanceGET(@RequestParam("id") int id) {

		System.out.println("Update Transport Finance");
		ModelAndView model = new ModelAndView();
		TransportFinance transportFinance = (TransportFinance) finanaceManagement_IServices.getPaymentDetails(id,
				"transportFinance");
		model.addObject("transportfinance", transportFinance);
		model.setViewName("/FinanceManagement/Payment_Management/Update_Transport_Finance");
		return model;
	}

	@RequestMapping(value = "/UpdateTransport_Finance_POST", method = RequestMethod.POST)
	public ModelAndView UpdateTransportFinancePOST(
			@ModelAttribute("transportfinance") TransportFinance transportFinance) {

		System.out.println("Update Transport Finance");
		finanaceManagement_IServices.updatePaymentDetails(transportFinance, "transportFinance");
		return new ModelAndView("redirect:/Transport_Finance");

	}

	@RequestMapping("/DeleteTransport_Finance")
	public ModelAndView DeleteTransportFinanceView(@RequestParam("id") int id) {

		System.out.println("Delete Transport Finance");
		finanaceManagement_IServices.deletePaymentDetails("transportFinance", id);
		return new ModelAndView("redirect:/Transport_Finance");

	}

	// Income details

	@RequestMapping(value = "/AddIncome", method = RequestMethod.GET)
	public ModelAndView AddIncomeGET(@ModelAttribute("payment") Payment payment) {

		return new ModelAndView("/FinanceManagement/Payment_Management/AddIncome");
	}

	@RequestMapping(value = "/AddIncome_post", method = RequestMethod.POST)
	public ModelAndView AddIncomePOST(@ModelAttribute("payment") Payment payment) {

		System.out.println("Add Income post");
		payment.setOther_income_expense_type("income");
		finanaceManagement_IServices.addPaymentDetails(payment);

		return new ModelAndView("redirect:/Income");
	}

	@RequestMapping(value = "/UpdateIncome_Get")
	public ModelAndView UpdateIncomeGET(@RequestParam("id") int id) {

		ModelAndView model = new ModelAndView();
		Payment payment = (Payment) finanaceManagement_IServices.getPaymentDetails(id, "payment");
		model.addObject("income", payment);
		model.setViewName("/FinanceManagement/Payment_Management/UpdateIncome");
		return model;
	}

	@RequestMapping(value = "/UpdateIncome_Post", method = RequestMethod.POST)
	public ModelAndView UpdateIncomePOST(@ModelAttribute("income") Payment payment) {

		System.out.println("New Payment : " + payment.getOther_income_expense_recieved());
		payment.setOther_income_expense_type("income");
		finanaceManagement_IServices.updatePaymentDetails(payment, "payment");

		return new ModelAndView("redirect:/Income");
	}

	@RequestMapping(value = "/DeleteIncome")
	public ModelAndView DeleteIncomeView(@RequestParam("id") int id) {

		System.out.println("Delete Income");
		finanaceManagement_IServices.deletePaymentDetails("payment", id);
		return new ModelAndView("redirect:/Income");
	}

	// Expenses

	@RequestMapping(value = "/AddExpenses", method = RequestMethod.GET)
	public ModelAndView AddExpensesGET(@ModelAttribute("payment") Payment payment) {

		System.out.println("Add Expenses get");
		return new ModelAndView("/FinanceManagement/Payment_Management/AddExpenses");
	}

	@RequestMapping(value = "/AddExpenses_POST", method = RequestMethod.POST)
	public ModelAndView AddExpensesPOST(@ModelAttribute("payment") Payment payment) {

		System.out.println("Add Expenses post");
		payment.setOther_income_expense_type("expense");
		finanaceManagement_IServices.addPaymentDetails(payment);

		return new ModelAndView("redirect:/Expenses");

	}

	@RequestMapping("/UpdateExpenses_Get")
	public ModelAndView UpdateExpensesGET(@RequestParam("id") int id) {

		System.out.println("Update Expenses get");
		ModelAndView model = new ModelAndView();
		Payment payment = (Payment) finanaceManagement_IServices.getPaymentDetails(id, "payment");
		model.addObject("expense", payment);
		model.setViewName("/FinanceManagement/Payment_Management/UpdateExpenses");
		return model;
	}

	@RequestMapping(value = "/UpdateExpenses_POST", method = RequestMethod.POST)
	public ModelAndView UpdateExpensesPOST(@ModelAttribute("income") Payment payment) {

		System.out.println("Update Expenses post");
		payment.setOther_income_expense_type("expense");
		finanaceManagement_IServices.updatePaymentDetails(payment, "payment");
		return new ModelAndView("redirect:/Expenses");

	}

	@RequestMapping("/DeleteExpenses")
	public ModelAndView DeleteExpensesView(@RequestParam("id") int id) {

		System.out.println("Delete Expenses");
		finanaceManagement_IServices.deletePaymentDetails("payment", id);
		return new ModelAndView("redirect:/Expenses");

	}
}
