package write.UniversityCrawler.Business.Commands;

import crosscutting.command.ICommand;

public class StartNewSemester implements ICommand{
	private String name;

	public StartNewSemester(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	
}
