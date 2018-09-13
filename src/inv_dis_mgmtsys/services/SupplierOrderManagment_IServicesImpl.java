package inv_dis_mgmtsys.services;

import java.util.List;

import inv_dis_mgmtsys.dao.SupplierOderManagment_IDAO;
import inv_dis_mgmtsys.model.Item;
import inv_dis_mgmtsys.model.Supplier;



public class SupplierOrderManagment_IServicesImpl implements SupplierOrderManagment_IServices{

	SupplierOderManagment_IDAO orderMan;
	
	@Override
	public List<Item> getItems() {
		List<Item> item=orderMan.getItems(); 
		return item;
	}

	
}
