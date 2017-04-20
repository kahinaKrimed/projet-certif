package appliAngular.dao;

import java.util.List;

import appliAngular.representation.NowPlayingFilmRepresentation;

public interface NowPlayingFilmDao extends DaoGeneric<NowPlayingFilmRepresentation, Long>{
	public List<NowPlayingFilmRepresentation> saveAllFilmsInDb();
	List<NowPlayingFilmRepresentation> findAll();
	public List<NowPlayingFilmRepresentation> findAllFilmPopulaire();
	public List<NowPlayingFilmRepresentation> saveFilmPopulaireInDb();

}
