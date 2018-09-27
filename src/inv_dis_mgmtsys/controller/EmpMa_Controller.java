package inv_dis_mgmtsys.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.lowagie.text.pdf.codec.Base64.OutputStream;

import inv_dis_mgmtsys.model.Admin;
import inv_dis_mgmtsys.model.Emp_Month_Salary;
import inv_dis_mgmtsys.model.PermanentEmployee;
import inv_dis_mgmtsys.model.Stock;
import inv_dis_mgmtsys.model.TemporaryEmployee;
import inv_dis_mgmtsys.services.EmpMa_IServicesImpl;
import inv_dis_mgmtsys.services.StockManagement_IServicesImpl;
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



public class EmpMa_Controller {

	@Autowired
	private EmpMa_IServicesImpl EmpMa_IServices;
	
	@Autowired
	StockManagement_IServicesImpl stockManagement_IServices;

	public EmpMa_Controller() {

		System.out.println(" Inside Emp Management COntroller");

	}
	
	@RequestMapping("/FI")
	public ModelAndView CEODashboardView() {

		return new ModelAndView("/Dashboards/FinanceManager");

	}
	
	@RequestMapping("/empPro")
	public ModelAndView supplierProfile() {

		ModelAndView model = new ModelAndView();
		System.out.println("emp Profile");
		
		HttpSession session = EmpMa_IServices.getHttpsession();
		
		PermanentEmployee p = (PermanentEmployee) session.getAttribute("permanentemployee");
		
		
		PermanentEmployee pemp = EmpMa_IServices.getPermanentEmployees(p.getId());

		model.addObject("permanentemployee", pemp);

		model.setViewName("/Employee Management/MyProfile");
		return model;
	}
	


	@RequestMapping("/Adminemp")
	public ModelAndView AdminDashboardView() {
		ModelAndView model = new ModelAndView();
		
		System.out.println( "Admin profile ");
		
		HttpSession session = EmpMa_IServices.getHttpsession();
		
		PermanentEmployee permanentemployee = (PermanentEmployee) session.getAttribute("permanentemployee");
		
		if( permanentemployee == null) {
			
			System.out.print("null");
			
			return new ModelAndView("/Employee Management/Staff_Login_Page");
		}
		model.addObject("permanentemployee", permanentemployee);
		model.setViewName("/Dashboards/Adminemp");
		return model;

	}
	
	@RequestMapping("/Area_ManagerD")
	public ModelAndView AreaManagerDashboardView() {

		return new ModelAndView("/DistributionManagement/AreaManagerDashboard");
	}

	@RequestMapping("/Area_Manager")
	public ModelAndView AMDashboardView() {
		ModelAndView model = new ModelAndView();
		
		System.out.println( "AM profile ");
		
		HttpSession session = EmpMa_IServices.getHttpsession();
		
		PermanentEmployee permanentemployee = (PermanentEmployee) session.getAttribute("permanentemployee");
		
		if( permanentemployee == null) {
			
			System.out.print("null");
			
			return new ModelAndView("/Employee Management/Staff_Login_Page");
		}
		model.addObject("permanentemployee", permanentemployee);
		model.setViewName("/DistributionManagement/AreaManagerDashboard");
		return model;

	}

	
	
	
	
	@RequestMapping("/DEOemp")
	public ModelAndView DEODashboardView() {
		
         ModelAndView model = new ModelAndView();
		
		System.out.println( "DEO profile ");
		
		HttpSession session = EmpMa_IServices.getHttpsession();
		
		PermanentEmployee permanentemployee = (PermanentEmployee) session.getAttribute("permanentemployee");
		
if( permanentemployee == null) {
			
			System.out.print("null");
			
			return new ModelAndView("/Employee Management/Staff_Login_Page");
		}
		
		model.addObject("permanentemployee", permanentemployee);
		
		model.setViewName("/Dashboards/DEODashboard_emp");
		
		return model;

		

	}

	@RequestMapping("/HRemp")
	public ModelAndView HRDashboardView() {

		return new ModelAndView("/Employee Management/AddNonStaff");

	}
	@RequestMapping("/SM")
	public ModelAndView StockMangerDashboard() {

		ModelAndView model = new ModelAndView();
	
		List<Stock> stockList = stockManagement_IServices.getAllStockDetail();

		model.addObject("stockList", stockList);
		model.setViewName("/StockManagement/StockView");

		return model;

	}
	

