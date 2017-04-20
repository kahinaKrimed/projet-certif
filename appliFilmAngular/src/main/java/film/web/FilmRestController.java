//package film.web;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;
//
//
//
//import appliAngular.jsonToObject.NowPlayingFilmJsonToObject;
//import appliAngular.jsonToObject.PersonJsonToObject;
//
//
//@RestController
//public class FilmRestController {
//
//	
//	
//	@RequestMapping(value = "/testrt", method = RequestMethod.GET)
//	public void testrt() {
//		
//		RestTemplate restT = new RestTemplate();
//		PersonJsonToObject personJsonToObject = restT.getForObject("https://api.themoviedb.org/3/search/person?api_key=f9dbb51c988c033af6bfcabbc3a01152&query=ben", PersonJsonToObject.class);
//        System.out.println(personJsonToObject.getResults()[0].getName());
//		
//	}
//	
//	@RequestMapping(value = "/testFilmConvert", method = RequestMethod.GET)
//	public void testFilmConvert() {
//		
//		RestTemplate restTemplateFilm = new RestTemplate();
//		NowPlayingFilmJsonToObject filmJsonToObject= restTemplateFilm.getForObject("https://api.themoviedb.org/3/movie/popular?api_key=f9dbb51c988c033af6bfcabbc3a01152&language=en-US&page=1", NowPlayingFilmJsonToObject.class);
//        System.out.println(filmJsonToObject.getResults()[0].getOriginal_title());
//		
//	}
//	
//	
//}

