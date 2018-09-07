package inv_dis_mgmtsys.dao;

import java.util.List; 

import inv_dis_mgmtsys.model.Item;
import inv_dis_mgmtsys.model.ItemsInCart;
import inv_dis_mgmtsys.model.OrderItem;
import inv_dis_mgmtsys.model.Retailer_Order;
import inv_dis_mgmtsys.model.Supplier;
import inv_dis_mgmtsys.model.SupplierOrderItems;
import inv_dis_mgmtsys.model.cart;


public interface OrderManagement_IDAO {

	public Item getItem(int itemcode);
	
	public List<Item> getTyers();
	
	public List<Item> getAllowyWheel();
	
	public List<Item> getBatteries();
	
	public void AddToCart(cart cartItem);
	
	public List<ItemsInCart> getCartItems(int userID);
	
	public void deleteCartItems(int cartID);
	
	public List<Supplier> getSuppliers();
	
	public void addSupplierOrderItem(int SupplierId,String ItemName,int amount);

	public List<SupplierOrderItems> getSupplierOrderItem(int SupplierID);
	
	public List<SupplierOrderItems> getOrderItemsFromSupplierOrderId(int SupplierOrderID);
	
	public void updateSupplierItem(int itemId,int amount);
	
	public List<Retailer_Order> getRetailerOrders(int retailerID);
	
	public void addtoOrder(int amount,int itemID,int RetailerId);
	
	public List<OrderItem> getOrderItems(int orderID);
	
	public Retailer_Order getSpecificOrderDetails(int orderId);
	
	public void checkOutRetailerOrder(int orderID);

	public void DeleteOrderItem(int orderItemID);
}

