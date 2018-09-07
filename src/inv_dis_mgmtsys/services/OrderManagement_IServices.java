package inv_dis_mgmtsys.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import inv_dis_mgmtsys.dao.OrderManagement_IDAOImpl;
import inv_dis_mgmtsys.model.Item;
import inv_dis_mgmtsys.model.ItemsInCart;
import inv_dis_mgmtsys.model.OrderItem;
import inv_dis_mgmtsys.model.Payment;
import inv_dis_mgmtsys.model.Retailer_Order;
import inv_dis_mgmtsys.model.Supplier;
import inv_dis_mgmtsys.model.SupplierOrderItems;
import inv_dis_mgmtsys.model.cart;

@Service
public interface OrderManagement_IServices {

	public Item getItem(int itemcode);
	
	public List<Item> getTyers();
	
	public List<Item> getAlloywheel();
	
	public List<Item> getbatteries();
	
	public void AddToCart(cart CartItem);
	
	public List<ItemsInCart> getCartItems(int userID);
	
	public void deleteCartItem(int cartID);
	
	public List<Supplier> getSuppliers();
	
	public void addSupplierOrderItem(int SupplierId,String ItemName,int amount);
	
	public List<SupplierOrderItems> getSupplierOrderItem(int SupplierID);
	
	public void updateSupplierItem(int itemId, int amount); 
	
	public List<SupplierOrderItems> getOrderItemsFromSupplierOrderId(int SupplierOrderID);
	
	public List<Retailer_Order> getRetailerOrders(int retailerID);
	
	public void addtoOrder(int amount, int itemID,int RetailerID);
	
	public List<OrderItem> getOrderItems(int orderID);
	
	public Retailer_Order getSpecificOrderDetails(int orderId);
	
	public void checkOutRetailerOrder(int orderID);
	
	public void DeleteOrderItem(int orderItemID);
}
