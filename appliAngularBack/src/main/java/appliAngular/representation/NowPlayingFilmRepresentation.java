package appliAngular.representation;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name="films")
public class NowPlayingFilmRepresentation implements Serializable {
	
	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;
	@Id
	private Long id;
	
	@Lob
	private String title;
	
	@Lob
	private String overview;
	
	@Lob
	private String release_date;
	
	@Lob
	private String poster_path;
	
	//private Double popularity;
	
	public NowPlayingFilmRepresentation() {
		super();
	}

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}



	public String getRelease_date() {
		return release_date;
	}

	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}

	public String getPoster_path() {
		return poster_path;
	}

	public void setPoster_path(String poster_path) {
		this.poster_path = poster_path;
	}



	/*public Double getPopularity() {
		return popularity;
	}



	public void setPopularity(Double popularity) {
		this.popularity = popularity;
	}*/
	
	

}
