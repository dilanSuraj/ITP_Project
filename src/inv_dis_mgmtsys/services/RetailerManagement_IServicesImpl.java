package inv_dis_mgmtsys.services;

import java.util.ArrayList; 
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

import inv_dis_mgmtsys.dao.RetailerManagement_IDAO;
import inv_dis_mgmtsys.dao.RetailerManagement_IDAOImpl;
import inv_dis_mgmtsys.model.Notification;
import inv_dis_mgmtsys.model.Retailer;
import inv_dis_mgmtsys.model.Retailer_Report;
 
@Service
public class RetailerManagement_IServicesImpl implements RetailerManagement_IServices {

	@Autowired
	RetailerManagement_IDAOImpl RetailerManagerIDAO;
	
	

	@Autowired
	private HttpSession httpsession;

	public HttpSession getHttpsession() {
		return httpsession;
	}

	public void setHttpsession(HttpSession httpsession) {
		this.httpsession = httpsession;
	}

	@Override
	public void addRetailers(Retailer Retailer) {

		RetailerManagerIDAO.addRetailerDetails(Retailer);
	}

	@Override
	public Retailer login(Retailer Retailer) {

		return RetailerManagerIDAO.Login(Retailer);
	}

	@Override
	public void deleteRetailer(int RetailerID) {

		RetailerManagerIDAO.deleteRetailer(RetailerID);

	}

	@Override
	public void deleteRetailerNotification(int RetailerID) {

		RetailerManagerIDAO.deleteRetailer_Notification(RetailerID);

	}

	@Override
	public void editRetailer(Retailer Retailer) {

		RetailerManagerIDAO.updateRetailerDetails(Retailer);

	}

	@Override
	public Retailer getRetailerDetails(int retailer_ID) {

		return RetailerManagerIDAO.getRetailerDetails(retailer_ID);
	}

	@Override
	public Retailer getRetailerDetails1(int Retailer_notification_ID) {

		return RetailerManagerIDAO.getRetailerDetails(Retailer_notification_ID);
	}

	@Override
	public List<Retailer> getRetailerList() {

		return RetailerManagerIDAO.getRetailerList();
	}

	public List<Notification> getRetailerList1() {

		return RetailerManagerIDAO.getRetailerList1();
	}

	@Override
	public void deleteRetailers(Notification retailer_notification) {

		RetailerManagerIDAO.deleteRetailers(retailer_notification);
	}

	public void saveSessionObjects(int retailer_ID) {

		if (this.httpsession == null) {
			return;
		}

		Retailer retailer = this.getRetailerDetails(retailer_ID);

		httpsession.setAttribute("retailer", retailer);
	}

	@Override
	public void editRetailer2(Retailer retailer) {

		RetailerManagerIDAO.editRetailer(retailer);
	}

	@Override
	public List<Retailer_Report> getRetailerReport(){
		
		return RetailerManagerIDAO.getRetailerReport();
		
	}
	
	public List<Map<String, Object>> getRetailerReportdetails() {

		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		List<Retailer_Report> listOfRetailerView = RetailerManagerIDAO.getRetailerReport();

		for (Retailer_Report RetailerView : listOfRetailerView) {
			Map<String, Object> map = new HashMap<>();
			map.put("retailer_ID", RetailerView.getRetailer_ID());
			map.put("retailer_name", RetailerView.getRetailer_name());
			map.put("retailer_contactno", RetailerView.getRetailer_contactno());
			map.put("retailer_regno", RetailerView.getRetailer_regno());
			map.put("retailer_address", RetailerView.getRetailer_address());
			map.put("retailer_province", RetailerView.getRetailer_province());

			list.add(map);

		}
		return list;
	}
}
