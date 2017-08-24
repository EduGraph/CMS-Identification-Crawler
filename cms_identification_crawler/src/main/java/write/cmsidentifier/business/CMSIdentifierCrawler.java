package write.cmsidentifier.business;

import org.jsoup.Jsoup;

import crosscutting.command.CommandResolver;
import crosscutting.command.ICommandResolver;
import crosscutting.query.IQueryResolver;
import crosscutting.query.QueryResolver;
import write.cmsidentifier.business.CMSIdentifierAlgorithmn.*;
import write.cmsidentifier.business.commands.IdentifiedCMSForWebsite;
import write.cmsidentifier.business.helper.SiteParser;
import write.cmsidentifier.business.models.CMSIdentifierResult;
import write.cmsidentifier.business.models.Seed;
import write.cmsidentifier.business.models.Seeds;
import write.cmsidentifier.business.models.Site;
import write.cmsidentifier.business.queries.GetSeeds;

public class CMSIdentifierCrawler implements ICMSIdentifierCrawler {
	private ICommandResolver commandResolver;
	private IQueryResolver queryResolver;

	public CMSIdentifierCrawler() {
		this.commandResolver = new CommandResolver();
		this.queryResolver = new QueryResolver();
	}

	@Override
	public void crawl() {
		Seeds seeds = (Seeds) queryResolver.Resolve(new GetSeeds());		
		seeds
			.getSeeds()
			.stream()
			.map(seed -> new IdentifiedCMSForWebsite(identifyCMS(seed)))
			.forEach(command -> commandResolver.resolve(command));
	}

	private CMSIdentifierResult identifyCMS(Seed seed) {
		Site site = new SiteParser(seed.getUrl()).parse();
		if (site.getHtml().isEmpty()) {
			// Website konnte nicht geladen werden
			return new CMSIdentifierResult(seed.getIdentifier(), null);
		}
		
		// Hack - Manche Unis (z.B. FAU) geben HTML zurück das nicht zu parsen ist. 
		// Da dies Verhalten neu ist, wurde der Workaround mit den try catch eingeführt
		try {
			Jsoup.parse(site.getHtml());
		} catch (Exception e) {
			return new CMSIdentifierResult(seed.getIdentifier(), null);
		}
		
		ICMSIdentifier identifier = 
				new CMSIdentifier(new ContanoIdentifier(site), 
				new CabacosIdentifier(site),
				new ContanoIdentifier(site),
				new DrupalIdentifier(site),
				new EgotecIdentifier(site), 
				new ExpressionEngineIdentifier(site),
				new FionaIdentifier(site),
				new FirstSpiritIdentifierIdentifier(site),
				new FramulaIdentifier(site),
				new GoettingerContentManagementSystemIdentifier(site),
				new IcoyaIdentifier(site),
				new ImperiaIdentifier(site),
				new Ionas3Identifier(site),
				new JoomlaIdentifier(site),
				new KrynIdentifier(site),
				new LarissaIdentifier(site),
				new MaGICIdentifier(site),
				new OpenCMSIdentifier(site),
				new PloneIdentifier(site),
				new ProcessWireIdentifier(site), 
				new PyroCmsIdentifier(site),
				new SharePointIdentifier(site), 
				new Typo3Identifier(site),
				new WebBoxIdentifier(site),
				new WeblicationIdentifier(site),
				new WebVanillaIdentifier(site),
				new WordPressIdentifier(site),
				new XIMSIdentifier(site),
				new ZMSIdentifier(site));
		return new CMSIdentifierResult(seed.getIdentifier(), identifier.identify());
	}

}
