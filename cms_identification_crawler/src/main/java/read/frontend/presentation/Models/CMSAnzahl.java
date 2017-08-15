package read.frontend.presentation.Models;

public class CMSAnzahl {
	private CMS cms;
	private int anzahl;

	public CMSAnzahl(CMS cms, int anzahl) {
		super();
		this.cms = cms;
		this.anzahl = anzahl;
	}

	public CMS getCms() {
		return cms;
	}

	public int getAnzahl() {
		return anzahl;
	}

}
