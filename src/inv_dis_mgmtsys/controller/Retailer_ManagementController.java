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

import inv_dis_mgmtsys.dao.RetailerManagement_IDAOImpl;
import inv_dis_mgmtsys.model.*;
import inv_dis_mgmtsys.services.RetailerManagement_IServices;
import inv_dis_mgmtsys.services.RetailerManagement_IServicesImpl;

@Controller
@Transactional
public class Retailer_ManagementController {

	@Autowired
	private RetailerManagement_IServicesImpl retailerManagement_IServices;

	@RequestMapping(value = "/Register", method = RequestMethod.GET)
	public ModelAndView Register_GET(@ModelAttribute("retailer") Retailer retailer) {

		return new ModelAndView("/RetailerManagement/Register");
	}

	@RequestMapping(value = "/Register_POST", method = RequestMethod.POST)
	public ModelAndView Register_POST(@ModelAttribute("retailer") Retailer retailer) {

		System.out.println("Add Retailer");
		System.out.println("Inside : " + retailer.getRetailer_address());
		retailerManagement_IServices.addRetailers(retailer);
		return new ModelAndView("redirect:/Retailer");
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView LoginRetailer_GET(@ModelAttribute("retailer") Retailer Retailer) {

		System.out.println("Get your login");
		return new ModelAndView("/UserManagement/General_LoginPage");
	}

	@RequestMapping(value = "/loginPOST", method = RequestMethod.POST)
	public ModelAndView LoginRetailer_POST(@ModelAttribute("retailer") Retailer Retailer, HttpSession session) {

		System.out.println("post Your Login");
		Retailer result = retailerManagement_IServices.login(Retailer);
		if (result != null) {

			retailerManagement_IServices.setHttpsession(session);
			retailerManagement_IServices.saveSessionObjects(result.getRetailer_ID());
			ModelAndView model = new ModelAndView();
			Retailer retailer = (Retailer) session.getAttribute("retailer");
			System.out.println("fgdf"+retailer.getRetailer_ID());
			model.setViewName("Dashboards/Retailer");
			return model;
		} else {
			retailerManagement_IServices.setHttpsession(null);
			return new ModelAndView("UserManagement/General_LoginPage");
		}
	}

	@RequestMapping(value = "/Delete_Request_GET", method = RequestMethod.GET)
	public ModelAndView deleteRetailers_GET(
		@ModelAttribute("retailer_notification") Notification retailer_notification) {
		
		ModelAndView model = new ModelAndView();
		HttpSession session = retailerManagement_IServices.getHttpsession();
		Retailer retailer = (Retailer) session.getAttribute("retailer");
		
		if (retailer == null) {
			return new ModelAndView("rediect:/Retailer");
		}
		retailer_notification.setRetailer_notification_retailerID(retailer.getRetailer_ID());
		model.addObject("retailer", retailer);
		model.setViewName("/RetailerManagement/Delete_Request");
		return model;
	}

	@RequestMapping(value = "/Delete_Request_POST", method = RequestMethod.POST)
	public ModelAndView deleteRetailers_POST(
			@ModelAttribute("retailer_notification") Notification retailer_notification) {
		System.out.println("Iside post");
		retailerManagement_IServices.deleteRetailers(retailer_notification);
		return new ModelAndView("redirect:/Retailer");
	}

	@RequestMapping(value = "/update_GET", method = RequestMethod.GET)
	public ModelAndView Update_GET() {
		
		ModelAndView model = new ModelAndView();
		HttpSession session = retailerManagement_IServices.getHttpsession();
		if (session == null) {
			System.out.println("NULL session");
			return new ModelAndView("redirect:/login");
		}
		Retailer retailer2 = (Retailer) session.getAttribute("retailer");
		if (retailer2 == null) {
			System.out.println("NULL");
			return new ModelAndView("redirect:/login");
		}
		Retailer retailer1 = retailerManagement_IServices.getRetailerDetails(retailer2.getRetailer_ID());
		model.addObject("retailer1", retailer1);
		model.setViewName("/RetailerManagement/update");
		return model;
	}
	
	@RequestMapping(value = "/update_POST", method = RequestMethod.POST)
	public ModelAndView Update_GET_POST(@ModelAttribute("retailer1")Retailer retailer) {
		retailerManagement_IServices.addRetailers(retailer);
		
		return new ModelAndView("/RetailerManagement/update");
	}

	/*@RequestMapping("/Delete_Request")
	public ModelAndView Delete_Request(@ModelAttribute("retailer_notification") Notification retailer_notification) {
		ModelAndView model = new ModelAndView();
		HttpSession session = retailerManagement_IServices.getHttpsession();
		Retailer retailer = (Retailer) session.getAttribute("retailer");
		if (retailer == null) {
			return new ModelAndView("rediect:/Retailer");
		}
		model.addObject("retailer", retailer);
		model.setViewName("/RetailerManagement/Delete_Request");
		return model;
	}
*/
	@RequestMapping("/Retailer")
	public ModelAndView Retailer() {

		return new ModelAndView("/Dashboards/Retailer");
	}

	@RequestMapping("/Add_Retailer_ADMIN")
	public ModelAndView Add_Retailer_ADMIN() {

		return new ModelAndView("/RetailerManagement/Add_Retailer_ADMIN");
	}

	@RequestMapping("/Update_Retailer_ADMIN")
	public ModelAndView Update_Retailer_ADMIN() {

		List<Retailer> retailerList = retailerManagement_IServices.getRetailerList();
		ModelAndView model = new ModelAndView();
		model.addObject("retailerList", retailerList);
		model.setViewName("/RetailerManagement/Update_Retailer_ADMIN");
		return model;
	}

	@RequestMapping("/Delete_Retailer_ADMIN")
	public ModelAndView Delete_Retailer_ADMIN() {

		return new ModelAndView("/RetailerManagement/Delete_Retailer_ADMIN");
	}

	@RequestMapping("/view")
	public ModelAndView view() {

		return new ModelAndView("/RetailerManagement/view");
	}

	@RequestMapping("/view2")
	public ModelAndView view2() {

		return new ModelAndView("/RetailerManagement/view2");
	}

	@RequestMapping("/viewFile")
	public ModelAndView viewFile() {
		List<Notification> list = retailerManagement_IServices.getRetailerList1();
		ModelAndView model = new ModelAndView();
		model.addObject("retailerList", list);
		model.setViewName("/RetailerManagement/viewFile");
		return model;

	}

	@RequestMapping("/Delete_Table")
	public ModelAndView Delete_Table() {
		return new ModelAndView("/RetailerManagement/Delete_Table");
	}

	@RequestMapping(value = "/Add_Retailer_ADMIN", method = RequestMethod.GET)
	public ModelAndView Add_Retailer_ADMINView(@ModelAttribute("retailer") Retailer retailer) {

		retailerManagement_IServices.addRetailers(retailer);
		return new ModelAndView("/RetailerManagement/Register");
	}

	@RequestMapping(value = "/DeleteRetailer")
	public ModelAndView DeleteRetailer(@RequestParam("id") int id) {

		System.out.println("Delete Delete Retailer");
		System.out.println(id);
		retailerManagement_IServices.deleteRetailer(id);
		return new ModelAndView("redirect:/Update_Retailer_ADMIN");

	}

	@RequestMapping(value = "/DeleteRetailer1")
	public ModelAndView DeleteRetailer1(@RequestParam("id") int id) {

		System.out.println("Delete Delete Retailer");
		System.out.println(id);
		retailerManagement_IServices.deleteRetailerNotification(id);
		return new ModelAndView("redirect:/viewFile");
	}

	@RequestMapping(value = "/Update_Retailer_Get1")
	public ModelAndView UpdateRetailerGET(@RequestParam("id") int id) {

		System.out.println("CHECK Adding retailer");
		ModelAndView model = new ModelAndView();
		Retailer Retailer = retailerManagement_IServices.getRetailerDetails(id);
		model.addObject("Retailer", Retailer);
		model.setViewName("/RetailerManagement/view");
		return model;
	}

	@RequestMapping(value = "/Update_Retailer_Get")
	public ModelAndView AdminUpdateRetailerGET(@RequestParam("id") int id) {

		System.out.println("CHECK Adding retailer");
		ModelAndView model = new ModelAndView();
		Retailer Retailer = retailerManagement_IServices.getRetailerDetails(id);

		model.addObject("Retailer", Retailer);
		model.setViewName("/RetailerManagement/Update_Retailer_ADMIN");

		return model;
	}

	@RequestMapping(value = "/Update_Retailer_Post1", method = RequestMethod.POST)
	public ModelAndView AdminUpdateIncomePOST(@ModelAttribute("Retailer") Retailer Retailer) {

		System.out.println("CHECK update Retailer");
		System.out.println("Retailer :::::" + Retailer.getRetailer_ID());
		retailerManagement_IServices.editRetailer(Retailer);
		return new ModelAndView("redirect:/Update_Retailer_ADMIN");

	}

	@RequestMapping(value = "/Update_Retailer_Post", method = RequestMethod.POST)
	public ModelAndView UpdateIncomePOST(@ModelAttribute("Retailer") Retailer Retailer) {

		System.out.println("CHECK update Retailer");
		System.out.println("Retailer:::::" + Retailer.getRetailer_ID());
		retailerManagement_IServices.editRetailer2(Retailer);
		return new ModelAndView("redirect:/Retailer");
	}

}
