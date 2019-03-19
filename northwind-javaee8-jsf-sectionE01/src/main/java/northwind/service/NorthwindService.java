package northwind.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import northwind.entity.Category;
import northwind.entity.Order;
import northwind.entity.Shipper;
import northwind.report.CategorySalesRevenue;

//@ApplicationScoped
//@Transactional
@Stateless
public class NorthwindService {

	@PersistenceContext
	private EntityManager entityManager;
	
	public Order findOrderWithDetails(int orderID) {
		Order singleResult = null;
		try {
			singleResult = entityManager.createQuery(
				"FROM Order o JOIN FETCH o.orderDetails "
				+ " WHERE o.orderID = :idValue"
				, Order.class)
				.setParameter("idValue", orderID)
				.getSingleResult();
		} catch(NonUniqueResultException | NoResultException e) {
			e.printStackTrace();			
		}
		
		return singleResult;
	}
	
	// Return a list of all years with orders (orderDate) sorted descending by the year
	public List<Integer> findYearsWithOrders() {
		return entityManager.createQuery(
			"SELECT YEAR(o.orderDate) AS OrderYear "
				+ " FROM Order o "
				+ " GROUP BY YEAR(o.orderDate) "
				+ " ORDER BY OrderYear DESC",
			Integer.class)
			.getResultList();
	}
	
	public List<CategorySalesRevenue> findCategorySalesRevenuesByYear(Integer salesYear) {
		return entityManager.createQuery(
			"SELECT new northwind.report.CategorySalesRevenue( "
				+ "c.categoryName, "
				+ "SUM(od.unitPrice * od.quantity * (1 - od.discount)) AS SalesTotal "
			+ ")"
			+ " FROM Order o, IN (o.orderDetails) od, IN (od.product) p, IN (p.category) c "
			+ " WHERE o.shippedDate IS NOT NULL AND YEAR(o.shippedDate) = :yearValue"
			+ " GROUP BY c.categoryName "
			+ " ORDER BY SalesTotal DESC ", 			 
			CategorySalesRevenue.class)
			.setParameter("yearValue", salesYear)
			.getResultList();
	}
	
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
