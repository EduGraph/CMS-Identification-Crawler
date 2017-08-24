package read.frontend.presentation.Models;

import crosscutting.ValueObjects.CMS;

public class HochschuleCMS {
	private String Hochschule;
	private CMS verwendetesCMS;

	public HochschuleCMS(String hochschule, CMS verwendetesCMS) {
		super();
		this.Hochschule = hochschule;
		this.verwendetesCMS = verwendetesCMS;
	}

	public String getHochschule() {
		return Hochschule;
	}

	public void setHochschule(String nameDerHochschule) {
		this.Hochschule = nameDerHochschule;
	}

	public CMS getVerwendetesCMS() {
		return verwendetesCMS;
	}

	public void setVerwendetesCMS(CMS verwendetesCMS) {
		this.verwendetesCMS = verwendetesCMS;
	}

}
