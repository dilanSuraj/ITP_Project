package inv_dis_mgmtsys.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import inv_dis_mgmtsys.dao.FinanaceManagement_IDAO;
import inv_dis_mgmtsys.dao.FinanaceManagement_IDAOImpl;
import inv_dis_mgmtsys.model.Payment;

@Service
public class FinanaceManagement_IServicesImpl implements FinanaceManagement_IServices{

	@Autowired
	FinanaceManagement_IDAOImpl finanaceManagerIDAO;
	
	@Override
	public void addPayments(Payment payment) {
		
		finanaceManagerIDAO.addPaymentDetails(payment);
		
	}

	@Override
	public void editPayments(Payment payment) {
		finanaceManagerIDAO.updatePaymentDetails(payment);
		
	}

	@Override
	public void deletePayments(int paymentID) {
		
		finanaceManagerIDAO.deletePaymentDetails(paymentID);
		
	}

	@Override
	public List<Payment> getPayments(String paymentCategory) {
		
		List<Payment> payments = finanaceManagerIDAO.getPayments(paymentCategory);
		return payments;
	}

	@Override
	public Payment getPaymentDetails(int paymentID) {
		
		Payment payment = finanaceManagerIDAO.getPaymentDetails(paymentID);
		return payment;
	}
	

}
