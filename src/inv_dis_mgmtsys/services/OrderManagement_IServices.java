package inv_dis_mgmtsys.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import inv_dis_mgmtsys.dao.OrderManagement_IDAOImpl;
import inv_dis_mgmtsys.model.Item;

@Service
public interface OrderManagement_IServices {

	public Item getItem(int itemcode);
}
