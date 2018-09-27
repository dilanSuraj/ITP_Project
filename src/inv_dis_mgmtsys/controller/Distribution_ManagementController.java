package inv_dis_mgmtsys.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import inv_dis_mgmtsys.model.ExtraStock_Distribution;
import inv_dis_mgmtsys.model.Item;
import inv_dis_mgmtsys.model.PermanentEmployee;
import inv_dis_mgmtsys.model.Retailer_Order;
import inv_dis_mgmtsys.services.DistributionManagement_IServicesImpl;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

@Controller
@Transactional
public class Distribution_ManagementController {

	@Autowired
	private DistributionManagement_IServicesImpl distributionManagement_IServicesImpl;

	
	@RequestMapping(value = "/AssignManager", method = RequestMethod.GET)
	public ModelAndView AssignManagerViewGet(@RequestParam("id") int id) {

		Retailer_Order deliveryOrders_Distribution = distributionManagement_IServicesImpl
				.getSingleRetailerOrderDetails(id);
		List<PermanentEmployee> list = distributionManagement_IServicesImpl.getAllSalesRepresentativeList();

		ModelAndView model = new ModelAndView();
		model.addObject("salesRepList", list);
		model.addObject("deliverDetails", deliveryOrders_Distribution);
		model.setViewName("/DistributionManagement/AssignManager");
		return model;
	}

	@RequestMapping(value="/AssignManager_POST",method=RequestMethod.POST)
	public ModelAndView AssignManagerViewPost(@ModelAttribute("deliverDetails")Retailer_Order retailer_Order) {
		
		System.out.println("Here");
		System.out.println("Retailer Order ID "+retailer_Order.getRetailer_OrderID());
		System.out.println("Retailer SR ID "+retailer_Order.getSR_ID());
		distributionManagement_IServicesImpl.updateDeliveryDetails(retailer_Order);
		
		List<Retailer_Order> listtOfRetailers = distributionManagement_IServicesImpl.getAllDeliveryDetails();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("deliveryList", listtOfRetailers);
		modelAndView.setViewName("/DistributionManagement/SalesRepresentativeDashboard");
		
		
		return modelAndView;
	    
	    
	    
	}
	
	
	@RequestMapping("/SalesRepresentativeView")
	public ModelAndView SalesRepresentativeViews() {
		List<Retailer_Order> listtOfRetailers = distributionManagement_IServicesImpl.getAllDeliveryDetails();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("deliveryList", listtOfRetailers);
		modelAndView.setViewName("/DistributionManagement/SalesRepresentativeDashboard");
		
		
		return modelAndView;
	}

	
	@RequestMapping("/SalesRepresentativeDashboard_POST")
	public ModelAndView SalesRepresentativeView() {
		List<Retailer_Order> listtOfRetailers = distributionManagement_IServicesImpl.getAllDeliveryDetails();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("deliveryList", listtOfRetailers);
		modelAndView.setViewName("/DistributionManagement/SalesRepresentativeDashboard");
		
		
		return modelAndView;
	}
	
	
	@RequestMapping("/SalesRepresentativeDashboard")
	public ModelAndView SalesRepresentativeViewDashboard() {
		List<Retailer_Order> listtOfRetailers = distributionManagement_IServicesImpl.getAllDeliveryDetails();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("deliveryList", listtOfRetailers);
		modelAndView.setViewName("/DistributionManagement/SalesRepDashboard");
		
		
		return modelAndView;
	}


	@RequestMapping("/AddDeliveryDetails")
	public ModelAndView AddDeliveryDetailsView() {

		List<Retailer_Order> listtOfRetailers = distributionManagement_IServicesImpl.getAllDeliveryDetails();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/DistributionManagement/AddDeliveryDetails");
		modelAndView.addObject("deliveryList", listtOfRetailers);

		return modelAndView;
	}

