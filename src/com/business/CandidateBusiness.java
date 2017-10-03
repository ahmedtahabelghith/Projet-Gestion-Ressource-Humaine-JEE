package com.business;

import java.util.ArrayList; 
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.dao.CandidateDao;
import com.dao.impl.CandidateDaoImp;
import com.model.Candidates;

 
 

public class CandidateBusiness {

	private CandidateDao CandidatDao = new CandidateDaoImp();

	private Candidates Candidat = new Candidates();

	private Candidates  currentCandidat = new Candidates(); 

	private List<Candidates> listCandidates = new ArrayList();

 

	public CandidateBusiness() {
		 
	} 
	 
 
	
	
  
	public void saveCandidates() {  
		CandidatDao.saveOrUpdate(currentCandidat); 
		currentCandidat =  new Candidates();
 
	}
	
	
	public void deleteCandidates(){ 
		CandidatDao.delete(currentCandidat);
	}

	public void clear() {
		Candidat = new Candidates();
		currentCandidat = new Candidates(); 
	}

	public void loadCandidates() {
		this.Candidat = currentCandidat;
	}

	public void quitter() {
		;
	}

	public List<Candidates> findAllCandidates() {
 
		listCandidates = CandidatDao.findAll(Candidates.class);
		return listCandidates;
	}
 
	 
 

	public List<Candidates> getlistCandidates() {
		
		listCandidates = CandidatDao.findAll(Candidates.class); 
		return listCandidates;
	}

	public void setlistCandidates(List<Candidates> listCandidates) {
		this.listCandidates = listCandidates;
	}




	public CandidateDao getCandidatDao() {
		return CandidatDao;
	}




	public void setCandidatDao(CandidateDao CandidatDao) {
		this.CandidatDao = CandidatDao;
	}




	public Candidates getUtil() {
		return Candidat;
	}




	public void setUtil(Candidates Candidat) {
		Candidat = Candidat;
	}



	public void setcurrentCandidat(Candidates currentCandidat) { 
		 
		this.currentCandidat = currentCandidat;
	}
	



	public Candidates getcurrentCandidat() {
		return currentCandidat;
	}

 

	
 

	 

}
