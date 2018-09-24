package inv_dis_mgmtsys.services;

import java.util.List;

import inv_dis_mgmtsys.model.Notification;
import inv_dis_mgmtsys.model.Retailer;
import inv_dis_mgmtsys.model.Retailer_Report;

public interface RetailerManagement_IServices {

	public void addRetailers(Retailer Retailer);

	public Retailer login(Retailer Retailer);

	public void deleteRetailer(int RetailerID);

	public void editRetailer(Retailer Retailer);

	public Retailer getRetailerDetails(int retailer_ID);
	
	public Retailer getRetailerDetails1(int Retailer_notification_ID);

	public List<Retailer> getRetailerList();

	public List<Notification> getRetailerList1();

	public void deleteRetailers(Notification retailer_notification);

	public void deleteRetailerNotification(int RetailerID);

	public void editRetailer2(Retailer retailer);
	
	public List<Retailer_Report> getRetailerReport();
}