package read.frontend.presentation;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import crosscutting.query.IQueryResolver;
import crosscutting.query.QueryResolver;
import read.frontend.presentation.Models.AnzahlDerVerwendetenCMS;
import read.frontend.presentation.Models.CMSDerHochschulen;
import read.frontend.presentation.Models.VeraenderungAktuelleWoche;
import read.frontend.presentation.Queries.CMSHochschulen;
import read.frontend.presentation.Queries.CMSVerbreitung;
import read.frontend.presentation.Queries.VeraenderungWoche;
import write.TimeEvents.CMSIdentifierCrawlerTimer;
import write.TimeEvents.ICMSIdentifierCrawlerTimer;
import write.TimeEvents.IUniversityCrawlerTimer;
import write.TimeEvents.UniversityCrawlerTimer;
import write.UniversityCrawler.IUniversityCrawler;
import write.UniversityCrawler.UniversityCrawler;
import write.cmsidentifier.business.CMSIdentifierCrawler;
import write.cmsidentifier.business.ICMSIdentifierCrawler;

@Path("/json")
public class FrontController {
	
	private IQueryResolver resolver;
	
	public FrontController() {
		resolver = new QueryResolver();
	}
	
	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_PLAIN)
	public Response verifyRESTService(InputStream incomingData){
		String result = "Everything works..";
		return Response.status(200).entity(result).build();
	}
	
	@GET
	@Path("/anzahlderverwendetencms")
	@Produces(MediaType.APPLICATION_JSON)
	public AnzahlDerVerwendetenCMS serviceAnzahlDerVerwendetenCMS() {
		return (AnzahlDerVerwendetenCMS)resolver.Resolve(new CMSVerbreitung());
	}
	
	@GET
	@Path("/cmsderhochschulen")
	@Produces(MediaType.APPLICATION_JSON)
	public CMSDerHochschulen serviceCmsDerHochschulen() {
		return (CMSDerHochschulen)resolver.Resolve(new CMSHochschulen());
	}
	
	@GET
	@Path("/veraenderungaktuellewoche")
	@Produces(MediaType.APPLICATION_JSON)
	public VeraenderungAktuelleWoche serviceVeraenderungAktuelleWoche() {
		return (VeraenderungAktuelleWoche)resolver.Resolve(new VeraenderungWoche());
	}
	
	@GET
	@Path("/crawlUniversities")
	@Produces(MediaType.TEXT_PLAIN)
	public Response startUniCrawling(InputStream incomingData){
		IUniversityCrawlerTimer universityCrawlerTimer = new UniversityCrawlerTimer();
		
		if (universityCrawlerTimer.start()) {
			IUniversityCrawler universityCrawler = new UniversityCrawler();
			universityCrawler.crawl();
			return Response.status(200).entity("Universities done...").build();
		}
		
		return Response.status(200).entity("Universities already crawled").build();
	}
	
	@GET
	@Path("/crawlCMS")
	@Produces(MediaType.TEXT_PLAIN)
	public Response startCMSCrawling(InputStream incomingData){
		ICMSIdentifierCrawlerTimer cmsIdentifierTimer = new CMSIdentifierCrawlerTimer();
		
		if (cmsIdentifierTimer.start()) {
			ICMSIdentifierCrawler cmdIdentifierCrawler = new CMSIdentifierCrawler();
			cmdIdentifierCrawler.crawl();
			return Response.status(200).entity("CmsIdentifierCrawler done...").build();
		}
		
		return Response.status(200).entity("CMS already crawled").build();
	}
}
