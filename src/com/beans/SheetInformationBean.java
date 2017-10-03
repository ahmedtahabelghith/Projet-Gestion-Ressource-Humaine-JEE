package com.beans;
 
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.business.CtpFoldersBusiness;
import com.business.QuestionEvaluationBusiness;
import com.business.SheetInformationBusiness;
import com.dao.SheetInformationDao;
import com.dao.impl.SheetInformationDaoImp;
import com.model.AdditionalCandidates;
import com.model.ContenuValidac;
import com.model.CtpFolders;
import com.model.EvaluationExperience;
import com.model.QuestionEvaluation;
import com.model.SheetInformation;

 

@ManagedBean
@SessionScoped
public class SheetInformationBean {

	private String q1="Lors de votre entretien d embauche, vous a-t-on bien expliqué le fonctionnement et le but d une ee ?",q2="Pour quelles raisons avez-vous choisi d intégrer une ee ?",q3="Quels objectifs (projets, perspectives et ambitions) visez-vous en intégrant cette ee?",q4="Pour quel poste avez-vous choisi d'être perfectionné/formé ?",q5="Quel salaire souhaitez-vous avoir lors de votre future embauche ?",rep1=" ",rep2=" ",rep3=" ",rep4=" ",rep5=" ";
	private SheetInformation  currentSheetInformation = new SheetInformation(); 
	private SheetInformationDao SheetInformationDao = new SheetInformationDaoImp();
	private SheetInformation sheetInformation = new SheetInformation();
	private   List<SheetInformation> lst = new ArrayList(); 
	
