package write.cmsidentifier.models;

public class Seed {
	private int Id;
	private String url;

	public Seed(int id, String url) {
		super();
		Id = id;
		this.url = url;
	}

	public int getId() {
		return Id;
	}

	public String getUrl() {
		return url;
	}

}
