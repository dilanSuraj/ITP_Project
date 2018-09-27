package inv_dis_mgmtsys.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import inv_dis_mgmtsys.dao.DistributionManagement_IDAOImpl;
import inv_dis_mgmtsys.model.DeliveryDetails_View;
import inv_dis_mgmtsys.model.ExtraStock_Distribution;
import inv_dis_mgmtsys.model.Item;
import inv_dis_mgmtsys.model.PermanentEmployee;
import inv_dis_mgmtsys.model.Retailer;
import inv_dis_mgmtsys.model.Retailer_Finance_View;
import inv_dis_mgmtsys.model.Retailer_Order;

@Service
public class DistributionManagement_IServicesImpl implements DistributionManagement_IServices {

	@Autowired
	private DistributionManagement_IDAOImpl distributionManagement_IDAOImpl;

	@Override
	public void addExtraStockDetails(ExtraStock_Distribution extrastock) {

		distributionManagement_IDAOImpl.addExtraStockDetails(extrastock);

	}

	@Override
	public List<ExtraStock_Distribution> getAllExtraStock_DistributionDetails() {

		List<ExtraStock_Distribution> list = distributionManagement_IDAOImpl.getAllExtraStock();
		Item item = null;
		int itemCode = 0;
		for (ExtraStock_Distribution extraStock_Distribution : list) {
			itemCode = extraStock_Distribution.getExtra_stock_itemcode();
			item = distributionManagement_IDAOImpl.getSingleItemDetails(itemCode);
			extraStock_Distribution.setItemName(item.getItem_name());
		}
		return list;
	}

	@Override
	public void deleteExtraStock_DistributionDetails(int extrastockID) {
		distributionManagement_IDAOImpl.deleteExtraStockDetails(extrastockID);

	}

	@Override
	public void updateExtraStock_DistributionDetails(ExtraStock_Distribution extrastock) {
		distributionManagement_IDAOImpl.updateExtraStockDetails(extrastock);

	}

	@Override
	public ExtraStock_Distribution getExtraStockDetails(int extrastockId) {
		ExtraStock_Distribution extrastock = distributionManagement_IDAOImpl.getExtraStockDetails(extrastockId);
		int itemCode = extrastock.getExtra_stock_itemcode();
		Item item = distributionManagement_IDAOImpl.getSingleItemDetails(itemCode);
		System.out.println(extrastockId);
		extrastock.setItemName(item.getItem_name());
		return extrastock;

	}

	@Override
	public List<Item> getAllItems() {

		return distributionManagement_IDAOImpl.getAllItems();
	}

	@Override
	public void updateDeliveryDetails(Retailer_Order deliveryOrders) {
		distributionManagement_IDAOImpl.updateDeliveryDetails(deliveryOrders);

	}

	@Override
	public List<Retailer_Order> getAllDeliveryDetails() {

		List<Retailer_Order> listOfRetailerOrders = distributionManagement_IDAOImpl.getAllRetailerOrders();
		List<Retailer> listOfRetailers = distributionManagement_IDAOImpl.getAllRetailers();
		List<PermanentEmployee> listOfPermanentEmployees = distributionManagement_IDAOImpl.getAllDistributionManagers();

		for (Retailer_Order retailer_Order : listOfRetailerOrders) {

			int retailerID = retailer_Order.getRetailer_ID();

			for (Retailer retailer : listOfRetailers) {
				if (retailer.getRetailer_ID() == retailerID) {
					retailer_Order.setRetailer(retailer);
				}
			}

			int distributionManagerID = retailer_Order.getRetailerorder_assigned_manager();
            int salesRepresentativeID = retailer_Order.getSR_ID();
			for (PermanentEmployee employee : listOfPermanentEmployees) {

				if (employee.getId() == distributionManagerID) {
					retailer_Order.setRetailerorder_assigned_manager_Name(employee.getFullname());
				}
				
				if (employee.getId() == salesRepresentativeID) {
					retailer_Order.setSalesRepresentative_Name(employee.getFullname());
				}
			}

		}

		return listOfRetailerOrders;

	}

	public Retailer_Order getSingleRetailerOrderDetails(int id) {

		Retailer_Order retailer_Order = distributionManagement_IDAOImpl.getSingleRetailerOrderDetails(id);
		List<Retailer> listOfRetailers = distributionManagement_IDAOImpl.getAllRetailers();

		int retailerID = retailer_Order.getRetailer_ID();

		for (Retailer retailer : listOfRetailers) {
			if (retailer.getRetailer_ID() == retailerID) {
				System.out.println("Retailer Name"+ retailer.getRetailer_name());
				retailer_Order.setRetailer(retailer);
			}
		}

		return retailer_Order;

	}

	public List<PermanentEmployee> getAllSalesRepresentativeList() {

		return distributionManagement_IDAOImpl.getAllSalesRepresentativeList();
	}
	
	public List<Map<String, Object>> getDeliveryDetailsView() {

		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		List<DeliveryDetails_View> listOfRetailerFinanceView = distributionManagement_IDAOImpl.getAllIncomeViewDetails();
		

		for (DeliveryDetails_View financeView : listOfRetailerFinanceView) {
			Map<String, Object> map = new HashMap<>();
			map.put("retailerOrderID", financeView.getRetailer_ID());
			map.put("retailerName", financeView.getRetailerName());
			map.put("retailerContactNo", financeView.getRetailerContactNo());
			map.put("retailerAddress", financeView.getRetailerAddress());
			map.put("orderTotal", financeView.getOrderTotal());
			map.put("orderDate", financeView.getOrderDate());
			map.put("SRID", financeView.getSRID());


			list.add(map);

		}
		return list;
	}

}
