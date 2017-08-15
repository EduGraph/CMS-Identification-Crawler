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
import read.frontend.presentation.Models.CMS;
import read.frontend.presentation.Models.CMSAnzahl;

@Path("/json")
public class FrontController {
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
		List<CMSAnzahl> cmsVerbreitung = new ArrayList<>();
		cmsVerbreitung.add(new CMSAnzahl(CMS.Typo3, 200));
		cmsVerbreitung.add(new CMSAnzahl(CMS.Drupal, 7));
		cmsVerbreitung.add(new CMSAnzahl(CMS.Imperia, 2));
		return new AnzahlDerVerwendetenCMS(cmsVerbreitung);
	}
	
}
