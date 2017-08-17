package read.frontend.presentation.Models;

public class VeraenderungWoche {
	private CMS cms;
	private int veraenderung;

	public VeraenderungWoche(CMS cms, int veraenderung) {
		super();
		this.cms = cms;
		this.veraenderung = veraenderung;
	}

	public CMS getCms() {
		return cms;
	}

	public int getVeraenderung() {
		return veraenderung;
	}
}
