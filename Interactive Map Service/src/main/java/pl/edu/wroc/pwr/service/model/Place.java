package pl.edu.wroc.pwr.service.model;

import pl.edu.wroc.pwr.model.util.Coordinates;

import java.util.Set;

/**
 * Created by krzaczek on 25.10.14.
 */
public class Place extends Model {

	private String id = "testPlaceId";
	private Coordinates coordinates;

	public Place() {
	}

	public Place(Coordinates coordinates, String name, String description, Long ownerId, Set<String> tags) {
		super(name, description, ownerId, tags);
		this.coordinates = coordinates;

	}

	@Override public String getId() {
		return id;
	}

	public Coordinates getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}

}