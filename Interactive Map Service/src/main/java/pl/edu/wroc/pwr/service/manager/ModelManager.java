package pl.edu.wroc.pwr.service.manager;

import pl.edu.wroc.pwr.service.model.Event;
import pl.edu.wroc.pwr.service.model.Model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by krzaczek on 29.10.14.
 */
public class ModelManager<T extends Model> {

	protected List<T> models = new ArrayList<T>();


	public List<T> getAll() {
		return models;
	}

	public T get(String id) {
		for (T model : models) {
			if (model.getId().equals(id)) {
				return model;
			}
		}
		return  null;
	}

	public String remove(String id, Long ownerId) {
		for (T model : models) {
			if (model.getId().equals(id)) {
				if (ownerId.equals(model.getOwnerId())) {
					models.remove(model);
					return model.getId();
				}
			}
		}
		return null;
	}



	public List<T> getFiltered(Set<String> tags) {
		List<T> filteredPlaces = new LinkedList<T>();
		for (T model : models) {
			if (containsTag(model, tags)) {
				filteredPlaces.add(model);
			}
		}
		return filteredPlaces;
	}

	private boolean containsTag(T model, Set<String> tags) {
		for (String tag : model.getTags()) {
			if (tags.contains(tag)) {
				return true;
			}
		}
		return false;
	}

}