	@RequestMapping(value = "/AddStaff", method = RequestMethod.GET)
	public ModelAndView AddStaff(@ModelAttribute("permanentemployee") PermanentEmployee staffemployee) {

		//EmpMa_IServices.addPermanentEmployees(staffemployee);
		return new ModelAndView("/Employee Management/AddStaff");

	}
	@RequestMapping(value = "/AddStaffPOST", method = RequestMethod.POST)
	public ModelAndView AddStaffPOST(@ModelAttribute("permanentemployee") PermanentEmployee staffemployee) {

		
		
		//double totalsal = EmpMa_IServices.calTotalSalPermanent(staffemployee.getBonus(), staffemployee.getSalary());
		
		
		EmpMa_IServices.addPermanentEmployees(staffemployee);
		return new ModelAndView("/Employee Management/ViewStaff");

	}
	
	
	@RequestMapping(value = "/AddStaffDEO", method = RequestMethod.GET)
	public ModelAndView AddStaffDEO(@ModelAttribute("permanentemployee") PermanentEmployee staffemployee) {

		EmpMa_IServices.addPermanentEmployees(staffemployee);
		return new ModelAndView("/Employee Management/AddStaffDEO");

	}
	
	@RequestMapping(value = "/AddMonSalaryHR" , method = RequestMethod.GET)
	public ModelAndView AddSalaryGetHR(@ModelAttribute("emp_month_salary") Emp_Month_Salary salary) {
		
		
		//EmpMa_IServices.addSalary(salary);
		
		return new ModelAndView("/Employee Management/AddMonSalaryHR");
		
		
	}
	@RequestMapping( value ="/AddMonSalary" , method = RequestMethod.GET)
	public ModelAndView AddSalaryGet(@ModelAttribute("emp_month_salary") Emp_Month_Salary salary) {
		
		
		//EmpMa_IServices.addSalary(salary);
		
		return new ModelAndView("/Employee Management/AddMonSalary");
		
		
	}
	
	
	@RequestMapping(value="/AddMonSalaryPOST" , method = RequestMethod.POST)
	public ModelAndView AddSalaryPOST(@ModelAttribute("emp_month_salary") Emp_Month_Salary salary) {
		
		System.out.println("This is output "+salary.getEmp_month_sal_amount());
		
		EmpMa_IServices.addSalary(salary);
		
		return new ModelAndView("redirect:/ViewMonSalary");

		
	}
	
	@RequestMapping(value = "/AddStaffDEOPOST", method = RequestMethod.POST)
	public ModelAndView AddStaffDEOPOST(@ModelAttribute("permanentemployee") PermanentEmployee staffemployee) {

		//double totalsal = EmpMa_IServices.calTotalSalPermanent(staffemployee.getBonus(), staffemployee.getSalary());
		//staffemployee.setTotalsal(totalsal);
		
		
		
		EmpMa_IServices.addPermanentEmployees(staffemployee);
		return new ModelAndView("/Employee Management/AddStaffDEO");

	}
	
	
	
	
	@RequestMapping(value = "/AddNonStaff", method = RequestMethod.GET)
	public ModelAndView AddNonStaff(@ModelAttribute("temporaryemployee") TemporaryEmployee nonstaffemployee) {
		
		EmpMa_IServices.addTEmployees(nonstaffemployee);
		return new ModelAndView("/Employee Management/AddNonStaff");

	}
	
	@RequestMapping(value = "/AddNonStaffPOST", method = RequestMethod.POST)
	public ModelAndView AddNonStaffPOST(@ModelAttribute("temporaryemployee") TemporaryEmployee nonstaffemployee) {
		
		
		//double totalsal = EmpMa_IServices.calTotalSalT(nonstaffemployee.getOt(), nonstaffemployee.getSalary());
		//nonstaffemployee.setTotalsal(totalsal);
		
		EmpMa_IServices.addTEmployees(nonstaffemployee);
		return new ModelAndView("/Employee Management/AddNonStaff");

	}
	@RequestMapping(value = "/AddNonStaffDEO", method = RequestMethod.GET)
	public ModelAndView AddNonStaffDEO(@ModelAttribute("temporaryemployee") TemporaryEmployee nonstaffemployee) {
		EmpMa_IServices.addTEmployees(nonstaffemployee);
		return new ModelAndView("/Employee Management/AddNonStaffDEO");

	}
	
