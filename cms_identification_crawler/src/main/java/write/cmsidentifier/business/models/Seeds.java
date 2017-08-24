package write.cmsidentifier.business.models;

import java.util.List;

import crosscutting.query.IResult;

public class Seeds implements IResult{
	private List<Seed> seeds;
	
	public Seeds(List<Seed> seeds) {
		this.seeds = seeds;
	}

	public List<Seed> getSeeds() {
		return seeds;
	}
}
