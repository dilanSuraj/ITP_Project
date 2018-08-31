package inv_dis_mgmtsys.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "vehicle")
public class Vehicle {

	@Id
	private String vehicle_number;

	@Column
	private double vehicle_milage;

	@Column
	private String vehicle_type;

	@Column
	private String vehicle_availabe_status;

	@Column
	private int vehicle_driver_ID;

	@Column
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date vehicle_repair_date;

	public String getVehicle_number() {
		return vehicle_number;
	}

	public void setVehicle_number(String vehicle_number) {
		this.vehicle_number = vehicle_number;
	}

	public double getVehicle_milage() {
		return vehicle_milage;
	}

	public void setVehicle_milage(double vehicle_milage) {
		this.vehicle_milage = vehicle_milage;
	}

	public String getVehicle_type() {
		return vehicle_type;
	}

	public void setVehicle_type(String vehicle_type) {
		this.vehicle_type = vehicle_type;
	}

	public String getVehicle_availabe_status() {
		return vehicle_availabe_status;
	}

	public void setVehicle_availabe_status(String vehicle_availabe_status) {
		this.vehicle_availabe_status = vehicle_availabe_status;
	}

	public int getVehicle_driver_ID() {
		return vehicle_driver_ID;
	}

	public void setVehicle_driver_ID(int vehicle_driver_ID) {
		this.vehicle_driver_ID = vehicle_driver_ID;
	}

	public Date getVehicle_repair_date() {
		return vehicle_repair_date;
	}

	public void setVehicle_repair_date(Date vehicle_repair_date) {
		this.vehicle_repair_date = vehicle_repair_date;
	}
	
	 

}
