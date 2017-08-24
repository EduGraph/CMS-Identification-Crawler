package crosscutting.query;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class QueryResolver implements IQueryResolver {

	public IResult Resolve(IQuery query) {
		String queryName = query.getClass().getName();
		String queryHandlerName = queryName + "Handler";
		try {
			Class<?> clazz = Class.forName(queryHandlerName);
			Constructor<?> constructor = clazz.getConstructor();
			IQueryHandler handler = (IQueryHandler) constructor.newInstance();
			return (IResult) handler.handle(query);
			
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return null;
	}

	
}
