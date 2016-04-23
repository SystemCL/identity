package md.utm.entity.model.dao;

import java.util.List;

import md.utm.entity.model.entity.Comment;
import md.utm.entity.model.entity.Message;

public interface MessageDAO extends GenericDAO {
	
	List<Message> getMessagesBySenderId();
	
	Message getCommentById(Integer idComment);

}
