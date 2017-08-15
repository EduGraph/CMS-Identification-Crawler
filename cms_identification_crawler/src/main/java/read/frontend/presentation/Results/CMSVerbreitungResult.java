package read.frontend.presentation.Results;

import java.util.List;

import read.frontend.presentation.Models.AnzahlDerVerwendetenCMS;

public class CMSVerbreitungResult implements IResult{
	private String testValue;

	public CMSVerbreitungResult(String testValue) {
		super();
		this.testValue = testValue;
	}
	
	public String getTestValue() {
		return testValue;
	}
	
	
}
