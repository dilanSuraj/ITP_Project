package inv_dis_mgmtsys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CEO_ManagementController {
	
	@RequestMapping("/CEO")
	public ModelAndView dashboardView() {
		
		System.out.println("Inside CEO dashbaord");
		return new ModelAndView("/Dashboards/CEO");
	}

}
