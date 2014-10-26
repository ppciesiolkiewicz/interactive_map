package pl.edu.wroc.pwr.service.manager;

import pl.edu.wroc.pwr.model.to.comment.CommentCreationTO;
import pl.edu.wroc.pwr.service.model.Comment;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by krzaczek on 26.10.14.
 */
public class CommentManager {

	private static List<Comment> comments = new ArrayList<Comment>();

	public Comment get(String commentId) {
		for (Comment comment : comments) {
			if (comment.getId().equals(commentId)) {
				return comment;
			}
		}
		return null;
	}

	public List<Comment> getCommentsFor(String targetId) {
		List<Comment> commentsForTarget = new LinkedList<Comment>();
		for (Comment comment : comments) {
			if (comment.getTargetId().equals(targetId)) {
				commentsForTarget.add(comment);
			}
		}
		return commentsForTarget;
	}

	public String remove(String commentId, Long ownerId) {
		for (Comment comment : comments) {
			if (comment.getId().equals(commentId)) {
				if (comment.getOwnerId().equals(ownerId)) {
					comments.remove(comment);
					return comment.getId();
				}
			}
		}
		return null;
	}

	public String createComment(CommentCreationTO commentCreationTO) {
		Comment comment = createCommentFromTO(commentCreationTO);
		comments.add(comment);
		return comment.getId();
	}

	private Comment createCommentFromTO(CommentCreationTO commentCreationTO) {
		Comment comment = new Comment();
		comment.setOwnerId(commentCreationTO.getOwnerId());
		comment.setTargetId(commentCreationTO.getTargetId());
		comment.setComment(commentCreationTO.getComment());
		return  comment;
	}
}
