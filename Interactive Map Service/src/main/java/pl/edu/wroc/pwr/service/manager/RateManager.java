package pl.edu.wroc.pwr.service.manager;

import pl.edu.wroc.pwr.model.to.rating.RateCreationTO;
import pl.edu.wroc.pwr.service.manager.utils.RateCalculator;
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

	private static List<Rate> rates = new ArrayList<Rate>();
	private final RateCalculator calculator;

	public RateManager() {
		calculator = new RateCalculator();
	}

	public Rate get(String rateId) {
		for (Rate rate : rates) {
			if (rate.getId().equals(rateId)) {
				return rate;
			}
		}
		return null;
	}

	public String remove(String rateId, Long ownerId) {
		for (Rate rate : rates) {
			if (rate.getId().equals(rateId)) {
				if (rate.getOwnerId().equals(ownerId)) {
					rates.remove(rate);
					return rate.getId();
				}
			}
		}
		return null;
	}

	public String createRate(RateCreationTO rateCreationTO) {
		if (!isValid(rateCreationTO)) {
			return null;
		}
		Rate rate = createRateFromTO(rateCreationTO);
		rates.add(rate);
		return rate.getId();
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

	public Double getAverage(String targetId) {
		List<Integer> rateValues = new LinkedList<Integer>();
		for(Rate rate : rates) {
			rateValues.add(rate.getRate());
		}
		return calculator.avg(rateValues);
	}
}
