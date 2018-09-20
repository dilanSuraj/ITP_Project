package inv_dis_mgmtsys.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "expenseview")
public class ExpenseView {

	@Id
	private int year;
	
	@Column
	private int month;
	
	@Column
	private double PaidAmt;
	
	@Column
	private String monthName;
	
	

	public String getMonthName() {
		if(month == 1)
			   return "January";
			else if(month == 2)
				   return "February";
			else if(month == 3)
				   return "March";
			else if(month == 4)
				   return "April";
			else if(month == 5)
				   return "May";
			else if(month == 6)
				   return "June";
			else if(month == 7)
				   return "July";
			else if(month == 8)
				   return "August";
			else if(month == 9)
				   return "September";
			else if(month == 10)
				   return "October";
			else if(month == 11)
				   return "November";
			else if(month == 12)
				   return "December";
		
		return "null";
			
	}

	public void setMonthName(String monthName) {
		this.monthName = monthName;
	}

	

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public double getPaidAmt() {
		return PaidAmt;
	}

	public void setPaidAmt(double paidAmt) {
		PaidAmt = paidAmt;
	}
	
	

}
