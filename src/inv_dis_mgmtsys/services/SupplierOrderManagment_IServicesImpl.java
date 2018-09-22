package inv_dis_mgmtsys.services;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import inv_dis_mgmtsys.dao.SupplierOderManagment_IDAOImpl;
import inv_dis_mgmtsys.model.Item;
import inv_dis_mgmtsys.model.Supplier_Order;
import inv_dis_mgmtsys.model.Supplier;

@Service
public class SupplierOrderManagment_IServicesImpl implements SupplierOrderManagment_IServices{

	@Autowired
	SupplierOderManagment_IDAOImpl orderMan;
	
	@Override
	public List<Item> getItems() {
		List<Item> item=orderMan.getItems(); 
		return item;
		
	}

	@Override
	public void placeTheOrder(Supplier_Order supplyItem) {

		orderMan.placeTheOrder(supplyItem);
	}

	@Override
	public List<Supplier_Order> getSupplierOrders(int StorManagerID) {
		
		 List<Supplier_Order> Supplier_Order=orderMan.getSupplierOrders(StorManagerID);
		 
		 for(Supplier_Order i:Supplier_Order) {
			 Item item=orderMan.getItem(i.getItem_code());
			 i.setItemname(item.getItem_name());
		 }
	
		 return Supplier_Order;
	
	}

	@Override
	public Supplier_Order getSupplierOrder(int orderId) {
		
		Supplier_Order supplier_Order=orderMan.getSupplierOrder(orderId);
		Item item=orderMan.getItem(supplier_Order.getItem_code());
		Supplier supplier=orderMan.getSupplier(supplier_Order.getSupplier_ID());
		supplier_Order.setItemname(item.getItem_name());
		supplier_Order.setSupplierName(supplier.getSupplier_name());
		
		return supplier_Order;
	}

	@Override
	public void orderRecived(int orderId) {
		
		Supplier_Order supplerOrder=orderMan.getSupplierOrder(orderId);
		supplerOrder.setOrder_Status("Recived");
		orderMan.UpdateSupplierOrder(supplerOrder);

		
	}

	
}
