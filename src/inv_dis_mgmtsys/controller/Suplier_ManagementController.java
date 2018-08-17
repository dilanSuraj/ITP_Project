package inv_dis_mgmtsys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class Suplier_ManagementController {

	@RequestMapping("/addSupplier")
	public ModelAndView addSupplier() {
		return new ModelAndView("/SupplierManagement/addSupplier");
	}
	
	@RequestMapping("/aDeleteSupplier")
	public ModelAndView aDeleteSupplier() {
		return new ModelAndView("/SupplierManagement/aDeleteSupplier");
	}
	
	@RequestMapping("/aEditSupplier")
	public ModelAndView aEditSupplier() {
		return new ModelAndView("/SupplierManagement/aEditSuppliers");
	}
	
	@RequestMapping("/editSupplierProfile")
	public ModelAndView editSupplierProfile() {
		return new ModelAndView("/SupplierManagement/editSupplierProfile");
	}
	
	@RequestMapping("/SupplierDashbord")
	public ModelAndView SupplierDashbord() {
		return new ModelAndView("/Dashboards/SupplierDashbord");
	}
	
	@RequestMapping("/supplierProfile")
	public ModelAndView supplierProfile() {
		return new ModelAndView("/SupplierManagement/supplierProfile");
	}
	
	@RequestMapping("/viewSupplier")
	public ModelAndView viewSupplier() {
		return new ModelAndView("/SupplierManagement/viewSupplier");
	}
	
}
