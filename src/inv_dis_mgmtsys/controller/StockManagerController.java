package inv_dis_mgmtsys.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

import inv_dis_mgmtsys.model.Item;
import inv_dis_mgmtsys.model.Payment;
import inv_dis_mgmtsys.model.PermanentEmployee;
import inv_dis_mgmtsys.model.Stock;
import inv_dis_mgmtsys.model.Store;
import inv_dis_mgmtsys.model.Supplier;
import inv_dis_mgmtsys.services.StockManagement_IServices;
import inv_dis_mgmtsys.services.StockManagement_IServicesImpl;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;


@Controller
@Transactional
public class StockManagerController {

	@Autowired
	StockManagement_IServicesImpl stockManagement_IServices;

	// Store Details all maping parts
	@RequestMapping("/StockDashboard")
	public ModelAndView dashboardView() {

		// System.out.println("Inside Stock dashbaord");
		return new ModelAndView("/StockManagement/StockDashboard");
	}

	@RequestMapping("/UpdateStock")
	public ModelAndView UpdateStockView() {

		// System.out.println("Inside Update Stock dashbaord");
		return new ModelAndView("/StockManagement/UpdateStock");
	}

	@RequestMapping(value = "/DeleteStock")
	public ModelAndView DeleteStockView(@RequestParam("id") int stock_ID) {

		System.out.println("Delete Stock");
		stockManagement_IServices.deleteStockDetails(stock_ID);
		return new ModelAndView("redirect:/StockView");

	}

	@RequestMapping(value = "/InsertStock", method = RequestMethod.GET)
	public ModelAndView InsertStockGET(@ModelAttribute("stock") Stock stock) {
		
		 //storeList and ItemName List
		List<Store> storeList = stockManagement_IServices.getStoreList();
		List<Item> itemList = stockManagement_IServices.getItemList();
		ModelAndView model = new ModelAndView();
		model.addObject("storeList", storeList );
		model.addObject("itemList", itemList );
		model.setViewName("/StockManagement/InsertStock");
		

		// System.out.println("Inside Insert Stock dashbaord");
		return model;
	}

	@RequestMapping(value = "/InsertStock_POST", method = RequestMethod.POST)
	public ModelAndView InsertStockPOST(@ModelAttribute("stock") Stock stock) {

		System.out.println("Insert Stock  post");

		stockManagement_IServices.addStockDetails(stock);

		return new ModelAndView("redirect:/StockView");
	}

	@RequestMapping("/StockView")
	public ModelAndView StockView() {

		ModelAndView model = new ModelAndView();
		List<Stock> stockList = stockManagement_IServices.getAllStockDetail();

		model.addObject("stockList", stockList);
		model.setViewName("/StockManagement/StockView");

		return model;
	}

	@RequestMapping(value = "/UpdateStock_Get")
	public ModelAndView UpdateStockGET(@RequestParam("id") int stock_ID) {

		ModelAndView model = new ModelAndView();
		Stock stock = (Stock) stockManagement_IServices.getSingleStockDetail(stock_ID);
		model.addObject("stock", stock);
		List<Item> itemList = stockManagement_IServices.getAllItemDetails();
		
		
		List<Store> storeList = stockManagement_IServices.getStoreList();
		
		model.addObject("storeList", storeList );
		model.addObject("ItemList", itemList);
		model.setViewName("/StockManagement/UpdateStock");
		return model;
	}

	@RequestMapping(value = "/UpdateStock_Post", method = RequestMethod.POST)
	public ModelAndView UpdateStockPOST(@ModelAttribute("stock") Stock stock) {

		stockManagement_IServices.updateStockDetails(stock);

		return new ModelAndView("redirect:/StockView");

	}

	// all details 0f the Items maping

	// 1.Insert and View Part
	@RequestMapping(value = "/InsertItem", method = RequestMethod.GET)
	public ModelAndView InsertItemGET(@ModelAttribute("item") Item item) {
        //supplierList
		List<Supplier> supplierList = stockManagement_IServices.getSupplierList();
		ModelAndView model = new ModelAndView();
		model.addObject("supplierList", supplierList );
		model.setViewName("/ItemManagement/InsertItem");
		// System.out.println("Inside Insert Stock dashbaord");
		return model;
	}

	@RequestMapping(value = "/InsertItem_POST", method = RequestMethod.POST)
	public ModelAndView InsertItemPOST(@ModelAttribute("item") Item item) {

		System.out.println("Insert Item post");
        int supplierID = item.getSupplierID();
        Supplier supplier = stockManagement_IServices.getSupplier(supplierID);
        item.setSupplier(supplier);
		stockManagement_IServices.addItemDetails(item);

		return new ModelAndView("redirect:/ItemView");
	}

	@RequestMapping("/ItemView")
	public ModelAndView ItemView() {

		ModelAndView model = new ModelAndView();
		List<Item> itemList = stockManagement_IServices.getAllItemDetails();

		model.addObject("itemList", itemList);
		model.setViewName("/ItemManagement/ItemView");

		return model;
	}

	// 2.Delete Part of the Item
	@RequestMapping(value = "/DeleteItem")
	public ModelAndView DeleteItemView(@RequestParam("id") int item_itemcode) {

		System.out.println("Delete Item");
		stockManagement_IServices.deleteItemDetails(item_itemcode);
		return new ModelAndView("redirect:/ItemView");

	}

