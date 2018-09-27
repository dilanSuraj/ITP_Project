package inv_dis_mgmtsys.dao;

import java.util.List;
//import java.util.Iterator;

//import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.Query;

import inv_dis_mgmtsys.model.PermanentEmployee;
import inv_dis_mgmtsys.model.TemporaryEmployee;
//import inv_dis_mgmtsys.model.Driver_view;
import inv_dis_mgmtsys.model.Vehicle;
import inv_dis_mgmtsys.model.Vehicle_view;

@Repository
public class VehicleManagement_IDAOImpl implements VehicleManagement_IDAO {

	@Autowired
	private SessionFactory session;

	@Override
	public void addVehicle(Vehicle vehicle) {

		session.getCurrentSession().save(vehicle);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Vehicle> getVehicleList() {

		@SuppressWarnings("rawtypes")
		List list = session.getCurrentSession().createQuery("FROM Vehicle").list();

		return list;

	}

	@Override
	public void deleteVehicle(String Vehicle_number) {
		Vehicle vehicle = (Vehicle) session.getCurrentSession().get(Vehicle.class, Vehicle_number);
		session.getCurrentSession().delete(vehicle);

	}

	public void addvehicle(PermanentEmployee driver) {
		session.getCurrentSession().saveOrUpdate(driver);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PermanentEmployee> getdriverList() {

		String hql = "From PermanentEmployee employee  where employee.role=?";
		Query query = session.getCurrentSession().createQuery(hql);
		query.setParameter(0, "D");
		return query.list();
		

	}

	@Override
	public void deletevehicle(int driver_perm_emp_id) {
		PermanentEmployee driver = (PermanentEmployee) session.getCurrentSession().get(PermanentEmployee.class,
				driver_perm_emp_id);
		session.getCurrentSession().delete(driver);
	}
	@Override
	public void edit_details_DEO(Vehicle vehicle) {

		String hql = "update Vehicle vehicle set vehicle.vehicleAdd_date= ?,vehicle.vehicle_repair_date= ?,vehicle.vehicle_fuelCost= ?,vehicle.vehicle_milage = ? where vehicle.\r\n"
				+ "vehicle_number = ?";
		Query query = session.getCurrentSession().createQuery(hql);

		
		query.setParameter(0, vehicle.getVehicleAdd_date());
		query.setParameter(1, vehicle.getVehicle_repair_date());
		query.setParameter(2, vehicle.getVehicle_fuelCost());
		query.setParameter(3, vehicle.getVehicle_milage());
		System.out.println(vehicle.getVehicle_number());
		query.setParameter(4, vehicle.getVehicle_number());

		int result = query.executeUpdate();
		System.out.println("Results : " + result);
		return;

	}

	@Override
	public PermanentEmployee getdriverList(int id) {

		return (PermanentEmployee) session.getCurrentSession().get(PermanentEmployee.class, id);
	}

	@Override
	public Vehicle getVehicle(int id) {

		return (Vehicle) session.getCurrentSession().get(Vehicle.class, id);
	}

	@Override
	public void edit_Details_TransportManager(Vehicle vehicle) {

		String hql = "update Vehicle vehicle set vehicle.vehicle_type= ?,vehicle.vehicle_milage = ? where vehicle.\r\n"
				+ "vehicle_number = ?";
		Query query = session.getCurrentSession().createQuery(hql);
		query.setParameter(0, vehicle.getVehicle_type());
		query.setParameter(1, vehicle.getVehicle_milage());
		query.setParameter(2, vehicle.getVehicle_number());

		int result = query.executeUpdate();
		System.out.println("Results : " + result);
		return;

	}
	
	@Override
	public void AssignDriver_TransportManager(Vehicle vehicle) {

		String hql = "update Vehicle vehicle set vehicle. \r\n" + 
				"vehicle_driver_ID = ? where vehicle.\r\n"
				+ "vehicle_number = ?";
		Query query = session.getCurrentSession().createQuery(hql);
		query.setParameter(0, vehicle.getVehicle_driver_ID());
		
		query.setParameter(1, vehicle.getVehicle_number());

		int result = query.executeUpdate();
		System.out.println("Results : " + result);
		return;

	}

	@Override
	public Vehicle getVehicle(String id) {
		return (Vehicle) session.getCurrentSession().get(Vehicle.class, id);
	}



	@SuppressWarnings("unchecked")
	public List<Vehicle_view> getAllVehicleReport(){
		
		return session.getCurrentSession().createQuery("From Vehicle_view").list();
	}

}
