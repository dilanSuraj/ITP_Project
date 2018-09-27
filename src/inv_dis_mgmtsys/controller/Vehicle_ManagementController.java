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

import com.lowagie.text.pdf.codec.Base64.OutputStream;

import inv_dis_mgmtsys.model.PermanentEmployee;
import inv_dis_mgmtsys.model.TemporaryEmployee;
import inv_dis_mgmtsys.model.Vehicle;
import inv_dis_mgmtsys.services.VehicleManagement_IServicesImpl;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;


@Controller
@Transactional
public class Vehicle_ManagementController<vehicle> {
	
	@Autowired
	private VehicleManagement_IServicesImpl Vehicle_Management_IServices;
	
	@RequestMapping("/Transport_Manager")
	public ModelAndView TransportManagerDashboardView() {
		
		ModelAndView model = new ModelAndView();
		List vehiclelist = Vehicle_Management_IServices.getVehicleList();
		model.addObject("vehiclelist", vehiclelist);
		model.setViewName("/VehicleManagement/TransportManager/Transport_manager_dashbord");
		
		System.out.println("Transport Manager Dashboard");
		return model;
				
	}
	
	@RequestMapping(value="/Transport_Manager_Add_GET",method=RequestMethod.GET)
	public ModelAndView TransportManager_Add_GET(@ModelAttribute("vehicle")Vehicle vehicle) {
				
		System.out.println("Transport Manager Dashboard");
	    return new ModelAndView("/VehicleManagement/TransportManager/Transport_manager_Add");
	}
	
	
	
	@RequestMapping("/Transport_Manager_Delete_POST")
	public ModelAndView TransportManager_Delete_POST(@RequestParam("id") String id) {
		System.out.println("Deleted : "+id );
		Vehicle_Management_IServices.deleteVehicle(id);
		System.out.println("Transport Manager Dashboard");
		return new ModelAndView("redirect:/Transport_Manager");
	}

	@RequestMapping(value="/Transport_Manager_Add_POST",method=RequestMethod.POST)
	public ModelAndView TransportManager_Add_POST(@ModelAttribute("vehicle")Vehicle vehicle) {
		System.out.println("Transport Manager Dashboard");
		Vehicle_Management_IServices.addNewVehicle_TransportManager(vehicle);
	    return new ModelAndView("redirect:/Transport_Manager");
	}	
	
	@RequestMapping("/Transport_Manager_Edit_GET")
	public ModelAndView TransportManager_Edit_GET(@RequestParam("id") String id) {
		
		
		
		Vehicle vehicle = Vehicle_Management_IServices.getVehicle(id);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("vehicle", vehicle);
		modelAndView.setViewName("/VehicleManagement/TransportManager/Transport_manager_Edit");
		
	    return modelAndView;
	}
	
	@RequestMapping(value = "/Transport_Manager_Edit_POST",method=RequestMethod.POST)
	public ModelAndView TransportManager_Edit_POST(@ModelAttribute("vehicle")Vehicle vehicle) {
		
		System.out.println("Transport Manager Dashboard");
		Vehicle_Management_IServices.updateEdit_TransportManager(vehicle);
		 return new ModelAndView("redirect:/Transport_Manager");
	}
	
	

	
	@RequestMapping("/Transport_Manager_Update_GET")
	public ModelAndView TransportManager_Update_GET(@ModelAttribute("vehicle")Vehicle vehicle) {
		
		List<Vehicle> vehicleList = Vehicle_Management_IServices.getVehicleList();
		List<PermanentEmployee> driverList = Vehicle_Management_IServices.getdriverList();
		ModelAndView model = new ModelAndView();
		model.addObject("driverList", driverList);
		model.addObject("vehicleList", vehicleList);
		model.setViewName("/VehicleManagement/TransportManager/Transport_manager_Update");
		Vehicle_Management_IServices.updateEdit_TransportManager(vehicle);
		System.out.println("Transport Manager Dashboard");
	    return model;
	}
	
	@RequestMapping(value="/Transport_Manager_Update_POST",method=RequestMethod.POST)
	public ModelAndView TransportManager_Update_POST(@ModelAttribute("vehicle")Vehicle vehicle) {
		
		System.out.println("Transport Manager Dashboard");
		Vehicle_Management_IServices.assignDriver_TransportManager(vehicle);
		return new ModelAndView("redirect:/Transport_Manager");
	}
	
	
	
	
	@RequestMapping("/Data_Entry_Operator")
	public ModelAndView DataEntryOperatorDashboardView() {
		
		System.out.println("Data Entry Operator Dashboard");
	    return new ModelAndView("/VehicleManagement/DEO/DEO_dashboard");
	}
	
	
	
	
	
	
	@RequestMapping(value="/Data_Entry_Operator_AddDetails_GET",method = RequestMethod.GET)
	public ModelAndView DataEntryOperator_AddDetails_GET(@ModelAttribute("vehcile")Vehicle vehicle) {
		
		List<Vehicle> vehicleList = Vehicle_Management_IServices.getVehicleList();
		ModelAndView model = new ModelAndView();
		model.addObject("vehicleList", vehicleList);
		model.setViewName("/VehicleManagement/DEO/DEO_add_details");
		Vehicle_Management_IServices.updateEdit_TransportManager(vehicle);
		System.out.println("Data Entry Operator Dashboard");
	    return model;
	}
	
