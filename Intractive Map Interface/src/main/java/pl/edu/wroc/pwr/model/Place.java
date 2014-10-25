package pl.edu.wroc.pwr.model;

import pl.edu.wroc.pwr.model.util.Coordinates;

import java.io.Serializable;

/**
 * Created by krzaczek on 25.10.14.
 */
public class Place implements Serializable {

	private String id = "testId";
	private Coordinates coordinates;
	private String name = "";
	private String description = "";
	private Long ownerId;

	public Place() {
	}

	public Place(Coordinates coordinates, String name, String description, Long ownerId) {
		this.coordinates = coordinates;
		this.name = name;
		this.description = description;
		this.ownerId = ownerId;
	}

	public String getId() {
		return id;
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
