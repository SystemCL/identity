package md.utm.entity.model.entity.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import md.utm.entity.model.entity.Person;


@Entity
public class UserAc implements Person {
	
	public Integer idAccount;
	public String username;
	public String password;
	
	
	
	public List<Profile> searchKnownById(int id){ 
		List<Profile> listPr = new ArrayList<Profile>();
		
		return listPr;
		
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
	
	
	

	

}
