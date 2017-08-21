package write.UniversityCrawler.Business.Models;

import java.util.Date;

public class Semester {
	private int id;
	private String name;
	private Date createTime;

	public Semester(int id, String name, Date createTime) {
		this.id = id;
		this.name = name;
		this.createTime = createTime;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	public Date getCreateDate() {
		return createTime;
	}

}
