package crosscutting.query;

public interface IQueryHandler<TQuery extends IQuery<TResult>, TResult>  {
	TResult handle(TQuery query);
}
