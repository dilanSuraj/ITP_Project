package inv_dis_mgmtsys.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import inv_dis_mgmtsys.dao.FinanaceManagement_IDAOImpl;
import inv_dis_mgmtsys.model.Finance;
import inv_dis_mgmtsys.model.Payment;


@Service
public class FinanaceManagement_IServicesImpl implements FinanaceManagement_IServices{

	@Autowired
	FinanaceManagement_IDAOImpl finanaceManagerIDAO;

	@Override
	public void addPaymentDetails(Finance finance) {
		finanaceManagerIDAO.addFinance(finance);		
	}

	
	@Override
	public List<Payment> getPayments(String paymentCategory) {
		List<Payment> payments = finanaceManagerIDAO.getfinancebyCategory(paymentCategory);
		return payments;
	}

	@Override
	public List<Finance> getAllPaymentDetails(String type) {
		
		return finanaceManagerIDAO.getAllFinanceDetails(type);
	
	}

	@Override
	public void deletePaymentDetails(String type,int paymentID) {
		
	    Finance finance = finanaceManagerIDAO.getSingleFinanceDetail(paymentID, type);		
		finanaceManagerIDAO.deleteFinance(finance);
		return;
	}

	@Override
	public void updatePaymentDetails(Finance finance, String type) {
		finanaceManagerIDAO.editFinance(finance, type);
		return;
	}

	@Override
	public Finance getPaymentDetails(int paymentId,String type) {
		
		return finanaceManagerIDAO.getSingleFinanceDetail(paymentId, type);
		
	}
	
	

}
