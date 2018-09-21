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

import inv_dis_mgmtsys.model.Admin;
import inv_dis_mgmtsys.model.Emp_Month_Salary;
import inv_dis_mgmtsys.model.PermanentEmployee;

import inv_dis_mgmtsys.model.TemporaryEmployee;
import inv_dis_mgmtsys.services.EmpMa_IServicesImpl;

@Controller
@Transactional
public class EmpMa_Controller {

	@Autowired
	private EmpMa_IServicesImpl EmpMa_IServices;

	public EmpMa_Controller() {

		System.out.println(" Inside Emp Management COntroller");

	}

	@RequestMapping("/FI")
	public ModelAndView CEODashboardView() {

		return new ModelAndView("/Dashboards/FinanceManager");

	}

	@RequestMapping("/Adminemp")
	public ModelAndView AdminDashboardView() {
		ModelAndView model = new ModelAndView();

		System.out.println("Admin profile ");

		HttpSession session = EmpMa_IServices.getHttpsession();

		PermanentEmployee permanentemployee = (PermanentEmployee) session.getAttribute("permanentemployee");

		if (permanentemployee == null) {

			System.out.print("null");

			return new ModelAndView("/Employee Management/Staff_Login_Page");
		}
		model.addObject("permanentemployee", permanentemployee);
		model.setViewName("/Dashboards/Adminemp");
		return model;

	}

	@RequestMapping("/DEOemp")
	public ModelAndView DEODashboardView() {

		ModelAndView model = new ModelAndView();

		System.out.println("DEO profile ");

		HttpSession session = EmpMa_IServices.getHttpsession();

		PermanentEmployee permanentemployee = (PermanentEmployee) session.getAttribute("permanentemployee");

		model.addObject("permanentemployee", permanentemployee);

		model.setViewName("/Dashboards/DEODashboard_emp");

		return model;

	}

	@RequestMapping("/HRemp")
	public ModelAndView HRDashboardView() {

		return new ModelAndView("/Dashboards/HrDashboard_emp");

	}

	@RequestMapping(value = "/AddStaff", method = RequestMethod.GET)
	public ModelAndView AddStaff(@ModelAttribute("permanentemployee") PermanentEmployee staffemployee) {

		// EmpMa_IServices.addPermanentEmployees(staffemployee);
		return new ModelAndView("/Employee Management/AddStaff");

	}

	@RequestMapping(value = "/AddStaffPOST", method = RequestMethod.POST)
	public ModelAndView AddStaffPOST(@ModelAttribute("permanentemployee") PermanentEmployee staffemployee) {

		

		EmpMa_IServices.addPermanentEmployees(staffemployee);
		return new ModelAndView("/Employee Management/AddStaff");

	}

	@RequestMapping(value = "/AddStaffDEO", method = RequestMethod.GET)
	public ModelAndView AddStaffDEO(@ModelAttribute("permanentemployee") PermanentEmployee staffemployee) {

		EmpMa_IServices.addPermanentEmployees(staffemployee);
		return new ModelAndView("/Employee Management/AddStaffDEO");

	}

	@RequestMapping(value = "/AddSalary", method = RequestMethod.GET)
	public ModelAndView AddSalaryGet(@ModelAttribute("emp_month_salary") Emp_Month_Salary salary) {

		// EmpMa_IServices.addSalary(salary);

		return new ModelAndView("/Employee Management/AddMonSalary");

	}

	@RequestMapping(value = "/AddSalaryPOST", method = RequestMethod.POST)
	public ModelAndView AddSalaryPOST(@ModelAttribute("emp_month_salary") Emp_Month_Salary salary) {
		EmpMa_IServices.addSalary(salary);
		return new ModelAndView("/Employee Management/ViewMonSalary");

	}

