package read.frontend.presentation.Models;

public class CMSCount {
	private CMS cms;
	private int anzahl;
	
	public CMSCount(CMS cms, int anzahl) {
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
