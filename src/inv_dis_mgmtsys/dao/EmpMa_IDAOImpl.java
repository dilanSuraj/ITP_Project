package inv_dis_mgmtsys.dao;


import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import inv_dis_mgmtsys.model.Emp_Month_Salary;
import inv_dis_mgmtsys.model.PermanentEmployee;

import inv_dis_mgmtsys.model.TemporaryEmployee;

/**
 *
 * @author Senura96
 */
@Repository
public class EmpMa_IDAOImpl implements EmpMa_IDAO{
@Autowired
private SessionFactory sessionFactory;


    @Override
    public void addPermanentEmployeeDetails(PermanentEmployee staffemployee) {
        sessionFactory.getCurrentSession().saveOrUpdate(staffemployee);
    }

    @Override
    public void addTEmployeeDetails(TemporaryEmployee temployee) {
        sessionFactory.getCurrentSession().saveOrUpdate(temployee);
    }
    
    
    @Override
	public void addESalary(Emp_Month_Salary salary) {
		sessionFactory.getCurrentSession().saveOrUpdate(salary);
		
	}

    @Override
    public List<PermanentEmployee> getPermanentEmployeeDetails(String emptitle) {
        @SuppressWarnings("unchecked")
       List list = sessionFactory.getCurrentSession().createQuery("FROM PermanentEmployee").list();
     return list;   
     
     
     
    }

    @Override
    public List<TemporaryEmployee> getTEmployeeDetails(String emptitle) {
    	 @SuppressWarnings("unchecked")
    	
       List list = sessionFactory.getCurrentSession().createQuery("FROM TemporaryEmployee").list();
        return list;
    }
    

	@Override
	public List<Emp_Month_Salary> getESalary(String emptitle) {
		 @SuppressWarnings("unchecked")
	    	
	       List list = sessionFactory.getCurrentSession().createQuery("FROM EmployeeSalary").list();
	        return list;
	
	}
    
    @Override
    public void deletePermanentEmployeeDetails(int id) {
        
    	PermanentEmployee staffemployee = (PermanentEmployee) sessionFactory.getCurrentSession().get(PermanentEmployee.class,id);
    	sessionFactory.getCurrentSession().delete(staffemployee);
        
    }
    

    @Override
    public void deleteTEmployeeDetails(int id) {
       
    	TemporaryEmployee nonstaffemployee = (TemporaryEmployee) sessionFactory.getCurrentSession().get(TemporaryEmployee.class,id);
    	sessionFactory.getCurrentSession().delete(nonstaffemployee);
    
    }
    @Override
	public void deleteSalary(int id) {
    	Emp_Month_Salary employeesalary = (Emp_Month_Salary) sessionFactory.getCurrentSession().get(Emp_Month_Salary.class,id);
		sessionFactory.getCurrentSession().delete(employeesalary);
	}
    
    

    @Override
    public void updatePermanentEmployeeDetails(PermanentEmployee staffemployee) {
    	
        String hql = "update PermanentEmployee staffemployee set staffemployee.NIC=?,staffemployee.address=?,staffemployee.age=?,staffemployee.bonus=?,staffemployee.fullname=?,staffemployee.gender=?,staffemployee.password=?,staffemployee.phoneno=?,staffemployee.role=?,staffemployee.salary=?,staffemployee.username=?,staffemployee.month=?,staffemployee.year=?,staffemployee.totalsal=? where staffemployee.id=?";
        Query qry = sessionFactory.getCurrentSession().createQuery(hql);
        
        qry.setParameter(0, staffemployee.getNIC());
        qry.setParameter(1, staffemployee.getAddress());
        qry.setParameter(2, staffemployee.getAge());
       
        qry.setParameter(4, staffemployee.getFullname());
        qry.setParameter(5, staffemployee.getGender());
        qry.setParameter(6, staffemployee.getPassword());
        qry.setParameter(7, staffemployee.getPhoneno());
        qry.setParameter(8, staffemployee.getRole());
        qry.setParameter(9, staffemployee.getSalary());
        qry.setParameter(10, staffemployee.getUsername());
      
        
        
     
       
        qry.setParameter(14, staffemployee.getId());
        
    	int result = qry.executeUpdate();
        
    
    
    }

