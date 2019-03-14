package northwind.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import northwind.entity.Category;
import northwind.entity.Shipper;
import northwind.report.CategorySalesRevenue;

//@ApplicationScoped
//@Transactional
@Stateless
public class NorthwindService {

	@PersistenceContext
	private EntityManager entityManager;
	
	public List<CategorySalesRevenue> findCategorySalesRevenues() {
		return entityManager.createQuery(
			"SELECT new northwind.report.CategorySalesRevenue( "
				+ "c.categoryName, "
				+ "SUM(od.unitPrice * od.quantity * (1 - od.discount)) AS SalesTotal "
			+ ")"
			+ " FROM Order o, IN (o.orderDetails) od, IN (od.product) p, IN (p.category) c "
			+ " GROUP BY c.categoryName "
			+ " ORDER BY SalesTotal DESC ", 			 
			CategorySalesRevenue.class)
			.getResultList();
	}
	
	public List<Shipper> findAllShipper() {
		return entityManager.createQuery(
			"FROM Shipper s ORDER BY s.companyName", Shipper.class)
			.getResultList();
	}
	
	public void createNewShipper(Shipper newShipper) {
//		int nextShipperID = (int) entityManager.createQuery(
//			"SELECT MAX(s.shipperID) + 1 FROM Shipper s"
//			).getSingleResult(); 
//		newShipper.setShipperID(nextShipperID);
		entityManager.persist(newShipper);
	}
	
	public void updateShipper(Shipper existingShipper) {
		entityManager.merge(existingShipper);
	}
	
	
	public void removeShipper(Shipper existingShipper) {
		if (!entityManager.contains(existingShipper) ) {
			existingShipper = entityManager.merge(existingShipper);
		}
		entityManager.remove(existingShipper);
	}
	
	
	public List<Category> findAllCategory() {
		return entityManager.createQuery(
			"FROM Category c ORDER BY c.categoryName", Category.class)
			.getResultList();
	}
	
	public void createNewCategory(Category newCategory) {
		entityManager.persist(newCategory);
	}
	
	public void updateCategory(Category existingCategory) {
		entityManager.merge(existingCategory);
	}
	
	
	public void removeCategory(Category existingCategory) {
		if (!entityManager.contains(existingCategory) ) {
			existingCategory = entityManager.merge(existingCategory);
		}
		entityManager.remove(existingCategory);
	}
	
}
