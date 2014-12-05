package pl.edu.wroc.pwr.service.manager.service;

import com.mongodb.WriteResult;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import pl.edu.wroc.pwr.model.to.user.UserTO;
import pl.edu.wroc.pwr.service.manager.DataManager;
import pl.edu.wroc.pwr.service.model.User;

/**
 * Created by krzaczek on 22.11.14.
 */
public class UserManager extends DataManager {

	public User get(String userId) {
		return mongoOperation.findById(userId, User.class);
	}

	public String create(UserTO userTO) {
		User user = createUserFromTO(userTO);
		mongoOperation.save(user);
		return user.getId();
	}

	public int update(UserTO userTO) {
		Query searchQuery = new Query(Criteria.where("id").is(userTO.getId()));
		Update update = new Update();
		WriteResult writeResult = mongoOperation.updateFirst(searchQuery, update, User.class);
		return writeResult.getN();
	}

	private User createUserFromTO(UserTO userTO) {
		User user = new User();
		user.setId(userTO.getId());
		return user;
	}
}