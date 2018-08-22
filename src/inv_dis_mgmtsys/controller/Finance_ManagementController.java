package inv_dis_mgmtsys.controller;


import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import inv_dis_mgmtsys.model.Payment;
import inv_dis_mgmtsys.model.Supplier_Finance;
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
	public ModelAndView FinanceManagerDashboardView() {
		
		System.out.println("Finance Manager Dashboard");
	    return new ModelAndView("/Dashboards/FinanceManager");
	}
	
	@RequestMapping("/Supplier_Finance")
	public ModelAndView SupplierFinanaceView() {
		
		System.out.println("Supplier Finanace");
	    return new ModelAndView("/FinanceManagement/Supplier_Finance_Management/Supplier_Finance");
	}
	
	@RequestMapping("/Edit_Supplier_Finance")
	public ModelAndView SupplierFinanaceEdit() {
		
		System.out.println("Supplier Finanace");
	    return new ModelAndView("/FinanceManagement/Supplier_Finance_Management/Edit_Supplier_Finance");
	}
	
	@RequestMapping("/Delete_Supplier_Finance")
	public ModelAndView SupplierFinanaceDelete() {
		
		System.out.println("Supplier Finanace");
	    return new ModelAndView("/FinanceManagement/Supplier_Finance_Management/Supplier_Finance");
	}
	
	@RequestMapping("/Add_Supplier_Finance")
	public ModelAndView SupplierFinanaceInsert_GET(@ModelAttribute("supplier_finance") Supplier_Finance supplier_finance ) {
		
		  return new ModelAndView("/FinanceManagement/Supplier_Finance_Management/Add_Supplier_Finance");
	}
	
	@RequestMapping(value="/Add_Supplier_Finance_POST",method=RequestMethod.POST)
	public ModelAndView SupplierFinanaceInsert_POST(@ModelAttribute("supplier_finance") Supplier_Finance supplier_finance) {
		
	    return new ModelAndView("/FinanceManagement/Supplier_Finance_Management/Supplier_Finance");
	}
	
	@RequestMapping("/Sale_Price")
	public ModelAndView SalePriceView() {
		
		System.out.println("Sale Price");
	    return new ModelAndView("/FinanceManagement/Sale_Price_Management/Sale_Price");
	}
	
	@RequestMapping("/Salary_Finace")
	public ModelAndView SalaryFinanceView() {
		
		System.out.println("Salary Finance");
	    return new ModelAndView("/FinanceManagement/Salary_Finance_Management/Salary_Finance");
	}
	
	@RequestMapping("/Retailer_Blacklist")
	public ModelAndView RetailerBlacklistView() {
		
		System.out.println("Retailer Blacklist");
	    return new ModelAndView("/FinanceManagement/Retailer_Finance_Management/Retailer_Blacklist");
	}
	
	@RequestMapping("/Add_Retailer_Blacklist")
	public ModelAndView RetailerBlacklistInsert() {
		
		System.out.println("Retailer Blacklist");
	    return new ModelAndView("/FinanceManagement/Retailer_Finance_Management/Add_Retailer_Blacklist");
	}
	
	@RequestMapping("/Delete_Retailer_Blacklist")
	public ModelAndView RetailerBlacklistDelete() {
		
		System.out.println("Retailer Blacklist");
	    return new ModelAndView("/FinanceManagement/Retailer_Finance_Management/Retailer_Blacklist");
	}
	
	@RequestMapping("/Retailer_Finance")
	public ModelAndView RetailerFinanceView() {
		
		System.out.println("Retailer Finance");
	    return new ModelAndView("/FinanceManagement/Retailer_Finance_Management/Retailer_Finance");
	}
	
	@RequestMapping("/Edit_Retailer_Finance")
	public ModelAndView RetailerFinanceEdit() {
		
		System.out.println("Retailer Finance");
	    return new ModelAndView("/FinanceManagement/Retailer_Finance_Management/Edit_Retailer_Finance");
	}
	
	@RequestMapping("/Delete_Retailer_Finance")
	public ModelAndView RetailerFinanceDelete() {
		
		System.out.println("Retailer Finance");
	    return new ModelAndView("/FinanceManagement/Retailer_Finance_Management/Retailer_Finance");
	}
	
	@RequestMapping("/Add_Retailer_Finance")
	public ModelAndView RetailerFinanceInsert() {
		
		System.out.println("Retailer Finance");
	    return new ModelAndView("/FinanceManagement/Retailer_Finance_Management/Add_Retailer_Finance");
	}
	
	@RequestMapping("/Profit")
	public ModelAndView ProfitView() {
		
		System.out.println("Profit");
	    return new ModelAndView("/FinanceManagement/Profit_Management/Profit");
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
	
	//Transport Financial details
	
	@RequestMapping("/Transport_Finance")
	public ModelAndView TransportFinanceView() {
		
		ModelAndView model = new ModelAndView();
		List<Payment> paymentList = finanaceManagement_IServices.getPayments("");
		
		model.addObject("paymentlist", paymentList);
		model.setViewName("/FinanceManagement/Payment_Management/Transport_Finance");
		System.out.println("Transport Finance");
	    return model;
	}
	
	@RequestMapping(value="/AddTransport_Finance",method=RequestMethod.GET)
	public ModelAndView AddTransportFinanceGET() {
		
		System.out.println("Add Transport Finance");
	    return new ModelAndView("/FinanceManagement/Payment_Management/Add_Transport_Finance");
	}
	
	@RequestMapping(value="/AddTransport_Finance",method=RequestMethod.POST)
	public ModelAndView AddTransportFinancePOST() {
		
		System.out.println("Add Transport Finance");
	    return new ModelAndView("/FinanceManagement/Payment_Management/Add_Transport_Finance");
	}
	
	@RequestMapping(value="/UpdateTransport_Finance",method=RequestMethod.GET)
	public ModelAndView UpdateTransportFinanceGET() {
		
		System.out.println("Update Transport Finance");
	    return new ModelAndView("/FinanceManagement/Payment_Management/Update_Transport_Finance");
	}
	
	@RequestMapping(value="/UpdateTransport_Finance",method=RequestMethod.POST)
	public ModelAndView UpdateTransportFinancePOST() {
		
		System.out.println("Update Transport Finance");
	    return new ModelAndView("/FinanceManagement/Payment_Management/Update_Transport_Finance");
	}
	
	@RequestMapping("/DeleteTransport_Finance")
	public ModelAndView DeleteTransportFinanceView() {
		
		System.out.println("Delete Transport Finance");
	    return new ModelAndView("/FinanceManagement/Payment_Management/Transport_Finance");
	}
	
	//Income details
	
	@RequestMapping(value="/AddIncome",method=RequestMethod.GET)
	public ModelAndView AddIncomeGET(@ModelAttribute("payment")Payment payment) {
		
		System.out.println("Add Income get");
		System.out.println("Date : "+ payment.getOther_income_expense_date());
		
	    return new ModelAndView("/FinanceManagement/Payment_Management/AddIncome");
	}
	
	@RequestMapping(value="/AddIncome_post",method=RequestMethod.POST)
	public ModelAndView AddIncomePOST(@ModelAttribute("payment")Payment payment) {
		
		System.out.println("Add Income post");
		payment.setOther_income_expense_type("income");
		finanaceManagement_IServices.addPaymentDetails(payment);
		
	    return new ModelAndView("redirect:/Income");
	}
	
	@RequestMapping(value="/UpdateIncome_Get")
	public ModelAndView UpdateIncomeGET(@RequestParam("id") int id) {
		
		ModelAndView model = new ModelAndView();
		Payment payment = (Payment) finanaceManagement_IServices.getPaymentDetails(id, "payment");
		model.addObject("income", payment);
		model.setViewName("/FinanceManagement/Payment_Management/UpdateIncome");
	    return model;
	}
	
	@RequestMapping(value="/UpdateIncome_Post",method=RequestMethod.POST)
	public ModelAndView UpdateIncomePOST(@ModelAttribute("income")Payment payment) {
		
		System.out.println("New Payment : "+ payment.getOther_income_expense_recieved());
		payment.setOther_income_expense_type("income");
		finanaceManagement_IServices.updatePaymentDetails(payment, "payment");
		
	    return new ModelAndView("redirect:/Income");
	}
	
	@RequestMapping(value="/DeleteIncome")
	public ModelAndView DeleteIncomeView(@RequestParam("id") int id) {
		
		System.out.println("Delete Income");
		finanaceManagement_IServices.deletePaymentDetails("payment", id);
	    return new ModelAndView("redirect:/Income");
	}
	
	//Expenses
	
	@RequestMapping(value="/AddExpenses",method=RequestMethod.GET)
	public ModelAndView AddExpensesGET(@ModelAttribute("payment")Payment payment) {
		
		System.out.println("Add Expenses get");
	    return new ModelAndView("/FinanceManagement/Payment_Management/AddExpenses");
	}
	
	@RequestMapping(value="/AddExpenses_POST",method=RequestMethod.POST)
	public ModelAndView AddExpensesPOST(@ModelAttribute("payment")Payment payment) {
		
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
	
	@RequestMapping(value="/UpdateExpenses_POST",method=RequestMethod.POST)
	public ModelAndView UpdateExpensesPOST(@ModelAttribute("income")Payment payment) {
		
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
