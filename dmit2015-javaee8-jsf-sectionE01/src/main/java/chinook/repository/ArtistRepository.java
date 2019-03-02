package chinook.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import chinook.entity.Artist;

public class ArtistRepository extends AbstractJpaRepository<Artist> {

	public ArtistRepository() {
		super(Artist.class);
	}

	@PersistenceContext(unitName="ChinookPU")
	private EntityManager entityManager;
	
	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}
		
}
