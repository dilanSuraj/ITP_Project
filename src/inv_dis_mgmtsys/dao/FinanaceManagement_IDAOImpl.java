package inv_dis_mgmtsys.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import inv_dis_mgmtsys.model.Payment;

@Repository
public class FinanaceManagement_IDAOImpl implements FinanaceManagement_IDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addPaymentDetails(Payment payment) {
		
		sessionFactory.getCurrentSession().saveOrUpdate(payment);
	}

	@Override
	public List<Payment> getTransportPayments() {
		
		return null;
	}

	@Override
	public List<Payment> getIncomePayments() {
		
		return null;
	}

	@Override
	public List<Payment> getExpensesPayments() {
		
		return null;
	}

	@Override
	public void deletePaymentDetails(Payment payment) {
		
		sessionFactory.getCurrentSession().delete(payment);
		
	}

	@Override
	public Payment updatePaymentDetails(Payment payment) {
		
		sessionFactory.getCurrentSession().update(payment);
		return payment;
	}

	@Override
	public Payment getPaymentDetails(int paymentId) {
		
		return (Payment)sessionFactory.getCurrentSession().get(Payment.class,paymentId);
	}

}
