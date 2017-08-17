package read.frontend.presentation.Queries;

import crosscutting.query.IQueryHandler;
import read.frontend.Data.IReadDomainDataAccessor;
import read.frontend.Data.ReadDomainDataAccessor;
import read.frontend.presentation.Models.VeraenderungAktuelleWoche;

public class VeraenderungWocheHandler implements IQueryHandler<VeraenderungWoche, VeraenderungAktuelleWoche>{
	private IReadDomainDataAccessor readDomainAccessor;
	
	public VeraenderungWocheHandler() {
		this.readDomainAccessor = new ReadDomainDataAccessor();
	}

	@Override
	public VeraenderungAktuelleWoche handle(VeraenderungWoche query) {
		return this.readDomainAccessor.GetVeraenderungAktulleWoche();
	}

}
