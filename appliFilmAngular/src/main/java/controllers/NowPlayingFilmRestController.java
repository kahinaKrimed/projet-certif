package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import appliAngular.dao.NowPlayingFilmDao;
import appliAngular.representation.NowPlayingFilmRepresentation;
;

@RestController
public class NowPlayingFilmRestController {
	
	@Autowired
	private NowPlayingFilmDao nowFilmRepo;
	
	
	@RequestMapping(value = "/film-save/", method = RequestMethod.GET)
	public void saveFilm() {
		System.out.println("toc toc");
		nowFilmRepo.saveAllFilmsInDb();
		System.out.println("!!!!!!");
	}
	
	
	@RequestMapping(value = "/filmPopulaire-save/", method = RequestMethod.GET)
	public void saveFilmPopulaire() {
		System.out.println("toc toc");
		nowFilmRepo.saveFilmPopulaireInDb();
		System.out.println("!!!!!!");
	}
	
	@RequestMapping(value = "/films-now-playing/", method = RequestMethod.GET)
	public ResponseEntity<List<NowPlayingFilmRepresentation>> listAll() {
		List<NowPlayingFilmRepresentation> filmRepresentations = nowFilmRepo.findAll();
		if (filmRepresentations == null) {
			return new ResponseEntity<List<NowPlayingFilmRepresentation>>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<NowPlayingFilmRepresentation>>(filmRepresentations, HttpStatus.OK);
		}
	}
	
	
	@RequestMapping(value = "/films-populaires/", method = RequestMethod.GET)
	public ResponseEntity<List<NowPlayingFilmRepresentation>> listFilmPopulaire() {
		List<NowPlayingFilmRepresentation> filmRepresentations = nowFilmRepo.findAllFilmPopulaire();
		if (filmRepresentations == null) {
			return new ResponseEntity<List<NowPlayingFilmRepresentation>>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<NowPlayingFilmRepresentation>>(filmRepresentations, HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/film-search/{id}", method = RequestMethod.GET)
	public ResponseEntity<NowPlayingFilmRepresentation> get(@PathVariable("id") Long id) {
		NowPlayingFilmRepresentation filmRepresentation = nowFilmRepo.find(id);
		if (filmRepresentation == null) {
			return new ResponseEntity<NowPlayingFilmRepresentation>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<NowPlayingFilmRepresentation>(filmRepresentation, HttpStatus.OK);
		}
	}
}
