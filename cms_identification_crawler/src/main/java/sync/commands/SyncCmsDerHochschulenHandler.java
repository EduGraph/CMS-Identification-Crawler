package sync.commands;

import crosscutting.command.ICommandHandler;
import sync.data.ISyncronisationAccessor;
import sync.data.SynchronisationAccessor;

public class SyncCmsDerHochschulenHandler implements ICommandHandler<SyncCmsDerHochschulen> {
	private ISyncronisationAccessor synchronisationAccessor;
	
	public SyncCmsDerHochschulenHandler() {
		this.synchronisationAccessor = new SynchronisationAccessor();
	}

	@Override
	public void handler(SyncCmsDerHochschulen command) {
		this.synchronisationAccessor.UpdateCMSDerHochschulen();
	}

}
