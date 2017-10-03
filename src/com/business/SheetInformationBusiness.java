package com.business;

import java.util.ArrayList; 
import java.util.List;

import com.dao.SheetInformationDao;
import com.dao.impl.SheetInformationDaoImp;
import com.model.CtpFolders;
import com.model.SheetInformation;

 

 

public class SheetInformationBusiness {

	private SheetInformationDao SheetInformationDao = new SheetInformationDaoImp();

	private SheetInformation sheetInformation = new SheetInformation();

	private SheetInformation  currentSheetInformation = new SheetInformation(); 

	private List<SheetInformation> listSheetInformation = new ArrayList();

 

	public SheetInformationBusiness() {
		 
	} 
	 
	
	
  
	public void saveSheetInformation() {  
		SheetInformationDao.saveOrUpdate(currentSheetInformation); 
	 
		currentSheetInformation =  new SheetInformation();
		 
 
	}
	
	

	public void saveSheetInformationExperienceProfessionnel(String matricule) {  
		 
		CtpFolders e= new CtpFolders();
	 	e.setMatricule(matricule);
		currentSheetInformation.setType("experienceProfessionnelle"); 
		currentSheetInformation.setCtpFolders(e);  
		SheetInformationDao.saveOrUpdate(currentSheetInformation); 
		currentSheetInformation =  new SheetInformation();
		sheetInformation =  new SheetInformation();
	 
	}
	
	
	public void saveSheetInformationStage(String matricule) {  
		 
		CtpFolders e= new CtpFolders();
	 	e.setMatricule(matricule);
		currentSheetInformation.setType("stage"); 
		currentSheetInformation.setCtpFolders(e);  
		SheetInformationDao.saveOrUpdate(currentSheetInformation); 
		currentSheetInformation =  new SheetInformation();
		sheetInformation =  new SheetInformation();
	 
	}
	
	public void saveSheetInformationFormationAcademique(String matricule) {  
		 
		CtpFolders e= new CtpFolders();
	 	e.setMatricule(matricule);
		currentSheetInformation.setType("formationAcademique"); 
		currentSheetInformation.setCtpFolders(e);  
		SheetInformationDao.saveOrUpdate(currentSheetInformation); 
		currentSheetInformation =  new SheetInformation();
		sheetInformation =  new SheetInformation();
	 
	}
	
	public void saveSheetInformationFormationComplementaire(String matricule) {  
		 
		CtpFolders e= new CtpFolders();
	 	e.setMatricule(matricule);
		currentSheetInformation.setType("formationComplementaire"); 
		currentSheetInformation.setCtpFolders(e);  
		SheetInformationDao.saveOrUpdate(currentSheetInformation); 
		currentSheetInformation =  new SheetInformation();
		sheetInformation =  new SheetInformation();
	 
	}
	
	public void saveSheetInformationAptitudeLanguage(String question,String matricule,int vote) {  
		
		System.out.println("question = "+question+"  matricule = "+matricule+"  vote = "+vote);
		int indice=0;
		boolean res=false,ress=false; 
		List<SheetInformation> lst = new ArrayList<SheetInformation>();
		lst.addAll(findAllSheetInformation())	;
		currentSheetInformation=new SheetInformation();
		
		  
		
		for(int i=0; i<lst.size(); i++) 
		 {	
			 
			if(lst.get(i).getQuestion()!= null)
			{   

		   		if((lst.get(i).getQuestion().equals(question) ) && (lst.get(i).getCtpFolders().getMatricule().equals(matricule) ))
				{   
		   			res=true;
					
				if(  (lst.get(i).getCtpFolders().getMatricule().equals(matricule))==true)
				{ress=true;
				 
					indice=i;
				}
		   	 
				}
		   		 
			}
		 }
		
		 
		if((res==true && ress==true) )
		{ 	 
			CtpFolders e= new CtpFolders();
		 	e.setMatricule(matricule);
		 	currentSheetInformation.setIdFicheRenseignement(lst.get(indice).getIdFicheRenseignement()); 
			currentSheetInformation.setType("Aptitudelanguage");
			currentSheetInformation.setQuestion(question);
			currentSheetInformation.setVote(vote);
			currentSheetInformation.setCtpFolders(e);  
			SheetInformationDao.saveOrUpdate(currentSheetInformation); 
			currentSheetInformation =  new SheetInformation();
			sheetInformation =  new SheetInformation();
			 
		}
		if((res==false && ress==false))
		{ 	
				
			CtpFolders e= new CtpFolders();
		 	e.setMatricule(matricule);
			currentSheetInformation.setType("Aptitudelanguage");
			currentSheetInformation.setQuestion(question);
			currentSheetInformation.setVote(vote);
			currentSheetInformation.setCtpFolders(e);  
			SheetInformationDao.saveOrUpdate(currentSheetInformation); 
			currentSheetInformation =  new SheetInformation();
			sheetInformation =  new SheetInformation();
			
			 
		}
		 
	 
	}
	
	
	
