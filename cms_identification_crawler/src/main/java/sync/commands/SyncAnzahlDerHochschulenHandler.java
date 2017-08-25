package sync.commands;

import crosscutting.command.ICommandHandler;
import sync.data.ISyncronisationAccessor;
import sync.data.SynchronisationAccessor;

public class SyncAnzahlDerHochschulenHandler implements ICommandHandler<SyncAnzahlDerHochschulen> {
	private ISyncronisationAccessor syncronisationAccessor;
	
	public SyncAnzahlDerHochschulenHandler() {
		this.syncronisationAccessor = new SynchronisationAccessor();
	}


	@Override
	public void handler(SyncAnzahlDerHochschulen command) {
		this.syncronisationAccessor.UpdateAnzahlDerVerwendetenCMS();
	}

}
