package inv_dis_mgmtsys.services;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/**
 *
 * @author Senura96
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Map;

import javax.servlet.http.HttpSession;

import java.util.List;

/**
 *
 * @author Senura96
 */
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import inv_dis_mgmtsys.dao.EmpMa_IDAOImpl;
import inv_dis_mgmtsys.model.Emp_Month_Salary;
import inv_dis_mgmtsys.model.Emp_Report;
import inv_dis_mgmtsys.model.IncomeView;
import inv_dis_mgmtsys.model.PermanentEmployee;

import inv_dis_mgmtsys.model.TemporaryEmployee;
@Service("emp_I")
public class EmpMa_IServicesImpl implements EmpMa_IServices {

        @Autowired
        EmpMa_IDAOImpl empManIDAO;
        
        
        @Autowired
    	private static HttpSession httpsession;
        
        
        public HttpSession getHttpsession() {
    		return httpsession;
    	}

    	public void setHttpsession(HttpSession httpsession) {
    		this.httpsession = httpsession;
    	}
    	
        public static HttpSession getSessionforProfile() {
        	
        	
        	return httpsession;
        	
        }
        
      public List<Map<String, Object>> getPermanentEmployeeViewDetails() {

    		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
    		List<Emp_Report> empViewList = empManIDAO.getPerEmpViewDetails();

    		for (Emp_Report s : empViewList) {
    			Map<String, Object> map = new HashMap<>();
    			map.put("id", s.getId());
    			map.put("fullname", s.getFullname());
    			map.put("nic", s.getNic());
    			map.put("gender", s.getGender());
    			map.put("role", s.getRole());

    			list.add(map);

    		}
    		return list;
    	}
    	
    @Override
    public void addPermanentEmployees(PermanentEmployee staffemployee) {
     
        empManIDAO.addPermanentEmployeeDetails(staffemployee);
    }

    @Override
    public void addTEmployees(TemporaryEmployee temployee) {
     empManIDAO.addTEmployeeDetails(temployee);
    }
    
    @Override
    public void addSalary(Emp_Month_Salary salary) {
    	
    empManIDAO.addESalary(salary);
    	
    }


    @Override
    public void editPermanentEmployees(PermanentEmployee staffemployee) {
        empManIDAO.updatePermanentEmployeeDetails(staffemployee);
    }

    @Override
    public void editTEmployees(TemporaryEmployee temployee) {
        empManIDAO.updateTEmployeeDetails(temployee);
    }
    
    @Override
    public void editSalary(Emp_Month_Salary salary) {
    	empManIDAO.updateSalary(salary);
    	
    }

    @Override
    public void deletePermanentEmployees(int id) {
        empManIDAO.deletePermanentEmployeeDetails(id);
    }

    @Override
    public void deleteTEmployees(int id) {
    	
     empManIDAO.deleteTEmployeeDetails(id);
    }
    
    @Override
    public void deleteSalary(int id) {
    	empManIDAO.deleteSalary(id);
    	
    }


    @Override
    public List<PermanentEmployee> getPermanentEmployeeDetails(String emptitle) {
        List<PermanentEmployee> staffemployes =empManIDAO.getPermanentEmployeeDetails( emptitle);
        return staffemployes;
        
    }

    @Override
    public List<TemporaryEmployee> getTEmployeeDetails(String emptitle) {
        List<TemporaryEmployee> nonstaffemployees =  empManIDAO.getTEmployeeDetails(emptitle);
        return nonstaffemployees;
        
    }
    @Override
    public List<Emp_Month_Salary> getEmployeeSalary(String emptitle) {
    	List<Emp_Month_Salary> salary = empManIDAO.getESalary(emptitle);
    	
    	return salary;
    }

    @Override
    public PermanentEmployee getPermanentEmployees(int id) {
       PermanentEmployee staffemployee =empManIDAO.getPermanentEmployee(id);
       return staffemployee;
    }

    @Override
    public TemporaryEmployee getTEmployees(int id) {
       TemporaryEmployee temployee = empManIDAO.getTEmployee(id);
       return temployee;
    }
    @Override
    public Emp_Month_Salary getSalary(int id) {
    	Emp_Month_Salary emp = empManIDAO.getSalary(id);
    	return emp;
    }
    	

    
    
	@Override
	public PermanentEmployee PermanentEmployeeLogin(PermanentEmployee staffemployee) {
		
		return empManIDAO.PermanentEmployeeLogin(staffemployee);
	}

	

	

	
	
	public void saveSessionObjectsStaff(int id) {
		
		if(this.httpsession == null) {
			
			
			System.out.println("Session is null");
			
			
			
		}
		
		System.out.print("Inside");
		
		PermanentEmployee pemployee = this.getPermanentEmployees(id);
		System.out.println("Saved id" + id);
		httpsession.setAttribute("permanentemployee", pemployee);
		httpsession.setAttribute("permanentemployeeName", pemployee.getUsername());
		
		
	}
	
	
	
   @Override
   public double calTotalSalPermanent(double bonus , double salary) {
    	
    	
    	double totalsal;
    	
    	totalsal = salary + (bonus * salary / 100);
    	
    	return totalsal;
    	
    }

  @Override
  public double calTotalSalT(double ot,double salary) {
	
	double totalsal;
	
	totalsal = salary + ot * 0.01 * salary;
	
	return totalsal;
   }


  
 
	  
  






	
    
}
