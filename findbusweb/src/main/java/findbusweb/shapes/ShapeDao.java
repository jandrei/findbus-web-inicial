package findbusweb.shapes;

import findbusweb.ed.Shapes;
import findbusweb.ed.Trips;
import findbusweb.infra.BaseDao;

public class ShapeDao extends BaseDao<Shapes, String>{
	
	public ShapeDao() {
		super(Shapes.class);
	}

}
