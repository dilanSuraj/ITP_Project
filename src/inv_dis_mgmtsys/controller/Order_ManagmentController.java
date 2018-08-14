package inv_dis_mgmtsys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Order_ManagmentController {

	@RequestMapping("/ShoppingItem")
	public ModelAndView shoppingItem() {
		
		//System.out.println("shopping item");
	    return new ModelAndView("/OrderManagment/RetailerOrder/ShoppingItem");
	}
	
	@RequestMapping("/RetailerOrderHistory")
	public ModelAndView RetailerOrderHistory() {
		
		//System.out.println("shopping item");
	    return new ModelAndView("/OrderManagment/RetailerOrder/RetailerOrderHistory");
	}
	
	@RequestMapping("/RetailerCart")
	public ModelAndView RetailerCart() {
		
		//System.out.println("shopping item");
	    return new ModelAndView("/OrderManagment/RetailerOrder/RetailerCart");
	}
	
	@RequestMapping("/RetailerOrder")
	public ModelAndView RetailerOrder() {
		
		//System.out.println("shopping item");
	    return new ModelAndView("/OrderManagment/RetailerOrder/RetailerOrder");
	}
	
	@RequestMapping("/tyers")
	public ModelAndView tyerspage() {
		
		//System.out.println("shopping item");
	    return new ModelAndView("/OrderManagment/RetailerOrder/Items");
	}
	
	@RequestMapping("/StoreManagerSuppliers")
	public ModelAndView StoreManagerSuppliers() {
		
		//System.out.println("shopping item");
	    return new ModelAndView("/OrderManagment/SupplierOrder/SuppliersStoreManager");
	}
	
	@RequestMapping("/SupplierOrderitem")
	public ModelAndView SupplierOrderitem() {
		
		//System.out.println("shopping item");
	    return new ModelAndView("/OrderManagment/SupplierOrder/SupplierOrderitem");
	}
	
	
	@RequestMapping("/UpdateSupplierOrder")
	public ModelAndView UpdateSupplierOrder() {
		
		//System.out.println("shopping item");
	    return new ModelAndView("/OrderManagment/SupplierOrder/UpdateSupplierOrder");
	}
}