	@RequestMapping(value = "/AddNonStaffDEOPOST", method = RequestMethod.POST)
	public ModelAndView AddNonStaffDEOPOST(@ModelAttribute("temporaryemployee") TemporaryEmployee nonstaffemployee) {
		

		//double totalsal = EmpMa_IServices.calTotalSalT(nonstaffemployee.getOt(), nonstaffemployee.getSalary());
		//nonstaffemployee.setTotalsal(totalsal);
		
		
		EmpMa_IServices.addTEmployees(nonstaffemployee);
		return new ModelAndView("/Employee Management/AddNonStaffDEO");

	}

	
	




	@RequestMapping(value = "/DeleteStaff", method = RequestMethod.GET)
	public ModelAndView DeleteStaff(@ModelAttribute("permanentemployee") PermanentEmployee staffemployee) {

		return new ModelAndView("/Employee Management/DeleteStaff");

	}

	@RequestMapping(value = "/DeleteStaff_POST", method = RequestMethod.POST)
	public ModelAndView DeleteStaff_POST(@RequestParam("id") int id) {

		EmpMa_IServices.deletePermanentEmployees(id);
		return new ModelAndView("redirect:/ViewStaff");

	}

	@RequestMapping(value = "/DeleteNonStaff", method = RequestMethod.GET)
	public ModelAndView DeleteNonStaff(@ModelAttribute("temporaryemployee") TemporaryEmployee nonstaffemployee) {

		return new ModelAndView("/Employee Management/DeleteNonStaff");

	}
	@RequestMapping(value = "/DeleteNonStaff_POST", method = RequestMethod.POST)
	public ModelAndView DeleteNonStaff_POST(@RequestParam("id") int id) {

		EmpMa_IServices.deleteTEmployees(id);
		return new ModelAndView("redirect:/ViewNonStaff");

	}
	
	@RequestMapping( value ="/DeleteSalaryPOST" , method=RequestMethod.GET)
	public ModelAndView DeleteSalary(@RequestParam("emp_month_sal_ID") int id) {
		
		EmpMa_IServices.deleteSalary(id);
		return new ModelAndView("redirect:/ViewMonSalary");
		
		
		
	}
	@RequestMapping("/UpdateMyProfile")
	public ModelAndView updateMyProfile(@RequestParam("id") int id) {
		
		ModelAndView model = new ModelAndView();
		PermanentEmployee permanentEmployee = EmpMa_IServices.getPermanentEmployees(id);
		model.addObject("permanentemployee", permanentEmployee);
		model.setViewName("/Employee Management/UpdateMyProfile");
		return model;
		
		
		
	}
	@RequestMapping(value="/UpdateMyProfile_POST",method=RequestMethod.POST)
	public ModelAndView UpdateStaff_MYPOST(@ModelAttribute("permanentemployee")PermanentEmployee permanentEmployee) {

		EmpMa_IServices.editPermanentEmployees(permanentEmployee);
		return new ModelAndView("redirect:/MyProfile");

	}
	


	@RequestMapping("/UpdateStaff")
	public ModelAndView UpdateStaff(@RequestParam("id") int id) {

		ModelAndView model = new ModelAndView();
		PermanentEmployee permanentEmployee = EmpMa_IServices.getPermanentEmployees(id);
		model.addObject("permanentemployee", permanentEmployee);
		model.setViewName("/Employee Management/UpdateStaff");
		return model;

	}
	
	@RequestMapping(value="/UpdateStaff_POST",method=RequestMethod.POST)
	public ModelAndView UpdateStaff_POST(@ModelAttribute("permanentemployee")PermanentEmployee permanentEmployee) {

		EmpMa_IServices.editPermanentEmployees(permanentEmployee);
		return new ModelAndView("redirect:/ViewStaff");

	}
	
