package crosscutting.command;

public interface ICommandHandler<TCommand extends ICommand> {
	void handler(TCommand command);
}
