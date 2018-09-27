package inv_dis_mgmtsys.services;

import java.util.ArrayList;
import java.util.HashMap;
//import java.util.ArrayList;
//import java.util.HashMap;
import java.util.List;
//import java.util.Map;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import inv_dis_mgmtsys.dao.VehicleManagement_IDAOImpl;
import inv_dis_mgmtsys.model.PermanentEmployee;
import inv_dis_mgmtsys.model.TemporaryEmployee;
//import inv_dis_mgmtsys.model.Driver_view;
import inv_dis_mgmtsys.model.Vehicle;
import inv_dis_mgmtsys.model.Vehicle_view;

@Service
public class VehicleManagement_IServicesImpl implements VehicleManagement_IServices{

	@Autowired
	
	private VehicleManagement_IDAOImpl vehicleManagement_IDAO;
	
	@Override
	public void addNewVehicle_TransportManager(Vehicle vehicle) {
		
		vehicleManagement_IDAO.addVehicle(vehicle);
		
		
	}
	@Override
	public void addVehicleDetails_DEO(Vehicle vehicle) {
		vehicleManagement_IDAO.edit_details_DEO(vehicle);
	}
	

	@Override
	public void deleteVehicle(String vehiclenumber) {
		vehicleManagement_IDAO.deleteVehicle(vehiclenumber);
		
	}

	
	
	@Override
	public List<PermanentEmployee> getdriverList(){
		return vehicleManagement_IDAO.getdriverList();
		
	}
	

	

	@Override
	public void updateEdit_TransportManager(Vehicle vehicle) {
		vehicleManagement_IDAO.edit_Details_TransportManager(vehicle);
		
	}
	
	@Override
	public void assignDriver_TransportManager(Vehicle vehicle) {
		vehicleManagement_IDAO.AssignDriver_TransportManager(vehicle);
		
	}

	@Override
	public List<Vehicle> getVehicleList() {
		
		List<Vehicle> vehicleList = vehicleManagement_IDAO.getVehicleList();
		List<PermanentEmployee> driverList = vehicleManagement_IDAO.getdriverList();
		
		for(Vehicle vehicle:vehicleList) {
			int driverID = vehicle.getVehicle_driver_ID();
			System.out.println(vehicle.getVehicle_driver_ID());
			for(PermanentEmployee employee:driverList) {
				if(driverID == employee.getId()) {
					vehicle.setVehicle_driver_name(employee.getFullname());
				}
			}
		}
		return vehicleList;
	}

	@Override
	public void updateEDit_DEO(Vehicle vehicle) {
		vehicleManagement_IDAO.edit_details_DEO(vehicle);
		
		
	}

	@Override
	public Vehicle getVehicle(String id) {
		return vehicleManagement_IDAO.getVehicle(id);
	}
	
	
	
	 public List<Map<String, Object>> getVehicleViewDetails(){
			
			List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
			List<Vehicle_view> listOfRetailerFinanceView = vehicleManagement_IDAO.getAllVehicleReport();
			
			for(Vehicle_view financeView : listOfRetailerFinanceView) {
				Map<String, Object> map = new HashMap<>();
				map.put("vehicle_number", financeView.getVehicle_number());
				map.put("vehicle_type", financeView.getVehicle_type());
				map.put("vehicle_milage",financeView.getVehicle_milage());
				map.put("vehicle_repair_date", financeView.getVehicle_repair_date());
				
				list.add(map);
							
			}
			return  list;
		}
		
}
