package findbusweb;

import javax.annotation.ManagedBean;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import findbusweb.agency.AgencyService;
import findbusweb.ed.Agency;

@Path("/teste")
@ManagedBean
public class Rest {
	
	@Inject
	AgencyService agencyService;
	
	
	@GET
	@Path("/teste")
	public Response teste(){
		java.util.List<Agency> agencias = agencyService.listar(new Agency());
		return Response.ok(new Gson().toJson(agencias)).build();
	}
}
