package inv_dis_mgmtsys.services;

import java.util.List;

import inv_dis_mgmtsys.model.Finance;
import inv_dis_mgmtsys.model.Item;
import inv_dis_mgmtsys.model.Payment;

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
	
	 
		
}
