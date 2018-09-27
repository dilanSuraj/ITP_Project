package inv_dis_mgmtsys.services;

import java.util.List;

import org.springframework.stereotype.Service;

import inv_dis_mgmtsys.model.Supplier;
import inv_dis_mgmtsys.model.Supplier_Finance;
import inv_dis_mgmtsys.model.Supplier_Order;
import inv_dis_mgmtsys.model.Supplier_Report;


@Service

public interface SupplierManagement_IServices {

	public void addSupplier(Supplier supplier);
	
	public List<Supplier> getSuppliers(String suppliertitle);
	
	public void deleteSupplier(int supplierID);

	public Supplier getSupplierDetails(int id);

	public void editSupplier(Supplier supplier);
	
	public Supplier login(Supplier supplier);
	
	public List<Supplier_Finance> getpaymentDetails(int supplier_ID);

	public List<Supplier_Finance> getpaymentDetails1(int supplier_ID);

	public double newOrders();

	public double totalPaid(int supplieriID);

	public double totalToBePaid(int supplier_ID);

	public int totalToBeSupply(int supplier_ID);

	public List<Supplier_Order> getSupplierOrderItem(int SupplierID);

	public List<Supplier_Order> getSupplierOrderItem1(int SupplierID);

	public int totalSupplied(int supplier_ID);

	public List<Supplier_Report> getSupplierReport();

	public List<Supplier_Finance> getpaymentDetailsa(int supplier_ID);
	
}
