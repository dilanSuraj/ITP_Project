package inv_dis_mgmtsys.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import inv_dis_mgmtsys.model.Payment;

@Repository
public class FinanaceManagement_IDAOImpl implements FinanaceManagement_IDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	JdbcTemplate template;  
	@Override
	public void addPaymentDetails(Payment payment) {
		
		sessionFactory.getCurrentSession().saveOrUpdate(payment);
	}

	
	@Override
	public List<Payment> getPayments(String paymentCategory) {
		
		
		@SuppressWarnings("unchecked")
		List<Payment> list = (List<Payment>)sessionFactory.getCurrentSession().createQuery("from Payment").list();
				
	
		return list;
		
		 
	}

	

	@Override
	public void deletePaymentDetails(int paymentID) {
		
		Payment payment = (Payment) sessionFactory.getCurrentSession().get(Payment.class,paymentID);
	 
		System.out.println("Delete:::"+payment.getOther_income_expense_amount());
		sessionFactory.getCurrentSession().delete(payment);
		
	}

	@Override
	public void updatePaymentDetails(Payment payment) {
		
		sessionFactory.getCurrentSession().saveOrUpdate(payment);
		return;
	}

	@Override
	public Payment getPaymentDetails(int paymentId) {
		
		return (Payment)sessionFactory.getCurrentSession().get(Payment.class,paymentId);
	}

}
