
package md.utm.entity.model.dao.impl;

import java.util.List;

import org.hibernate.Query;

import com.opensymphony.xwork2.ActionContext;

import md.utm.entity.exception.NullProfileException;
import md.utm.entity.model.dao.CommentDAO;
import md.utm.entity.model.entity.Comment;

@SuppressWarnings("unchecked")
public class CommentDAOImpl extends GenericDAOImpl implements CommentDAO {

	
	public List<Comment> getAllComments() {
		Integer idProf = (Integer) ActionContext.getContext().getSession().get("profile_id");
		if (idProf == null) {
			throw new NullProfileException();
		}
		Query createQuery = getSession()
				.createQuery("from Comment where profile_id=:profileId order by creationDate desc");
		createQuery.setInteger("profileId", idProf);
		// createQuery.setMaxResults(1);
		createQuery.list();
		return createQuery.list();
	}

	
	public Comment getCommentById(Integer idComment) {

		return get(Comment.class, idComment);

	}

}