	// 3. Update details of the Item
	@RequestMapping("/UpdateItem")
	public ModelAndView UpdateItemView() {

		// System.out.println("Inside Update Stock dashbaord");
		return new ModelAndView("/ItemManagement/UpdateItem");
	}

	@RequestMapping(value = "/UpdateItem_Get")
	public ModelAndView UpdateItemGET(@RequestParam("id") int item_itemcode) {

		ModelAndView model = new ModelAndView();
		Item item = (Item) stockManagement_IServices.getSingleItemDetails(item_itemcode);
		model.addObject("item", item);
		List<Item> itemList = stockManagement_IServices.getAllItemDetails();
		model.addObject("itemList", itemList);
		model.setViewName("/ItemManagement/UpdateItem");
		return model;
	}

	@RequestMapping(value = "/UpdateItem_Post", method = RequestMethod.POST)
	public ModelAndView UpdateItemPOST(@ModelAttribute("item") Item item) {

		stockManagement_IServices.updateItemDetails(item);

		return new ModelAndView("redirect:/ItemView");
	}

	// all details of the Store

	// 1. Insert and View of the Store
	@RequestMapping(value = "/InsertStore", method = RequestMethod.GET)
	public ModelAndView InsertStoreGET(@ModelAttribute("store") Store store) {
		
		
		
		//new Edited
		ModelAndView model = new ModelAndView();
		List<PermanentEmployee> employeeList = stockManagement_IServices.getEmployeeList();
		List<PermanentEmployee> employeeSMList = new ArrayList<PermanentEmployee>();
		 for( PermanentEmployee p: employeeList) {
			   if(p.getRole().equals("SM")) {
				   
				   employeeSMList.add(p);
			   }
			 
			 
			 
		 }
		
		 model.addObject("employeeList", employeeSMList);
		 model.setViewName("/StoreManagement/InsertStore");
			return model;
		//new Edited
/*
		System.out.println("Inside Insert Store dashbaord");
		return new ModelAndView("/StoreManagement/InsertStore");
		
		
		*/
	}

	@RequestMapping(value = "/InsertStore_POST", method = RequestMethod.POST)
	public ModelAndView InsertStorePOST(@ModelAttribute("store") Store store) {

	
		
		
		System.out.println("Insert Store  post");
		stockManagement_IServices.addStoreDetails(store);
		return new ModelAndView("redirect:/StoreView");
	}

	@RequestMapping("/StoreView")
	public ModelAndView StoreView() {

		ModelAndView model = new ModelAndView();
		List<Store> storeList = stockManagement_IServices.getAllStoreDetails();

		model.addObject("storeList", storeList);
		model.setViewName("/StoreManagement/StoreView");

		return model;
	}

	// 2. Update details of the Store
	
	
	@RequestMapping(value = "/UpdateStore_Get")
	public ModelAndView UpdateStoreGET(@RequestParam("id") int store_ID) {

		ModelAndView model = new ModelAndView();
		//edited new store emp name
		
		
		
		Store store = (Store) stockManagement_IServices.getSingleStoreDetails(store_ID);
		List<Store> storeList = stockManagement_IServices.getAllStoreDetails();
		List<PermanentEmployee> employeeList = stockManagement_IServices.getEmployeeList();
		List<PermanentEmployee> employeeSMList = new ArrayList<PermanentEmployee>();
		 for( PermanentEmployee p: employeeList) {
			   if(p.getRole().equals("SM")) {
				   
				   employeeSMList.add(p);
			   }
			 
			 
			 
		 }
		
		model.addObject("store", store);
		model.addObject("storeList", storeList);
		model.addObject("employeeList", employeeSMList);
		model.setViewName("/StoreManagement/UpdateStore");
		return model;
	}

	@RequestMapping(value = "/UpdateStore_Post", method = RequestMethod.POST)
	public ModelAndView UpdateStorePOST(@ModelAttribute("store") Store store) {

		stockManagement_IServices.updateStoreDetails(store);

		return new ModelAndView("redirect:/StoreView");
	}

	// 3. Delete details of the Store
	
	@RequestMapping(value = "/DeleteStore")
	public ModelAndView DeleteStoreView(@RequestParam("id") int store_ID) {

		System.out.println("Delete Store");
		stockManagement_IServices.deleteStoreDetails(store_ID);
		return new ModelAndView("redirect:/StoreView");

	}
	
	
	//Report Generations
	
	@RequestMapping(value = "/StoreStockItmaDetails", method = RequestMethod.GET)
	@ResponseBody
	public void getExpenseReport(HttpSession session) throws JRException, IOException {

		//This line needs to be changed
		List<Map<String,Object>> dataSource = stockManagement_IServices.getAllStoreReportViewDetails();
		JRDataSource jrDataSource = new JRBeanCollectionDataSource(dataSource);
		String path = session.getServletContext().getRealPath("/Report/");
		//This line needs to be changed
		JasperDesign jasperDesign = JRXmlLoader.load(path + "/StoreReportDetailsView.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
		//JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,null , jrDataSource);
		ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder
				.currentRequestAttributes();
		HttpServletResponse response = servletRequestAttributes.getResponse();
		response.setContentType("application/x-pdf");
		//This line needs to be changed
		response.setHeader("Per-Delivery-Details", "inline; filename=StoreReport.pdf");

		final ServletOutputStream outStream = response.getOutputStream();
		//JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
	}
	

}