package inv_dis_mgmtsys.services;

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
	

}
