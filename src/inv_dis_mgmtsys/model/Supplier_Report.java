package inv_dis_mgmtsys.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "supplier_report")
public class Supplier_Report {

	@Id
	private String Item_Name;
	
	@Column
	private String Company;
	
	@Column
	private double SALES;

	public String getItem_Name() {
		return Item_Name;
	}

	public void setItem_Name(String item_Name) {
		Item_Name = item_Name;
	}

	public String getCompany() {
		return Company;
	}

	public void setCompany(String company) {
		Company = company;
	}

	public double getSALES() {
		return SALES;
	}

	public void setSALES(double sALES) {
		SALES = sALES;
	}
	
	
}
