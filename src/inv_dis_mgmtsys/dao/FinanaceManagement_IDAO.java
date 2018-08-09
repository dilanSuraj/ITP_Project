package inv_dis_mgmtsys.dao;

import java.util.List;

import inv_dis_mgmtsys.model.Payment;

public interface FinanaceManagement_IDAO {
	
	public void addPaymentDetails(Payment payment);

	public List<Payment> getTransportPayments();
	
	public List<Payment> getIncomePayments();
	
	public List<Payment> getExpensesPayments();

	public void deletePaymentDetails(Payment payment);

	public Payment updatePaymentDetails(Payment payment);

	public Payment getPaymentDetails(int paymentId);
	

}