    @Override
    public void updateTEmployeeDetails(TemporaryEmployee nonstaffemployee) {
    	String hql = "update TemporaryEmployee nonstaffemployee set nonstaffemployee.NIC=?,nonstaffemployee.address=?,nonstaffemployee.age=?,nonstaffemployee.fullname=?,nonstaffemployee.gender=?,nonstaffemployee.ot=?,nonstaffemployee.phoneno=?,nonstaffemployee.salary=?,nonstaffemployee.role=?,nonstaffemployee.month=?,nonstaffemployee.year=?,nonstaffemployee.totalsal=? where nonstaffemployee.id=?";
    	Query qry = sessionFactory.getCurrentSession().createQuery(hql);
    	qry.setParameter(0, nonstaffemployee.getNIC());
    	qry.setParameter(1, nonstaffemployee.getAddress());
    	qry.setParameter(2, nonstaffemployee.getAge());
    	qry.setParameter(3, nonstaffemployee.getFullname());
    	qry.setParameter(4, nonstaffemployee.getGender());
    	
    	qry.setParameter(6, nonstaffemployee.getPhoneno());
    	qry.setParameter(7, nonstaffemployee.getSalary());
    	
    	qry.setParameter(8, nonstaffemployee.getRole());


    	qry.setParameter(12, nonstaffemployee.getId());
    	

		int result = qry.executeUpdate();
	
    }

    @Override
	public void updateSalary(Emp_Month_Salary salary) {
		
	String hql="update EmployeeSalary s set s.emp_month_sal_month=?,s.emp_month_sal_year=?,s.emp_month_sal_amount=?,s.emp_month_sal_status=?,s.emp_month_sal_date=?,s.emp_month_sal_category=?,s.emp_month_sal_empID=? where s.emp_month_sal_ID=?";
	Query qry = sessionFactory.getCurrentSession().createQuery(hql);
	
	qry.setParameter(0, salary.getEmp_month_sal_month());
	qry.setParameter(1, salary.getEmp_month_sal_year());
	qry.setParameter(2, salary.getEmp_month_sal_amount());
	qry.setParameter(3, salary.getEmp_month_sal_status());
	qry.setParameter(4, salary.getEmp_month_sal_date());
	qry.setParameter(5, salary.getEmp_month_sal_category());
	qry.setParameter(6, salary.getEmp_month_sal_empID());
	qry.setParameter(7, salary.getEmp_month_sal_ID());
	
	
	int result =qry.executeUpdate();
	
    	
    	
	}


    
    
    @Override
    public PermanentEmployee getPermanentEmployee(int id) {
        return (PermanentEmployee) sessionFactory.getCurrentSession().get(PermanentEmployee.class,id);
       
    }

    @Override
    public TemporaryEmployee getTEmployee(int id) {
        
        return (TemporaryEmployee) sessionFactory.getCurrentSession().get(TemporaryEmployee.class,id);
    }
    
	@Override
	public Emp_Month_Salary getSalary(int id) {
		
		return (Emp_Month_Salary) sessionFactory.getCurrentSession().get(Emp_Month_Salary.class, id);
	}
	
	

	@Override
	public PermanentEmployee PermanentEmployeeLogin(PermanentEmployee staffemployee) {
	
		String hql = "Select staffemployee.id FROM PermanentEmployee staffemployee where staffemployee.username=? AND staffemployee.password=?";
		Query query =  sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter(0, staffemployee.getUsername());
		query.setParameter(1, staffemployee.getPassword());
		
		
		List result = query.list();
		Iterator iterator = result.iterator();
		
		 int empID = 0;
		 while(iterator.hasNext()){
			 empID  = (int) iterator.next();
			 
			 
			 if(!result.isEmpty()) {
	        	   PermanentEmployee sessionemployee = (PermanentEmployee)sessionFactory.getCurrentSession().get(PermanentEmployee.class, empID);
	        	   return sessionemployee;
	        	   
	        	   
	        	   
	        	   
	        	   
	        	   
	           }
			 
			
			 
		 }
		return null;
	}

	
	




	

	
	 public double calTotalSalPermanent(double bonus , double salary) {
	    	
	    	
	    	double totalsal;
	    	
	    	totalsal = salary + (bonus * salary / 100);
	    	
	    	return totalsal;
	    	
	    }

	  
	  public double calTotalSalT(double ot,double salary) {
		
		double totalsal;
		
		totalsal = salary + ot * 0.01 * salary;
		
		return totalsal;
	   }

	


	

	
	
	

    
}
