package com.business;

import java.util.ArrayList; 
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.dao.impl.ContenuValidacDaoImp;
import com.model.ContenuValidac;

 



@ManagedBean
@SessionScoped 

public class ContenuValidacBusiness {

	private ContenuValidacDaoImp ContenuValidacsDao = new ContenuValidacDaoImp();
	private ContenuValidac ContenuValidacs = new ContenuValidac();
	private ContenuValidac  currentContenuValidacs = new ContenuValidac();
	private List<ContenuValidac> listContenuValidacs = new ArrayList();

 

	public ContenuValidacBusiness() {
		 
	} 
	 
 
	
	
  
	public void saveContenuValidacs() {  
		ContenuValidacsDao.saveOrUpdate(currentContenuValidacs); 
		currentContenuValidacs =  new ContenuValidac();
 
	}
	
	
	public void deletecs(){ 
		ContenuValidacsDao.delete(currentContenuValidacs);
	}

	public void clear() {
		ContenuValidacs = new ContenuValidac();
		currentContenuValidacs = new ContenuValidac(); 
	}

	public void loadContenuValidacs() {
		this.ContenuValidacs = currentContenuValidacs;
	}

	public void quitter() {
		;
	}

	public List<ContenuValidac> findAllContenuValidacs() {
 
		listContenuValidacs = ContenuValidacsDao.findAll(ContenuValidac.class);
		return listContenuValidacs;
	}
 
	 
 

	public List<ContenuValidac> getListContenuValidacs() {
		
		listContenuValidacs = ContenuValidacsDao.findAll(ContenuValidac.class); 
		return listContenuValidacs;
	}

	public void setListContenuValidacs(List<ContenuValidac> listContenuValidacs) {
		this.listContenuValidacs = listContenuValidacs;
	}





	public ContenuValidacDaoImp getContenuValidacsDao() {
		return ContenuValidacsDao;
	}





	public void setContenuValidacsDao(ContenuValidacDaoImp contenuValidacsDao) {
		ContenuValidacsDao = contenuValidacsDao;
	}





	public ContenuValidac getContenuValidacs() {
		return ContenuValidacs;
	}





	public void setContenuValidacs(ContenuValidac contenuValidacs) {
		ContenuValidacs = contenuValidacs;
	}





	public ContenuValidac getCurrentContenuValidacs() {
		return currentContenuValidacs;
	}





	public void setCurrentContenuValidacs(ContenuValidac currentContenuValidacs) {
		this.currentContenuValidacs = currentContenuValidacs;
	}


 



	  
 
 

	
 

	 

}
