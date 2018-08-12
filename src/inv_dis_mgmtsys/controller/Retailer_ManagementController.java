package inv_dis_mgmtsys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Retailer_ManagementController {

	@RequestMapping("/Register")
	public ModelAndView Register() {
	
		return new ModelAndView("/RetailerManagement/Register");
	}
	@RequestMapping("/update")
	public ModelAndView Update() {
	
		return new ModelAndView("/RetailerManagement/update");
	}
	@RequestMapping("/Retailer")
	public ModelAndView Retailer() {
	
		return new ModelAndView("/Dashboards/Retailer");
	}
}
