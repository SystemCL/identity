package md.utm.entity.action.user;

import java.util.Date;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;

import md.utm.entity.model.dao.CommentDAO;
import md.utm.entity.model.entity.Comment;

public class CrudCommentAction implements ModelDriven<Comment> {
	private final Comment comment = new Comment();
	private CommentDAO commentDAO;

	public Comment getModel() {
		return comment;
	}

	public void setCommentDAO(CommentDAO commentDAO) {
		this.commentDAO = commentDAO;
	}

	public String addComment() {
		comment.setCreationDate(new Date());
		commentDAO.save(comment);
		if (comment.getIdMessage() != null) {
			return Action.SUCCESS;
		}
		return Action.ERROR;
	}
}
