package pl.edu.wroc.pwr.model.to.rating;

/**
 * Created by krzaczek on 26.10.14.
 */
public class RateCreationTO {

	private Long rate;
	private String ownerId;
	private String targetId;

	public RateCreationTO() {
	}

	public RateCreationTO(Long rate, String ownerId, String targetId) {
		this.rate = rate;
		this.ownerId = ownerId;
		this.targetId = targetId;
	}

	public Long getRate() {
		return rate;
	}

	public void setRate(Long rate) {
		this.rate = rate;
	}

	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}

	public String getTargetId() {
		return targetId;
	}

	public void setTargetId(String targetId) {
		this.targetId = targetId;
	}
}

