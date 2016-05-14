package md.utm.entity.action.user;

import com.opensymphony.xwork2.ActionSupport;

import md.utm.entity.model.dao.ProfileDAO;
import md.utm.entity.model.entity.Profile;

public class ImageAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private Integer userProfileId;
	private ProfileDAO profileDAO;

	public void setProfileDAO(ProfileDAO profileDAO) {
		this.profileDAO = profileDAO;
	}

	public void setUserProfileId(Integer userProfileId) {
		this.userProfileId = userProfileId;
	}

	public byte[] loadImage() {
		byte[] image = new byte[0];
		if (userProfileId != null) {
			Profile findProfileById = profileDAO.findProfileById(userProfileId);
			image = findProfileById.getPicture();
		}
		return image;
	}

	public String getContentType() {
		return "image/jpeg";
	}

	@Override
	public String execute() {
		return SUCCESS;
	}
}
