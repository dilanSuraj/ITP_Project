package inv_dis_mgmtsys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserManagementController {
	
	@RequestMapping("/")
	public ModelAndView homePageView() {
		
		System.out.println("HomePage");
	    return new ModelAndView("index");
		
	}
	
	@RequestMapping("/staff_login")
	public ModelAndView generalLoginView() {
		
		System.out.println("General Login page");
		return new ModelAndView("/UserManagement/General_LoginPage");
	}

}
