package inv_dis_mgmtsys.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import inv_dis_mgmtsys.model.Item;
import inv_dis_mgmtsys.model.ItemsInCart;
import inv_dis_mgmtsys.model.Payment;
import inv_dis_mgmtsys.model.Supplier;
import inv_dis_mgmtsys.model.SupplierOrderItems;
import inv_dis_mgmtsys.model.Supplier_Order;
import inv_dis_mgmtsys.model.cart;

@Repository
public class OrderManagement_IDAOImpl implements OrderManagement_IDAO {

	@Autowired
	private SessionFactory sessionFactory;

	JdbcTemplate template;

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

		//item.setSupplier_order_ID(supplierOrder.getSupplier_OrderID());
		//item.setSupplier_order_item_Name(ItemName);
		//item.setSupplier_order_item_Amount(amount);

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

}
