package com.business;

import java.util.ArrayList; 
import java.util.List;

import com.dao.AdditionalCandidatesDao;
import com.dao.impl.AdditionalCandidatesDaoImp;
import com.model.AdditionalCandidates;
 

 

 

public class AdditionalCandidatesBusiness {

	private AdditionalCandidatesDao AdditionalCandidatDao = new AdditionalCandidatesDaoImp();

	private AdditionalCandidates AdditionalCandidat = new AdditionalCandidates();

	private AdditionalCandidates  currentAdditionalCandidat = new AdditionalCandidates(); 

	private List<AdditionalCandidates> listAdditionalCandidates = new ArrayList();

 

	public AdditionalCandidatesBusiness() {
		 
	} 
	 
	
	
  
	public void saveAdditionalCandidates() {  
		AdditionalCandidatDao.saveOrUpdate(currentAdditionalCandidat); 
		currentAdditionalCandidat =  new AdditionalCandidates();
 
	}
	
	
	public void deleteAdditionalCandidates(){ 
		AdditionalCandidatDao.delete(currentAdditionalCandidat);
	}

	public void clear() {
		AdditionalCandidat = new AdditionalCandidates();
		currentAdditionalCandidat = new AdditionalCandidates(); 
	}

	public void loadAdditionalCandidates() {
		this.AdditionalCandidat = currentAdditionalCandidat;
	}

	public void quitter() {
		;
	}

	public List<AdditionalCandidates> findAllAdditionalCandidates() {

		listAdditionalCandidates = AdditionalCandidatDao.findAll(AdditionalCandidates.class);
		return listAdditionalCandidates;
	}
 
	 
 

	public List<AdditionalCandidates> getlistAdditionalCandidates() {
		
		listAdditionalCandidates = AdditionalCandidatDao.findAll(AdditionalCandidates.class); 
		return listAdditionalCandidates;
	}

	public void setlistAdditionalCandidates(List<AdditionalCandidates> listAdditionalCandidates) {
		this.listAdditionalCandidates = listAdditionalCandidates;
	}




	public AdditionalCandidatesDao getAdditionalCandidatDao() {
		return AdditionalCandidatDao;
	}




	public void setAdditionalCandidatDao(AdditionalCandidatesDao AdditionalCandidatDao) {
		this.AdditionalCandidatDao = AdditionalCandidatDao;
	}




	public AdditionalCandidates getUtil() {
		return AdditionalCandidat;
	}




	public void setUtil(AdditionalCandidates Candidat) {
		Candidat = Candidat;
	}



	public void setcurrentCandidat(AdditionalCandidates currentCandidat) { 
		 
		this.currentAdditionalCandidat = currentCandidat;
	}
	



	public AdditionalCandidates getcurrentCandidat() {
		return currentAdditionalCandidat;
	}

 

	
 

	 

}
