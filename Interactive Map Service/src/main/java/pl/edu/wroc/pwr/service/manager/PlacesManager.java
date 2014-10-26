package pl.edu.wroc.pwr.service.manager;


import pl.edu.wroc.pwr.model.to.PlaceCreationTO;
import pl.edu.wroc.pwr.model.to.PlaceTO;
import pl.edu.wroc.pwr.service.model.Place;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

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

	public void update(PlaceTO placeTO, Long ownerId) {
		Place place = createPlaceFromTO(placeTO);
	}


	public String create(PlaceCreationTO placeTO) {
		Place place = createPlaceFromCreationTO(placeTO);
		places.add(place);
		return place.getId();
	}


	private Place createPlaceFromTO(PlaceTO placeTO) {
		Place placeFromCreationTO = createPlaceFromCreationTO(placeTO);
		placeFromCreationTO.setId(placeTO.getId());
		return  placeFromCreationTO;
	}

	private Place createPlaceFromCreationTO(PlaceCreationTO placeTO) {
		Place place = new Place();
		place.setCoordinates(placeTO.getCoordinates());
		place.setDescription(placeTO.getDescription());
		place.setName(placeTO.getName());
		place.setOwnerId(placeTO.getOwnerId());
		place.setTags(placeTO.getTags());
		return place;
	}

	public Object getFiltered(Set<String> tags) {
		List<Place> filteredPlaces = new LinkedList<Place>();
		for (Place place : places) {
			if(containsTag(place, tags)) {
				filteredPlaces.add(place);
			}
		}
		return  filteredPlaces;
	}

	private boolean containsTag(Place place, Set<String> tags) {
		for(String tag : place.getTags()) {
			if(tags.contains(tag)) {
				return true;
			}
		}
		return false;
	}

}
