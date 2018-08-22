package inv_dis_mgmtsys.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "supplier_finance")
public class Supplier_Finance implements Finance{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int supplier_finance_id;
		
	public int getSupplier_finance_id() {
		return supplier_finance_id;
	}

	@Column
	private int supplier_orderID;
	
	@Column
	private double amount;
	

	@Column
	private String paymentState;
		
	@Column
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date payment_date;
	

	public int getSupplier_orderID() {
		return supplier_orderID;
	}

	public void setSupplier_orderID(int supplier_orderID) {
		this.supplier_orderID = supplier_orderID;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getPaymentState() {
		return paymentState;
	}

	public void setPaymentState(String paymentState) {
		this.paymentState = paymentState;
	}

	public Date getPayment_date() {
		return payment_date;
	}

	public void setPayment_date(Date payment_date) {
		this.payment_date = payment_date;
	}



	
}
