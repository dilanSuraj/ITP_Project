package inv_dis_mgmtsys.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import inv_dis_mgmtsys.model.Item;
import inv_dis_mgmtsys.model.ItemsInCart;
import inv_dis_mgmtsys.model.OrderItem;
import inv_dis_mgmtsys.model.Payment;
import inv_dis_mgmtsys.model.Retailer_Order;
import inv_dis_mgmtsys.model.Supplier;
import inv_dis_mgmtsys.model.SupplierOrderItems;
import inv_dis_mgmtsys.model.Supplier_Order;
import inv_dis_mgmtsys.model.cart;

@Repository
public class OrderManagement_IDAOImpl implements OrderManagement_IDAO {

	@Autowired
	private SessionFactory sessionFactory;

	JdbcTemplate template;

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); 
	
	@Override
	public Item getItem(int itemcode) {
		System.out.println("inside dao ");

		return (Item) sessionFactory.getCurrentSession().get(Item.class, itemcode);

	}

	@Override
	public List<Item> getTyers() {

		@SuppressWarnings("unchecked")
		List<Item> list = (List<Item>) sessionFactory.getCurrentSession()
				.createQuery("from Item i where i.item_type='Tyers'").list();

		return list;
	}
	
	@Override
	public List<Item> getAllowyWheel() {

		@SuppressWarnings("unchecked")
		List<Item> list = (List<Item>) sessionFactory.getCurrentSession()
				.createQuery("from Item i where i.item_type='alloy'").list();

		return list;
	}
	
	@Override
	public List<Item> getBatteries() {

		@SuppressWarnings("unchecked")
		List<Item> list = (List<Item>) sessionFactory.getCurrentSession()
				.createQuery("from Item i where i.item_type='batteris'").list();

		return list;
	}
	
	

	@Override
	public void AddToCart(cart cartItem) {
		sessionFactory.getCurrentSession().saveOrUpdate(cartItem);
	}

	@Override
	public List<ItemsInCart> getCartItems(int userID) {

		Query query = sessionFactory.getCurrentSession().createQuery("from cart c where c.cart_retailer_ID=:id");
		query.setParameter("id", userID);
		List<cart> cartItems = (List<cart>) query.list();

		List<ItemsInCart> ItemsOfCart = new ArrayList<ItemsInCart>();

		System.out.println(userID);
		System.out.println(cartItems.toString());

		for (cart i : cartItems) {
			Query query2 = sessionFactory.getCurrentSession()
					.createQuery("from ItemsInCart i where i.item_itemcode=:id");
			int id = i.getCart_itemcode();
			query2.setInteger("id", id);
			ItemsInCart data = (ItemsInCart) query2.list().get(0);
			data.setItem_amount(i.getCart_amount());
			data.setCart_ID(i.getCart_ID());
			ItemsOfCart.add(data);

		}

		return ItemsOfCart;
	}

	@Override
	public void deleteCartItems(int cartID) {

		cart cartItem = (cart) sessionFactory.getCurrentSession().get(cart.class, cartID);
		sessionFactory.getCurrentSession().delete(cartItem);

	}

	@Override
	public List<Supplier> getSuppliers() {
		@SuppressWarnings("unchecked")
		List<Supplier> SupplierList = (List<Supplier>) sessionFactory.getCurrentSession().createQuery("from Supplier")
				.list();

		return SupplierList;
	}

	public void addSupplierOrder(int SupplierId) {

		Supplier_Order supplierOrder = new Supplier_Order();
		supplierOrder.setSupplier_ID(SupplierId);
		sessionFactory.getCurrentSession().saveOrUpdate(supplierOrder);

	}

	@Override
	public void addSupplierOrderItem(int SupplierId, String ItemName, int amount) {

		Query query = sessionFactory.getCurrentSession()
				.createQuery("from Supplier_Order o where o.supplier_ID=:SupplierId");
		query.setParameter("SupplierId", SupplierId);
		List<Supplier_Order> supplierOrders = (List<Supplier_Order>) query.list();

		Supplier_Order supplierOrder = new Supplier_Order();

		if (supplierOrders.isEmpty()) {

			System.out.println("order table null");
			addSupplierOrder(SupplierId);
		}

		supplierOrder = (Supplier_Order) query.list().get(0);

		SupplierOrderItems item = new SupplierOrderItems();

		item.setSupplier_order_ID(supplierOrder.getSupplier_OrderID());
		item.setSupplier_order_item_Name(ItemName);
		item.setSupplier_order_item_Amount(amount);

		sessionFactory.getCurrentSession().saveOrUpdate(item);

	}

	@Override
	public List<SupplierOrderItems> getSupplierOrderItem(int SupplierID) {
		
		Query query = sessionFactory.getCurrentSession()
				.createQuery("from Supplier_Order o where o.supplier_ID=:SupplierId");
		query.setParameter("SupplierId", SupplierID);
		Supplier_Order supplyorder = (Supplier_Order) query.list().get(0);
		
		Query query2 = sessionFactory.getCurrentSession().createQuery("from SupplierOrderItems s where s.supplier_order_ID=:id");
		query2.setParameter("id", supplyorder.getSupplier_OrderID());
		List<SupplierOrderItems> itemList = (List<SupplierOrderItems>)query2.list();

		return itemList;
		
	}

	@Override
	public void updateSupplierItem(int itemId, int amount) {
		
		Query query2 = sessionFactory.getCurrentSession().createQuery("from SupplierOrderItems s where s.supplier_order_ItemID=:id");
		query2.setParameter("id", itemId);
		SupplierOrderItems item = (SupplierOrderItems)query2.list().get(0);
		
		item.setSupplier_order_item_Amount(amount);
		sessionFactory.getCurrentSession().saveOrUpdate(item);
		
		
	}

	@Override
	public List<SupplierOrderItems> getOrderItemsFromSupplierOrderId(int SupplierOrderID) {
		Query query2 = sessionFactory.getCurrentSession().createQuery("from SupplierOrderItems s where s.supplier_order_ID=:id");
		query2.setParameter("id", SupplierOrderID);
		List<SupplierOrderItems> itemList = (List<SupplierOrderItems>)query2.list();

		return itemList;
	}

	@Override
	public List<Retailer_Order> getRetailerOrders(int retailerID) {
		
		Query query2 =sessionFactory.getCurrentSession().createQuery("from Retailer_Order r where r.retailer_ID=:id");
		query2.setParameter("id", retailerID);
		List<Retailer_Order> retailerOrders = (List<Retailer_Order>)query2.list();

		return retailerOrders;
	}

	@Override
	public void addtoOrder(int amount, int itemID,int RetailerID) {
	
		//check for the order
		Query query2 = sessionFactory.getCurrentSession().createQuery("from Retailer_Order r where r.retailer_ID=:id and r.retailer_orderstatus='Incomplete'");
		query2.setParameter("id", RetailerID);
		List<Retailer_Order> orders = (List<Retailer_Order>)query2.list();
		
	
			if(orders.isEmpty()) {
			Retailer_Order order=new Retailer_Order();
			order.setRetailer_ID(RetailerID);
			order.setRetailer_orderstatus("Incomplete");
			order.setOder_total(0);
			
			Date currentDate=new Date();		
			order.setOrder_date(currentDate);
			order.setRetailerorder_assigned_manager(0);
			sessionFactory.getCurrentSession().saveOrUpdate(order);
			
		}
		
		Retailer_Order order = (Retailer_Order)query2.list().get(0);
		
		OrderItem nitem=new OrderItem();
		nitem.setOrderItem_ID(order.getRetailer_OrderID());
		nitem.setOrderItem_itemcode(itemID);
		nitem.setOrderItem_unitscount(amount);
		nitem.setOrdertItem_order_ID(order.getRetailer_OrderID());
		
		Query query3 = sessionFactory.getCurrentSession().createQuery("from Item i where i.item_itemcode=:itemId");
		query3.setParameter("itemId", itemID);
		Item item = (Item)query3.list().get(0);
		
		nitem.setOderitem_totalcost(item.getItem_saleprice()*amount);
		
		order.setOder_total(order.getOder_total()+nitem.getOderitem_totalcost());
		System.out.print("the total price of the item is "+nitem.getOderitem_totalcost());
		sessionFactory.getCurrentSession().save(nitem);
		sessionFactory.getCurrentSession().saveOrUpdate(order);
		
	}

	@Override
	public List<OrderItem> getOrderItems(int orderID) {

		@SuppressWarnings("unchecked")
		Query query  = sessionFactory.getCurrentSession().createQuery("from OrderItem i where i.ordertItem_order_ID=:id");
		query.setParameter("id", orderID);
		List<OrderItem>items = (List<OrderItem>)query.list();
		for(OrderItem i: items){
			int itemID=i.getOrderItem_itemcode();
			Query query1=sessionFactory.getCurrentSession().createQuery("from Item i where i.item_itemcode=:id");
			query1.setParameter("id", itemID);
			System.out.println("item id "+itemID);
			Item selectedItem=(Item)query1.list().get(0);
			i.setItemName(selectedItem.getItem_name());	
			i.setUnitPrice(selectedItem.getItem_saleprice());
			
		}
		
		return items;
	}

	@Override
	public Retailer_Order getSpecificOrderDetails(int orderId) {
		
		Query query2 =sessionFactory.getCurrentSession().createQuery("from Retailer_Order r where r.retailer_OrderID=:id");
		query2.setParameter("id", orderId);
		Retailer_Order retailerOrders = (Retailer_Order)query2.list().get(0);

		return retailerOrders;
		
	}

	@Override
	public void checkOutRetailerOrder(int orderID) {
	
		Retailer_Order retailerOrders= getSpecificOrderDetails(orderID);
		retailerOrders.setRetailer_orderstatus("Inprocess");
		sessionFactory.getCurrentSession().saveOrUpdate(retailerOrders);
		
	}

	@Override
	public void DeleteOrderItem(int orderItemID) {

		OrderItem orderitem = (OrderItem) sessionFactory.getCurrentSession().get(OrderItem.class, orderItemID);
		sessionFactory.getCurrentSession().delete(orderitem);
		
	}
	
	

}
