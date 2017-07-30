package read.frontend.presentation;

import read.frontend.presentation.Queries.CMSVerbreitung;
import read.frontend.presentation.Resolver.IQueryResolver;
import read.frontend.presentation.Resolver.QueryResolver;
import read.frontend.presentation.Results.CMSVerbreitungResult;

public class main {

	public static void main(String[] args) {
		IQueryResolver resolver = new QueryResolver();
		CMSVerbreitungResult verbreitung = (CMSVerbreitungResult) resolver.Resolve(new CMSVerbreitung());
		System.out.println(verbreitung.getTestValue());
	}

}
