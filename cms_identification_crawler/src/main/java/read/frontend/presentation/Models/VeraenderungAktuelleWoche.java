package read.frontend.presentation.Models;

import java.util.List;

import crosscutting.query.IResult;

public class VeraenderungAktuelleWoche implements IResult{
	private List<VeraenderungWoche> veraenderungWoches;

	public VeraenderungAktuelleWoche(List<VeraenderungWoche> veraenderungWoches) {
		super();
		this.veraenderungWoches = veraenderungWoches;
	}

	public List<VeraenderungWoche> getVeraenderungWoches() {
		return veraenderungWoches;
	}
}
