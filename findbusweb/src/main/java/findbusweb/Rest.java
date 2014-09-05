package findbusweb;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

@Path("/teste")
public class Rest {
	@GET
	@Path("/teste")
	public Response teste(){
		Map<String, String> mapa = new HashMap<String, String>();
		mapa.put("idade", "25");
		mapa.put("nome", "jandrei");
		mapa.put("nomemeio", "carlos");
		mapa.put("sobrenome", "masiero");
		
		return Response.ok(new Gson().toJson(mapa)).build();
	}
}
