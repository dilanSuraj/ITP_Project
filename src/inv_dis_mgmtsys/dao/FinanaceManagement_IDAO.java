package inv_dis_mgmtsys.dao;

import java.util.List;

import javax.sql.DataSource;

import inv_dis_mgmtsys.model.DataPoint;
import inv_dis_mgmtsys.model.Emp_Month_Salary;
import inv_dis_mgmtsys.model.ExpenseView;
import inv_dis_mgmtsys.model.Finance;
import inv_dis_mgmtsys.model.IncomeView;
import inv_dis_mgmtsys.model.Item;
import inv_dis_mgmtsys.model.Payment;
import inv_dis_mgmtsys.model.PermanentEmployee;
import inv_dis_mgmtsys.model.Retailer;
import inv_dis_mgmtsys.model.Retailer_Blacklist;
import inv_dis_mgmtsys.model.Retailer_Finance;
import inv_dis_mgmtsys.model.Retailer_Order;
import inv_dis_mgmtsys.model.Supplier;
import inv_dis_mgmtsys.model.Supplier_Order;
import inv_dis_mgmtsys.model.TemporaryEmployee;
import inv_dis_mgmtsys.model.Vehicle;



public interface FinanaceManagement_IDAO{

	
    public void addFinance(Finance finance);
	
	public void editFinance(Finance finance,String type);
	
	public void deleteFinance(Finance finance);
	
	public List<Payment> getfinancebyCategory(String paymentCategory);
	
	public List<Finance> getAllFinanceDetails(String type);
	
	public Finance getSingleFinanceDetail(int paymentID,String type);
	
	public Item getSingleItemDetail(int ID);
	
	public List<Item> getAllItemDetails();
	
	public void editItemPrice(Item item);
	
	public List<Vehicle> getAllVehicleDetails();
	
	public List<Retailer_Order> getAllRetailerOrderDetails();
	
	public Retailer_Order getSingleRetailerOrderDetails(int retailerOrderID);
	
	public List<Emp_Month_Salary> getAllEmpMonthSalary();
   
    public Emp_Month_Salary getSingleSalaryDetails(int emp_month_ID);
    
    public void editMonthSalaryDetails(Emp_Month_Salary emp_Month_Salary);
    
    public List<Retailer_Blacklist> getBlacklistedRetailerFinanceList();
    
    public void editBlacklistedRetailerStatus(String status, int retailerID);
    
    public Retailer getRetailer(int retailerID);
    
    public List<Retailer> getAllRetailers();

	public Supplier_Order getSingleSupplierOrderDetails(int supplierOrderID);
	
	public Supplier getSupplier(int supplierID);
	
	public List<Supplier_Order> getAllSupplierOrderDetails();

	public List<IncomeView> getAllIncomeViewDetails();

	public List<ExpenseView> getAllExpenseViewDetails();

	

}
