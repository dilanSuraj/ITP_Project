package inv_dis_mgmtsys.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import inv_dis_mgmtsys.dao.SupplierManagement_IDAOImpl;
import inv_dis_mgmtsys.model.Item;
import inv_dis_mgmtsys.model.Supplier;
import inv_dis_mgmtsys.model.Supplier_Finance;
import inv_dis_mgmtsys.model.Supplier_Order;
import inv_dis_mgmtsys.model.Supplier_Report;

@Service("supplierManagement_IServices")

public class SupplierManagement_IServicesImpl implements SupplierManagement_IServices {

	@Autowired
	SupplierManagement_IDAOImpl supplierManagerIDO;

	@Autowired
	private HttpSession httpsession;

	public HttpSession getHttpsession() {
		return httpsession;
	}

	public void setHttpsession(HttpSession httpsession) {
		this.httpsession = httpsession;
	}

	@Override
	public void addSupplier(Supplier supplier) {

		supplierManagerIDO.addSupplierDetails(supplier);
	}

	@Override
	public List<Supplier> getSuppliers(String suppliertitle) {

		List<Supplier> supplier = supplierManagerIDO.getSupplierDetails(suppliertitle);
		return supplier;
	}

	@Override
	public void deleteSupplier(int supplierID) {

		supplierManagerIDO.deleteSupplier(supplierID);

	}

	@Override
	public Supplier getSupplierDetails(int supplieriID) {

		Supplier supplier = supplierManagerIDO.getSupplierDetails(supplieriID);
		return supplier;
	}

	@Override
	public void editSupplier(Supplier supplier) {

		supplierManagerIDO.updateSupplierDetails(supplier);

	}

	@Override
	public Supplier login(Supplier supplier) {

		return supplierManagerIDO.Login(supplier);
	}

	@Override
	public List<Supplier_Finance> getpaymentDetails(int supplier_ID) {

		List<Supplier_Order> supplier_Order = supplierManagerIDO.getSupplierOrder(supplier_ID);
		List<Supplier_Finance> supplier_Finance = new ArrayList<Supplier_Finance>();

		System.out.println(supplier_ID);

		for (Supplier_Order i : supplier_Order) {

			
			System.out.println("this is the one " + i.getSupplier_OrderID());
			Supplier_Finance finance = supplierManagerIDO.getFinanceDetails1(i.getSupplier_OrderID());
			System.out.println("printing the details of the finace" + finance.getPaymentState());
			if (finance.getPaymentState().equals("paid")) {
				
				System.out.println("add to the list");
				supplier_Finance.add(finance);
			}

		}

		

		return supplier_Finance;

	}

	@Override
	public List<Supplier_Finance> getpaymentDetails1(int supplier_ID) {

		List<Supplier_Order> supplier_Order = supplierManagerIDO.getSupplierOrder(supplier_ID);
		List<Supplier_Finance> supplier_Finance = new ArrayList<Supplier_Finance>();

		System.out.println(supplier_ID);

		for (Supplier_Order i : supplier_Order) {

			
			System.out.println("this is the one " + i.getSupplier_OrderID());
			Supplier_Finance finance = supplierManagerIDO.getFinanceDetails1(i.getSupplier_OrderID());
			System.out.println("printing the details of the finace" + finance.getPaymentState());
			if (finance.getPaymentState().equals("not paid")) {
				
				System.out.println("add to the list");
				supplier_Finance.add(finance);
			}

		}
		
		return supplier_Finance;


	}

	@Override
	public double newOrders() {

		return 0;

	}

	public void saveSessionObjects(int supplier_ID) {

		if (this.httpsession == null) {
			System.out.println("Session is null");
			return;
		}
		System.out.println("Inside");

		Supplier supplier = this.getSupplierDetails(supplier_ID);
		Double totalPaid = this.totalPaid(supplier_ID);
		Double totalToBePaid = totalToBePaid(supplier_ID);
		int totalToBesupply = this.totalToBeSupply(supplier_ID);
		int totalSupplied = this.totalSupplied(supplier_ID);

		System.out.println("Saved id " + supplier_ID);
		httpsession.setAttribute("supplier", supplier);
		httpsession.setAttribute("totalPaid", totalPaid);
		httpsession.setAttribute("totalToBePaid", totalToBePaid);
		httpsession.setAttribute("totalToBesupply", totalToBesupply);
		httpsession.setAttribute("totalSupplied", totalSupplied);

	}