	@RequestMapping(value="/UpdateNonStaff",method=RequestMethod.GET)
	public ModelAndView UpdateNonStaff(@RequestParam("id")int id) {

		
		ModelAndView model = new ModelAndView();
		TemporaryEmployee nonstaffEmployee = EmpMa_IServices.getTEmployees(id);
		model.addObject("temporaryemployee", nonstaffEmployee);
		model.setViewName("/Employee Management/UpdateNonStaff");
		return model;
		
	}
	
	
	@RequestMapping(value="/UpdateMonSalaryHR" , method=RequestMethod.GET)
	public ModelAndView UpdateSalaryHR(@RequestParam("emp_month_sal_ID")int id ) {
		
		ModelAndView model = new ModelAndView();
		Emp_Month_Salary salary = EmpMa_IServices.getSalary(id);
		model.addObject("emp_month_salary", salary);
		model.setViewName("/Employee Management/UpdateMonSalaryHR");
		return model;
		
	}
	
	@RequestMapping(value="/UpdateMonSalary" , method=RequestMethod.GET)
	public ModelAndView UpdateSalary(@RequestParam("emp_month_sal_ID")int id ) {
		
		ModelAndView model = new ModelAndView();
		Emp_Month_Salary salary = EmpMa_IServices.getSalary(id);
		model.addObject("emp_month_salary", salary);
		model.setViewName("/Employee Management/UpdateMonSalary");
		return model;
		
	}
	
	
	@RequestMapping(value="/UpdateMonSalaryPOST" , method=RequestMethod.POST)
	public ModelAndView UpdateMonSalaryPOST(@ModelAttribute("emp_month_salary") Emp_Month_Salary salary) {
		
		EmpMa_IServices.editSalary(salary);
		
		return new ModelAndView("redirect:/ViewMonSalary");
		
		
		
		
	}
	
	@RequestMapping(value="/UpdateMonSalaryPOSTHR" , method=RequestMethod.POST)
	public ModelAndView UpdateMonSalaryPOSTHR(@ModelAttribute("emp_month_salary") Emp_Month_Salary salary) {
		
		EmpMa_IServices.editSalary(salary);
		
		return new ModelAndView("redirect:/ViewMonSalaryHR");
		
		
		
		
	}
	
	
	
	
	
	
	@RequestMapping(value="/UpdateNonStaffPOST",method = RequestMethod.POST)
	public ModelAndView UpdateNonStaffPOST(@ModelAttribute("temporaryemployee") TemporaryEmployee nonstaffemployee) {

		
		EmpMa_IServices.editTEmployees(nonstaffemployee);
		
		return new ModelAndView("redirect:/ViewNonStaff");

		
	}
	

	
	
	
	
	

	@RequestMapping("/ViewStaff")
	public ModelAndView ViewStaff() {

		ModelAndView model = new ModelAndView();
		List emplist = (List) EmpMa_IServices.getPermanentEmployeeDetails("ViewStaff");
		model.addObject("emplist", emplist);
		model.setViewName("/Employee Management/ViewStaff");
		return model;

	}
	@RequestMapping("/ViewMonSalary")
	public ModelAndView ViewMonSalary() {

		ModelAndView model = new ModelAndView();
		List slist = (List) EmpMa_IServices.getEmployeeSalary("ViewMonSalary");
		model.addObject("slist", slist);
		model.setViewName("/Employee Management/ViewMonSalary");
		return model;

	}
	
	@RequestMapping("/ViewMonSalaryHR")
	public ModelAndView ViewSalary() {

		ModelAndView model = new ModelAndView();
		List slist = (List) EmpMa_IServices.getEmployeeSalary("ViewMonSalaryHR");
		model.addObject("slist", slist);
		model.setViewName("/Employee Management/ViewMonSalaryHR");
		return model;

	}



