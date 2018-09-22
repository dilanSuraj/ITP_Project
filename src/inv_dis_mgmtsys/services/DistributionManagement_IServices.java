package inv_dis_mgmtsys.services;

import java.util.List;

import inv_dis_mgmtsys.model.ExtraStock_Distribution;
import inv_dis_mgmtsys.model.Item;
import inv_dis_mgmtsys.model.Retailer_Order;

public interface DistributionManagement_IServices {
	
	public void addExtraStockDetails(ExtraStock_Distribution extrastock);
	
    public List<ExtraStock_Distribution> getAllExtraStock_DistributionDetails();

	public void deleteExtraStock_DistributionDetails(int extrastockID);

	public void updateExtraStock_DistributionDetails(ExtraStock_Distribution extrastock);

	public ExtraStock_Distribution getExtraStockDetails(int extrastockId);
	
	public List<Item> getAllItems();

	public List<Retailer_Order> getAllDeliveryDetails();
	
	
	public void updateDeliveryDetails(Retailer_Order deliveryOrders);

}