	@Override
	public double totalPaid(int supplier_ID) {
		

		List<Supplier_Finance> payment_List = this
				.getpaymentDetails(supplier_ID);

		@SuppressWarnings("unchecked")
		List<Supplier_Finance> supplier_Finances = (List<Supplier_Finance>) (List<?>) payment_List;

		double income = 0;
		for (Supplier_Finance supplierFinances : supplier_Finances) {

			if (supplierFinances.getPaymentState().equals("paid")) {
				income += supplierFinances.getAmount();
			}
		}
		return income;
	}

	@Override
	public double totalToBePaid(int supplier_ID) {
		
		
		List<Supplier_Finance> payment_List = this
				.getpaymentDetails1(supplier_ID);

		@SuppressWarnings("unchecked")
		List<Supplier_Finance> supplier_Finances = (List<Supplier_Finance>) (List<?>) payment_List;

		double income = 0;
		for (Supplier_Finance supplierFinances : supplier_Finances) {

			if (supplierFinances.getPaymentState().equals("not paid")) {
				income += supplierFinances.getAmount();
			}
		}
		return income;
	}
	
	@Override
	public int totalToBeSupply(int supplier_ID) {
		
		
		List<Supplier_Order> SupplierOrderItems = supplierManagerIDO.getSupplierOrder(supplier_ID);

		@SuppressWarnings("unchecked")
		List<Supplier_Order> Order = (List<Supplier_Order>) (List<?>) SupplierOrderItems;

		int amount = 0;
		for (Supplier_Order supplierOder : Order) {

			if (supplierOder.getOrder_Status().equals("Incomplet")) {
			
			amount += supplierOder.getAmount() ;
			}
			
		}
		return amount;
	}
	
	@Override
	public int totalSupplied(int supplier_ID) {
		
		
		List<Supplier_Order> SupplierOrderItems = supplierManagerIDO.getSupplierOrder(supplier_ID);

		@SuppressWarnings("unchecked")
		List<Supplier_Order> Order = (List<Supplier_Order>) (List<?>) SupplierOrderItems;

		int amount = 0;
		for (Supplier_Order supplierOder : Order) {

			if (supplierOder.getOrder_Status().equals("Complet")) {
			
			amount += supplierOder.getAmount() ;
			}
			
		}
		return amount;
	}

	@Override
	public List<Supplier_Order> getSupplierOrderItem(int SupplierID) {
		
		System.out.println("getting item list");
		List<Supplier_Order> supplier_Order = supplierManagerIDO.getSupplierOrder(SupplierID);
		List<Supplier_Order> supplier_item = new ArrayList<Supplier_Order>();

		System.out.println(SupplierID);

		for (Supplier_Order i : supplier_Order) {

			
			System.out.println("this is the supplier_Order" + i.getSupplier_OrderID());
			Item item = supplierManagerIDO.getSupplierOrderItem(i.getItem_code());
			System.out.println("this is item"+item.getItem_name());
			i.setItemname(item.getItem_name());
			if (i.getOrder_Status().equals("Incomplet")) {
				
				System.out.println("add to the list "+i.getAmount()+i.getSupplier_order_date());
				supplier_item.add(i);
			}

		}
		
		return supplier_item;
	}
	@Override
	public List<Supplier_Order> getSupplierOrderItem1(int SupplierID) {
		
		System.out.println("getting item list");
		List<Supplier_Order> supplier_Order = supplierManagerIDO.getSupplierOrder(SupplierID);
		List<Supplier_Order> supplier_item = new ArrayList<Supplier_Order>();

		System.out.println(SupplierID);

		for (Supplier_Order i : supplier_Order) {

			
			System.out.println("this is the supplier_Order" + i.getSupplier_OrderID());
			Item item = supplierManagerIDO.getSupplierOrderItem(i.getItem_code());
			System.out.println("this is item"+item.getItem_name());
			i.setItemname(item.getItem_name());
			if (i.getOrder_Status().equals("Complet")) {
				
				System.out.println("add to the list "+i.getAmount()+i.getSupplier_order_date());
				supplier_item.add(i);
			}

		}
		
		return supplier_item;
	}
	
	@Override
	public List<Supplier_Report> getSupplierReport(){
		
		return supplierManagerIDO.getSupplierReport();
	}
	
	
	 public List<Map<String, Object>> getSupplierViewDetails(){
			
			List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
			List<Supplier_Report> listOfSupplierView = supplierManagerIDO.getSupplierReport();
			
			for(Supplier_Report supplierView : listOfSupplierView) {
				Map<String, Object> map = new HashMap<>();
				map.put("Company", supplierView.getCompany());
				map.put("SALES", supplierView.getSALES());
				map.put("Item_Name",supplierView.getItem_Name());
				
				list.add(map);
							
			}
			return  list;
		}
	
}
