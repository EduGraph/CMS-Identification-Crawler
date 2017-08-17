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
		return null;
	}

	
}
