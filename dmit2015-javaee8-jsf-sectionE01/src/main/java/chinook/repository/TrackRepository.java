package chinook.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import chinook.entity.Track;

public class TrackRepository extends AbstractJpaRepository<Track> {

	public TrackRepository() {
		super(Track.class);
	}

	@PersistenceContext(unitName="ChinookPU")
	private EntityManager entityManager;
	
	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}
		
}
