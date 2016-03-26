package md.utm.entity.model.entity;


//import java.util.ArrayList;
//import java.util.List;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.util.Date;

import javax.persistence.Entity;


@Entity
public class UserAc extends Administrator{
	
	public Integer idAccount;
	public String username;
	public String password;
	public String email;
	public Date createdDate;
	public boolean admin;
	
	//@OneToOne @MapsId
	//Profile profile;
	
/*	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}*/

	public boolean isAdmin() {
		return admin;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getIdAccount() {
		return idAccount;
	}
	
	public void setIdAccount(Integer idAccount) {
		this.idAccount = idAccount;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public boolean getadmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
	
	




	
	
	

	

}
