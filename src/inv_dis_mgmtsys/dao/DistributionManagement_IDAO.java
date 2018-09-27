package inv_dis_mgmtsys.dao;

import java.util.List;

import inv_dis_mgmtsys.model.DeliveryDetails_View;
import inv_dis_mgmtsys.model.ExtraStock_Distribution;
import inv_dis_mgmtsys.model.IncomeView;
import inv_dis_mgmtsys.model.Item;
import inv_dis_mgmtsys.model.PermanentEmployee;
import inv_dis_mgmtsys.model.Retailer;
import inv_dis_mgmtsys.model.Retailer_Order;
import inv_dis_mgmtsys.model.Vehicle;



public interface DistributionManagement_IDAO {
	
	public void addExtraStockDetails(ExtraStock_Distribution extraStock);

	public List<ExtraStock_Distribution> getAllExtraStock();

	public void deleteExtraStockDetails(int extrastockID);

	public void updateExtraStockDetails(ExtraStock_Distribution extraStock);

	public ExtraStock_Distribution getExtraStockDetails(int extrastockID);
	
	public List<Item> getAllItems();
	
	public List<Vehicle> getAllVehicle();
	
	public Item getSingleItemDetails(int itemCode);

	public List<Retailer_Order> getAllRetailerOrders();

	public List<PermanentEmployee> getAllDistributionManagers();

	public List<Retailer> getAllRetailers();
	
	public List<DeliveryDetails_View> getAllIncomeViewDetails();

	
	
	//sub function 2
	
	public void updateDeliveryDetails(Retailer_Order deliveryOrders);


}
