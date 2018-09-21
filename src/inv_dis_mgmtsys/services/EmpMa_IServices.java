package inv_dis_mgmtsys.services;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.List;

import inv_dis_mgmtsys.model.Emp_Month_Salary;
import inv_dis_mgmtsys.model.PermanentEmployee;

import inv_dis_mgmtsys.model.TemporaryEmployee;
/**
 *
 * @author Senura96
 */
public interface EmpMa_IServices {
    
    
    public void addPermanentEmployees(PermanentEmployee staffemployee);
    public void addTEmployees(TemporaryEmployee temployee);
    public void addSalary(Emp_Month_Salary salary);
    
    public void editPermanentEmployees(PermanentEmployee staffemployee);
    public void editTEmployees(TemporaryEmployee temployee);
    public void editSalary(Emp_Month_Salary salary);
    
    public void deletePermanentEmployees(int id);
    public void deleteTEmployees(int id);
    public void deleteSalary(int id);
    
    
    
    
    
    
    
    public List<PermanentEmployee>  getPermanentEmployeeDetails(String emptitle);
    public List<TemporaryEmployee> getTEmployeeDetails(String emptitle);
    public List<Emp_Month_Salary>   getEmployeeSalary(String emptitle);
    
    public PermanentEmployee getPermanentEmployees(int id);
    public TemporaryEmployee getTEmployees(int id);
    public Emp_Month_Salary getSalary(int id);
   
    
    public PermanentEmployee PermanentEmployeeLogin(PermanentEmployee staffemployee);
    

    
    public double calTotalSalPermanent(double bonus , double salary);
    
    
    public double calTotalSalT(double ot,double salary);
    	
    	
    	
    
    
    
}
