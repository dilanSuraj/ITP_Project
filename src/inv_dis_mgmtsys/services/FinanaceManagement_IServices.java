package inv_dis_mgmtsys.services;

import java.util.List;

import inv_dis_mgmtsys.model.Payment;

public interface FinanaceManagement_IServices {

	
	public void addPayments(Payment payment);
	
	public void editPayments(Payment payment);
	
	public void deletePayments(int paymentID);
	
	public List<Payment> getPayments(String paymentCategory);
	
	public Payment getPaymentDetails(int paymentID);
		
}
