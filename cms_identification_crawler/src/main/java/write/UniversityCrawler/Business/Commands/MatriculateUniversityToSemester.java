package write.UniversityCrawler.Business.Commands;

import crosscutting.command.ICommand;
import write.UniversityCrawler.Business.Models.Semester;
import write.UniversityCrawler.Business.Models.University;

public class MatriculateUniversityToSemester implements ICommand {
	private University university;
	private Semester semester;

	public MatriculateUniversityToSemester(University university, Semester semester) {
		super();
		this.university = university;
		this.semester = semester;
	}

	public University getUniversity() {
		return university;
	}

	public Semester getSemester() {
		return semester;
	}
}
