package inv_dis_mgmtsys.model;

import java.text.DateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "other_income_expense")
public class Payment implements Finance{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int other_income_expense_ID;
	
	@Column
	private double other_income_expense_amount;
	
	@Column
	private double other_income_expense_recieved;
	
	public double getOther_income_expense_recieved() {
		return other_income_expense_recieved;
	}

	public void setOther_income_expense_recieved(double other_income_expense_recieved) {
		this.other_income_expense_recieved = other_income_expense_recieved;
	}

	@Column
	private String other_income_expense_paymentstate;
	
	@Column
	private String other_income_expense_category;
	
	@Column
	private String other_income_expense_description;
	
	public String getOther_income_expense_description() {
		return other_income_expense_description;
	}

	public void setOther_income_expense_description(String other_income_expense_description) {
		this.other_income_expense_description = other_income_expense_description;
	}

	@Column
	private String other_income_expense_type;
	
	public String getOther_income_expense_type() {
		return other_income_expense_type;
	}

	public void setOther_income_expense_type(String other_income_expense_type) {
		this.other_income_expense_type = other_income_expense_type;
	}

	@Column
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date other_income_expense_date;
	

	public int getOther_income_expense_ID() {
		return other_income_expense_ID;
	}

	public void setOther_income_expense_ID(int other_income_expense_ID) {
		this.other_income_expense_ID = other_income_expense_ID;
	}

	public double getOther_income_expense_amount() {
		return other_income_expense_amount;
	}

	public void setOther_income_expense_amount(double other_income_expense_amount) {
		this.other_income_expense_amount = other_income_expense_amount;
	}

	public String getOther_income_expense_paymentstate() {
		return other_income_expense_paymentstate;
	}

	public void setOther_income_expense_paymentstate(String other_income_expense_paymentstate) {
		this.other_income_expense_paymentstate = other_income_expense_paymentstate;
	}

	public String getOther_income_expense_category() {
		return other_income_expense_category;
	}

	public void setOther_income_expense_category(String other_income_expense_category) {
		this.other_income_expense_category = other_income_expense_category;
	}

	public Date getOther_income_expense_date() {
		return other_income_expense_date;
	}

	public void setOther_income_expense_date(Date other_income_expense_date) {
		this.other_income_expense_date = other_income_expense_date;
	}

	@Transient
	private String other_income_expense_dateInString;
		
	public String getOther_income_expense_dateInString() {
		return other_income_expense_dateInString = DateFormat.getDateInstance().format(this.other_income_expense_date);
	}

	public void setOther_income_expense_dateInString(String other_income_expense_dateInString) {
		this.other_income_expense_dateInString = other_income_expense_dateInString;
	}


	
	
	
	

}
