package read.frontend.presentation.Resolver;

import read.frontend.presentation.Queries.IQuery;
import read.frontend.presentation.Results.IResult;

public interface IQueryResolver {
	IResult Resolve(IQuery query);
}
