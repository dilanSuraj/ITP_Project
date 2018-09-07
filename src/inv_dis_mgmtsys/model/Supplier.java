package inv_dis_mgmtsys.model;

import javax.persistence.Column; 
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "supplier")
public class Supplier {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int supplier_ID;

	@Column
	private String supplier_name;
	
	@Column
	private String supplier_companyname;
	
	@Column
	private String supplier_username;
	
	@Column
	private String supplier_address;
	
	@Column
	private int supplier_regNo;
	
	@Column
	private int supplier_contactno;
	
	@Column
	private String supplier_password;

	public String getSupplier_name() {
		return supplier_name;
	}

	public int getSupplier_ID() {
		return supplier_ID;
	}

	public void setSupplier_name(String supplier_name) {
		this.supplier_name = supplier_name;
	}

	public String getSupplier_companyname() {
		return supplier_companyname;
	}

	public void setSupplier_companyname(String supplier_companyname) {
		this.supplier_companyname = supplier_companyname;
	}

	public String getSupplier_username() {
		return supplier_username;
	}

	public void setSupplier_username(String supplier_username) {
		this.supplier_username = supplier_username;
	}

	public String getSupplier_address() {
		return supplier_address;
	}

	public void setSupplier_address(String supplier_address) {
		this.supplier_address = supplier_address;
	}

	public int getSupplier_regNo() {
		return supplier_regNo;
	}

	public void setSupplier_regNo(int supplier_regNo) {
		this.supplier_regNo = supplier_regNo;
	}

	public int getSupplier_contactno() {
		return supplier_contactno;
	}

	public void setSupplier_contactno(int supplier_contactno) {
		this.supplier_contactno = supplier_contactno;
	}

	public String getSupplier_password() {
		return supplier_password;
	}

	public void setSupplier_password(String supplier_password) {
		this.supplier_password = supplier_password;
	}

}
