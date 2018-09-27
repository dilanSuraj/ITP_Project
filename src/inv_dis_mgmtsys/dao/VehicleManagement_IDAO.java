package inv_dis_mgmtsys.dao;

import java.util.List;


import inv_dis_mgmtsys.model.PermanentEmployee;
import inv_dis_mgmtsys.model.TemporaryEmployee;
import inv_dis_mgmtsys.model.Vehicle;

public interface VehicleManagement_IDAO {

	void addVehicle(Vehicle vehicle);

	List<Vehicle> getVehicleList();

	void deleteVehicle(String Vehicle_number);

	List<PermanentEmployee> getdriverList();

	void deletevehicle(int driver_perm_emp_id);

	void edit_details_DEO(Vehicle vehicle);

	PermanentEmployee getdriverList(int id);

	Vehicle getVehicle(int id);

	void edit_Details_TransportManager(Vehicle vehicle);

	Vehicle getVehicle(String id);

	void AssignDriver_TransportManager(Vehicle vehicle);


	

	


}
