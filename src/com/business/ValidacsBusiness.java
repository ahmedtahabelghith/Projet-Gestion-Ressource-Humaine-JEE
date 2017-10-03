package com.business;

import java.util.ArrayList; 
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.dao.impl.ValidacsDaoImp;
import com.model.Validacs;





@ManagedBean
@SessionScoped 

public class ValidacsBusiness {

	private ValidacsDaoImp ValidacsDao = new ValidacsDaoImp();
	private Validacs validacs = new Validacs();
	private Validacs  currentValidacs = new Validacs();
	private List<Validacs> listValidacs = new ArrayList();

 

	public ValidacsBusiness() {
		 
	} 
	 
 
	
	
  
	public void saveValidacs() {  
		ValidacsDao.saveOrUpdate(currentValidacs); 
		currentValidacs =  new Validacs();
 
	}
	
	
	public void deletecs(){ 
		ValidacsDao.delete(currentValidacs);
	}

	public void clear() {
		validacs = new Validacs();
		currentValidacs = new Validacs(); 
	}

	public void loadvalidacs() {
		this.validacs = currentValidacs;
	}

	public void quitter() {
		;
	}

	public List<Validacs> findAllvalidacs() {
 
		listValidacs = ValidacsDao.findAll(Validacs.class);
		return listValidacs;
	}
 
	 
 

	public List<Validacs> getListValidacs() {
		
		listValidacs = ValidacsDao.findAll(Validacs.class); 
		return listValidacs;
	}

	public void setListValidacs(List<Validacs> listValidacs) {
		this.listValidacs = listValidacs;
	}


 



	 
 




	public ValidacsDaoImp getValidacsDao() {
		return ValidacsDao;
	}





	public void setValidacsDao(ValidacsDaoImp validacsDao) {
		ValidacsDao = validacsDao;
	}





	public Validacs getValidacs() {
		return validacs;
	}





	public void setValidacs(Validacs validacs) {
		this.validacs = validacs;
	}





	public Validacs getCurrentValidacs() {
		return currentValidacs;
	}





	public void setCurrentValidacs(Validacs currentValidacs) {
		this.currentValidacs = currentValidacs;
	}



 


	public void setUtil(Validacs validacs) {
		validacs = validacs;
	}



	public void setcurrentvalidacs(Validacs currentValidacs) { 
		 
		this.currentValidacs = currentValidacs;
	}
	



	public Validacs getcurrentValidacs() {
		return currentValidacs;
	}

 

	
 

	 

}
