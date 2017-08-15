package read.frontend.presentation;

import java.io.InputStream;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/json")
public class FrontController {
	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_PLAIN)
	public Response verifyRESTService(InputStream incomingData){
		String result = "Everything works..";
		return Response.status(200).entity(result).build();
	}
}
