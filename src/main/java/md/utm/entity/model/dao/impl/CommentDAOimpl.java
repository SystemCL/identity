
package md.utm.entity.model.dao.impl;

import java.util.List;

import md.utm.entity.model.dao.CommentDAO;
import md.utm.entity.model.entity.Comment;

@SuppressWarnings("unchecked")
public class CommentDAOimpl extends GenericDaoImpl implements CommentDAO {

	public List<Comment> getAllComments() {
		// TODO Auto-generated method stub
		return getHibernateTemplate().find("from Comment order by creationDate desc");
	}
}
