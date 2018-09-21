package inv_dis_mgmtsys.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "deleted_stakeholders")
public class Deleted_stakeholders {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int deleted_stakeholder_ID ;
	
	@Column
	private String deleted_stakeholder_name;
	
	@Column
	private int deleted_stakeholder_contact;
	
	@Column
	private String deleted_stakeholder_role;
	
	@Column
	private String deleted_stakeholder_reason;

	public int getDeleted_stakeholder_ID() {
		return deleted_stakeholder_ID;
	}

	public void setDeleted_stakeholder_ID(int deleted_stakeholder_ID) {
		this.deleted_stakeholder_ID = deleted_stakeholder_ID;
	}

	public String getDeleted_stakeholder_name() {
		return deleted_stakeholder_name;
	}

	public void setDeleted_stakeholder_name(String deleted_stakeholder_name) {
		this.deleted_stakeholder_name = deleted_stakeholder_name;
	}

	public int getDeleted_stakeholder_contact() {
		return deleted_stakeholder_contact;
	}

	public void setDeleted_stakeholder_contact(int deleted_stakeholder_contact) {
		this.deleted_stakeholder_contact = deleted_stakeholder_contact;
	}

	public String getDeleted_stakeholder_role() {
		return deleted_stakeholder_role;
	}

	public void setDeleted_stakeholder_role(String deleted_stakeholder_role) {
		this.deleted_stakeholder_role = deleted_stakeholder_role;
	}

	public String getDeleted_stakeholder_reason() {
		return deleted_stakeholder_reason;
	}

	public void setDeleted_stakeholder_reason(String deleted_stakeholder_reason) {
		this.deleted_stakeholder_reason = deleted_stakeholder_reason;
	}
	
}
