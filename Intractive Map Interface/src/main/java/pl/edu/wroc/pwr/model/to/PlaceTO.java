package pl.edu.wroc.pwr.model.to;

import pl.edu.wroc.pwr.model.util.Coordinates;

/**
 * Created by krzaczek on 26.10.14.
 */
public class PlaceTO extends  PlaceCreationTO {

	private String id;

	public PlaceTO() {}

	public PlaceTO(Coordinates coordinates, String name, String description,
		Long ownerId, String id) {
		super(coordinates, name, description, ownerId);
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
