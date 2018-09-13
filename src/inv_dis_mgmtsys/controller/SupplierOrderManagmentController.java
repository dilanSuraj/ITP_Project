package inv_dis_mgmtsys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import inv_dis_mgmtsys.model.Item;
import inv_dis_mgmtsys.services.OrderManagement_IServicesImpl;
import inv_dis_mgmtsys.services.SupplierOrderManagment_IServices;

@Controller
@Transactional
public class SupplierOrderManagmentController {
	
	@Autowired
	SupplierOrderManagment_IServices iServices;
	
	@RequestMapping("/orderNewItem")
	public ModelAndView getItems(){
		
		List<Item> items= iServices.getItems();
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("Items",items);
		modelAndView.setViewName("OrderManagment/SupplierOrder/OrderNewStocks.jsp");
		
		return modelAndView;
		
	}

}
