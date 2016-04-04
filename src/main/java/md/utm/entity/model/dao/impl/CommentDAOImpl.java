
package md.utm.entity.model.dao.impl;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import md.utm.entity.model.dao.CommentDAO;
import md.utm.entity.model.entity.Comment;
import md.utm.entity.model.entity.UserAccount;

@SuppressWarnings("unchecked")
public class CommentDAOImpl extends GenericDaoImpl implements CommentDAO {

	public List<Comment> getAllComments() {
		
		Integer idProf;
        Map session = ActionContext.getContext().getSession(); 
        idProf = (Integer)session.get("profile_id"); 
        //System.out.println("id-ul pentru profil din sesiune = " + test);
		
		return getHibernateTemplate().find("from Comment where profile_idProfile=? order by creationDate desc", idProf);
		
		//("from Profile where idProfile=?",idProfile 
	}

	public Comment getCommentById(Integer idComment){
		
		return get(Comment.class, idComment);
		//return getHibernateTemplate().find("from Comment order by creationDate desc");
		
	}

}
