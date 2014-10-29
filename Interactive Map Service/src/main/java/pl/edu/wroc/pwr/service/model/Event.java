package pl.edu.wroc.pwr.service.model;

import java.util.Set;

/**
 * Created by krzaczek on 26.10.14.
 */
public class Event extends Model {

	private String id = "testEventId";
	private String placeId;

	public Event(String placeId, String name, String description, Long ownerId,
		Set<String> tags) {
		super(name, description, ownerId, tags);
		this.placeId = placeId;
	}

	public Event() {
	}

	@Override public String getId() {
		return id;
	}

	public String getPlaceId() {
		return placeId;
	}

	public void setPlaceId(String placeId) {
		this.placeId = placeId;
	}

}
