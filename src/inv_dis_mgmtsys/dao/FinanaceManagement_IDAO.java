package inv_dis_mgmtsys.dao;

import java.util.List;

import inv_dis_mgmtsys.model.Payment;

public interface FinanaceManagement_IDAO {

	public void addPaymentDetails(Payment payment);

	public List<Payment> getPayments(String paymentCategory);

	public void deletePaymentDetails(int paymentID);

	public void updatePaymentDetails(Payment payment);

	public Payment getPaymentDetails(int paymentId);

}
