package inv_dis_mgmtsys.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "store")
public class Store {

	@Column
	private String store_name;

	@Column
	private String store_address;

	// Primary Key
	@Id
	private int store_ID;

	// Edited before it was transint
	@Column
	private int store_staff_emp_ID;
	
	@Transient
	
	private String staff_name;

	public String getStaff_name() {
		return staff_name;
	}

	public void setStaff_name(String staff_name) {
		this.staff_name = staff_name;
	}

	public String getStore_name() {
		return store_name;
	}

	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}

	public String getStore_address() {
		return store_address;
	}

	public void setStore_address(String store_address) {
		this.store_address = store_address;
	}

	public int getStore_ID() {
		return store_ID;
	}

	public void setStore_ID(int store_ID) {
		this.store_ID = store_ID;
	}

	public int getStore_staff_emp_ID() {
		return store_staff_emp_ID;
	}

	public void setStore_staff_emp_ID(int store_staff_emp_ID) {
		this.store_staff_emp_ID = store_staff_emp_ID;
	}

	
}
