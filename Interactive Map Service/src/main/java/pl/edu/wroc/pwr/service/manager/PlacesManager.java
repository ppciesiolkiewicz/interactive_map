package pl.edu.wroc.pwr.service.manager;

import pl.edu.wroc.pwr.model.to.place.PlaceCreationTO;
import pl.edu.wroc.pwr.model.to.place.PlaceTO;
import pl.edu.wroc.pwr.service.model.Place;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by krzaczek on 25.10.14.
 */
public class PlacesManager extends  ModelManager<Place>{

	public void update(PlaceTO placeTO, Long ownerId) {
		Place place = createPlaceFromTO(placeTO);
	}

	public String create(PlaceCreationTO placeTO) {
		Place place = createPlaceFromCreationTO(placeTO);
		models.add(place);
		return place.getId();
	}

	private Place createPlaceFromTO(PlaceTO placeTO) {
		Place placeFromCreationTO = createPlaceFromCreationTO(placeTO);
		placeFromCreationTO.setId(placeTO.getId());
		return placeFromCreationTO;
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

}
