
package md.utm.entity.model.entity;

import javax.persistence.MappedSuperclass;

import javax.persistence.Entity;

@MappedSuperclass
public class Administrator {

	public boolean newAccount(int idAccount){
		
		return false;
	}
	
	public boolean deleteAccount(int idAccount){
		
		return false;
	}
	
	public boolean suspendAccount(int idAccount){
		
		return false;
	}
}
