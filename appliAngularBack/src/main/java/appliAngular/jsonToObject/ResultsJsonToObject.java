package appliAngular.jsonToObject;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultsJsonToObject {

	private String id;

    private Known_forJsonToObject[] known_for;

    private String name;

    private String adult;

    private String popularity;

    private String profile_path;

	public ResultsJsonToObject() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Known_forJsonToObject[] getKnown_for() {
		return known_for;
	}

	public void setKnown_for(Known_forJsonToObject[] known_for) {
		this.known_for = known_for;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdult() {
		return adult;
	}

	public void setAdult(String adult) {
		this.adult = adult;
	}

	public String getPopularity() {
		return popularity;
	}

	public void setPopularity(String popularity) {
		this.popularity = popularity;
	}

	public String getProfile_path() {
		return profile_path;
	}

	public void setProfile_path(String profile_path) {
		this.profile_path = profile_path;
	}
    
    
}
