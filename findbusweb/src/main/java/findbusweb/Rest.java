package findbusweb;

import javax.annotation.ManagedBean;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import findbusweb.agency.AgencyService;
import findbusweb.calendar.CalendarService;
import findbusweb.ed.Agency;
import findbusweb.ed.Calendars;
import findbusweb.ed.Routes;
import findbusweb.ed.Shapes;
import findbusweb.ed.StopTime;
import findbusweb.ed.Stops;
import findbusweb.ed.Trips;
import findbusweb.routes.RouteService;
import findbusweb.shapes.ShapeService;
import findbusweb.stops.StopService;
import findbusweb.stoptime.StopTimeService;
import findbusweb.trips.TripService;

@Path("/r")
@ManagedBean
public class Rest {

	@Inject
	AgencyService agencyService;

	@Inject
	RouteService routeService;

	@Inject
	StopService stopService;

	@Inject
	CalendarService calendarService;

	@Inject
	TripService tripService;

	@Inject
	ShapeService shapeService;

	@Inject
	StopTimeService stopTimeService;

	@Context
	Request request;

	@GET
	@Path("/agencys")
	public Response agencys() {
		java.util.List<Agency> agencias = agencyService.listar(new Agency());
		return Response.ok(new Gson().toJson(agencias)).build();
	}

	@GET
	@Path("/routes")
	public Response routes() {
		java.util.List<Routes> rotas = routeService.listar(new Routes());
		return Response.ok(new Gson().toJson(rotas)).build();
	}

	@GET
	@Path("/stops")
	public Response stops() {
		java.util.List<Stops> rotas = stopService.listar(new Stops());
		return Response.ok(new Gson().toJson(rotas)).build();
	}

	@GET
	@Path("/calendars")
	public Response calendars() {
		java.util.List<Calendars> lista = calendarService
				.listar(new Calendars());
		return Response.ok(new Gson().toJson(lista)).build();
	}

	@GET
	@Path("/trips")
	public Response trips(@Context HttpServletRequest request) {
		String page = request.getParameter("page");
		String max = request.getParameter("max");
		
		if (page ==null || page.isEmpty() || max == null || max.isEmpty()){
			return Response.ok("max e page devem ser informados").build();
		}
		
		java.util.List<Trips> lista = tripService.listarTodos(Integer.valueOf(max), Integer.valueOf(page));
		return Response.ok(new Gson().toJson(lista)).build();
	}

	@GET
	@Path("/shapes")
	public Response shapes(@Context HttpServletRequest request) {
		String page = request.getParameter("page");
		String max = request.getParameter("max");
		if (page ==null || page.isEmpty() || max == null || max.isEmpty()){
			return Response.ok("max e page devem ser informados").build();
		}
		
		java.util.List<Shapes> lista = shapeService.listarTodos(
				Integer.valueOf(max), Integer.valueOf(page));
		return Response.ok(new Gson().toJson(lista)).build();
	}

	@GET
	@Path("/stoptime")
	public Response stopTime() {
		java.util.List<StopTime> lista = stopTimeService.listar(new StopTime());
		return Response.ok(new Gson().toJson(lista)).build();
	}

}
