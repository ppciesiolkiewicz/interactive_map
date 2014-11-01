package pl.edu.wroc.pwr.service.manager.service;

import com.mongodb.WriteResult;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import pl.edu.wroc.pwr.service.db.SpringMongoConfig;
import pl.edu.wroc.pwr.service.manager.DataManager;
import pl.edu.wroc.pwr.service.model.Model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by krzaczek on 29.10.14.
 */
public class ModelManager<T extends Model>  extends DataManager {

	private final Class<T> type;

	public ModelManager(Class<T> type) {
		this.type = type;
	}

	public List<T> getAll() {
		return mongoOperation.findAll(type);
	}

	public T get(String id) {
		return mongoOperation.findById(id, type);
	}

	public int remove(String id, Long ownerId) {
		Query searchQuery = new Query(Criteria.where("id").is(id).andOperator(Criteria.where("ownerId").is(ownerId)));
		WriteResult removed = mongoOperation.remove(searchQuery, type);
		return removed.getN();
	}

	//TODO implement
	public Set<T> getFiltered(Set<String> tags) {
		Set<T> filteredPlaces = new HashSet<T>();
		//		for(String tag : tags) {
		//			Query serachQuery = new Query(Criteria.where("tags").)
		//			try (DBCursor cursor = mongoOperation.find(query, type)) {
		//				while (cursor.hasNext()) {
		//					System.out.println(cursor.next());
		//				}
		//			}
		//		}
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
