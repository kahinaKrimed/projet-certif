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

import appliAngular.dao.NowPlayingFilmDao;
import appliAngular.jsonToObject.NowPlayingFilmJsonToObject;
import appliAngular.jsonToObject.ResultFilmJsonToObject;
import appliAngular.representation.NowPlayingFilmRepresentation;


@Repository
@Transactional
public class NowPlayingFilmDaoImpl implements NowPlayingFilmDao {
	
	
@PersistenceContext
private EntityManager em;

@Autowired
private RestTemplate restTemplate;

	@Override
	public NowPlayingFilmRepresentation find(Long id) {
		
		
		return em.find(NowPlayingFilmRepresentation.class,id) ;
	}

	
	@Transactional
	public List<NowPlayingFilmRepresentation> findAll() {
		
		Query query = em.createQuery("select f from NowPlayingFilmRepresentation f");
		System.out.println(query.toString());
		return query.getResultList();		
		}
		
	

	@Override
	public void create(NowPlayingFilmRepresentation nowPlayingFilm) {
	em.persist(nowPlayingFilm);
		
	}

	@Override
	public NowPlayingFilmRepresentation update(NowPlayingFilmRepresentation nowPlayingFilm) {
	
		return em.merge(nowPlayingFilm);
	}

	@Override
	public void delete(NowPlayingFilmRepresentation nowPlayingFilm) {
		em.remove(nowPlayingFilm);
		
	}
//	@Override
//	public void save(NowPlayingFilmRepresentation nowPlayingFilm) {
//		em.persist(nowPlayingFilm);
//		
//	}
//	
//	public NowPlayingFilmRepresentation findFilmRepresentation(Long id) {
//		return filmDao.find(id);
//		
//	}
//	public NowPlayingFilmRepresentation newFilm(NowPlayingFilmRepresentation nowPlayingFilm){
//		filmDao.save(nowPlayingFilm);
//		return nowPlayingFilm;
//				
//	}
	
	
//	public List<NowPlayingFilmRepresentation> listAllFilms(){
//		List<NowPlayingFilmRepresentation> films= new ArrayList<>();
//		for(NowPlayingFilmRepresentation film : filmDao.findAll()){
//			films.add(film);			
//		}
//		return films;
//	}
	
//	public void saveAllFilms(){
//		
//		NowPlayingFilmJsonToObject nowPlayingFilm= new NowPlayingFilmJsonToObject();
//		
//		
//		int totalPages= nowPlayingFilm.getTotal_pages();
//		for (int i=1; i<=totalPages; i++){
//			
//			nowPlayingFilm = (NowPlayingFilmJsonToObject) restTemplate.getForObject("https://api.themoviedb.org/3/movie/popular?api_key=f9dbb51c988c033af6bfcabbc3a01152&language=en-US&page="+i,  NowPlayingFilmJsonToObject.class);
//			NowPlayingFilmRepresentation filmRepresentation = new NowPlayingFilmRepresentation();
//			
//			for (ResultFilmJsonToObject results : nowPlayingFilm.getResults()){
//	
//				filmRepresentation.setId(Long.parseLong(results.getId()));
//				filmRepresentation.setTitle(results.getTitle());
//				filmRepresentation.setOverview(results.getOverview());
//				filmRepresentation.setRelease_date(results.getRelease_date());
//				filmRepresentation.setPoster_path(results.getPoster_path());
//				
//			em.persist(filmRepresentation);
//				
//				
//				
//			}
//		}
//
//	}

	
	public List<NowPlayingFilmRepresentation> saveAllFilmsInDb() {
		System.out.println("je suis dans le save films");
	
		List<NowPlayingFilmRepresentation> listFilms= new ArrayList<NowPlayingFilmRepresentation>();	
	
		NowPlayingFilmJsonToObject nowPlayingFilm = restTemplate.getForObject("https://api.themoviedb.org/3/movie/now_playing?api_key=f9dbb51c988c033af6bfcabbc3a01152&language=en-US&page=1",  NowPlayingFilmJsonToObject.class);
				NowPlayingFilmRepresentation filmRepresentation = new NowPlayingFilmRepresentation();
			System.out.println("je suis dans le save films2");
				for (ResultFilmJsonToObject results : nowPlayingFilm.getResults()){
					System.out.println("je suis dans le save films3");
					if(results.getId()!=null){
						
					filmRepresentation.setId(Long.parseLong(results.getId()));
					filmRepresentation.setTitle(results.getTitle());
					System.out.println(filmRepresentation.getTitle());
					filmRepresentation.setOverview(results.getOverview());
					System.out.println(filmRepresentation.getOverview());
					filmRepresentation.setRelease_date(results.getRelease_date());
					System.out.println(filmRepresentation.getRelease_date());
					filmRepresentation.setPoster_path(results.getPoster_path());
					System.out.println(filmRepresentation.getPoster_path());
//					filmRepresentation.setPopularity(Double.parseDouble(results.getPopularity()));
//					System.out.println(filmRepresentation.getPopularity());
					em.merge(filmRepresentation);
					listFilms.add(filmRepresentation);
					
					}else{
						em.persist(filmRepresentation);
					}
				}
			
			
			return listFilms;
			}


	@Override
	public List<NowPlayingFilmRepresentation> findAllFilmPopulaire() {
		Query query = em.createQuery("select f from NowPlayingFilmRepresentation f where f.popularity >20.00");
		return query.getResultList();		
		}


	@Override
	public List<NowPlayingFilmRepresentation> saveFilmPopulaireInDb() {
		System.out.println("je suis dans le save films");
	
	List<NowPlayingFilmRepresentation> listFilmPop= new ArrayList<NowPlayingFilmRepresentation>();	

	NowPlayingFilmJsonToObject nowPlayingFilm = restTemplate.getForObject("https://api.themoviedb.org/3/movie/popular?api_key=f9dbb51c988c033af6bfcabbc3a01152&language=fr_FR&page=1",  NowPlayingFilmJsonToObject.class);
			NowPlayingFilmRepresentation filmRepresentation = new NowPlayingFilmRepresentation();
		System.out.println("je suis dans le save filmsPop2");
			for (ResultFilmJsonToObject results : nowPlayingFilm.getResults()){
				System.out.println("je suis dans le save filmsPop3");
				if(results.getId()!=null){
					
				filmRepresentation.setId(Long.parseLong(results.getId()));
				filmRepresentation.setTitle(results.getTitle());
				System.out.println(filmRepresentation.getTitle());
				filmRepresentation.setOverview(results.getOverview());
				System.out.println(filmRepresentation.getOverview());
				filmRepresentation.setRelease_date(results.getRelease_date());
				System.out.println(filmRepresentation.getRelease_date());
				filmRepresentation.setPoster_path(results.getPoster_path());
				System.out.println(filmRepresentation.getPoster_path());
				
				em.merge(filmRepresentation);
				listFilmPop.add(filmRepresentation);
				
				}else{
					em.persist(filmRepresentation);
				}
			}
		
		
		return listFilmPop;
		}
	
		
	
}
	



