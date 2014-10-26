package pl.edu.wroc.pwr.service.endpoint;

import pl.edu.wroc.pwr.model.to.event.EventCreationTO;
import pl.edu.wroc.pwr.model.to.event.EventTO;
import pl.edu.wroc.pwr.service.manager.EventsManager;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Set;

/**
 * Created by krzaczek on 26.10.14.
 */
@Path("/events")
public class EventsService {

	private EventsManager eventsManager = new EventsManager();

	@GET
	@Path("/")
	public Response getAllEvents() {
		return Response.status(Response.Status.OK).entity(eventsManager.getAll()).type(MediaType.APPLICATION_JSON)
			.build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/")
	public Response createEvent(EventCreationTO event) {
		return Response.status(Response.Status.OK).entity(eventsManager.create(event)).type(
			MediaType.APPLICATION_JSON).build();
	}

	@GET
	@Path("/{id}")
	public Response getEvent(@PathParam("id") String id) {
		return Response.status(Response.Status.OK).entity(eventsManager.get(id)).type(MediaType.APPLICATION_JSON)
			.build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/filtered")
	public Response createEvent(Set<String> tags) {
		return Response.status(Response.Status.OK).entity(eventsManager.getFiltered(tags)).type(
			MediaType.APPLICATION_JSON).build();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/")
	public Response updateEvent(@QueryParam("ownerId") Long ownerId, EventTO event) {
		eventsManager.update(event, ownerId);
		return Response.status(Response.Status.OK).type(MediaType.APPLICATION_JSON).build();
	}

	@DELETE
	@Path("/{id}/{ownerId}")
	public Response removeEvent(@PathParam("id") String id, @PathParam("ownerId") Long ownerId) {
		eventsManager.remove(id, ownerId);
		return Response.status(Response.Status.OK).type(MediaType.APPLICATION_JSON).build();
	}

}
