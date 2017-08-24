package crosscutting.command;

public interface ICommandResolver {
	void resolve(ICommand command);
}