	@RequestMapping(value="/Data_Entry_Operator_AddDetails_POST",method = RequestMethod.POST)
	public ModelAndView DataEntryOperator_AddDetails_POST(@ModelAttribute("vehicle")Vehicle vehicle) {
		
		System.out.println("Data Entry Operator Dashboard");
		Vehicle_Management_IServices.addVehicleDetails_DEO(vehicle);
		return new ModelAndView("redirect:/Data_Entry_Operator_AddAll_GET");
	}
	
	

	
	@RequestMapping("/Data_Entry_Operator_AddAll_GET")
	public ModelAndView DataEntryOperator_AddMileage_POST() {
		
		
		ModelAndView model = new ModelAndView();
		List<Vehicle> vehiclelist = Vehicle_Management_IServices.getVehicleList();
		model.addObject("vehiclelist",vehiclelist);
	    model.setViewName("/VehicleManagement/DEO/DEO_details");
		System.out.println("Vehicle Details");
		return model;
	}
	
	
	
	@RequestMapping("/Data_Entry_Operator_EditDetails_GET")
	public ModelAndView DataEntryOperator_EditDetails_GET(@RequestParam("id") String id) {
		
		Vehicle vehicle = Vehicle_Management_IServices.getVehicle(id);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("vehicle", vehicle);
		modelAndView.setViewName("/VehicleManagement/DEO/DEO_edit_details");
		
	    return modelAndView;
	    
	    
	}
	
	@RequestMapping(value = "/Data_Entry_Operator_EditDetails_POST",method = RequestMethod.POST)
	public ModelAndView DataEntryOperator_EditDetails_POST(@ModelAttribute("vehicle")Vehicle vehicle) {
		
		System.out.println("Data Entry Operator Dashboard");
		Vehicle_Management_IServices.updateEDit_DEO(vehicle);
	    return new ModelAndView("redirect:/Data_Entry_Operator_AddAll_GET");
	}
	
	
	
	@RequestMapping(value="/Data_Entry_Operator_DeleteDEO_GET", method = RequestMethod.GET)
	public ModelAndView DataEntryOperator_DeleteDEO_GET(@ModelAttribute("vehicle")Vehicle vehicle) {
		
		System.out.println("Data Entry Operator Dashboard");
	    return new ModelAndView("/VehicleManagement/DEO/DEO_dashboard");
	}
	
	
	@RequestMapping("/Data_Entry_Operator_DeleteDEO_POST")
	public ModelAndView DataEntryOperator_DeleteDEO_POST(@RequestParam("id")String id) {
		
		System.out.println("Deleted : "+id );
		Vehicle_Management_IServices.deleteVehicle(id);
		System.out.println("Data Entry Operator Dashboard");
		return new ModelAndView("redirect:/Data_Entry_Operator_AddAll_GET");
	}
	
	
	
	@RequestMapping(value="/Data_Entry_Operator_UpdateEDIT_GET",method=RequestMethod.GET)
	public ModelAndView DataEntryOperator_UpdateEDIT_GET(@ModelAttribute("vehicle")Vehicle vehicle) {
		
		System.out.println("Update Edit Details");
		ModelAndView model = new ModelAndView();
		
		List<PermanentEmployee> driverList = Vehicle_Management_IServices.getdriverList();
		List<Vehicle> vehicleList = Vehicle_Management_IServices.getVehicleList();
		model.addObject("driverList",driverList);
		model.addObject("vehicleList",vehicleList);
		model.setViewName("/VehicleManagement/DEO/DEO_edit_details");
		return model;
		
		
		
	}
	
	@RequestMapping(value="/Data_Entry_Operator_UpdateEDIT_POST",method=RequestMethod.POST)
	public ModelAndView DataEntryOperator_UpdateEDIT_POST(@ModelAttribute("vehicle")Vehicle vehicle) {
		
		Vehicle_Management_IServices.updateEDit_DEO(vehicle);
		return new ModelAndView("redirect:/Data_Entry_Operator_AddAll_GET");
		

	}
	

	
	@RequestMapping("/Driver")
	public ModelAndView DriverDashboardView() {
		
		System.out.println("Driver Dashboard");
	    return new ModelAndView("/VehicleManagement/Driver/Driver_Profile");
	}
	
	
	@RequestMapping(value = "vehicleReport", method = RequestMethod.GET)
	@ResponseBody
	public void getVehicleReport(HttpSession session) throws JRException, IOException {

		//This line needs to be changed
		List<java.util.Map<String, Object>> dataSource = Vehicle_Management_IServices.getVehicleViewDetails();
		JRDataSource jrDataSource = new JRBeanCollectionDataSource(dataSource);
		String path = session.getServletContext().getRealPath("/Report/");
		//This line needs to be changed
		JasperDesign jasperDesign = JRXmlLoader.load(path + "/Vehicle_Report.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,null , jrDataSource);
		ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder
				.currentRequestAttributes();
		HttpServletResponse response = servletRequestAttributes.getResponse();
		response.setContentType("application/x-pdf");
		//This line needs to be changed
		response.setHeader("Content-disposition", "inline; filename=Vehicle Report.pdf");

		final ServletOutputStream outStream = response.getOutputStream();
		JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
	}
	
	

}
