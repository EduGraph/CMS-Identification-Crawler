package crosscutting.query;

public interface IQueryResolver {
	IResult Resolve(IQuery query);
}
