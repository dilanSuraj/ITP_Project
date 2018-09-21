package inv_dis_mgmtsys.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import inv_dis_mgmtsys.model.Supplier;
import inv_dis_mgmtsys.model.Supplier_Finance;
import inv_dis_mgmtsys.model.Supplier_Order;
import inv_dis_mgmtsys.services.SupplierManagement_IServicesImpl;

@Controller
@Transactional
public class Suplier_ManagementController {

	@Autowired
	private SupplierManagement_IServicesImpl supplierManagement_IServices;

	@RequestMapping("/addSupplier")
	public ModelAndView addSupplier() {

		System.out.println("Admin Adding suppliers");
		return new ModelAndView("/SupplierManagement/addSupplier");
	}

	@RequestMapping("/aDeleteSupplier")
	public ModelAndView aDeleteSupplier() {

		System.out.println("Admin Deleteting suppliers");
		return new ModelAndView("/SupplierManagement/aDeleteSupplier");
	}

	@RequestMapping("/aEditSupplier")
	public ModelAndView aEditSupplier() {

		System.out.println("Admin Updating suppliers");
		return new ModelAndView("/SupplierManagement/aEditSuppliers");
	}

	@RequestMapping("/editSupplierProfile")
	public ModelAndView editSupplierProfile() {

		System.out.println("Supplier Updating supplier profile");
		return new ModelAndView("/SupplierManagement/editSupplierProfile");
	}

	@RequestMapping("/SupplierDashbord")
	public ModelAndView SupplierDashbord() {

		ModelAndView model = new ModelAndView();
		HttpSession session = supplierManagement_IServices.getHttpsession();
		Supplier supplier = (Supplier) session.getAttribute("supplier");
		if(supplier == null) {
			System.out.println("Null");
			return new ModelAndView("redirect:/login");
			
		}
		model.addObject("supplier", supplier);
		List<Supplier_Order> SupplierItems = supplierManagement_IServices.getSupplierOrderItem(supplier.getSupplier_ID());
		
		model.addObject("SupplierItems", SupplierItems);
		
		List<Supplier_Order> SupplierItems1 = supplierManagement_IServices.getSupplierOrderItem1(supplier.getSupplier_ID());
		model.addObject("SupplierItems1", SupplierItems1);

		
		
		
		List<Supplier_Finance> supplier_Finance = supplierManagement_IServices
				.getpaymentDetails(supplier.getSupplier_ID());
		model.addObject("Supplier_Finance", supplier_Finance);
		
		for(Supplier_Finance i:supplier_Finance) {
			
			System.out.println("details "+i.getSupplier_finance_id());
		}

		List<Supplier_Finance> Supplier_Finance1 = supplierManagement_IServices
				.getpaymentDetails1(supplier.getSupplier_ID());
		model.addObject("Supplier_Finance1", Supplier_Finance1);

		model.setViewName("/Dashboards/SupplierDashbord");
		return model;
	}

	@RequestMapping("/supplierProfile")
	public ModelAndView supplierProfile() {

		ModelAndView model = new ModelAndView();
		System.out.println("Supplier Profile");
		
		HttpSession session = supplierManagement_IServices.getHttpsession();
		
		Supplier supplier1 = (Supplier) session.getAttribute("supplier");
		
		
		Supplier supplier = supplierManagement_IServices.getSupplierDetails(supplier1.getSupplier_ID());

		model.addObject("supplier", supplier);

		model.setViewName("/SupplierManagement/supplierProfile");
		return model;
	}

	@RequestMapping("/viewSupplier")
	public ModelAndView viewSupplier() {

		ModelAndView model = new ModelAndView();
		List<Supplier> supplierList = supplierManagement_IServices.getSuppliers("viewSupplier");

		model.addObject("supplierList", supplierList);
		model.setViewName("/SupplierManagement/viewSupplier");

		System.out.println("View Supplier Details As Admin");
		return model;
	}

	@RequestMapping("/deoviewSupplier")
	public ModelAndView deoviewSupplier() {

		ModelAndView model = new ModelAndView();
		List<Supplier> supplierList = supplierManagement_IServices.getSuppliers("deoviewSupplier");

		model.addObject("supplierList", supplierList);
		model.setViewName("/SupplierManagement/deoViewSupplier");

		System.out.println("View Supplier Details As Deo");
		return model;
	}

