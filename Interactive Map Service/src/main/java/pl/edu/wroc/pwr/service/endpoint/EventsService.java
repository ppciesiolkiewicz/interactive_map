package pl.edu.wroc.pwr.service.endpoint;

import pl.edu.wroc.pwr.service.manager.EventsManager;

import javax.ws.rs.Path;

/**
 * Created by krzaczek on 26.10.14.
 */
@Path("/events")
public class EventsService {

	private EventsManager eventsManager = new EventsManager();
}
