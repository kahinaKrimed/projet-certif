package appliAngular.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import appliAngular.dao.ActeurDao;
import appliAngular.jsonToObject.NowPlayingFilmJsonToObject;
import appliAngular.jsonToObject.PersonJsonToObject;
import appliAngular.jsonToObject.ResultFilmJsonToObject;
import appliAngular.jsonToObject.ResultsJsonToObject;
import appliAngular.representation.ActeurRepresentation;
import appliAngular.representation.NowPlayingFilmRepresentation;


@Repository
@Transactional
public class ActeurDaoImpl implements ActeurDao{
	
	@PersistenceContext
	private EntityManager em;

	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public ActeurRepresentation find(Long id) {
		return em.find(ActeurRepresentation.class,id) ;
	}

	@Override
	public void create(ActeurRepresentation acteurRepresentation) {
		em.persist(acteurRepresentation);
		
	}

	@Override
	public ActeurRepresentation update(ActeurRepresentation acteurRepresentation) {
		return em.merge(acteurRepresentation);
	}

	@Override
	public void delete(ActeurRepresentation acteurRepresentation) {
		em.remove(acteurRepresentation);
		
	}

	@Override
	public List<ActeurRepresentation> saveAllActeursInDb() {
		System.out.println("je suis dans le save acteurs");
		
		List<ActeurRepresentation> listActeurs= new ArrayList<ActeurRepresentation>();	
	
		PersonJsonToObject acteur = restTemplate.getForObject("https://api.themoviedb.org/3/person/popular?api_key=f9dbb51c988c033af6bfcabbc3a01152&language=en-US&page=1", PersonJsonToObject.class);
				ActeurRepresentation acteurRepresentation = new ActeurRepresentation();
			System.out.println("je suis dans le save acts2");
				for (ResultsJsonToObject results : acteur.getResults()){
					System.out.println("je suis dans le save act3");
					if(results.getId()!=null){
						
					acteurRepresentation.setId(Long.parseLong(results.getId()));
					
					acteurRepresentation.setAdult(results.getAdult());
					System.out.println(acteurRepresentation.getAdult());
					
					acteurRepresentation.setName(results.getName());
					System.out.println(acteurRepresentation.getName());
					
					acteurRepresentation.setPopularity(results.getPopularity());
					System.out.println(acteurRepresentation.getPopularity());
					
					acteurRepresentation.setProfile_path(results.getProfile_path());
					System.out.println(acteurRepresentation.getProfile_path());
					
					
					em.merge(acteurRepresentation);
					listActeurs.add(acteurRepresentation);
					
					}else{
						em.persist(acteurRepresentation);
					}
				}
			
			
			return listActeurs;
	}

	@Override
	public List<ActeurRepresentation> findAll() {
		System.out.println("je suis dans le findall");
		Query query = em.createQuery("select a from ActeurRepresentation a");
		return query.getResultList();		
	}

	
}
