package md.utm.entity.model.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;



@Entity
public class Profile {
	
	
	public int getIdProfile() {
		return idProfile;
	}

	public void setIdProfile(int idProfile) {
		this.idProfile = idProfile;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

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

	public long getPicture() {
		return picture;
	}

	public void setPicture(long picture) {
		this.picture = picture;
	}

	@Id public int idProfile;
	public String firstName;
	public String lastName;
	public Date dBirthday;
	public String location;
	public String status;
	public long picture;
	
	
//	public List<Message> messageList;
//	public List<Comment> commentList;
//	public List<Announcement> announcementList;
	
	
	public int sendKnownRequest(int id){
		
		return 0;
		
	}
	
	public boolean reportProfile(int id){
		
		return false;
		
	}
	
	public boolean deleteKnown(int id){
		
		return false;
		
	}
	
	public boolean getMessages(){
		
		return false;
	}
	
	public boolean getComments(){
		
		return false;
	}
	
	public boolean getAnnouncement(){
		
		return false;
	}

}
