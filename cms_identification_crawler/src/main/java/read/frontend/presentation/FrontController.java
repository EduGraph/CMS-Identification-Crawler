package read.frontend.presentation;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import read.frontend.presentation.Models.AnzahlDerVerwendetenCMS;
import read.frontend.presentation.Models.CMSDerHochschulen;
import read.frontend.presentation.Queries.CMSHochschulen;
import read.frontend.presentation.Queries.CMSVerbreitung;
import read.frontend.presentation.Resolver.IQueryResolver;
import read.frontend.presentation.Resolver.QueryResolver;

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
	
}