	@RequestMapping("/ViewNonStaff")
	public ModelAndView ViewNonStaff() {
		ModelAndView model = new ModelAndView();
		List emplist = (List) EmpMa_IServices.getTEmployeeDetails("ViewNonStaff");
		model.addObject("emplist", emplist);
		model.setViewName("/Employee Management/ViewNonStaff");
		return model;

	}

	
	@RequestMapping(value="/AdminLoginPOST"  , method=RequestMethod.POST)
	public ModelAndView  AdminLoginPOST(@ModelAttribute("permanentemployee") PermanentEmployee admin) {
		
		
		if( admin.getUsername() == "admin#" && admin.getPassword() == "admin123#") {
		return new ModelAndView("/Dashboards/AdminDashboard_emp");
		
		
		
		}
		
		
		
		return new ModelAndView("redirect:/CEO");
	}
	
	
	
	
	@RequestMapping(value="/AdminLogin" , method=RequestMethod.GET)
	public ModelAndView AdminLogin(@ModelAttribute("permanentemployee") PermanentEmployee admin) {
		
		return new ModelAndView("/UserManagement/Admin_LoginPage");
		
	}
	
	

	@RequestMapping("/StaffLogin")
	public ModelAndView LoginStaff(@ModelAttribute("permanentemployee") PermanentEmployee staffemployee) {

		return new ModelAndView("/UserManagement/Staff_LoginPage");

	}
	
	
	

	@RequestMapping(value = "/StaffLoginPOST", method = RequestMethod.POST)
	public ModelAndView StaffLogin_POST(@ModelAttribute("permanentemployee") PermanentEmployee staffemployee,HttpSession session) {

		System.out.println("Login post");

		System.out.println("Login post");

		PermanentEmployee result = EmpMa_IServices.PermanentEmployeeLogin(staffemployee);

		String position = result.getRole();
		
		if( result != null) {
			
		if (position.equals("CEO")) {
			
			EmpMa_IServices.setHttpsession(session);
			EmpMa_IServices.saveSessionObjectsStaff(result.getId());

			ModelAndView model = new ModelAndView();
			model.setViewName("redirect:/CEO");
			
			return model;
	

			

		}
		else if(position.equals("HR")) {
			
			EmpMa_IServices.setHttpsession(session);
			EmpMa_IServices.saveSessionObjectsStaff(result.getId());
			
			ModelAndView model = new ModelAndView();
			model.setViewName("redirect:/HR");
			return model;
	
			
		}
		else if (position.equals("SM")) {

			EmpMa_IServices.setHttpsession(session);
			EmpMa_IServices.saveSessionObjectsStaff(result.getId());

			ModelAndView model = new ModelAndView();
			model.setViewName("redirect:/SM");
			return model;

		}
		else if(position.equals("AM")) {
			EmpMa_IServices.setHttpsession(session);
		EmpMa_IServices.saveSessionObjectsStaff(result.getId());
		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:/Area_Manager");
		return model;
		}
		
		else if(position.equals("FI")) {
			
		EmpMa_IServices.setHttpsession(session);
		EmpMa_IServices.saveSessionObjectsStaff(result.getId());
		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:/FI");
		return model;
		}
		
		else if(position.equals("HR")) {
			
			EmpMa_IServices.setHttpsession(session);
			EmpMa_IServices.saveSessionObjectsStaff(result.getId());
			ModelAndView model = new ModelAndView();
			model.setViewName("redirect:/HRemp");
			return model;
			}
		
		
		
		
		EmpMa_IServices.setHttpsession(null);}
		
		return new ModelAndView("/UserManagement/Staff_LoginPage");
		

	}
	
	
	@RequestMapping(value = "/perempreport", method = RequestMethod.GET)
	@ResponseBody
	public void getExpenseReport(HttpSession session) throws JRException, IOException {

		//This line needs to be changed
		List<Map<String,Object>> dataSource = EmpMa_IServices.getPermanentEmployeeViewDetails();
		JRDataSource jrDataSource = new JRBeanCollectionDataSource(dataSource);
		String path = session.getServletContext().getRealPath("/Report/");
		//This line needs to be changed
		JasperDesign jasperDesign = JRXmlLoader.load(path + "/Per_Emp_Report.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
		//JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,null , jrDataSource);
		ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpServletResponse response = servletRequestAttributes.getResponse();
		response.setContentType("application/x-pdf");
		//This line needs to be changed
		response.setHeader("Per-Employee-Details", "inline; filename=PerEmpReport.pdf");

		final ServletOutputStream outStream = response.getOutputStream();
		//JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
	}
	
	
	

}
