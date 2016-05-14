package md.utm.entity.model.entity;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
//import md.utm.entity.model.entity.Message;
import javax.persistence.Transient;

import org.apache.struts2.StrutsException;

@Entity
public class Profile {

	private Integer idProfile;
	private String firstName;
	private String lastName;
	private Date dBirthday;
	private String location;
	private String status;
	private byte[] picture;
	private String email;
	private File profileImage;
	private Set<Message> messages;

	private List<Comment> comment;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getIdProfile() {
		return idProfile;
	}

	public void setIdProfile(Integer idProfile) {
		this.idProfile = idProfile;
	}

	public void setProfileImage(File profileImage) {
		this.profileImage = profileImage;
		if (profileImage != null) {
			picture = new byte[(int) profileImage.length()];
			try {
				FileInputStream fileInputStream = new FileInputStream(profileImage);
				fileInputStream.read(picture);
				fileInputStream.close();
			} catch (Exception e) {
				throw new StrutsException(e.getMessage(), e);
			}
		}
	}

	@Transient
	public File getProfileImage() {
		return profileImage;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "profile")
	public List<Comment> getComment() {
		if (comment == null) {
			comment = new ArrayList<Comment>();
		}
		return comment;
	}

	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	// @Column(nullable = false)
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getdBirthday() {
		return dBirthday;
	}

	public void setdBirthday(Date dBirthday) {
		this.dBirthday = dBirthday;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Lob
	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}
	// @ManyToMany(targetEntity=md.utm.entity.model.entity.Message.class,
	// mappedBy="message")

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "profile_messages", joinColumns = @JoinColumn(name = "profile_id"), inverseJoinColumns = @JoinColumn(name = "message_id"))
	public Set<Message> getMessages() {
		return messages;
	}

	public void setMessages(Set<Message> messages) {
		this.messages = messages;
	}

}
