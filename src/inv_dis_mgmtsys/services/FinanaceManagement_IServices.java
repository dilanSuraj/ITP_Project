package inv_dis_mgmtsys.services;

import java.util.List;

import inv_dis_mgmtsys.model.DataPoint;
import inv_dis_mgmtsys.model.Emp_Month_Salary;
import inv_dis_mgmtsys.model.Finance;
import inv_dis_mgmtsys.model.Item;
import inv_dis_mgmtsys.model.Payment;
import inv_dis_mgmtsys.model.Retailer;
import inv_dis_mgmtsys.model.Retailer_Blacklist;
import inv_dis_mgmtsys.model.Retailer_Order;
import inv_dis_mgmtsys.model.Vehicle;

public interface FinanaceManagement_IServices {

	
    public void addPaymentDetails(Finance finance);
		
    public List<Finance> getAllPaymentDetails(String type);
    
    List<Payment> getPayments(String paymentCategory);

	public void deletePaymentDetails(String type,int paymentID);

	public void updatePaymentDetails(Finance finance, String type);

	public Finance getPaymentDetails(int paymentId,String type);
	
    public Item getSingleItemDetail(int ID);
	
	public List<Item> getAllItemDetails();
	
	public void editItemPrice(Item item);
		
	public List<DataPoint> getDataPoints(int initial_year);
		
	public List<Vehicle> getAllVehicleDetails();
	
	public List<Retailer_Order> getAllRetailerOrders();
	
	public List<Emp_Month_Salary> getAllEmpMonthSalary();
	   
    public Emp_Month_Salary getSingleSalaryDetails(int emp_month_ID);
    
    public void editMonthSalaryDetails(Emp_Month_Salary emp_Month_Salary);
    
    public Retailer getRetailer(int retailerID);
    
    public List<Retailer_Blacklist> getBlacklistedRetailerFinanceList();
    
    public void editBlacklistedRetailerStatus(String status, int retailerID);
}
