package pl.edu.wroc.pwr.service.manager;

import pl.edu.wroc.pwr.model.to.event.EventCreationTO;
import pl.edu.wroc.pwr.model.to.event.EventTO;
import pl.edu.wroc.pwr.service.model.Event;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by krzaczek on 26.10.14.
 */
public class EventsManager {

	private static List<Event> events = new ArrayList<Event>();

	public List<Event> getAll() {
		return events;
	}

	public Event get(String id) {
		for (Event event : events) {
			if (event.getId().equals(id)) {
				return event;
			}
		}
	return  null;
	}

	public String remove(String id, Long ownerId) {
		for (Event event : events) {
			if (event.getId().equals(id)) {
				if (ownerId.equals(event.getOwnerId())) {
					events.remove(event);
					return event.getId();
				}
			}
		}
	return null;
	}


	public void update(EventTO eventTO, Long ownerId) {
		Event event = createEventFromTO(eventTO);
	}

	public String create(EventCreationTO eventTO) {
		Event event = createEventFromCreationTO(eventTO);
		events.add(event);
		return event.getId();
	}

	private Event createEventFromTO(EventTO eventTO) {
		Event eventFromCreationTO = createEventFromCreationTO(eventTO);
		eventFromCreationTO.setId(eventTO.getId());
		return eventFromCreationTO;
	}

	private Event createEventFromCreationTO(EventCreationTO eventTO) {
		Event event = new Event();
		event.setPlaceId(eventTO.getPlaceId());
		event.setDescription(eventTO.getDescription());
		event.setName(eventTO.getName());
		event.setOwnerId(eventTO.getOwnerId());
		event.setTags(eventTO.getTags());
		return event;
	}

	public List getFiltered(Set<String> tags) {
		List<Event> filteredPlaces = new LinkedList<Event>();
		for (Event event : events) {
			if (containsTag(event, tags)) {
				filteredPlaces.add(event);
			}
		}
		return filteredPlaces;
	}

	private boolean containsTag(Event event, Set<String> tags) {
		for (String tag : event.getTags()) {
			if (tags.contains(tag)) {
				return true;
			}
		}
		return false;
	}

}