	private SheetInformationBusiness ShetB=new SheetInformationBusiness();

	
	
	
	public String sheetInformationExiste(CtpFolders c) {  
		lst=ShetB.findAllSheetInformation();
		String res="ficheNonExiste.xhtml";
		 
	 
		for(int i=0;i<lst.size();i++)
		{  
			if (lst.get(i).getCtpFolders().getMatricule().equals(c.getMatricule())==true)
			{
				res="ficheDeRenseignement.xhtml";
			}
		}
		return res;
	 
	}
	
	
	
	
	
	
	
	
	public void saveSinqueQuestion(String matricule) {  

		int indice1=0,indice2=0,indice3=0,indice4=0,indice5=0;
		boolean res1=false,ress1=false,res2=false,ress2=false,res3=false,ress3=false,res4=false,ress4=false,res5=false,ress5=false; 
		List<SheetInformation> lst = new ArrayList<SheetInformation>();
		SheetInformationBusiness shB=new SheetInformationBusiness();
		lst.addAll(shB.findAllSheetInformation())	;
		currentSheetInformation=new SheetInformation();

		
		CtpFolders e= new CtpFolders();
	 	e.setMatricule(matricule);
	 	
	 	
		
		for(int i=0; i<lst.size(); i++) 
		 {	
			 
			if(lst.get(i).getQuestion()!= null)
			{ 

		   		if((lst.get(i).getQuestion().equals(q1)))
				{  
		   			res1=true;
					
				if(  (lst.get(i).getCtpFolders().getMatricule().equals(matricule))==true)
				{ress1=true;
					indice1=i;
				}
		   	 
				}
		   		 
			}
		 }
		 
		if((res1==true && ress1==true) )
		{ 	  
		 	currentSheetInformation.setIdFicheRenseignement(lst.get(indice1).getIdFicheRenseignement()); 
			currentSheetInformation.setType("question"); 
			currentSheetInformation.setReponce(rep1);
			currentSheetInformation.setQuestion(q1);
			currentSheetInformation.setCtpFolders(e);  
			SheetInformationDao.saveOrUpdate(currentSheetInformation); 
			currentSheetInformation =  new SheetInformation();
			sheetInformation =  new SheetInformation();
		}
		if((res1==false && ress1==false)||(res1==true && ress1==false)||(res1==false && ress1==true))
		{ 	
				
			currentSheetInformation.setType("question"); 
			currentSheetInformation.setReponce(rep1);
			currentSheetInformation.setQuestion(q1);
			currentSheetInformation.setCtpFolders(e);  
			SheetInformationDao.saveOrUpdate(currentSheetInformation); 
			currentSheetInformation =  new SheetInformation();
			sheetInformation =  new SheetInformation();
			 
		}
		 


		
		for(int i=0; i<lst.size(); i++) 
		 {	
			 
			if(lst.get(i).getQuestion()!= null)
			{ 

		   		if((lst.get(i).getQuestion().equals(q2)))
				{  
		   			res2=true;
					
				if(  (lst.get(i).getCtpFolders().getMatricule().equals(matricule))==true)
				{ress2=true;
					indice2=i;
				}
		   	 
				}
		   		 
			}
		 }
	 
		if((res2==true && ress2==true) )
		{ 	  
		 	currentSheetInformation.setIdFicheRenseignement(lst.get(indice2).getIdFicheRenseignement()); 
			currentSheetInformation.setType("question"); 
			currentSheetInformation.setReponce(rep2);
			currentSheetInformation.setQuestion(q2);
			currentSheetInformation.setCtpFolders(e);  
			SheetInformationDao.saveOrUpdate(currentSheetInformation); 
			currentSheetInformation =  new SheetInformation();
			sheetInformation =  new SheetInformation();
		}
		if((res2==false && ress2==false)||(res2==true && ress2==false)||(res2==false && ress2==true))
		{ 	
				
			currentSheetInformation.setType("question"); 
			currentSheetInformation.setReponce(rep2);
			currentSheetInformation.setQuestion(q2);
			currentSheetInformation.setCtpFolders(e);  
			SheetInformationDao.saveOrUpdate(currentSheetInformation); 
			currentSheetInformation =  new SheetInformation();
			sheetInformation =  new SheetInformation();
			 
		}
		 

		

		
		for(int i=0; i<lst.size(); i++) 
		 {	
			 
			if(lst.get(i).getQuestion()!= null)
			{ 

		   		if((lst.get(i).getQuestion().equals(q3)))
				{  
		   			res3=true;
					
				if(  (lst.get(i).getCtpFolders().getMatricule().equals(matricule))==true)
				{ress3=true;
					indice3=i;
				}
		   	 
				}
		   		 
			}
		 }
	 
		if((res3==true && ress3==true) )
		{ 	  
		 	currentSheetInformation.setIdFicheRenseignement(lst.get(indice3).getIdFicheRenseignement()); 
			currentSheetInformation.setType("question"); 
			currentSheetInformation.setReponce(rep3);
			currentSheetInformation.setQuestion(q3);
			currentSheetInformation.setCtpFolders(e);  
			SheetInformationDao.saveOrUpdate(currentSheetInformation); 
			currentSheetInformation =  new SheetInformation();
			sheetInformation =  new SheetInformation();
		}
		if((res3==false && ress3==false)||(res3==true && ress3==false)||(res3==false && ress3==true))
		{ 	
				
			currentSheetInformation.setType("question"); 
			currentSheetInformation.setReponce(rep3);
			currentSheetInformation.setQuestion(q3);
			currentSheetInformation.setCtpFolders(e);  
			SheetInformationDao.saveOrUpdate(currentSheetInformation); 
			currentSheetInformation =  new SheetInformation();
			sheetInformation =  new SheetInformation();
			 
		}
		 


		
		for(int i=0; i<lst.size(); i++) 
		 {	
			 
			if(lst.get(i).getQuestion()!= null)
			{ 

		   		if((lst.get(i).getQuestion().equals(q4)))
				{  
		   			res4=true;
					
				if(  (lst.get(i).getCtpFolders().getMatricule().equals(matricule))==true)
				{ress4=true;
					indice4=i;
				}
		   	 
				}
		   		 
			}
		 }
	 
		if((res4==true && ress4==true) )
		{ 	  
		 	currentSheetInformation.setIdFicheRenseignement(lst.get(indice4).getIdFicheRenseignement()); 
			currentSheetInformation.setType("question"); 
			currentSheetInformation.setReponce(rep4);
			currentSheetInformation.setQuestion(q4);
			currentSheetInformation.setCtpFolders(e);  
			SheetInformationDao.saveOrUpdate(currentSheetInformation); 
			currentSheetInformation =  new SheetInformation();
			sheetInformation =  new SheetInformation();
		}
		if((res4==false && ress4==false)||(res4==true && ress4==false)||(res4==false && ress4==true))
		{ 	
				
			currentSheetInformation.setType("question"); 
			currentSheetInformation.setReponce(rep4);
			currentSheetInformation.setQuestion(q4);
			currentSheetInformation.setCtpFolders(e);  
			SheetInformationDao.saveOrUpdate(currentSheetInformation); 
			currentSheetInformation =  new SheetInformation();
			sheetInformation =  new SheetInformation();
			 
		}
		 

		
		for(int i=0; i<lst.size(); i++) 
		 {	
			 
			if(lst.get(i).getQuestion()!= null)
			{ 

		   		if((lst.get(i).getQuestion().equals(q5)))
				{  
		   			res5=true;
					
				if(  (lst.get(i).getCtpFolders().getMatricule().equals(matricule))==true)
				{ress5=true;
					indice5=i;
				}
		   	 
				}
		   		 
			}
		 }
	 
		if((res5==true && ress5==true) )
		{ 	  
		 	currentSheetInformation.setIdFicheRenseignement(lst.get(indice5).getIdFicheRenseignement()); 
			currentSheetInformation.setType("question"); 
			currentSheetInformation.setReponce(rep5);
			currentSheetInformation.setQuestion(q5);
			currentSheetInformation.setCtpFolders(e);  
			SheetInformationDao.saveOrUpdate(currentSheetInformation); 
			currentSheetInformation =  new SheetInformation();
			sheetInformation =  new SheetInformation();
		}
		if((res5==false && ress5==false)||(res5==true && ress5==false)||(res5==false && ress5==true))
		{ 	
				
			currentSheetInformation.setType("question"); 
			currentSheetInformation.setReponce(rep5);
			currentSheetInformation.setQuestion(q5);
			currentSheetInformation.setCtpFolders(e);  
			SheetInformationDao.saveOrUpdate(currentSheetInformation); 
			currentSheetInformation =  new SheetInformation();
			sheetInformation =  new SheetInformation();
			 
		}
		 

		rep1=null;
		rep2=null;
		rep3=null;
		rep4=null;
		rep5=null;
		
	}
	
	

 
	
	
	
	
	
	
	
	
	public String  changeVariable(String var) {  
		String varChange=var;
		if (varChange== "true")
			{varChange="Vrai";}
		if (varChange== "false")
		{varChange="Faux" ;}
		
		return  varChange;
 
	}
	
	

