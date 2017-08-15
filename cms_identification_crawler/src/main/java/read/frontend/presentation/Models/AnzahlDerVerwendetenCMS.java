package read.frontend.presentation.Models;

import java.util.List;

import read.frontend.presentation.Results.IResult;

public class AnzahlDerVerwendetenCMS implements IResult{
	private List<CMSAnzahl> cmsVerbreitung;

	public AnzahlDerVerwendetenCMS(List<CMSAnzahl> cmsVerbreitung) {
		super();
		this.cmsVerbreitung = cmsVerbreitung;
	}

	public List<CMSAnzahl> getCmsVerbreitung() {
		return cmsVerbreitung;
	}

}
