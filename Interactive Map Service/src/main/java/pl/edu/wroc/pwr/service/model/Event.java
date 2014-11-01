package pl.edu.wroc.pwr.service.model;

import java.util.Date;
import java.util.Set;

/**
 * Created by krzaczek on 26.10.14.
 */
public class Event extends Model {

	private String id = "testEventId";
	private String placeId;
	private Date date;

	public Event(String placeId, String name, String description, Long ownerId,
		Set<String> tags, Date date) {
		super(name, description, ownerId, tags);
		this.placeId = placeId;
		this.date = date;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
