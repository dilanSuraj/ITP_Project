package inv_dis_mgmtsys.services;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import inv_dis_mgmtsys.dao.OrderManagement_IDAOImpl;
import inv_dis_mgmtsys.model.Item;
import inv_dis_mgmtsys.model.ItemsInCart;
import inv_dis_mgmtsys.model.OrderItem;
import inv_dis_mgmtsys.model.Retailer_Order;
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
	public boolean AddToCart(cart CartItem) {

		if (orderMan.checkCartItemexist(CartItem) == false) {
			orderMan.AddToCart(CartItem);
			return true;
		} else{
			return false;
		}
	}

	@Override
	public List<ItemsInCart> getCartItems(int userID) {
		List<ItemsInCart> cartItems = orderMan.getCartItems(userID);
		return cartItems;
	}

	@Override
	public void deleteCartItem(int cartID) {

		orderMan.deleteCartItems(cartID);
	}

	@Override
	public List<Retailer_Order> getRetailerOrders(int retailerID) {
		List<Retailer_Order> retailerOrders = orderMan.getRetailerOrders(retailerID);
		return retailerOrders;
	}

	@Override
	public void addtoOrder(int amount, int itemID, int RetailerID) {
		orderMan.addtoOrder(amount, itemID, RetailerID);

	}

	@Override
	public List<Item> getAlloywheel() {
		List<Item> alloywheel = orderMan.getAllowyWheel();
		return alloywheel;
	}

	@Override
	public List<Item> getbatteries() {
		List<Item> battaries = orderMan.getBatteries();
		return battaries;
	}

	@Override
	public List<OrderItem> getOrderItems(int orderID) {
		List<OrderItem> items = orderMan.getOrderItems(orderID);
		return items;
	}

	@Override
	public Retailer_Order getSpecificOrderDetails(int orderId) {
		Retailer_Order retailerOrders = orderMan.getSpecificOrderDetails(orderId);
		return retailerOrders;
	}

	@Override
	public Retailer_Order checkOutRetailerOrder(int orderID) {
		Retailer_Order order = orderMan.checkOutRetailerOrder(orderID);
		return order;
	}

	@Override
	public void DeleteOrderItem(int orderItemID, int OrderID) {

		double orderItemcost = orderMan.DeleteOrderItem(orderItemID);
		Retailer_Order orderToUpdate = orderMan.getSpecificOrderDetails(OrderID);

		orderToUpdate.setOder_total(orderToUpdate.getOder_total() - orderItemcost);
		orderMan.updateRetailerOrder(orderToUpdate);

	}


}
