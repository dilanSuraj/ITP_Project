package inv_dis_mgmtsys.services;

import java.util.List;

import inv_dis_mgmtsys.model.PermanentEmployee;
import inv_dis_mgmtsys.model.TemporaryEmployee;
import inv_dis_mgmtsys.model.Vehicle;

public interface VehicleManagement_IServices {

	void addNewVehicle_TransportManager(Vehicle vehicle);

	void addVehicleDetails_DEO(Vehicle vehicle);

	List<Vehicle> getVehicleList();

	void deleteVehicle(String vehiclenumber);

	List<PermanentEmployee> getdriverList();

	

	void updateEdit_TransportManager(Vehicle vehicle);


	void updateEDit_DEO(Vehicle vehicle);

	Vehicle getVehicle(String id);

	void assignDriver_TransportManager(Vehicle vehicle);

	
	
	
	
	//public static List<Map<String, Object>> getDriver_view();
	
	
	


	

}