	@RequestMapping(value = "/Extra_Stock_Details", method = RequestMethod.GET)
	public ModelAndView ExtraStockDetailsGET(@ModelAttribute("extrastock") ExtraStock_Distribution extraStock) {

		List<Item> itemList = distributionManagement_IServicesImpl.getAllItems();

		ModelAndView model = new ModelAndView();
		model.addObject("ItemList", itemList);
		model.setViewName("/DistributionManagement/ExtraStockDetails");

		return model;

	}

	@RequestMapping(value = "/Extra_Stock_Details_POST", method = RequestMethod.POST)
	public ModelAndView ExtraStockDetailsPOST(@ModelAttribute("extrastock") ExtraStock_Distribution extraStock) {

		distributionManagement_IServicesImpl.addExtraStockDetails(extraStock);
		return new ModelAndView("redirect:/Extra_Stock_View");

	}

	@RequestMapping("/Sales_Representative_View")
	public ModelAndView SalesRepresentativeDashboardView() {

		return new ModelAndView("/DistributionManagement/SalesRepresentativeDashboard");
	}

	@RequestMapping(value = "/Extra_Stock_View", method = RequestMethod.GET)
	public ModelAndView ExtraStockView(@ModelAttribute("extrastock") ExtraStock_Distribution extraStock) {

		List<ExtraStock_Distribution> stockList = distributionManagement_IServicesImpl
				.getAllExtraStock_DistributionDetails();

		ModelAndView model = new ModelAndView();
		model.addObject("stockList", stockList);
		model.setViewName("/DistributionManagement/ExtraStockView");
		return model;

	}

	@RequestMapping("/Delete_Extra_Stock")
	public ModelAndView ExtraStockDelete(@RequestParam("id") int id) {

		System.out.println("Supplier Finanace");
		distributionManagement_IServicesImpl.deleteExtraStock_DistributionDetails(id);

		return new ModelAndView("redirect:/Extra_Stock_View");
	}

	@RequestMapping(value = "/UpdateExtra_Stock_Get", method = RequestMethod.GET)
	public ModelAndView ExtraStockEdit_GET(@RequestParam("id") int id) {

		ExtraStock_Distribution extraStock_Distribution = distributionManagement_IServicesImpl.getExtraStockDetails(id);

		ModelAndView model = new ModelAndView();
		model.addObject("extrastock", extraStock_Distribution);
		model.setViewName("/DistributionManagement/EditExtraStock");
		return model;

	}

	@RequestMapping(value = "/UpdateExtra_Stock_Post", method = RequestMethod.POST)
	public ModelAndView ExtraStockEdit_POST(@ModelAttribute("extrastock") ExtraStock_Distribution extraStock) {

		distributionManagement_IServicesImpl.updateExtraStock_DistributionDetails(extraStock);
		return new ModelAndView("redirect:/Extra_Stock_View");

	}
	
	@RequestMapping(value = "deliverydetailsview", method = RequestMethod.GET)
	@ResponseBody
	public void getExpenseReport(HttpSession session) throws JRException, IOException {

		//This line needs to be changed
		List<java.util.Map<String,Object>> dataSource = distributionManagement_IServicesImpl.getDeliveryDetailsView();
		JRDataSource jrDataSource = new JRBeanCollectionDataSource(dataSource);
		String path = session.getServletContext().getRealPath("/Report/");
		//This line needs to be changed
		JasperDesign jasperDesign = JRXmlLoader.load(path + "/DeliveryDetailsView.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
		//JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,null , jrDataSource);
		ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder
				.currentRequestAttributes();
		HttpServletResponse response = servletRequestAttributes.getResponse();
		response.setContentType("application/x-pdf");
		//This line needs to be changed
		response.setHeader("Per-Delivery-Details", "inline; filename=DeliveryDetailsView.pdf");

		final ServletOutputStream outStream = response.getOutputStream();
		//JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
	}
	
	
	
	
}
