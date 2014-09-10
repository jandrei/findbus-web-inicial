package findbusweb;

import javax.annotation.ManagedBean;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import findbusweb.agency.AgencyService;
import findbusweb.ed.Agency;
import findbusweb.ed.Routes;
import findbusweb.ed.Stops;
import findbusweb.routes.RouteService;
import findbusweb.stops.StopService;

@Path("/r")
@ManagedBean
public class Rest {
	
	@Inject
	AgencyService agencyService;
	
	@Inject
	RouteService routeService;

	@Inject
	StopService stopService;
	
	@GET
	@Path("/agencys")
	public Response agencys(){
		java.util.List<Agency> agencias = agencyService.listar(new Agency());
		return Response.ok(new Gson().toJson(agencias)).build();
	}

	@GET
	@Path("/routes")
	public Response routes(){
		java.util.List<Routes> rotas = routeService.listar(new Routes());
		return Response.ok(new Gson().toJson(rotas)).build();
	}
	
	@GET
	@Path("/stops")
	public Response stops(){
		java.util.List<Stops> rotas = stopService.listar(new Stops());
		return Response.ok(new Gson().toJson(rotas)).build();
	}
}
