package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import appliAngular.dao.ActeurDao;
import appliAngular.dao.NowPlayingFilmDao;
import appliAngular.representation.ActeurRepresentation;
import appliAngular.representation.NowPlayingFilmRepresentation;

@RestController
public class ActeurRestController {
	
	@Autowired
	private ActeurDao acteurDao;
	
	
	@RequestMapping(value = "/acteur-save/", method = RequestMethod.GET)
	public void saveActeur() {
		System.out.println("toc toc");
		acteurDao.saveAllActeursInDb();
		System.out.println("ça marche !!!");
	}
	
	@RequestMapping(value = "/acteurs-populaires/", method = RequestMethod.GET)
	public ResponseEntity<List<ActeurRepresentation>> listAll() {
		List<ActeurRepresentation> acteurRepresentations = acteurDao.findAll();
		if (acteurRepresentations == null) {
			return new ResponseEntity<List<ActeurRepresentation>>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<ActeurRepresentation>>(acteurRepresentations, HttpStatus.OK);
		}
	}

}
