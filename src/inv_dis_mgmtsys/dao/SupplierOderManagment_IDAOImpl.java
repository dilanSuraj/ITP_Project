package inv_dis_mgmtsys.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import inv_dis_mgmtsys.model.Item;
import inv_dis_mgmtsys.model.Supplier;

public class SupplierOderManagment_IDAOImpl implements SupplierOderManagment_IDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public List<Item> getItems() {
		@SuppressWarnings("unchecked")
		List<Item> list = (List<Item>) sessionFactory.getCurrentSession()
				.createQuery("from Item").list();

		for(Item i:list) {
			
			int supplier_ID=i.getItem_supplier_ID();
			
			Query query = sessionFactory.getCurrentSession().createQuery("from Supplier s where c.supplier_ID=:id");
			query.setParameter("id", supplier_ID);
			Supplier supplier= (Supplier)query.list().get(0);
			i.setSupplier_Name(supplier.getSupplier_name());
		}
		return list;
	}

	
}
