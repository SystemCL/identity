
package md.utm.entity.model.dao.impl;

import java.util.List;

import md.utm.entity.model.dao.CommentDAO;
import md.utm.entity.model.entity.Comment;
import md.utm.entity.model.entity.UserAccount;

@SuppressWarnings("unchecked")
public class CommentDAOImpl extends GenericDaoImpl implements CommentDAO {

	public List<Comment> getAllComments() {
		// TODO Auto-generated method stub
		return getHibernateTemplate().find("from Comment order by creationDate desc");
	}

	public Comment getCommentById(Integer idComment){
		
		return get(Comment.class, idComment);
		//return getHibernateTemplate().find("from Comment order by creationDate desc");
		
	}

}
