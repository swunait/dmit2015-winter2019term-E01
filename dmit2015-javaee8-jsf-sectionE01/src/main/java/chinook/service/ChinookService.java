package chinook.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import chinook.entity.Artist;
import chinook.repository.ArtistRepository;

@Stateless
public class ChinookService {

	@Inject
	private ArtistRepository artistRepository;
	
	public void createArtist(Artist newArtist) {
		artistRepository.create(newArtist);
	}
	
	public List<Artist> findAllArtist() {
		return artistRepository.findAll();
	}
	
	public void deleteArtist(Artist existingArtist) {
		artistRepository.remove(existingArtist);
	}
	public void deleteArtist(int artistId) {
		Artist existingArtist = artistRepository.find(artistId);
		deleteArtist(existingArtist);
	}
	
	public void updateArtist(Artist exisitngArtist) {
		artistRepository.edit(exisitngArtist);
	}
}
