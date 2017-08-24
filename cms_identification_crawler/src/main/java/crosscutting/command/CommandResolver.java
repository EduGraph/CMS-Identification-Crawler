package crosscutting.command;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class CommandResolver implements ICommandResolver {

	@Override
	public void resolve(ICommand command) {
		String commandName = command.getClass().getName();
		String commandHandlerName = commandName + "Handler";
		try {
			Class<?> clazz = Class.forName(commandHandlerName);
			Constructor<?> constructor = clazz.getConstructor();
			ICommandHandler handler = (ICommandHandler) constructor.newInstance();
			handler.handler(command);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