	@RequestMapping("/deoaddSupplier")
	public ModelAndView deoaddSupplier() {

		System.out.println("Adding Supplier Details As Deo");
		return new ModelAndView("/SupplierManagement/deoAddSupplier");
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView LoginSupplier_GET(@ModelAttribute("supplier") Supplier supplier) {

		System.out.println("Login get");
		return new ModelAndView("/UserManagement/General_LoginPage");
	}

	@RequestMapping(value = "/loginPOST", method = RequestMethod.POST)
	public ModelAndView LoginSupplier_POST(@ModelAttribute("supplier") Supplier supplier, HttpSession session) {

		System.out.println("Login post");

		Supplier result = supplierManagement_IServices.login(supplier);
		//System.out.println("Supplier ID in controller "+supplier.getSupplier_ID());
		if (result != null) {

			supplierManagement_IServices.setHttpsession(session);
			supplierManagement_IServices.saveSessionObjects(result.getSupplier_ID());
			System.out.println("Supplier ID in controller "+result.getSupplier_ID());
			ModelAndView model = new ModelAndView();
			model.setViewName("redirect:/SupplierDashbord");
			return model;
		} else {
			supplierManagement_IServices.setHttpsession(null);
			return new ModelAndView("redirect:/login");
		}
	}

	@RequestMapping(value = "/AddSupplier_post", method = RequestMethod.POST)
	public ModelAndView AddSupplierform(@ModelAttribute("supplier") Supplier supplier) {

		
		if(supplier.getSupplier_password()==supplier.getSupplier_password2())
		{
		
			System.out.println("Adding supplier");
			supplierManagement_IServices.addSupplier(supplier);
			return new ModelAndView("redirect:/deoviewSupplier");
		}
		else {
			ModelAndView model = new ModelAndView();
			model.setViewName("redirect:/deoaddSupplier");
			String Error ="Password is incorrect ";
			model.addObject("Error", Error);
			
			
			return model;
		}
	}

	@RequestMapping(value = "/AdminAddSupplier_post", method = RequestMethod.POST)
	public ModelAndView AdminAddSupplierform(@ModelAttribute("supplier") Supplier supplier) {

		if(supplier.getSupplier_password()==supplier.getSupplier_password2())
		{
		
			System.out.println("Adding supplier");
			supplierManagement_IServices.addSupplier(supplier);
			return new ModelAndView("redirect:/viewSupplier");
		}
		else {
			
			ModelAndView model = new ModelAndView();
			String Error ="Password is incorrect ";
			model.addObject("Error", Error);
			model.setViewName("redirect:/addSupplier");
			return model;
			
		}
	}

	@RequestMapping(value = "/DeleteSupplier")
	public ModelAndView DeleteSupplier(@RequestParam("id") int id) {

		System.out.println("Delete Supplier");
		supplierManagement_IServices.deleteSupplier(id);
		return new ModelAndView("redirect:/viewSupplier");

	}

	@RequestMapping(value = "/Update_Supplier_Get1")
	public ModelAndView AdminUpdateSupplierGET(@RequestParam("id") int id) {

		System.out.println("CHECK Adding supplier");
		ModelAndView model = new ModelAndView();
		
		HttpSession session = supplierManagement_IServices.getHttpsession();
		
		Supplier supplier1 = (Supplier) session.getAttribute("supplier");
		
		
		Supplier supplier = supplierManagement_IServices.getSupplierDetails(supplier1.getSupplier_ID());
		
		model.addObject("supplier", supplier);
		model.setViewName("/SupplierManagement/aEditSuppliers");
		return model;
	}

	@RequestMapping(value = "/Edit_Supplier_Get")
	public ModelAndView EditSupplierGET(@RequestParam("id") int id) {
		
		HttpSession session = supplierManagement_IServices.getHttpsession();
		
		Supplier supplier1 = (Supplier) session.getAttribute("supplier");

		System.out.println("CHECK Adding supplier");
		System.out.println("CHECK " + id);
		ModelAndView model = new ModelAndView();
		Supplier supplier = supplierManagement_IServices.getSupplierDetails(supplier1.getSupplier_ID());
		model.addObject("supplier", supplier);
		model.setViewName("/SupplierManagement/editSupplierProfile");
		return model;
	}

	@RequestMapping(value = "/Edit_Supplier_Post", method = RequestMethod.POST)
	public ModelAndView editSupplierPOST(@ModelAttribute("supplier") Supplier supplier) {
		

		HttpSession session = supplierManagement_IServices.getHttpsession();
		
		Supplier supplier1 = (Supplier) session.getAttribute("supplier");
		

		System.out.println("in");
		if(supplier.getSupplier_password2().equals(supplier.getNew_supplier_password())&&(supplier1.getSupplier_password().equals(supplier.getSupplier_password1()))){
			System.out.println("out");
			supplierManagement_IServices.editSupplier(supplier);
			return new ModelAndView("redirect:/SupplierDashbord");
		
		}
		ModelAndView model = new ModelAndView();
		model.addObject("supplier", supplier);
		model.setViewName("/SupplierManagement/editSupplierProfile");
		return model;
	}

	@RequestMapping(value = "/Update_Supplier_Get")
	public ModelAndView UpdateSupplierGET(@RequestParam("id") int id) {

		System.out.println("CHECK Adding supplier");
		ModelAndView model = new ModelAndView();
		Supplier supplier = supplierManagement_IServices.getSupplierDetails(id);
		System.out.println(supplier.getSupplier_ID());
		model.addObject("supplier", supplier);
		model.setViewName("/SupplierManagement/deoEditSuppliers");
		return model;
	}

	@RequestMapping(value = "/Update_Supplier_Post1", method = RequestMethod.POST)
	public ModelAndView AdminSupplierPOST(@ModelAttribute("supplier") Supplier supplier) {

		System.out.println("CHECK update supplier");
		System.out.println("Supplier :::::" + supplier.getSupplier_ID());
		supplierManagement_IServices.editSupplier(supplier);
		return new ModelAndView("redirect:/viewSupplier");

	}

	@RequestMapping(value = "/Update_Supplier_Post", method = RequestMethod.POST)
	public ModelAndView UpdateSupplierPOST(@ModelAttribute("supplier") Supplier supplier) {

		System.out.println("CHECK update supplier");
		System.out.println("Suppplier:::::" + supplier.getSupplier_ID());
		supplierManagement_IServices.editSupplier(supplier);
		return new ModelAndView("redirect:/deoviewSupplier");
	}

}
