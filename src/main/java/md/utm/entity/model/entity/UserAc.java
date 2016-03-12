package md.utm.entity.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class UserAc implements Person {
	
	public Integer idAccount;
	public String username;
	public String password;
	
	
	public List<Profile> searchKnownById(int id){ //list Profile in loc de int
		List<Profile> listPr = new ArrayList<Profile>();
		
		return listPr;
		
	}
	
	public boolean edit_profile(){
		
		return false;
	}

	public boolean upload_photo(){
		
		return false;
	}
	
	public boolean accept_known_request(){
		
		return false;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getId() {
		return idAccount;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	

	public void edit() {
		// TODO Auto-generated method stub
		
	}



	public void save() {
		// TODO Auto-generated method stub
		
	}



	public void block() {
		// TODO Auto-generated method stub
		
	}



	public void updateData() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	

}
