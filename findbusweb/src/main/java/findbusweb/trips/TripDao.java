package findbusweb.trips;

import findbusweb.ed.Trips;
import findbusweb.infra.BaseDao;

public class TripDao extends BaseDao<Trips, String>{
	
	public TripDao() {
		super(Trips.class);
	}

}