	@RequestMapping(value = "/AddStaffDEOPOST", method = RequestMethod.POST)
	public ModelAndView AddStaffDEOPOST(@ModelAttribute("permanentemployee") PermanentEmployee staffemployee) {

		

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

	@RequestMapping(value = "/DeleteSalaryPOST", method = RequestMethod.GET)
	public ModelAndView DeleteSalary(@RequestParam("emp_month_sal_ID") int id) {

		EmpMa_IServices.deleteSalary(id);
		return new ModelAndView("redirect:/ViewMonSalary");

	}

	@RequestMapping("/UpdateStaff")
	public ModelAndView UpdateStaff(@RequestParam("id") int id) {

		ModelAndView model = new ModelAndView();
		PermanentEmployee permanentEmployee = EmpMa_IServices.getPermanentEmployees(id);
		model.addObject("permanentemployee", permanentEmployee);
		model.setViewName("/Employee Management/UpdateStaff");
		return model;

	}

	@RequestMapping(value = "/UpdateStaff_POST", method = RequestMethod.POST)
	public ModelAndView UpdateStaff_POST(@ModelAttribute("permanentemployee") PermanentEmployee permanentEmployee) {

		EmpMa_IServices.editPermanentEmployees(permanentEmployee);
		return new ModelAndView("redirect:/ViewStaff");

	}

	@RequestMapping(value = "/UpdateNonStaff", method = RequestMethod.GET)
	public ModelAndView UpdateNonStaff(@RequestParam("id") int id) {

		ModelAndView model = new ModelAndView();
		TemporaryEmployee nonstaffEmployee = EmpMa_IServices.getTEmployees(id);
		model.addObject("temporaryemployee", nonstaffEmployee);
		model.setViewName("/Employee Management/UpdateNonStaff");
		return model;

	}

	@RequestMapping(value = "/UpdateMonSalary", method = RequestMethod.GET)
	public ModelAndView UpdateSalary(@RequestParam("emp_month_sal_ID") int id) {

		ModelAndView model = new ModelAndView();
		Emp_Month_Salary salary = EmpMa_IServices.getSalary(id);
		model.addObject("emp_month_salary", salary);
		model.setViewName("/Employee Management/UpdateMonSalary");
		return model;

	}

	@RequestMapping(value = "/UpdateMonSalaryPOST", method = RequestMethod.POST)
	public ModelAndView UpdateMonSalaryPOST(@ModelAttribute("emp_month_salary") Emp_Month_Salary salary) {

		EmpMa_IServices.editSalary(salary);

		return new ModelAndView("redirect:/ViewMonSalary");

	}

	@RequestMapping(value = "/UpdateNonStaffPOST", method = RequestMethod.POST)
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
	public ModelAndView ViewSalary() {

		ModelAndView model = new ModelAndView();
		List slist = (List) EmpMa_IServices.getEmployeeSalary("ViewMonSalary");
		model.addObject("slist", slist);
		model.setViewName("/Employee Management/ViewMonSalary");
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

	@RequestMapping(value = "/AdminLoginPOST", method = RequestMethod.POST)
	public ModelAndView AdminLoginPOST(@ModelAttribute("admin") Admin admin) {

		if (admin.getUsername() == "admin#" && admin.getPassword() == "admin123#") {
			return new ModelAndView("/Dashboards/AdminDashboard_emp");

		}

		return new ModelAndView("redirect:/Admin_LoginPage");
	}

	@RequestMapping(value = "/AdminLogin", method = RequestMethod.GET)
	public ModelAndView AdminLogin(@ModelAttribute("admin") Admin admin) {

		return new ModelAndView("/UserManagement/Admin_LoginPage");

	}

	@RequestMapping("/StaffLogin")
	public ModelAndView LoginStaff(@ModelAttribute("permanentemployee") PermanentEmployee staffemployee) {

		return new ModelAndView("/UserManagement/Staff_LoginPage");

	}

	@RequestMapping(value = "/StaffLoginPOST", method = RequestMethod.POST)
	public ModelAndView StaffLogin_POST(@ModelAttribute("permanentemployee") PermanentEmployee staffemployee,
			HttpSession session) {

		System.out.println("Login post");

		System.out.println("Login post");

		PermanentEmployee result = EmpMa_IServices.PermanentEmployeeLogin(staffemployee);

		String position = result.getRole();

		if (result != null) {

			if (position.equals("CEO")) {

				EmpMa_IServices.setHttpsession(session);
				EmpMa_IServices.saveSessionObjectsStaff(result.getId());

				ModelAndView model = new ModelAndView();
				model.setViewName("redirect:/CEO");

				return model;

			} else if (position.equals("HR")) {

				EmpMa_IServices.setHttpsession(session);
				EmpMa_IServices.saveSessionObjectsStaff(result.getId());

				ModelAndView model = new ModelAndView();
				model.setViewName("redirect:/HR");
				return model;

			}

			else if (position.equals("FI")) {

				EmpMa_IServices.setHttpsession(session);
				EmpMa_IServices.saveSessionObjectsStaff(result.getId());

				ModelAndView model = new ModelAndView();
				model.setViewName("redirect:/FI");
				return model;

			}

		}

		EmpMa_IServices.setHttpsession(null);
		return new ModelAndView("/UserManagement/Staff_LoginPage");

	}

}
