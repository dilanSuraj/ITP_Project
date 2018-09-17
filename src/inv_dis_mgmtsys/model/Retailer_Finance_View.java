package inv_dis_mgmtsys.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "retailer_finance_view")
public class Retailer_Finance_View {

	@Id
	private int ID;
	@Column
	private double paymentAmt;
	@Column
	private Date payment_date;
	@Column
	private Date deadline_payment_date;
	@Column
	private String retailer_name;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public double getPaymentAmt() {
		return paymentAmt;
	}

	public void setPaymentAmt(double paymentAmt) {
		this.paymentAmt = paymentAmt;
	}

	public Date getPayment_date() {
		return payment_date;
	}

	public void setPayment_date(Date payment_date) {
		this.payment_date = payment_date;
	}

	public Date getDeadline_payment_date() {
		return deadline_payment_date;
	}

	public void setDeadline_payment_date(Date deadline_payment_date) {
		this.deadline_payment_date = deadline_payment_date;
	}

	public String getRetailer_name() {
		return retailer_name;
	}

	public void setRetailer_name(String retailer_name) {
		this.retailer_name = retailer_name;
	}

	public double getOder_total() {
		return oder_total;
	}

	public void setOder_total(double oder_total) {
		this.oder_total = oder_total;
	}

	@Column
	private double oder_total;

}
