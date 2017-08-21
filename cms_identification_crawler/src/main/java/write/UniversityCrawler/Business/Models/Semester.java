package write.UniversityCrawler.Business.Models;

public class Semester {
	private int id;
	private String name;

	public Semester(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

}
