package pl.edu.wroc.pwr.model.to;

import pl.edu.wroc.pwr.model.util.Coordinates;

/**
 * Created by krzaczek on 26.10.14.
 */
public class PlaceCreationTO {

	private Coordinates coordinates;
	private String name = "";
	private String description = "";
	private Long ownerId;

	public PlaceCreationTO() {
	}

	public PlaceCreationTO(Coordinates coordinates, String name, String description, Long ownerId) {
		this.coordinates = coordinates;
		this.name = name;
		this.description = description;
		this.ownerId = ownerId;
	}

	public Coordinates getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}
}
