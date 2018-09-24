package inv_dis_mgmtsys.dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.List;

import inv_dis_mgmtsys.model.Emp_Month_Salary;
import inv_dis_mgmtsys.model.Emp_Report;
import inv_dis_mgmtsys.model.IncomeView;
import inv_dis_mgmtsys.model.PermanentEmployee;

import inv_dis_mgmtsys.model.TemporaryEmployee;
 public interface EmpMa_IDAO {
    
    public void addPermanentEmployeeDetails(PermanentEmployee staffemployee);
    public void addTEmployeeDetails(TemporaryEmployee temployee);
    public void addESalary(Emp_Month_Salary salary);
    
    
    public List<PermanentEmployee> getPermanentEmployeeDetails(String emptitle);
    public List<TemporaryEmployee> getTEmployeeDetails(String emptitle);
   public List<Emp_Month_Salary>  getESalary(String emptitle);
   public List<Emp_Report> getPerEmpViewDetails();
    
    
    public void deletePermanentEmployeeDetails(int id);
    public void deleteTEmployeeDetails(int id);
    public void deleteSalary(int id);
    
    
    public void updatePermanentEmployeeDetails(PermanentEmployee staffemployee);
    public void updateTEmployeeDetails(TemporaryEmployee temployee);
    public void updateSalary(Emp_Month_Salary salary);
   
  
    
    public PermanentEmployee getPermanentEmployee(int id);
    public TemporaryEmployee getTEmployee(int id);
    public Emp_Month_Salary getSalary(int id);
    
    
    public PermanentEmployee PermanentEmployeeLogin(PermanentEmployee staffemployee);
    
    
    
    
    
    
    
    
}
