package com.business;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList; 
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.beans.SheetInformationBean;
import com.dao.CtpFoldersDao;
import com.dao.impl.CtpFoldersDaoImp;
 
import com.model.Candidates;
import com.model.CtpFolders;

 
@ManagedBean(name = "ctpFolders")
@SessionScoped
  
public class CtpFoldersBusiness {

	private CtpFoldersDao CtpDao = new CtpFoldersDaoImp();

	private CtpFolders Ctp = new CtpFolders();

	private CtpFolders  currentCtp=new CtpFolders();
 
	private List<CtpFolders> listCtpFolders = new ArrayList();
	   
	private String dat ;
	private int ribModifie;
	
private String changeSituation ;

	public CtpFoldersBusiness() {
		
		 
	} 
	 
	
	public CtpFolders rechercheCtpFoldersSelonMail(String mail) {
		 
		
			CtpFolders res = new CtpFolders();
			  List<CtpFolders> list = new ArrayList(); 
			  CtpFoldersBusiness listCtp = new CtpFoldersBusiness();	
			  
			  list= listCtp.findAllCtpFolders();
			    
			  for(int i=0; i<list.size(); i++) 
				 {  
				  if((list.get(i).getCandidates().getEmail().equals(mail)))
					{   
					   res=list.get(i);
						
					}
		 	  
				 }
		return res;
		  
			
		}
  
	public void saveCtpFolders() {  	 
	 
		CtpDao.saveOrUpdate(currentCtp);  
		CtpDao.saveOrUpdate(currentCtp.getCandidates()); 
		currentCtp =  new CtpFolders();
	 
	}
	
	public void saveCtpFoldersSansSupprimerCurentCtp() {  
		 
		
		CtpDao.saveOrUpdate(currentCtp);  
		CtpDao.saveOrUpdate(currentCtp.getCandidates()); 

	 
	}
	
	public void deleteCtpFolders(){ 
		CtpDao.delete(currentCtp);
	}

	public void clear() {
		Ctp = new CtpFolders();
		currentCtp = new CtpFolders(); 
	}

	public void loadCtpFolders() {
	 
		this.Ctp = currentCtp;
	}

	public void quitter() {
		;
	}

	public List<CtpFolders> findAllCtpFolders() {

		listCtpFolders = CtpDao.findAll(CtpFolders.class);
		return listCtpFolders;
	}
 
	
	 
	
	
	
	public void  updateCaseCetifie(boolean var) {  
		System.out.println("var = " +var);
	currentCtp.setCertificat(var);
	CtpDao.saveOrUpdate(currentCtp);  
	 
 
		
	 
 
	}
	
 

	public List<CtpFolders> getlistCtpFolders() {
		
		listCtpFolders = CtpDao.findAll(CtpFolders.class); 
		return listCtpFolders;
	}

	public void setlistCtpFolders(List<CtpFolders> listCtpFolders) {
		this.listCtpFolders = listCtpFolders;
	}




	public CtpFoldersDao getCtpDao() {
		return CtpDao;
	}




	public void setCtpDao(CtpFoldersDao CtpDao) {
		this.CtpDao = CtpDao;
	}




	public CtpFolders getCtp() {
		return Ctp;
	}




	public void setCtp(CtpFolders ctp) {
		Ctp = ctp;
	}




 



	public void setCurrentCtp(CtpFolders currentCtp) {
	 
		this.currentCtp = new CtpFolders();
		this.currentCtp = currentCtp;
		 
	}




	public CtpFolders getCurrentCtp() {
		 
		return currentCtp;
	}




	public String getDat() {

		Date aujourdhui = new Date();
		 
		DateFormat shortDateFormat = DateFormat.getDateTimeInstance(DateFormat.SHORT,DateFormat.SHORT);
		
		return  shortDateFormat.format(aujourdhui);
	}


	public String getChangeSituation() {
		 System.out.println("get");
		return changeSituation;
	}


	public void setChangeSituation(String changeSituation) {
		 currentCtp.setCtpSituation(changeSituation);
		this.changeSituation = changeSituation;
	}


	public int getRibModifie() {
		return ribModifie;
	}


	public void setRibModifie(int ribModifie) {
		currentCtp.setRib(ribModifie);
		this.ribModifie = ribModifie;
	}

	

 


	 
	
	


 



	


 

	
 

	 

}
