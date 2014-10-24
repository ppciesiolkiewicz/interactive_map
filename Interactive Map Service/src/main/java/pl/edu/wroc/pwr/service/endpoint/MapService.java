package pl.edu.wroc.pwr.service.endpoint;


import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by krzaczek on 24.10.14.
 */
public class MapService extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> s = new HashSet<Class<?>>();
		s.add(PlacesService.class);
		return s;
	}
}