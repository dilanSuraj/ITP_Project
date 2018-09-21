package inv_dis_mgmtsys.services;

import java.util.List;  

import org.springframework.stereotype.Service;

import inv_dis_mgmtsys.model.Item;
import inv_dis_mgmtsys.model.ItemsInCart;
import inv_dis_mgmtsys.model.OrderItem;
import inv_dis_mgmtsys.model.Retailer_Order;
import inv_dis_mgmtsys.model.cart;

@Service
public interface OrderManagement_IServices {

	public Item getItem(int itemcode);
	
	public List<Item> getTyers();
	
	public List<Item> getAlloywheel();
	
	public List<Item> getbatteries();
	
	public boolean AddToCart(cart CartItem);
	
	public List<ItemsInCart> getCartItems(int userID);
	
	public void deleteCartItem(int cartID);
	
	public List<Retailer_Order> getRetailerOrders(int retailerID);
	
	public void addtoOrder(int amount, int itemID,int RetailerID);
	
	public List<OrderItem> getOrderItems(int orderID);
	
	public Retailer_Order getSpecificOrderDetails(int orderId);
	
	public Retailer_Order checkOutRetailerOrder(int orderID);
	
	public void DeleteOrderItem(int orderItemID,int OrderID);
}
