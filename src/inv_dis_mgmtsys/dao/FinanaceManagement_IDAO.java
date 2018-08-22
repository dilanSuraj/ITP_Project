package inv_dis_mgmtsys.dao;

import java.util.List;

import inv_dis_mgmtsys.model.Finance;
import inv_dis_mgmtsys.model.Payment;


public interface FinanaceManagement_IDAO{

	
    void addFinance(Finance finance);
	
	public void editFinance(Finance finance,String type);
	
	public void deleteFinance(Finance finance);
	
	public List<Payment> getfinancebyCategory(String paymentCategory);
	
	public List<Finance> getAllFinanceDetails(String type);
	
	public Finance getSingleFinanceDetail(int paymentID,String type);

	
}
