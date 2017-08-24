package write.UniversityCrawler;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import crosscutting.command.CommandResolver;
import crosscutting.command.ICommandResolver;
import crosscutting.query.IQueryResolver;
import crosscutting.query.QueryResolver;
import write.UniversityCrawler.Business.Commands.MatriculateUniversityToSemester;
import write.UniversityCrawler.Business.Commands.StartNewSemester;
import write.UniversityCrawler.Business.Models.Semester;
import write.UniversityCrawler.Business.Models.University;
import write.UniversityCrawler.Business.Queries.GetLastSemester;
	
public class UniversityCrawler implements IUniversityCrawler {
	private static final String Wikipediabase = "https://de.wikipedia.org";
	private static final String URLListOfAllGermanUniversities = "https://de.wikipedia.org/wiki/Liste_der_Hochschulen_in_Deutschland";
	private static final int TimeoutInMillisecounds = 5000;
	
	private ICommandResolver commandResolver;
	private IQueryResolver queryResolver;
	
	public UniversityCrawler() {
		this.commandResolver = new CommandResolver();
		this.queryResolver = new QueryResolver();
	}

	@Override
	public void crawl() {
		// Neues Semester anlegen
		this.commandResolver.resolve(new StartNewSemester());
		Semester semester = (Semester)this.queryResolver.Resolve(new GetLastSemester());
		
		// Wikipedia-Seiten der Hochschulen laden
		List<University> wikipages = this.crawlUniversityList();
		
		// Die URLs der Hochschulen aus ihren Wikipeida-Seiten extrahieren
		List<University> universities = 
				 wikipages
				.stream()
				.map(university -> this.extractURLFromWikipage(university))
				.collect(Collectors.toList());
		
		// Ergebnisse Speichern
		universities.forEach(university -> this.commandResolver.resolve(new MatriculateUniversityToSemester(university, semester)));
	}

	private List<University> crawlUniversityList() {
		try {
			return Jsoup.parse(new URL(URLListOfAllGermanUniversities), TimeoutInMillisecounds)
					.select("#mw-content-text > div > table > tbody > tr > td:nth-child(1) > a")
					.stream()
					.map(element -> new University(element.attr("title"), element.attr("href")))
					.collect(Collectors.toList());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	private University extractURLFromWikipage(University university){
		try {
			URL url = new URL(Wikipediabase + university.getWikipedia_URL());
			
			Optional<String> websiteUrl = Jsoup.parse(url, TimeoutInMillisecounds)
					.select("#Vorlage_Infobox_Hochschule > tbody > tr > td > a.external")
					.stream()
					.findFirst()
					.map(website -> website.attr("href"));
			
			if (websiteUrl.isPresent()) {
				return new University(university.getName(), university.getWikipedia_URL(), websiteUrl.get());
			}
			
			return university;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return university;
	}
}
