package pl.edu.wroc.pwr.service.manager;

import pl.edu.wroc.pwr.model.to.event.EventCreationTO;
import pl.edu.wroc.pwr.model.to.event.EventTO;
import pl.edu.wroc.pwr.service.model.Event;

/**
 * Created by krzaczek on 26.10.14.
 */
public class EventsManager extends ModelManager<Event> {

	public void update(EventTO eventTO, Long ownerId) {
		Event event = createEventFromTO(eventTO);
	}

	public String create(EventCreationTO eventTO) {
		Event event = createEventFromCreationTO(eventTO);
		models.add(event);
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

}
