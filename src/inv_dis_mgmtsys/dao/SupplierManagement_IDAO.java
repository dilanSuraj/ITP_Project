package inv_dis_mgmtsys.dao;

import java.util.List;

import inv_dis_mgmtsys.model.Item;
import inv_dis_mgmtsys.model.Supplier;
import inv_dis_mgmtsys.model.Supplier_Finance;
import inv_dis_mgmtsys.model.Supplier_Order;
import inv_dis_mgmtsys.model.Supplier_Report;

public interface SupplierManagement_IDAO {
	
	public void addSupplierDetails(Supplier supplier);
	
	public List<Supplier> getSupplierDetails(String suppliertitle);

	public void deleteSupplier(int supplierID);
	
	public Supplier getSupplierDetails(int supplier_ID);
	
	public void updateSupplierDetails(Supplier supplier);
	
	public Supplier Login(Supplier supplier);
	
	public Supplier_Order getOderDetails(int supplier_ID);

	public Supplier_Finance getFinanceDetails1(int order_ID);

	public List<Supplier_Finance> getFinanceDetails2(int order_ID);

	public List<Supplier_Finance> getAllFinanceDetails(int supplier_ID);

	public Item getSupplierOrderItem(int SupplierID);

	public List<Supplier_Order> getSupplierOrder(int supplier_ID);

	public List<Item> getSupplierOrderItemList(int supplier_ID);

	public List<Supplier_Report> getSupplierReport();

	

	
}
