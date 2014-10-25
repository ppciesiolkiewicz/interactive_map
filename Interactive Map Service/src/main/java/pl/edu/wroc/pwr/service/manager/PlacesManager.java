package pl.edu.wroc.pwr.service.manager;

import pl.edu.wroc.pwr.model.Place;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by krzaczek on 25.10.14.
 */
public class PlacesManager {

	private static List<Place> places = new ArrayList<Place>();

	public List<Place> getAll() {
		return places;
	}

	public Place get(String id) {
		for (Place place : places) {
			if (place.getId().equals(id)) {
				return place;
			}
		}
		throw new NullPointerException();
	}

	public void remove(String id, Long ownerId) {
		for (Place place : places) {
			if (place.getId().equals(id)) {
				if (ownerId.equals(place.getOwnerId())) {
					places.remove(place);
					return;
				}
			}
		}
		throw new NullPointerException();
	}

	public void update(Place place, Long ownerId) {

	}

	public String create(Place place) {
		places.add(place);
		return place.getId();
	}
}
