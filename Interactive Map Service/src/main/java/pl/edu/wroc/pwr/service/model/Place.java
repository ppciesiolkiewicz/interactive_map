package pl.edu.wroc.pwr.service.model;

import pl.edu.wroc.pwr.model.util.Coordinates;

import java.io.Serializable;
import java.util.Set;

/**
 * Created by krzaczek on 25.10.14.
 */
public class Place implements Serializable {

	private String id = "testId";
	private Coordinates coordinates;
	private String name = "";
	private String description = "";
	private Long ownerId;
	private Set<String> tags;

	public Place() {
	}

	public Place(Coordinates coordinates, String name, String description, Long ownerId, Set<String> tags) {
		this.coordinates = coordinates;
		this.name = name;
		this.description = description;
		this.ownerId = ownerId;
		this.tags = tags;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public Set<String> getTags() {
		return tags;
	}

	public void setTags(Set<String> tags) {
		this.tags = tags;
	}
}