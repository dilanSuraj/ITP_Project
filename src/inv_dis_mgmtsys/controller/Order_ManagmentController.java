package inv_dis_mgmtsys.controller;

import java.util.List ;   

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import inv_dis_mgmtsys.model.Item;
import inv_dis_mgmtsys.model.ItemsInCart;
import inv_dis_mgmtsys.model.OrderItem;
import inv_dis_mgmtsys.model.cart;
import inv_dis_mgmtsys.model.Retailer_Order;
import inv_dis_mgmtsys.services.OrderManagement_IServicesImpl;

@Controller
@Transactional
public class Order_ManagmentController {

	@Autowired
	OrderManagement_IServicesImpl orderMan;

	public Order_ManagmentController() {
		
		
	}
	@RequestMapping("/ShoppingItem")
	public ModelAndView shoppingItem(@RequestParam("itemNo") int itemcode) {

		ModelAndView itempage = new ModelAndView();
		Item item = orderMan.getItem(itemcode);
		itempage.addObject("Item", item);
		itempage.setViewName("/OrderManagment/RetailerOrder/ShoppingItem");
		return itempage;

	}

	@RequestMapping("/tyers")
	public ModelAndView tyersList() {

		ModelAndView model = new ModelAndView();
		List<Item> tyerList = orderMan.getTyers();

		model.addObject("tyerList", tyerList);
		model.setViewName("/OrderManagment/RetailerOrder/Items");
		return model;
	}
	
	@RequestMapping("/alloywheel")
	public ModelAndView AllowywheelList() {

		ModelAndView model = new ModelAndView();
		List<Item> tyerList = orderMan.getAlloywheel();

		model.addObject("tyerList", tyerList);
		model.setViewName("/OrderManagment/RetailerOrder/Items");
		return model;
	}
	
	@RequestMapping("/batteries")
	public ModelAndView BatteryList() {

		ModelAndView model = new ModelAndView();
		List<Item> tyerList = orderMan.getbatteries();

		model.addObject("tyerList", tyerList);
		model.setViewName("/OrderManagment/RetailerOrder/Items");
		return model;
	}
	

	@RequestMapping("/add_to_cart")
	public ModelAndView AddToCart(@ModelAttribute("cart") cart CartItem) {

		boolean check=orderMan.AddToCart(CartItem);

		ModelAndView model = new ModelAndView();
		List<ItemsInCart> itemList = orderMan.getCartItems(50);
		if(check) {
			model.addObject("AddToCartCheck",1);
		}
		else {
			model.addObject("AlreadyInTheCart",3);
		}
		model.addObject("itemList", itemList);
		
		model.setViewName("/OrderManagment/RetailerOrder/RetailerCart");

		return model;
	}

	@RequestMapping("/RetailerCart")
	public ModelAndView RetailerCart() {

		ModelAndView model = new ModelAndView();
		List<ItemsInCart> itemList = orderMan.getCartItems(50);

		model.addObject("itemList", itemList);
		model.setViewName("/OrderManagment/RetailerOrder/RetailerCart");

		return model;
	}

	@RequestMapping("/DeleteCartItem")
	public ModelAndView DeleteCartItem(@RequestParam("cartID") int cartID) {

		orderMan.deleteCartItem(cartID);

		ModelAndView model = new ModelAndView();
		List<ItemsInCart> itemList = orderMan.getCartItems(50);

		model.addObject("itemList", itemList);
		model.addObject("DeleteItem",2);
		model.setViewName("/OrderManagment/RetailerOrder/RetailerCart");

		return model;
	}
	
	@RequestMapping("/RetailerAddToOrder")
	public ModelAndView AddtoOrderRetailer(@RequestParam("amount") int amount,@RequestParam("itemCode") int itemcode) {

		orderMan.addtoOrder(amount, itemcode,50);
		
		ModelAndView model1 = new ModelAndView();
		List<ItemsInCart> itemList = orderMan.getCartItems(50);

		model1.addObject("itemList", itemList);
		model1.setViewName("/OrderManagment/RetailerOrder/RetailerCart");

		return model1;
		
	}

	@RequestMapping("/RetailerOrderHistory")
	public ModelAndView RetailerOrderHistory() {

		ModelAndView model = new ModelAndView();
		List<Retailer_Order> oderlist = orderMan.getRetailerOrders(50);

		model.addObject("oderlist", oderlist);
		model.setViewName("/OrderManagment/RetailerOrder/RetailerOrderHistory");

		return model;
	}
	
	@RequestMapping("/ViewRorder")
	public ModelAndView viewRetailerOrder(@RequestParam("orderId") int orderID) {
		ModelAndView model =new ModelAndView();
		List<OrderItem> orderitems=orderMan.getOrderItems(orderID);
		Retailer_Order orderDetails=orderMan.getSpecificOrderDetails(orderID);
		
		model.addObject("itemList", orderitems);
		model.addObject("orderDetails", orderDetails);
		model.setViewName("/OrderManagment/RetailerOrder/RetailerOrder");
		return model;
	}
	
	@RequestMapping("/checkOutRetailerOrder")
	public ModelAndView checkOutRetailer(@RequestParam("orderID") int orderID) {
		
		Retailer_Order order=orderMan.checkOutRetailerOrder(orderID);
		ModelAndView model =new ModelAndView();
		model.addObject("OrderDetails",order);
		model.setViewName("OrderManagment/RetailerOrder/OrderCheckOut");
		return model;
		
	}
	
	@RequestMapping("/DeleteOrderItem")
	public ModelAndView DeleteOrderItem(@RequestParam("orderItemID") int orderItemID,@RequestParam("orderId") int orderID) {
		
		orderMan.DeleteOrderItem(orderItemID,orderID);

		ModelAndView model =new ModelAndView();
		List<OrderItem> orderitems=orderMan.getOrderItems(orderID);
		Retailer_Order orderDetails=orderMan.getSpecificOrderDetails(orderID);
		
		model.addObject("itemList", orderitems);
		model.addObject("orderDetails", orderDetails);
		model.setViewName("/OrderManagment/RetailerOrder/RetailerOrder");
		return model;
		
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handleMissingParams(Exception ex) {
	    ModelAndView model=new ModelAndView();
	   
	    model.setViewName("/OrderManagment/badRequest");
	    
	    return model;
	}

}
