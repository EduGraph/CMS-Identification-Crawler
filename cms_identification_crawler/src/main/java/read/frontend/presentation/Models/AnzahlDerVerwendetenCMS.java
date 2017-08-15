package read.frontend.presentation.Models;

import java.util.List;

public class AnzahlDerVerwendetenCMS {
	private List<CMSAnzahl> cmsVerbreitung;

	public AnzahlDerVerwendetenCMS(List<CMSAnzahl> cmsVerbreitung) {
		super();
		this.cmsVerbreitung = cmsVerbreitung;
	}

	public List<CMSAnzahl> getCmsVerbreitung() {
		return cmsVerbreitung;
	}

}
