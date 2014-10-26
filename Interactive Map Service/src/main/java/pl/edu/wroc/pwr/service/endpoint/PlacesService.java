package pl.edu.wroc.pwr.service.endpoint;

import pl.edu.wroc.pwr.model.to.PlaceCreationTO;
import pl.edu.wroc.pwr.model.to.PlaceTO;
import pl.edu.wroc.pwr.service.manager.PlacesManager;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by krzaczek on 24.10.14.
 */
@Path("/places")
public class PlacesService {

	private PlacesManager placesManager = new PlacesManager();

	@GET
	@Path("/")
	public Response getAllPlaces() {
		return Response.status(Response.Status.OK).entity(placesManager.getAll()).type(MediaType.APPLICATION_JSON)
			.build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/")
	public Response createPlace(PlaceCreationTO place) {
		return Response.status(Response.Status.OK).entity(placesManager.create(place)).type(
			MediaType.APPLICATION_JSON).build();
	}

	@GET
	@Path("/{id}")
	public Response getPlace(@PathParam("id") String id) {
		return Response.status(Response.Status.OK).entity(placesManager.get(id)).type(MediaType.APPLICATION_JSON)
			.build();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/")
	public Response updatePlace(@QueryParam("ownerId") Long ownerId, PlaceTO place) {
		placesManager.update(place, ownerId);
		return Response.status(Response.Status.OK).type(MediaType.APPLICATION_JSON).build();
	}

	@DELETE
	@Path("/{id}/{ownerId}")
	public Response removePlace(@PathParam("id") String id, @PathParam("ownerId") Long ownerId) {
		placesManager.remove(id, ownerId);
		return Response.status(Response.Status.OK).type(MediaType.APPLICATION_JSON).build();
	}

}