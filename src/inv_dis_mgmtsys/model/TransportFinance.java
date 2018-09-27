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
@Table(name = "transportpayment")
public class TransportFinance implements Finance{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transportpayment_ID;
	
	@Column
	private double transportpayment_amount;
	
	@Column
	private String transportpayment_state;
	
	@Column
	private String transportpayment_vehicleID;
	
	@Column
	private String transportpayment_category;
	
	@Column
	private String transportpayment_description;
	
	@Transient
	private String other_income_expense_dateInString;
	
	public String getTransportpayment_category() {
		return transportpayment_category;
	}

	public void setTransportpayment_category(String transportpayment_category) {
		this.transportpayment_category = transportpayment_category;
	}

	public String getTransportpayment_description() {
		return transportpayment_description;
	}

	public void setTransportpayment_description(String transportpayment_description) {
		this.transportpayment_description = transportpayment_description;
	}

	@Column
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date transportpayment_date;

	public int getTransportpayment_ID() {
		return transportpayment_ID;
	}

	public void setTransportpayment_ID(int transportpayment_ID) {
		this.transportpayment_ID = transportpayment_ID;
	}

	public double getTransportpayment_amount() {
		return transportpayment_amount;
	}

	public void setTransportpayment_amount(double transportpayment_amount) {
		this.transportpayment_amount = transportpayment_amount;
	}

	public String getTransportpayment_state() {
		return transportpayment_state;
	}

	public void setTransportpayment_state(String transportpayment_state) {
		this.transportpayment_state = transportpayment_state;
	}

	public String getTransportpayment_vehicleID() {
		return transportpayment_vehicleID;
	}

	public void setTransportpayment_vehicleID(String transportpayment_vehicleID) {
		this.transportpayment_vehicleID = transportpayment_vehicleID;
	}

	public Date getTransportpayment_date() {
		return transportpayment_date;
	}

	public void setTransportpayment_date(Date transportpayment_date) {
		this.transportpayment_date = transportpayment_date;
	}
	
	public String getOther_income_expense_dateInString() {
		return other_income_expense_dateInString = DateFormat.getDateInstance().format(this.transportpayment_date);
	}

	public void setOther_income_expense_dateInString(String other_income_expense_dateInString) {
		this.other_income_expense_dateInString = other_income_expense_dateInString;
	}
	
			


}
