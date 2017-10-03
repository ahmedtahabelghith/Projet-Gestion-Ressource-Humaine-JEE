package com.business;

import java.util.ArrayList; 
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.dao.UsersDao;
import com.dao.impl.UsersDaoImp;
import com.model.Candidates;

import com.model.Users;
 

public class UsersBusiness {

	private UsersDao UsersDao = new UsersDaoImp();

	private Users users = new Users();

	private Users  currentUsers = new Users(); 

	private List<Users> listUsers = new ArrayList();

 

	public UsersBusiness() {
		 
	} 
	 
 
	
	
  
	public void saveCandidates() {  
		UsersDao.saveOrUpdate(currentUsers); 
		currentUsers =  new Users();
 
	}
	
	
	public void deleteCandidates(){ 
		UsersDao.delete(currentUsers);
	}

	public void clear() {
		users = new Users();
		currentUsers = new Users(); 
	}

	public void loadUsers() {
		this.users = currentUsers;
	}

	public void quitter() {
		;
	}

	public List<Users> findAllUsers() {
 
		listUsers = UsersDao.findAll(Users.class);
		return listUsers;
	}
 
	 
 

	public List<Users> getlistCandidates() {
		
		listUsers = UsersDao.findAll(Users.class); 
		return listUsers;
	}

	public void setlistCandidates(List<Users> listUsers) {
		this.listUsers = listUsers;
	}




	public UsersDao getUsersDao() {
		return UsersDao;
	}




	public void setUsersDao(UsersDao UsersDao) {
		this.UsersDao = UsersDao;
	}



 




	public void setUtil(Candidates users) {
		users = users;
	}



	public void setcurrentUsers(Users currentUsers) { 
		 
		this.currentUsers = currentUsers;
	}
	



	public Users getcurrentUsers() {
		return currentUsers;
	}

 

	
 

	 

}
