package pl.edu.wroc.pwr.service.manager;

import com.mongodb.WriteResult;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import pl.edu.wroc.pwr.model.to.rating.RateCreationTO;
import pl.edu.wroc.pwr.service.db.SpringMongoConfig;
import pl.edu.wroc.pwr.service.manager.utils.RateCalculator;
import pl.edu.wroc.pwr.service.model.Comment;
import pl.edu.wroc.pwr.service.model.Rate;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by krzaczek on 26.10.14.
 */
public class RateManager {

	public static final int RATE_MIN = 1;
	public static final int RATE_MAX = 5;

	ApplicationContext ctx =new AnnotationConfigApplicationContext(SpringMongoConfig.class);
	MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");

	private final RateCalculator calculator;

	public RateManager() {
		calculator = new RateCalculator();
	}

	public Rate get(String rateId) {
		return mongoOperation.findById(rateId, Rate.class);
	}

	public int remove(String rateId, Long ownerId) {
		Query searchUserQuery = new Query(Criteria.where("id").is(rateId).andOperator(Criteria.where("ownerId").is(ownerId)));
		WriteResult remove = mongoOperation.remove(searchUserQuery, Rate.class);
		return remove.getN();
	}

	public String createRate(RateCreationTO rateCreationTO) {
		if (!isValid(rateCreationTO)) {
			return null;
		}
		Rate rate = createRateFromTO(rateCreationTO);
		mongoOperation.save(rate);
		return rate.getId();
	}

	public Double getAverage(String targetId) {
		List<Integer> rateValues = new LinkedList<Integer>();
		Query searchUserQuery = new Query(Criteria.where("targetId").is(targetId));
		List<Rate> rates = mongoOperation.find(searchUserQuery, Rate.class);
		for(Rate rate : rates) {
			rateValues.add(rate.getRate());
		}
		return calculator.avg(rateValues);
	}

	private boolean isValid(RateCreationTO rateCreationTO) {
		Integer rate = rateCreationTO.getRate();
		return rate >= RATE_MIN && rate <= RATE_MAX;
	}

	private Rate createRateFromTO(RateCreationTO rateCreationTO) {
		Rate rate = new Rate();
		rate.setOwnerId(rateCreationTO.getOwnerId());
		rate.setRate(rateCreationTO.getRate());
		rate.setTargetId(rateCreationTO.getTargetId());
		return rate;
	}


}
