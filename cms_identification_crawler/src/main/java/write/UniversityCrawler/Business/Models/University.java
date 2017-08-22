package write.UniversityCrawler.Business.Models;

import java.net.URL;

public class University {
	private int id;
	private String Name;
	private URL Wikipedia_URL;
	private URL Website_URL;

	public University(int id, String name, URL wikipedia_URL, URL website_URL) {
		super();
		this.id = id;
		Name = name;
		Wikipedia_URL = wikipedia_URL;
		Website_URL = website_URL;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return Name;
	}

	public URL getWikipedia_URL() {
		return Wikipedia_URL;
	}

	public URL getWebsite_URL() {
		return Website_URL;
	}
}
