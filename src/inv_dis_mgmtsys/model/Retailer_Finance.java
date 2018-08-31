package inv_dis_mgmtsys.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "retailer_finance")
public class Retailer_Finance implements Finance{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int retailer_finance_id;
		
	public int getRetailer_finance_id() {
		return retailer_finance_id;
	}

	public void setRetailer_finance_id(int retailer_finance_id) {
		this.retailer_finance_id = retailer_finance_id;
	}

	public int getRetailer_orderID() {
		return retailer_orderID;
	}

	public void setRetailer_orderID(int retailer_orderID) {
		this.retailer_orderID = retailer_orderID;
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

	public Date getDeadline_payment_date() {
		return deadline_payment_date;
	}

	public void setDeadline_payment_date(Date deadline_payment_date) {
		this.deadline_payment_date = deadline_payment_date;
	}

	@Column
	private int retailer_orderID;
	
	@Column
	private double amount;
	

	@Column
	private String paymentState;
		
	@Column
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date payment_date;
	
	@Column
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date deadline_payment_date;
	
	@Transient
	private double TotalAmount;
	
	@Transient
	private Retailer retailer;
	
	

	public Retailer getRetailer() {
		return retailer;
	}

	public void setRetailer(Retailer retailer) {
		this.retailer = retailer;
	}

	public double getTotalAmount() {
		return TotalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		TotalAmount = totalAmount;
	}
	
	@Transient
	private List<Retailer_Order> retailerOrderList;

	public List<Retailer_Order> getRetailerOrderList() {
		return retailerOrderList;
	}

	public void setRetailerOrderList(List<Retailer_Order> retailerOrderList) {
		this.retailerOrderList = retailerOrderList;
	}
	

}
