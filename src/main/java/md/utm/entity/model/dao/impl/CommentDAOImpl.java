
package md.utm.entity.model.dao.impl;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;

import md.utm.entity.exception.NullProfileException;
import md.utm.entity.model.dao.CommentDAO;
import md.utm.entity.model.entity.Comment;

@SuppressWarnings("unchecked")
public class CommentDAOImpl extends GenericDAOImpl implements CommentDAO {

	@Override
	public List<Comment> getAllComments() {

		Integer idProf = (Integer) ActionContext.getContext().getSession().get("profile_id");
		if (idProf == null) {
			throw new NullProfileException();
		}
		// System.out.println("id-ul pentru profil din sesiune = " + test);

		return getHibernateTemplate().find("from Comment where profile_id=? order by creationDate desc", idProf);

		// ("from Profile where idProfile=?",idProfile
	}

	@Override
	public Comment getCommentById(Integer idComment) {

		return get(Comment.class, idComment);
		// return getHibernateTemplate().find("from Comment order by
		// creationDate desc");

	}

}
