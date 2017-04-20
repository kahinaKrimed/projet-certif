package appliAngular.jsonToObject;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NowPlayingFilmJsonToObject {
	
	private  ArrayList<ResultFilmJsonToObject> results= new ArrayList<ResultFilmJsonToObject>();;

    private String page;

    private int total_pages;

    private String total_results;
    

	public NowPlayingFilmJsonToObject() {
		super();
		// TODO Auto-generated constructor stub
	}





	public ArrayList<ResultFilmJsonToObject> getResults() {
		return results;
	}





	public void setResults(ArrayList<ResultFilmJsonToObject> results) {
		this.results = results;
	}





	public String getPage() {
		return page;
	}


	public void setPage(String page) {
		this.page = page;
	}


	public int getTotal_pages() {
		return total_pages;
	}


	public void setTotal_pages(int total_pages) {
		this.total_pages = total_pages;
	}


	public String getTotal_results() {
		return total_results;
	}


	public void setTotal_results(String total_results) {
		this.total_results = total_results;
	}

	
}
