package pl.edu.wroc.pwr.service.model;

/**
 * Created by krzaczek on 26.10.14.
 */
public class Comment {

	private String id = "testCommentId";
	private String targetId;
	private String comment;
	private Long ownerId;

	public Comment() {
	}

	public Comment(String comment, Long ownerId, String targetId) {
		this.comment = comment;
		this.ownerId = ownerId;
		this.targetId = targetId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
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