package read.frontend.presentation.Queries;

import java.util.ArrayList;
import java.util.List;

import read.frontend.presentation.Models.AnzahlDerVerwendetenCMS;
import read.frontend.presentation.Models.CMS;
import read.frontend.presentation.Models.CMSAnzahl;
import read.frontend.presentation.Results.CMSVerbreitungResult;

public class CMSVerbreitungHandler implements IQueryHandler<CMSVerbreitung, AnzahlDerVerwendetenCMS> {

	public AnzahlDerVerwendetenCMS handle(CMSVerbreitung query) {

		List<CMSAnzahl> cmsVerbreitung = new ArrayList<>();
		cmsVerbreitung.add(new CMSAnzahl(CMS.Typo3, 300));
		cmsVerbreitung.add(new CMSAnzahl(CMS.Drupal, 7));
		cmsVerbreitung.add(new CMSAnzahl(CMS.Imperia, 2));
		return new AnzahlDerVerwendetenCMS(cmsVerbreitung);
	}

}
