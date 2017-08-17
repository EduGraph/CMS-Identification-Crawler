package read.frontend.presentation.Queries;

import crosscutting.query.IQueryHandler;
import read.frontend.Data.IReadDomainDataAccessor;
import read.frontend.Data.ReadDomainDataAccessor;
import read.frontend.presentation.Models.AnzahlDerVerwendetenCMS;

public class CMSVerbreitungHandler implements IQueryHandler<CMSVerbreitung, AnzahlDerVerwendetenCMS> {

	private IReadDomainDataAccessor readDomainDataAccessor;
	
	public CMSVerbreitungHandler() {
		this.readDomainDataAccessor = new ReadDomainDataAccessor();
	}
	
	public AnzahlDerVerwendetenCMS handle(CMSVerbreitung query) {
		return this.readDomainDataAccessor.GetAnzahlDerVerwendetenCMS();
	}
}
