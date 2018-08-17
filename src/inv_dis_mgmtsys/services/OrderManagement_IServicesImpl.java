package inv_dis_mgmtsys.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import inv_dis_mgmtsys.dao.OrderManagement_IDAOImpl;
import inv_dis_mgmtsys.model.Item;

public class OrderManagement_IServicesImpl implements OrderManagement_IServices{

	@Autowired
	private OrderManagement_IDAOImpl item;
	@Override
	@Transactional
	public Item getItem(int itemcode) {

		System.out.println("inside service ");
		//Item chec=ordermange.getItem(itemcode);
		System.out.println("out form idao");
		return item.getItem(itemcode);
	}
	
	

}
 