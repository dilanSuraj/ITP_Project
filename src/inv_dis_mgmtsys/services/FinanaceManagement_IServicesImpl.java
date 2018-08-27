package inv_dis_mgmtsys.services;

import java.text.DecimalFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import inv_dis_mgmtsys.dao.FinanaceManagement_IDAOImpl;
import inv_dis_mgmtsys.model.Finance;
import inv_dis_mgmtsys.model.Item;
import inv_dis_mgmtsys.model.Payment;


@Service
public class FinanaceManagement_IServicesImpl implements FinanaceManagement_IServices{

	@Autowired
	FinanaceManagement_IDAOImpl finanaceManagerIDAO;

	@Override
	public void addPaymentDetails(Finance finance) {
		finanaceManagerIDAO.addFinance(finance);		
	}

	
	@Override
	public List<Payment> getPayments(String paymentCategory) {
		List<Payment> payments = finanaceManagerIDAO.getfinancebyCategory(paymentCategory);
		return payments;
	}

	@Override
	public List<Finance> getAllPaymentDetails(String type) {
		
		return finanaceManagerIDAO.getAllFinanceDetails(type);
	
	}

	@Override
	public void deletePaymentDetails(String type,int paymentID) {
		
	    Finance finance = finanaceManagerIDAO.getSingleFinanceDetail(paymentID, type);		
		finanaceManagerIDAO.deleteFinance(finance);
		return;
	}

	@Override
	public void updatePaymentDetails(Finance finance, String type) {
		finanaceManagerIDAO.editFinance(finance, type);
		return;
	}

	@Override
	public Finance getPaymentDetails(int paymentId,String type) {
		
		return finanaceManagerIDAO.getSingleFinanceDetail(paymentId, type);
		
	}


	@Override
	public Item getSingleItemDetail(int ID) {
		return finanaceManagerIDAO.getSingleItemDetail(ID);
	}


	@Override
	public List<Item> getAllItemDetails() {
		System.out.println("In Services");
		return finanaceManagerIDAO.getAllItemDetails();
	}


	@Override
	public void editItemPrice(Item item) {
		
		double itemSalePrice = item.getItem_saleprice();
		double itemGrossPrice = item.getItem_grossprice();
		double profit = itemSalePrice- itemGrossPrice;
		double calPriceProfitPercentage = (profit)/itemGrossPrice;
		DecimalFormat twoDForm = new DecimalFormat("#.##");
		
		item.setItem_percentageProfit(Double.valueOf(twoDForm.format(calPriceProfitPercentage))*100);
		finanaceManagerIDAO.editItemPrice(item);
	}
	
	

}
