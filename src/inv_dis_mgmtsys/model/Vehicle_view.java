
package inv_dis_mgmtsys.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "vehicle_view")
public class Vehicle_view {
	

	@Id
	private int ID;
	
	@Column
	private String vehicle_number;
	
	@Column
	private String vehicle_type;


	@Column
	private double vehicle_milage;

	
	public int getID() {
		return ID;
	}


	public void setID(int iD) {
		ID = iD;
	}


	public String getVehicle_number() {
		return vehicle_number;
	}


	public void setVehicle_number(String vehicle_number) {
		this.vehicle_number = vehicle_number;
	}


	public String getVehicle_type() {
		return vehicle_type;
	}


	public void setVehicle_type(String vehicle_type) {
		this.vehicle_type = vehicle_type;
	}


	public double getVehicle_milage() {
		return vehicle_milage;
	}


	public void setVehicle_milage(double vehicle_milage) {
		this.vehicle_milage = vehicle_milage;
	}


	public Date getVehicle_repair_date() {
		return vehicle_repair_date;
	}


	public void setVehicle_repair_date(Date vehicle_repair_date) {
		this.vehicle_repair_date = vehicle_repair_date;
	}


	@Column
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date vehicle_repair_date;
	
	

}	

	