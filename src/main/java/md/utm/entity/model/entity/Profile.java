package md.utm.entity.model.entity;


import java.sql.Blob;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.ManyToMany;
//import md.utm.entity.model.entity.Message;




@Entity
public class Profile {

	public int idProfile;
	public String firstName;
	public String lastName;
	public Date dBirthday;
	public String location;
	public String status;
	public Blob picture;
	public Set<Message> messages;

	

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
	
	//@ManyToMany(targetEntity=md.utm.entity.model.entity.Message.class, mappedBy="message")
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "profile_messages", 
	joinColumns = @JoinColumn(name = "profile_id") , 
	inverseJoinColumns = @JoinColumn(name = "message_id") )
	public Set<Message> getMessages() {
		return messages;
	}

	public void setMessages(Set<Message> messages) {
		this.messages = messages;
	}








}
