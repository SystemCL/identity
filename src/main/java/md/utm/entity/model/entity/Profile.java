package md.utm.entity.model.entity;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;




@Entity
public class Profile {

	public int idProfile;
	public String firstName;
	public String lastName;
	public Date dBirthday;
	public String location;
	public String status;
	public Blob picture;




	private List<Comment> comment;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getIdProfile() {
		return idProfile;
	}

	public void setIdProfile(int idProfile) {
		this.idProfile = idProfile;
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

	//@Column(nullable = false)
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
	
	public Blob getPicture() {
		return picture;
	}

	public void setPicture(Blob picture) {
		this.picture = picture;
	}





}
