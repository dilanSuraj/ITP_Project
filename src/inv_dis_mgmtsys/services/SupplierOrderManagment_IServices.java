package inv_dis_mgmtsys.services;

import inv_dis_mgmtsys.model.Item ;
import inv_dis_mgmtsys.model.Supplier_Order;

import java.util.List;



public interface SupplierOrderManagment_IServices {

	public List<Item> getItems();
	
	public void placeTheOrder(Supplier_Order supplyItem);
	
	public List<Supplier_Order> getSupplierOrders(int StorManagerID);
	
	public Supplier_Order getSupplierOrder(int orderId);
	
	public void orderRecived(int orderId);
}
