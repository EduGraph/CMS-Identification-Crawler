package sync.commands;

import crosscutting.command.CommandResolver;
import crosscutting.command.ICommandHandler;
import crosscutting.command.ICommandResolver;

public class SynchronizeReadHandler implements ICommandHandler<SynchronizeRead> {
	private ICommandResolver commandResolver;
	
	public SynchronizeReadHandler() {
		this.commandResolver = new CommandResolver();
	}

	@Override
	public void handler(SynchronizeRead command) {
		commandResolver.resolve(new SyncAnzahlDerHochschulen());
		commandResolver.resolve(new SyncVeraenderungAktuelleWoche());
		commandResolver.resolve(new SyncCmsDerHochschulen());
	}
}
