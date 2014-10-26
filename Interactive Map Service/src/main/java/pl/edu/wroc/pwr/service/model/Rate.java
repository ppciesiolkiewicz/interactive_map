package pl.edu.wroc.pwr.service.model;

/**
 * Created by krzaczek on 26.10.14.
 */
public class Rate {

	private String id;
	private Integer rate;
	private Long ownerId;
	private String targetId;

	public Rate() {
	}

	public Rate(Integer rate, Long ownerId, String targetId) {
		this.rate = rate;
		this.ownerId = ownerId;
		this.targetId = targetId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getRate() {
		return rate;
	}

	public void setRate(Integer rate) {
		this.rate = rate;
	}

	public Long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}

	public String getTargetId() {
		return targetId;
	}

	public void setTargetId(String targetId) {
		this.targetId = targetId;
	}
}
