package inv_dis_mgmtsys.dao;

import org.hibernate.Query;
import org.hibernate.Session; 
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import inv_dis_mgmtsys.model.Item;

@Repository
public class OrderManagement_IDAOImpl implements OrderManagement_IDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Item getItem(int itemcode) {

		System.out.println("inside dao ");

		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("from item i WHERE i.item_itemcode=:item_itemcode");		// HQL
		q.setParameter("item_itemcode", itemcode);
		
		Item result=(Item)q.uniqueResult();
		System.out.println(result.getItem_name());
		return result;

		}
	
	
	}



	

