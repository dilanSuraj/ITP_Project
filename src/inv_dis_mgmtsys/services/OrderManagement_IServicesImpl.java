package inv_dis_mgmtsys.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import inv_dis_mgmtsys.dao.OrderManagement_IDAOImpl;
import inv_dis_mgmtsys.model.Item;
import inv_dis_mgmtsys.model.ItemsInCart;
import inv_dis_mgmtsys.model.Payment;
import inv_dis_mgmtsys.model.Supplier;
import inv_dis_mgmtsys.model.SupplierOrderItems;
import inv_dis_mgmtsys.model.cart;

@Service
public class OrderManagement_IServicesImpl implements OrderManagement_IServices {

	@Autowired
	OrderManagement_IDAOImpl orderMan;

	@Override
	public Item getItem(int itemcode) {

		Item item = orderMan.getItem(itemcode);
		return item;
	}

	@Override
	public List<Item> getTyers() {

		List<Item> tyers = orderMan.getTyers();
		return tyers;
	}

	@Override
	public void AddToCart(cart CartItem) {
		orderMan.AddToCart(CartItem);
	}

	@Override
	public List<ItemsInCart> getCartItems(int userID) {
		 List<ItemsInCart> cartItems=orderMan.getCartItems(userID); 
		return cartItems;
	}

	@Override
	public void deleteCartItem(int cartID) {
	
		orderMan.deleteCartItems(cartID);
	}

	@Override
	public List<Supplier> getSuppliers() {
		List<Supplier> SupplierList=orderMan.getSuppliers();
		return SupplierList;
	}

	@Override
	public void addSupplierOrderItem(int SupplierId, String ItemName, int amount) {
		orderMan.addSupplierOrderItem(SupplierId, ItemName, amount);
	}

	@Override
	public List<SupplierOrderItems> getSupplierOrderItem(int SupplierID) {
		List<SupplierOrderItems> SupplierOrderItems=orderMan.getSupplierOrderItem(SupplierID);
		return SupplierOrderItems;
	}

	@Override
	public void updateSupplierItem(int itemId, int amount) {
	
		orderMan.updateSupplierItem(itemId, amount);
	}

	@Override
	public List<SupplierOrderItems> getOrderItemsFromSupplierOrderId(int SupplierOrderID) {
		
		List<SupplierOrderItems> SupplierOrderItems=orderMan.getOrderItemsFromSupplierOrderId(SupplierOrderID);
		return SupplierOrderItems;
	}
	

}
