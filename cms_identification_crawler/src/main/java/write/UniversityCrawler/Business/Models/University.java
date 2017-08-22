package write.UniversityCrawler.Business.Models;

public class University {
	private int id;
	private String Name;
	private String WikipediaURL;
	private String WebsiteURL;

	public University(String name, String wikipediaURL, String websiteURL, int id) {
		this.id = id;
		Name = name;
		WikipediaURL = wikipediaURL;
		WebsiteURL = websiteURL;
	}
	
	public University(String name, String wikipediaURL, String websiteURL) {
		Name = name;
		WikipediaURL = wikipediaURL;
		WebsiteURL = websiteURL;
		this.id = 0;
	}
	
	public University(String name, String wikipediaURL) {
		Name = name;
		WikipediaURL = wikipediaURL;
		this.id = 0;
		WebsiteURL = null;		
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return Name;
	}

	public String getWikipedia_URL() {
		return WikipediaURL;
	}

	public String getWebsite_URL() {
		return WebsiteURL;
	}
}
