package inv_dis_mgmtsys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Finance_ManagementController {

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
	public ModelAndView SupplierFinanaceInsert() {
		
		System.out.println("Supplier Finanace");
	    return new ModelAndView("/FinanceManagement/Supplier_Finance_Management/Add_Supplier_Finance");
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
		
		System.out.println("Expenses");
	    return new ModelAndView("/FinanceManagement/Payment_Management/Expenses");
	}
	
	@RequestMapping("/Income")
	public ModelAndView IncomeView() {
		
		System.out.println("Income");
	    return new ModelAndView("/FinanceManagement/Payment_Management/Income");
	}
	
	//Transport Financial details
	
	@RequestMapping("/Transport_Finance")
	public ModelAndView TransportFinanceView() {
		
		System.out.println("Transport Finance");
	    return new ModelAndView("/FinanceManagement/Payment_Management/Transport_Finance");
	}
	
	@RequestMapping("/AddTransport_Finance")
	public ModelAndView AddTransportFinanceView() {
		
		System.out.println("Add Transport Finance");
	    return new ModelAndView("/FinanceManagement/Payment_Management/Add_Transport_Finance");
	}
	
	@RequestMapping("/UpdateTransport_Finance")
	public ModelAndView UpdateTransportFinanceView() {
		
		System.out.println("Update Transport Finance");
	    return new ModelAndView("/FinanceManagement/Payment_Management/Update_Transport_Finance");
	}
	
	@RequestMapping("/DeleteTransport_Finance")
	public ModelAndView DeleteTransportFinanceView() {
		
		System.out.println("Delete Transport Finance");
	    return new ModelAndView("/FinanceManagement/Payment_Management/Transport_Finance");
	}
	
	//Income details
	
	@RequestMapping("/AddIncome")
	public ModelAndView AddIncomeView() {
		
		System.out.println("Add Income");
	    return new ModelAndView("/FinanceManagement/Payment_Management/AddIncome");
	}
	
	@RequestMapping("/UpdateIncome")
	public ModelAndView UpdateIncomeView() {
		
		System.out.println("Update Income");
	    return new ModelAndView("/FinanceManagement/Payment_Management/UpdateIncome");
	}
	
	@RequestMapping("/DeleteIncome")
	public ModelAndView DeleteIncomeView() {
		
		System.out.println("Delete Income");
	    return new ModelAndView("/FinanceManagement/Payment_Management/Income");
	}
	
	//Expenses
	
	@RequestMapping("/AddExpenses")
	public ModelAndView AddExpensesView() {
		
		System.out.println("Add Expenses");
	    return new ModelAndView("/FinanceManagement/Payment_Management/AddExpenses");
	}
	
	@RequestMapping("/UpdateExpenses")
	public ModelAndView UpdateExpensesView() {
		
		System.out.println("Update Expenses");
	    return new ModelAndView("/FinanceManagement/Payment_Management/UpdateExpenses");
	}
	
	@RequestMapping("/DeleteExpenses")
	public ModelAndView DeleteExpensesView() {
		
		System.out.println("Delete Expenses");
	    return new ModelAndView("/FinanceManagement/Payment_Management/Expenses");
	}
}
