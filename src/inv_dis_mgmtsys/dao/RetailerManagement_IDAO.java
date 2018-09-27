package inv_dis_mgmtsys.dao;

import java.util.List;

import inv_dis_mgmtsys.model.Notification;
import inv_dis_mgmtsys.model.Retailer;
import inv_dis_mgmtsys.model.Retailer_Report;

public interface RetailerManagement_IDAO {

	public void addRetailerDetails(Retailer Retailer);

	public void deleteRetailerDetails(Retailer Retailer);

	public void updateRetailerDetails1(Retailer Retailer);

	public Retailer getRetailerDetails(int RetailerID);

	public Retailer Login(Retailer Retailer);

	public void deleteRetailer(int RetailerID);

	public void updateRetailerDetails(Retailer retailer);
	
	public List<Retailer> getRetailerList();
	
	public List<Notification> getRetailerList1();
	
	public void deleteRetailers(Notification retailer_notification);

	public void deleteRetailer_Notification(int retailer_notification_ID);

	public void editRetailer(Retailer retailer);

	public List<Retailer_Report> getRetailerReport();
}
