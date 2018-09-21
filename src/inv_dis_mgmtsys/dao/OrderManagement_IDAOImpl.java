package inv_dis_mgmtsys.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import inv_dis_mgmtsys.model.Item;
import inv_dis_mgmtsys.model.ItemsInCart;
import inv_dis_mgmtsys.model.OrderItem;
import inv_dis_mgmtsys.model.Retailer_Order;
import inv_dis_mgmtsys.model.cart;

@Repository
public class OrderManagement_IDAOImpl implements OrderManagement_IDAO {

	@Autowired
	private SessionFactory sessionFactory;



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

		@SuppressWarnings("unchecked")
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
	public List<Retailer_Order> getRetailerOrders(int retailerID) {

		Query query2 = sessionFactory.getCurrentSession().createQuery("from Retailer_Order r where r.retailer_ID=:id");
		query2.setParameter("id", retailerID);

		@SuppressWarnings("unchecked")
		List<Retailer_Order> retailerOrders = (List<Retailer_Order>) query2.list();

		return retailerOrders;
	}

	@Override
	public void addtoOrder(int amount, int itemID, int RetailerID) {

		// check for the order
		Query query2 = sessionFactory.getCurrentSession()
				.createQuery("from Retailer_Order r where r.retailer_ID=:id and r.retailer_orderstatus='Incomplete'");
		query2.setParameter("id", RetailerID);

		@SuppressWarnings("unchecked")
		List<Retailer_Order> orders = (List<Retailer_Order>) query2.list();

		if (orders.isEmpty()) {
			Retailer_Order order = new Retailer_Order();
			order.setRetailer_ID(RetailerID);
			order.setRetailer_orderstatus("Incomplete");
			order.setOder_total(0);

			Date currentDate = new Date();
			
			order.setOrder_date(currentDate);
			order.setRetailerorder_assigned_manager(0);
			sessionFactory.getCurrentSession().saveOrUpdate(order);

		}

		Retailer_Order order = (Retailer_Order) query2.list().get(0);

		OrderItem nitem = new OrderItem();
		nitem.setOrderItem_ID(order.getRetailer_OrderID());
		nitem.setOrderItem_itemcode(itemID);
		nitem.setOrderItem_unitscount(amount);
		nitem.setOrdertItem_order_ID(order.getRetailer_OrderID());

		Query query3 = sessionFactory.getCurrentSession().createQuery("from Item i where i.item_itemcode=:itemId");
		query3.setParameter("itemId", itemID);
		Item item = (Item) query3.list().get(0);

		nitem.setOderitem_totalcost(item.getItem_saleprice() * amount);

		order.setOder_total(order.getOder_total() + nitem.getOderitem_totalcost());
		System.out.print("the total price of the item is " + nitem.getOderitem_totalcost());
		sessionFactory.getCurrentSession().save(nitem);
		sessionFactory.getCurrentSession().saveOrUpdate(order);

	}

	@Override
	public List<OrderItem> getOrderItems(int orderID) {

		Query query = sessionFactory.getCurrentSession()
				.createQuery("from OrderItem i where i.ordertItem_order_ID=:id");
		query.setParameter("id", orderID);

		@SuppressWarnings("unchecked")
		List<OrderItem> items = (List<OrderItem>) query.list();
		for (OrderItem i : items) {
			int itemID = i.getOrderItem_itemcode();
			Query query1 = sessionFactory.getCurrentSession().createQuery("from Item i where i.item_itemcode=:id");
			query1.setParameter("id", itemID);
			System.out.println("item id " + itemID);
			Item selectedItem = (Item) query1.list().get(0);
			i.setItemName(selectedItem.getItem_name());
			i.setUnitPrice(selectedItem.getItem_saleprice());

		}

		return items;
	}

	// get retailer Order Details of a specific order
	@Override
	public Retailer_Order getSpecificOrderDetails(int orderId) {

		Query query2 = sessionFactory.getCurrentSession()
				.createQuery("from Retailer_Order r where r.retailer_OrderID=:id");
		query2.setParameter("id", orderId);
		Retailer_Order retailerOrders = (Retailer_Order) query2.list().get(0);

		return retailerOrders;

	}

	@Override
	public Retailer_Order checkOutRetailerOrder(int orderID) {

		Retailer_Order retailerOrders = getSpecificOrderDetails(orderID);
		retailerOrders.setRetailer_orderstatus("Inprocess");

		Date currentDate = new Date();
		retailerOrders.setOrder_date(currentDate);
		sessionFactory.getCurrentSession().saveOrUpdate(retailerOrders);
		return retailerOrders;
	}

	@Override
	public double DeleteOrderItem(int orderItemID) {

		OrderItem orderitem = (OrderItem) sessionFactory.getCurrentSession().get(OrderItem.class, orderItemID);
		double ItemTotal = orderitem.getOderitem_totalcost();
		sessionFactory.getCurrentSession().delete(orderitem);
		return ItemTotal;
	}

	@Override
	public void updateRetailerOrder(Retailer_Order retailerOrder) {

		sessionFactory.getCurrentSession().saveOrUpdate(retailerOrder);

	}

	@Override
	public boolean checkCartItemexist(cart Cart) {
		int retailerID = Cart.getCart_retailer_ID();
		int itemID = Cart.getCart_itemcode();

		Query query2 = sessionFactory.getCurrentSession()
				.createQuery("from cart c where c.cart_retailer_ID=:rid and c.cart_itemcode=:itemID");
		query2.setParameter("rid", retailerID);
		query2.setParameter("itemID", itemID);
		boolean CartItem= query2.uniqueResult() !=null;
		
		if(CartItem ==false) {
			return false;
		}
		else {
			return true;
		}

	}
}
