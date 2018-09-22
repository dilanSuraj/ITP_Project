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
import inv_dis_mgmtsys.model.Supplier_Order;
import inv_dis_mgmtsys.services.SupplierOrderManagment_IServicesImpl;

@Controller
@Transactional
public class SupplierOrderManagmentController {

	@Autowired
	SupplierOrderManagment_IServicesImpl iServices;

	@RequestMapping("/orderNewItem")
	public ModelAndView getItems() {

		List<Item> items = iServices.getItems();

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("Items", items);
		modelAndView.setViewName("OrderManagment/SupplierOrder/OrderNewStocks");

		return modelAndView;

	}

	@RequestMapping("/SelectedItem")
	public ModelAndView getOrderItem(@ModelAttribute("Item") Item item) {

		Item Items = item;

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("Items", Items);
		modelAndView.setViewName("/OrderManagment/SupplierOrder/SupplierOrderitem");

		return modelAndView;
	}
	
	@RequestMapping("/placeTheOrder")
	public ModelAndView placeTheOrder(@ModelAttribute("Suppler_Order") Supplier_Order supplyOrder) {
		
		iServices.placeTheOrder(supplyOrder);
		
		List<Item> items = iServices.getItems();

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("Items", items);
		modelAndView.setViewName("OrderManagment/SupplierOrder/OrderNewStocks");

		return modelAndView;
		
		
	}
	
	@RequestMapping("/SupplierOrders")
	public ModelAndView SupplierOrderHistory() {
		
		List<Supplier_Order> orders= iServices.getSupplierOrders(50);
		
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("oderlist",orders);
		modelAndView.setViewName("OrderManagment/SupplierOrder/SupplierOrderHistory");
		return modelAndView;
		
	}
	
	@RequestMapping("/ViewSupplierOrder")
	public ModelAndView SupplierOrder(@RequestParam("OrderId") int orderId) {
		
		Supplier_Order order= iServices.getSupplierOrder(orderId);
		
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("order",order);
		modelAndView.setViewName("OrderManagment/SupplierOrder/SupplierOrder");
		return modelAndView;
	}
	
	@RequestMapping("/OrderRecived")
	public ModelAndView SupplierOrderReceived(@RequestParam("OrderId") int orderID) {
		iServices.orderRecived(orderID);
		
		List<Supplier_Order> orders= iServices.getSupplierOrders(50);
		
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("oderlist",orders);
		modelAndView.setViewName("OrderManagment/SupplierOrder/SupplierOrderHistory");
		return modelAndView;
		
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handleMissingParams(Exception ex) {
	    ModelAndView model=new ModelAndView();
	    
	    model.setViewName("/OrderManagment/badRequest");
	    
	    return model;
	}

	
	
	

}
