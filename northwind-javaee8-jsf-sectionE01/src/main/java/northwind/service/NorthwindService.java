package northwind.service;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import northwind.entity.Shipper;

@ApplicationScoped
public class NorthwindService implements Serializable {
	private static final long serialVersionUID = 1L;

	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public List<Shipper> findAllShipper() {
		return entityManager.createQuery(
			"FROM Shipper s ORDER BY s.companyName", Shipper.class)
			.getResultList();
	}
	
	@Transactional
	public void createNewShipper(Shipper newShipper) {
		int nextShipperID = (int) entityManager.createQuery(
			"SELECT MAX(s.shipperID) + 1 FROM Shipper s"
			).getSingleResult(); 
		newShipper.setShipperID(nextShipperID);
		entityManager.persist(newShipper);
	}
	
	@Transactional
	public void removeShipper(Shipper existingShipper) {
		entityManager.remove(existingShipper);
	}
	
}
