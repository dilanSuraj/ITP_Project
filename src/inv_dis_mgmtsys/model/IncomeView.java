package inv_dis_mgmtsys.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "incomeview")
public class IncomeView {

	@Column
	private int year;
	
	@Id
	private int id;
	
	@Column
	private int month;
	
	@Transient
	private String monthInString;
	
	
	public String getMonthInString() {
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
		return null;
	}

	public void setMonthInString(String monthInString) {
		this.monthInString = monthInString;
	}

	@Column
	private double paidAmt;

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
		return paidAmt;
	}

	public void setPaidAmt(double paidAmt) {
		this.paidAmt = paidAmt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	 
	
}




