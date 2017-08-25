package sync.commands;

import crosscutting.command.ICommandHandler;
import sync.data.ISyncronisationAccessor;
import sync.data.SynchronisationAccessor;

public class SyncVeraenderungAktuelleWocheHandler implements ICommandHandler<SyncVeraenderungAktuelleWoche> {
	private ISyncronisationAccessor synchronisationAccessor;
	
	public SyncVeraenderungAktuelleWocheHandler() {
		this.synchronisationAccessor = new SynchronisationAccessor();
	}

	@Override
	public void handler(SyncVeraenderungAktuelleWoche command) {
		synchronisationAccessor.UpdateVeraenderungAktuelleWoche();
	}
}
