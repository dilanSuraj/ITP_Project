package inv_dis_mgmtsys.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	
	
	public String getSupplier_companyname() {
		return supplier_companyname;
	}

	public void setSupplier_companyname(String supplier_companyname) {
		this.supplier_companyname = supplier_companyname;
	}

	public List<Item> getItemList() {
		return itemList;
	}

	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}

	@OneToMany(mappedBy = "supplier")
	private List<Item> itemList;

	public String getSupplier_name() {
		return supplier_name;
	}

	public List<Item> getItemlist() {
		return itemList;
	}

	public void setItemlist(List<Item> itemlist) {
		this.itemList = itemlist;
	}

	public void setSupplier_ID(int supplier_ID) {
		this.supplier_ID = supplier_ID;
	}

	public int getSupplier_ID() {
		return supplier_ID;
	}

	public void setSupplier_name(String supplier_name) {
		this.supplier_name = supplier_name;
	}
	
	

}