	public List<SheetInformation> rechercheExperienceProfessionnelleSelonMatricule(String matricule)   
	{
		List<SheetInformation> listSheetInformation= new ArrayList<SheetInformation>();
		List<SheetInformation> sheetInformation= new ArrayList<SheetInformation>();
		SheetInformationBusiness list = new SheetInformationBusiness() ;
		
		
		listSheetInformation.addAll(list.findAllSheetInformation());
		 
		
		
		for(int i=0; i<listSheetInformation.size(); i++) 
		 {	 
		 
			if(listSheetInformation.get(i).getType().equals("experienceProfessionnelle") && listSheetInformation.get(i).getCtpFolders().getMatricule().equals(matricule) )
			{     
				sheetInformation.add(listSheetInformation.get(i));
		 	  
		 
		 }
			 
		 
	}
		return sheetInformation ;
	
	}
	
	
	
	
	
	
	
	
	

	public List<SheetInformation> rechercheStageSelonMatricule(String matricule)   
	{
		List<SheetInformation> listSheetInformation= new ArrayList<SheetInformation>();
		List<SheetInformation> sheetInformation= new ArrayList<SheetInformation>();
		SheetInformationBusiness list = new SheetInformationBusiness() ;
		
		
		listSheetInformation.addAll(list.findAllSheetInformation());
		 
		
		
		for(int i=0; i<listSheetInformation.size(); i++) 
		 {	 
		 
			if(listSheetInformation.get(i).getType().equals("stage") && listSheetInformation.get(i).getCtpFolders().getMatricule().equals(matricule) )
			{     
				sheetInformation.add(listSheetInformation.get(i));
		 	  
		 
		 }
			 
		 
	}
		return sheetInformation ;
	
	}
	
	
	

