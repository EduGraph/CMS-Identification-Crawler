package write.cmsidentifier.business.models;

public class Seed {
	private int identifier;
	private String url;

	public Seed(int id, String url) {
		super();
		identifier = id;
		this.url = url;
	}

	public int getIdentifier() {
		return identifier;
	}

	public String getUrl() {
		return url;
	}

}
