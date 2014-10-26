package pl.edu.wroc.pwr.service;

import pl.edu.wroc.pwr.service.endpoint.EventsService;
import pl.edu.wroc.pwr.service.endpoint.PlacesService;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by krzaczek on 24.10.14.
 */
@ApplicationPath("/MapService/v1")
public class MapService extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> s = new HashSet<Class<?>>();
		s.add(PlacesService.class);
		s.add(EventsService.class);
		return s;
	}
}