	public List<SheetInformation> rechercheFormationAcademiqueSelonMatricule(String matricule)   
	{
		List<SheetInformation> listSheetInformation= new ArrayList<SheetInformation>();
		List<SheetInformation> sheetInformation= new ArrayList<SheetInformation>();
		SheetInformationBusiness list = new SheetInformationBusiness() ;
		
		
		listSheetInformation.addAll(list.findAllSheetInformation());
		 
		
		
		for(int i=0; i<listSheetInformation.size(); i++) 
		 {	 
		 
			if(listSheetInformation.get(i).getType().equals("formationAcademique") && listSheetInformation.get(i).getCtpFolders().getMatricule().equals(matricule) )
			{     
				sheetInformation.add(listSheetInformation.get(i));
		 	  
		 
		 }
			 
		 
	}
		return sheetInformation ;
	
	}
	
	
	public List<SheetInformation> rechercheFormationComplementaireSelonMatricule(String matricule)   
	{
		List<SheetInformation> listSheetInformation= new ArrayList<SheetInformation>();
		List<SheetInformation> sheetInformation= new ArrayList<SheetInformation>();
		SheetInformationBusiness list = new SheetInformationBusiness() ;
		
		
		listSheetInformation.addAll(list.findAllSheetInformation());
		 
		
		
		for(int i=0; i<listSheetInformation.size(); i++) 
		 {	 
		 
			if(listSheetInformation.get(i).getType().equals("formationComplementaire") && listSheetInformation.get(i).getCtpFolders().getMatricule().equals(matricule) )
			{     
				sheetInformation.add(listSheetInformation.get(i));
		 	  
		 
		 }
			 
		 
	}
		return sheetInformation ;
	
	}
	

	public List<SheetInformation> rechercheAptitudeLanguageSelonMatricule(String matricule)   
	{
		List<SheetInformation> listSheetInformation= new ArrayList<SheetInformation>();
		List<SheetInformation> sheetInformation= new ArrayList<SheetInformation>();
		SheetInformationBusiness list = new SheetInformationBusiness() ;
		
		
		listSheetInformation.addAll(list.findAllSheetInformation());
		 
		
		
		for(int i=0; i<listSheetInformation.size(); i++) 
		 {	 
		 
			if(listSheetInformation.get(i).getType().equals("Aptitudelanguage") && listSheetInformation.get(i).getCtpFolders().getMatricule().equals(matricule) )
			{     
				sheetInformation.add(listSheetInformation.get(i));
		 	  
		 
		 }
			 
		 
	}
		return sheetInformation ;
	
	}
	
	
	

	
	
	
	public List<SheetInformation> rechercheVieAssosiativeSelonMatricule(String matricule)   
	{
		List<SheetInformation> listSheetInformation= new ArrayList<SheetInformation>();
		List<SheetInformation> sheetInformation= new ArrayList<SheetInformation>();
		SheetInformationBusiness list = new SheetInformationBusiness() ;
		
		
		listSheetInformation.addAll(list.findAllSheetInformation());
		 
		
		
		for(int i=0; i<listSheetInformation.size(); i++) 
		 {	 
		 
			if(listSheetInformation.get(i).getType().equals("vieAssosiative") && listSheetInformation.get(i).getCtpFolders().getMatricule().equals(matricule) )
			{     
				sheetInformation.add(listSheetInformation.get(i));
		 	  
		 
		 }
			 
		 
	}
		return sheetInformation ;
	
	}



	public String getQ1() {
		return q1;
	}



	public void setQ1(String q1) {
		this.q1 = q1;
	}



	public String getQ2() {
		return q2;
	}



	public void setQ2(String q2) {
		this.q2 = q2;
	}



	public String getQ3() {
		return q3;
	}



	public void setQ3(String q3) {
		this.q3 = q3;
	}



	public String getQ4() {
		return q4;
	}



	public void setQ4(String q4) {
		this.q4 = q4;
	}



	public String getQ5() {
		return q5;
	}



	public void setQ5(String q5) {
		this.q5 = q5;
	}



	public String getRep1() {
		return rep1;
	}



	public void setRep1(String rep1) {
		this.rep1 = rep1;
	}



	public String getRep2() {
		return rep2;
	}



	public void setRep2(String rep2) {
		this.rep2 = rep2;
	}



	public String getRep3() {
		return rep3;
	}



	public void setRep3(String rep3) {
		this.rep3 = rep3;
	}



	public String getRep4() {
		return rep4;
	}



	public void setRep4(String rep4) {
		this.rep4 = rep4;
	}



	public String getRep5() {
		return rep5;
	}



	public void setRep5(String rep5) {
		this.rep5 = rep5;
	}


 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
