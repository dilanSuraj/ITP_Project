package inv_dis_mgmtsys.dao;

import java.util.List;

import inv_dis_mgmtsys.model.Item;

import inv_dis_mgmtsys.model.Supplier;
import inv_dis_mgmtsys.model.Supplier_Order;

public interface SupplierOderManagment_IDAO {

	public List<Item> getItems();
	
	public void placeTheOrder(Supplier_Order supplyItem);
	
	public List<Supplier_Order> getSupplierOrders(int StorManagerID);
	
	public Item getItem(int ItemId);
	
	public Supplier_Order getSupplierOrder(int orderId);
	
	public Supplier getSupplier(int supplierId);
	
	public void UpdateSupplierOrder(Supplier_Order supplerOrder);
}
