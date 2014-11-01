package pl.edu.wroc.pwr.model.to.comment;

/**
 * Created by krzaczek on 26.10.14.
 */
public class CommentCreationTO {

	private String comment;
	private Long ownerId;
	private String targetId;

	public CommentCreationTO() {
	}

	public CommentCreationTO(String comment, Long ownerId, String targetId) {
		this.comment = comment;
		this.ownerId = ownerId;
		this.targetId = targetId;
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
