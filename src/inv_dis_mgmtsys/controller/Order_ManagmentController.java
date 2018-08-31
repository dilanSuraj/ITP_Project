package inv_dis_mgmtsys.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import inv_dis_mgmtsys.dao.OrderManagement_IDAOImpl;
import inv_dis_mgmtsys.model.Item;
import inv_dis_mgmtsys.model.ItemsInCart;
import inv_dis_mgmtsys.model.Payment;
import inv_dis_mgmtsys.model.Supplier;
import inv_dis_mgmtsys.model.SupplierOrderItems;
import inv_dis_mgmtsys.model.cart;
import inv_dis_mgmtsys.services.OrderManagement_IServicesImpl;

@Controller
@Transactional
public class Order_ManagmentController {

	@Autowired
	OrderManagement_IServicesImpl orderMan;

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

	@RequestMapping("/add_to_cart")
	public ModelAndView AddToCart(@ModelAttribute("cart") cart CartItem) {

		orderMan.AddToCart(CartItem);

		ModelAndView model = new ModelAndView();
		List<Item> tyerList = orderMan.getTyers();

		model.addObject("tyerList", tyerList);
		model.setViewName("/OrderManagment/RetailerOrder/Items");
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
		model.setViewName("/OrderManagment/RetailerOrder/RetailerCart");

		return model;
	}

	@RequestMapping("/RetailerOrderHistory")
	public ModelAndView RetailerOrderHistory() {

		// System.out.println("shopping item");
		return new ModelAndView("/OrderManagment/RetailerOrder/RetailerOrderHistory");
	}

	@RequestMapping("/RetailerOrder")
	public ModelAndView RetailerOrder() {

		// System.out.println("shopping item");
		return new ModelAndView("/OrderManagment/RetailerOrder/RetailerOrder");
	}

	@RequestMapping("/StoreManagerSuppliers")
	public ModelAndView StoreManagerSuppliers() {

		ModelAndView model = new ModelAndView();
		List<Supplier> SupplierList = orderMan.getSuppliers();

		model.addObject("SupplierList", SupplierList);
		model.setViewName("/OrderManagment/SupplierOrder/SuppliersStoreManager");

		return model;

	}

	@RequestMapping("/SupplierOrderitem")
	public ModelAndView SupplierOrderitem() {

		ModelAndView model = new ModelAndView();
		List<Supplier> SupplierList = orderMan.getSuppliers();

		model.addObject("SupplierList", SupplierList);
		model.setViewName("/OrderManagment/SupplierOrder/SupplierOrderitem");

		return model;
	}

	@RequestMapping("/addSupplyOrderItem")
	public ModelAndView addSupplierOrderItem(@RequestParam("Supplier") int SupplierId,
			@RequestParam("itemName") String ItemName, @RequestParam("amount") int amount) {

		orderMan.addSupplierOrderItem(SupplierId, ItemName, amount);
		return new ModelAndView("/OrderManagment/SupplierOrder/SupplierOrderitem");

	}

	@RequestMapping("/UpdateSupplierOrder")
	public ModelAndView UpdateSupplierOrder() {

		ModelAndView model = new ModelAndView();
		List<Supplier> SupplierList = orderMan.getSuppliers();

		model.addObject("SupplierList", SupplierList);
		model.setViewName("/OrderManagment/SupplierOrder/UpdateSupplierOrder");

		return model;
	}

	@RequestMapping("/SupplierOrderRefresh")
	public ModelAndView getSupplierOrderItem(@RequestParam("SupplierID") int SupplierID) {

		ModelAndView model1 = new ModelAndView();
		List<SupplierOrderItems> SupplierOrderItems = orderMan.getSupplierOrderItem(SupplierID);
		List<Supplier> SupplierList = orderMan.getSuppliers();
		model1.addObject("SupplierOrderItems", SupplierOrderItems);

		model1.addObject("SupplierList", SupplierList);
		model1.setViewName("/OrderManagment/SupplierOrder/UpdateSupplierOrder");

		return model1;

	}
	
	@RequestMapping("/SOrderitemUpdate")
	public ModelAndView updateSupplierOrderItem(@RequestParam("supplier_order_ItemID") int itemID,
			@RequestParam("supplier_order_item_Amount")int amount,
			@RequestParam("supplier_order_ID")int orderId){
	
		orderMan.updateSupplierItem(itemID, amount);
		
		ModelAndView model1 = new ModelAndView();
		List<SupplierOrderItems> SupplierOrderItems = orderMan.getOrderItemsFromSupplierOrderId(orderId);
		List<Supplier> SupplierList = orderMan.getSuppliers();
		model1.addObject("SupplierOrderItems", SupplierOrderItems);

		model1.addObject("SupplierList", SupplierList);
		model1.setViewName("/OrderManagment/SupplierOrder/UpdateSupplierOrder");

		return model1;
	}

}
