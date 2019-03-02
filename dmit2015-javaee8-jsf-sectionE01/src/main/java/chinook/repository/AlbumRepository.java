package chinook.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import chinook.entity.Album;

public class AlbumRepository extends AbstractJpaRepository<Album> {

	public AlbumRepository() {
		super(Album.class);
	}

	@PersistenceContext(unitName="ChinookPU")
	private EntityManager entityManager;
	
	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}
		
}