	public void saveSheetInformationVieAssosiative(String matricule) {  
		 
		CtpFolders e= new CtpFolders();
	 	e.setMatricule(matricule);
		currentSheetInformation.setType("vieAssosiative"); 
		currentSheetInformation.setCtpFolders(e);  
		SheetInformationDao.saveOrUpdate(currentSheetInformation); 
		currentSheetInformation =  new SheetInformation();
		sheetInformation =  new SheetInformation();
	 
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void saveSheetInformationQuestion(String question ,String matricule, String rep) {  
 
		int indice=0;
		boolean res=false,ress=false; 
		List<SheetInformation> lst = new ArrayList<SheetInformation>();
		lst.addAll(findAllSheetInformation())	;
		currentSheetInformation=new SheetInformation();
		
		  
		
		for(int i=0; i<lst.size(); i++) 
		 {	
			 
			if(lst.get(i).getQuestion()!= null)
			{  
		   		if((lst.get(i).getQuestion().equals(question)))
				{    res=true;
					
				if(  (lst.get(i).getCtpFolders().getMatricule().equals(matricule))==true)
				{ress=true;
					indice=i;
				}
		   		else {
					res=false;
				}
		   		
				}
		   		else{
		   			res=false;
		   		}
		   	
			}
		 }
		
		if((res==true && ress==true) )
		{ 
			currentSheetInformation.setIdFicheRenseignement(lst.get(indice).getIdFicheRenseignement()); 
			currentSheetInformation.setReponce(rep);			
			currentSheetInformation.setType("question"); 
			currentSheetInformation.setQuestion(question); 
			CtpFolders e= new CtpFolders();
		 	e.setMatricule(matricule);
			currentSheetInformation.setCtpFolders(e);
			
			SheetInformationDao.saveOrUpdate(currentSheetInformation); 
			SheetInformationDao.saveOrUpdate(currentSheetInformation.getCtpFolders()); 
			currentSheetInformation =  new SheetInformation();
			sheetInformation =  new SheetInformation();
		}
		if((res==false && ress==false))
		{ 	
				
			currentSheetInformation.setType("question"); 
			currentSheetInformation.setQuestion(question); 
			currentSheetInformation.setReponce(rep);
			CtpFolders e= new CtpFolders();
		 	e.setMatricule(matricule);
			currentSheetInformation.setCtpFolders(e);
			
				SheetInformationDao.saveOrUpdate(currentSheetInformation); 
				SheetInformationDao.saveOrUpdate(currentSheetInformation.getCtpFolders()); 
				currentSheetInformation =  new SheetInformation();
				sheetInformation =  new SheetInformation();
			 
		}
			 
		
	 
	}
	
	
	
	
	
	
	
	
	
	
	public void deleteSheetInformationSelonId(){ 
		SheetInformationDao.delete(currentSheetInformation);
	}

	
	
	
	
	
	
	
	
	
	
	public void deleteSheetInformation(){ 
		SheetInformationDao.delete(currentSheetInformation);
	}

	
	
	
	
	
	
	
	
	public void clear() {
		sheetInformation = new SheetInformation();
		currentSheetInformation = new SheetInformation(); 
	}

	public void loadSheetInformation() {
		this.sheetInformation = currentSheetInformation;
	}

	public void quitter() {
		;
	}

	public List<SheetInformation> findAllSheetInformation() {

		listSheetInformation = SheetInformationDao.findAll(SheetInformation.class);
		return listSheetInformation;
	}
 
	 
 

	public List<SheetInformation> getlistSheetInformation() {
		
		listSheetInformation = SheetInformationDao.findAll(SheetInformation.class); 
		return listSheetInformation;
	}

	public void setlistSheetInformation(List<SheetInformation> listSheetInformation) {
		this.listSheetInformation = listSheetInformation;
	}




	public SheetInformationDao getSheetInformationDao() {
		return SheetInformationDao;
	}




	public void setSheetInformationDao(SheetInformationDao SheetInformationDao) {
		this.SheetInformationDao = SheetInformationDao;
	}




	public SheetInformation getUtil() {
		return sheetInformation;
	}




	public void setUtil(SheetInformation SheetInformation) {
		SheetInformation = SheetInformation;
	}



	public void setcurrentSheetInformation(SheetInformation currentSheetInformation) { 
		 
		this.currentSheetInformation = currentSheetInformation;
	}
	



	public SheetInformation getcurrentSheetInformation() {
		return currentSheetInformation;
	}




	public SheetInformation getSheetInformation() {
		return sheetInformation;
	}




	public void setSheetInformation(SheetInformation sheetInformation) {
		this.sheetInformation = sheetInformation;
	}

 

	
 

	 

}
