package read.frontend.presentation.Queries;

import crosscutting.query.IQueryHandler;
import read.frontend.Data.IReadDomainDataAccessor;
import read.frontend.Data.ReadDomainDataAccessor;
import read.frontend.presentation.Models.CMSDerHochschulen;

public class CMSHochschulenHandler implements IQueryHandler<CMSHochschulen, CMSDerHochschulen>{
	private IReadDomainDataAccessor readDomainDataAccessor;
	
	public CMSHochschulenHandler() {
		this.readDomainDataAccessor = new ReadDomainDataAccessor();
	}

	@Override
	public CMSDerHochschulen handle(CMSHochschulen query) {
		return this.readDomainDataAccessor.GetCMSDerHochschulen();
	}

}
