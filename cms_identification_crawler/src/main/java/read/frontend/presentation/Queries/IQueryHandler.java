package read.frontend.presentation.Queries;

public interface IQueryHandler<TQuery extends IQuery<TResult>, TResult>  {
	TResult handle(TQuery query);
}
