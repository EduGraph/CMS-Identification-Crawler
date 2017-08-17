package crosscutting.command;

public interface ICommandResolver {
	void handle(ICommand command);
}
