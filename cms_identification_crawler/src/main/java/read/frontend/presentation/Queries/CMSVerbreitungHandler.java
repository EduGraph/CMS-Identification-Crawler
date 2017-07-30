package read.frontend.presentation.Queries;

import read.frontend.presentation.Results.CMSVerbreitungResult;

public class CMSVerbreitungHandler implements IQueryHandler<CMSVerbreitung, CMSVerbreitungResult> {

	public CMSVerbreitungResult handle(CMSVerbreitung query) {
		return new CMSVerbreitungResult("Works so far");
	}

}
