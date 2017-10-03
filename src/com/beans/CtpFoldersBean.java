package com.beans;
 
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
import com.dao.CtpFoldersDao;
import com.dao.impl.CtpFoldersDaoImp;
import com.model.AdditionalCandidates;
import com.model.Candidates;
import com.model.CtpFolders;
import com.model.QuestionEvaluation;
import com.model.SheetInformation;
import com.sun.org.apache.bcel.internal.generic.NEW;

 

@ManagedBean
@SessionScoped
public class CtpFoldersBean {

	
	private CtpFolders  etudiant= new CtpFolders(); 
	private CtpFoldersBusiness CtpFoldersBus;
	private List<CtpFolders> listCtpFolders =new  ArrayList<CtpFolders>();
	private   List<QuestionEvaluation> list = new ArrayList(); 
	private QuestionEvaluationBusiness   QuesEvalB=new QuestionEvaluationBusiness();
	private CtpFoldersDao CtpDao = new CtpFoldersDaoImp();
	private String var ;


	
	





public void miseAJourCTP(CtpFolders c) {  
	FacesContext facesContext = FacesContext.getCurrentInstance();
 c.setInternalRules(true);
 c.setLicensePhoto(true);
 c.setInternalRules(true);
 c.setContrat(true);
 CtpDao.saveOrUpdate(c);  
 
 try {
	facesContext.getExternalContext().redirect("sousMenuCandidat.xhtml");
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} 	 
		
}
	
	

public String contratExiste(Boolean c) {  
	 System.out.println(c);
	String res="ficheNonExiste.xhtml";	  
	 if (c==true )
		{
			res="contratSwissContact.xhtml";
		}
	  
	 	return res;	
		
}




public Date dateAttestation(CtpFolders c) {  
	if(c.getExitDate()==null)
	{
		return c.getEndContractDate();
	}
	else return c.getExitDate();		
}


public String droitImageExiste(Boolean c) {  
	 
	String res="ficheNonExiste.xhtml";	  
	 if (c==true )
		{
			res="autorisationDroitImage.xhtml";
		}
	  
	 	return res;	
		
}



public String reglementInterneExiste(Boolean c) {  
	 
	String res="ficheNonExiste.xhtml";	  
	 if (c==true )
		{
			res="reglementInterne.xhtml";
		}
	  
	 	return res;	
		
}

public String noteReetExiste(Boolean c) {  
	 
	String res="ficheNonExiste.xhtml";	  
	 if (c==true )
		{
			res="noteReet.xhtml";
		}
	  
	 	return res;	
		
}

public String evaluationExperianceExiste(int c) {  
	 
	list=QuesEvalB.findAllQuestionEvaluation();
	String res="ficheNonExiste.xhtml";
	
	
 try
 {
	for(int i=0;i<list.size();i++)
	{  
		if (list.get(i).getEvaluationExperience().getIdEvaluation()==c)
		{
			res="evaluationExperience.xhtml";
		}
	}
 }
 catch (ArithmeticException e)
 {
	 System.out.println("erreur");
 }
	return res;
	
		
}
public String attestationExiste(Boolean c) {  
	 
	String res="ficheNonExiste.xhtml";	  
	 if (c==true )
		{
			res="attestationDeTravail.xhtml";
		}
	  
	 	return res;	
		
}

 


	public String getVar() {
	 
	return var;
}



public void setVar(String var) {
 
	this.var = var;
}



	public String  changeVariable(String var) {
		 
		String varChange=var;
		if (varChange.equals("true"))
			{varChange="Oui";}
		else if (varChange.equals("false"))
		{varChange="Non" ;}
		  else
		  {varChange="Non" ;}
		
		return  varChange;
 
	}
	
	public String  changeVariableCertifie(String var) {
		 
		String varChange=var;
		if (varChange.equals("true"))
			{varChange="Oui";}
		else if (varChange.equals("false"))
		{varChange="Non" ;}
		  else
		  {varChange="En attente" ;}
		
		return  varChange;
 
	}
	
	
	public String  testChaineVide(String var) {  
		 
		String test="Oui";
		if (var=="")
			{test="Non";}
		 
		
		return  test;
 
	}

	public String  dateSystem() {  
		 
		Date d=new Date();
		DateFormat mediumDateFormat = DateFormat.getDateInstance();
		return  mediumDateFormat.format(d);
 
	}
	
	public String  testSurImageCTP(String photo, String sexe) {   
		String res="";

		 if(photo.length()==0)
		 {  
			 if(sexe.equals("h") || sexe.equals("H"))
				 res="male.png";
			 if(sexe.equals("f") || sexe.equals("F"))
				 res="femme.png";
		 }
		 else res=photo;
		 
		return  res;
 
	}	
	

	
	public Boolean  evaluationOui(String var) {  
 
		boolean res=true;  
		if (var=="")
		 res=false;
		 
		 
		
		return  res;
 
	}	
	
	
	public Boolean  evaluationNon(String var) {  
		 
		boolean res=true;  
		if (var!="")
		 res=false;
		 
		 
		
		return  res;
 
	}	
	
	
	public List<String> questionCtp(Integer idEvaluation)    {
		List<QuestionEvaluation> listQustion= new ArrayList<QuestionEvaluation>();
		List<String> listReponceCtpCurrent= new ArrayList<String>();
		QuestionEvaluationBusiness question = new QuestionEvaluationBusiness() ;
		
		
		listQustion.addAll(question.findAllQuestionEvaluation());
		 
		
		
		for(int i=0; i<listQustion.size(); i++) 
		 {	 
		 
			if((int)listQustion.get(i).getEvaluationExperience().getIdEvaluation()== (int)idEvaluation)
			{    
				listReponceCtpCurrent.add(listQustion.get(i).getReponce());
				 
			}
			else
			{
				listReponceCtpCurrent.add("aucun réponse");
			}
			 
				 
		 
		 }
		
		return listReponceCtpCurrent ;
		
 
	}
	
	
	
	

	
	public List<String> voteQuestionCtp(Integer idEvaluation)   
	{ System.out.println(idEvaluation);
		List<QuestionEvaluation> listQuestion= new ArrayList<QuestionEvaluation>();
		List<String> listVoteCtpCurrent= new ArrayList<String>();
		QuestionEvaluationBusiness question = new QuestionEvaluationBusiness() ;
		
		
		listQuestion.addAll(question.findAllQuestionEvaluation());
		 
		
		
		for(int i=0; i<listQuestion.size(); i++) 
		 {	 
		 
			if((int)listQuestion.get(i).getEvaluationExperience().getIdEvaluation()== (int)idEvaluation)
			{     
			
		 
				if(listQuestion.get(i).getVote()==null)
				{ 
					listVoteCtpCurrent.add("0");
				}
				else{  
					listVoteCtpCurrent.add(listQuestion.get(i).getVote().toString());
				}
		 	 
				 
		 
		 }
			else {
				listVoteCtpCurrent.add("0");
			}
			
		
		
		
 
	}
		return listVoteCtpCurrent ;
	
	}
	
	
	
	
	
	
	
	

	public List<String> commentairevoteQuestionCtp(Integer idEvaluation)   
	{
		List<QuestionEvaluation> listQustion= new ArrayList<QuestionEvaluation>();
		List<String> listCommentaireCtpCurrent= new ArrayList<String>();
		QuestionEvaluationBusiness question = new QuestionEvaluationBusiness() ;
		
		
		listQustion.addAll(question.findAllQuestionEvaluation());
		 
		
		
		for(int i=0; i<listQustion.size(); i++) 
		 {	 
		 
			if((int)listQustion.get(i).getEvaluationExperience().getIdEvaluation()== (int)idEvaluation)
			{     
			
			 
				if(listQustion.get(i).getNote()==null)
				{   
					listCommentaireCtpCurrent.add("Sans commentaire");
				}
				else{   
					listCommentaireCtpCurrent.add(listQustion.get(i).getNote());
				}
		 	 
				 
		 
		 }
			else {
						listCommentaireCtpCurrent.add("Sans commentaire");
			}
		
		
		
 
	}
		return listCommentaireCtpCurrent ;
	
	}
	
	
	
	
	public int  convertirBooleanInteger (String var) {  
		 int  res=0;
		 
		 if(var.equals(true))
			 res= 1;
		 
		 if(var.equals(false))
			 res= 2;
		 
		 
			return res;
			 
 
	}
	
	
	public Integer  convertirInteger (String var) {  
		 
 
		return   Integer.parseInt(var);
			
			 
 
	}
	
	
	
	public Boolean  premierCase(int var) {  
		 

			if (var==1)
				return true;
			else return false;
 
	}	
	
	public Boolean  deuxiemeCase(int var) {  
		 
			if (var==2)
				return true;
			else return false;
		 
		 	}	
	
	public Boolean  troisiemeCase(int var) {  
		 
			if (var==3)
				return true;
			else return false;
			 
	 
	}	
	
 
	
	
	public Boolean  quatrièmeCase(int var) {  
		 
		if (var==4)
			return true;
		else return false;
 
	}
	public Boolean  cinquiemeCase(int var) {  
		 
		if (var==5)
			return true;
		else return false;
 
	}
	
	
	
	public Boolean  sexeHomme(String var) {  
		 
		if (var.equals("h")|| var.equals("H"))
			return true;
		else 
			return false;
 
	}
	
	public Boolean  sexeFemme(String var) {  
		 
		if (var.equals("f")|| var.equals("F"))
			return true;
		else 
			return false;
 
	}
	
	public String  changeSexe(String var) {  
		 String res="";
		if (var.equals("f")|| var.equals("F"))
			res="Femme";
		else 
			if (var.equals("h")|| var.equals("H"))
				res="Homme";
		return res;
	}

 
	
	public Boolean  caseCelibataire(String var) {  
		 
		if (var.equals("celibataire"))
			return true;
		else 
			return false;
 
	}
	
	public Boolean  caseMarie(String var) {  
		 
		if (var.equals("marie"))
			return true;
		else 
			return false;
 
	}
	
	public Boolean  caseVeuf(String var) {  
		 
		if (var.equals("veuf"))
			return true;
		else 
			return false;
 
	}
	 
	
	

	public List<SheetInformation> listInformationSelonExperienceProfessionnelle(String matricule) {
		
		  List<SheetInformation> res = new ArrayList();
		  List<SheetInformation> listInfo = new ArrayList();
		  List<SheetInformation> listReponceCtpCurrent = new ArrayList();
		  SheetInformation var = new SheetInformation();
		  SheetInformationBusiness tabInfo = new SheetInformationBusiness();		  
		  listInfo= tabInfo.findAllSheetInformation();
		   
		  for(int i=0; i<listInfo.size(); i++) 
			 { 
			  if((listInfo.get(i).getCtpFolders().getMatricule().equals(matricule)) && ( listInfo.get(i).getType().equals("experienceProfessionnelle")))
				{  
				    var.setDateStart(listInfo.get(i).getDateStart());
					var.setDateEnd(listInfo.get(i).getDateEnd());
					var.setPost(listInfo.get(i).getPost());
					var.setBusiness(listInfo.get(i).getBusiness());
					var.setRemuneration(listInfo.get(i).getRemuneration());
					
					listReponceCtpCurrent.add(var);
					var =new SheetInformation();
				}
			 
			  
			 }
		  return listReponceCtpCurrent;
		  
		  	  
		
		
	}
	
	
	

	public List<SheetInformation> listInformationSelonStage(String matricule) {
		
		  List<SheetInformation> res = new ArrayList();
		  List<SheetInformation> listInfo = new ArrayList();
		  List<SheetInformation> listReponceCtpCurrent = new ArrayList();
		  SheetInformation var = new SheetInformation();
		  SheetInformationBusiness tabInfo = new SheetInformationBusiness();		  
		  listInfo= tabInfo.findAllSheetInformation();
		    
		  for(int i=0; i<listInfo.size(); i++) 
			 { 
			  if((listInfo.get(i).getCtpFolders().getMatricule().equals(matricule)) && ( listInfo.get(i).getType().equals("stage")))
				{   
				    var.setDateStart(listInfo.get(i).getDateStart());
					var.setDateEnd(listInfo.get(i).getDateEnd());
					var.setPost(listInfo.get(i).getPost());
					var.setBusiness(listInfo.get(i).getBusiness());
					var.setRemuneration(listInfo.get(i).getRemuneration());
					
					listReponceCtpCurrent.add(var);
					var =new SheetInformation();
				}
		 
			  
			 }
		  return listReponceCtpCurrent;
		  
		  	  
		
		
	}
	
	

	public List<SheetInformation> listInformationSelonFormationAcademique(String matricule) {
		
		  List<SheetInformation> res = new ArrayList();
		  List<SheetInformation> listInfo = new ArrayList();
		  List<SheetInformation> listReponceCtpCurrent = new ArrayList();
		  SheetInformation var = new SheetInformation();
		  SheetInformationBusiness tabInfo = new SheetInformationBusiness();		  
		  listInfo= tabInfo.findAllSheetInformation();
		    
		  for(int i=0; i<listInfo.size(); i++) 
			 { 
			  if((listInfo.get(i).getCtpFolders().getMatricule().equals(matricule)) && ( listInfo.get(i).getType().equals("formationAcademique")))
				{   
				    var.setDiploma(listInfo.get(i).getDiploma());
					var.setSpecialty(listInfo.get(i).getSpecialty());
					var.setEstablishment(listInfo.get(i).getEstablishment());
					var.setYears(listInfo.get(i).getYears());
					 
					
					listReponceCtpCurrent.add(var);
					var =new SheetInformation();
				}
		 
			  
			 }
		  return listReponceCtpCurrent;
		  
		  	  
		
		
	}
	
	
	
	

	public List<SheetInformation> listInformationSelonFormationComplementaire(String matricule) {
		
		  List<SheetInformation> res = new ArrayList();
		  List<SheetInformation> listInfo = new ArrayList();
		  List<SheetInformation> listReponceCtpCurrent = new ArrayList();
		  SheetInformation var = new SheetInformation();
		  SheetInformationBusiness tabInfo = new SheetInformationBusiness();		  
		  listInfo= tabInfo.findAllSheetInformation();
		    
		  for(int i=0; i<listInfo.size(); i++) 
			 { 
			  if((listInfo.get(i).getCtpFolders().getMatricule().equals(matricule)) && ( listInfo.get(i).getType().equals("formationComplementaire")))
				{   
				    var.setSector(listInfo.get(i).getSector());
					var.setYears(listInfo.get(i).getYears());
					var.setEstablishment(listInfo.get(i).getEstablishment());
					var.setCertificate(listInfo.get(i).getCertificate());
					 
					
					listReponceCtpCurrent.add(var);
					var =new SheetInformation();
				}
		 
			  
			 }
		  return listReponceCtpCurrent;
		  
		  	  
		
		
	}
	
	
	

	public Integer listInformationSelonAptitudeLanguageArabe(String matricule ) {
		
		  List<SheetInformation> res = new ArrayList();
		  List<SheetInformation> listInfo = new ArrayList();
		   Integer resultat=0;
		  SheetInformation var = new SheetInformation();
		  SheetInformationBusiness tabInfo = new SheetInformationBusiness();		  
		  listInfo= tabInfo.findAllSheetInformation();
		    
		  for(int i=0; i<listInfo.size(); i++) 
			 { 
			  if((listInfo.get(i).getCtpFolders().getMatricule().equals(matricule)) && ( listInfo.get(i).getType().equals("Aptitudelanguage"))&&(listInfo.get(i).getQuestion().equals("arabe")))
				{   
				     
				 
					resultat=listInfo.get(i).getVote();
				}
		 
			  
			 }
		  return resultat;
		  
		  	  
		
		
	}
	
	

	public Integer listInformationSelonAptitudeLanguageFrancais(String matricule) {

		  List<SheetInformation> res = new ArrayList();
		  List<SheetInformation> listInfo = new ArrayList();
		   Integer resultat=0;
		  SheetInformation var = new SheetInformation();
		  SheetInformationBusiness tabInfo = new SheetInformationBusiness();		  
		  listInfo= tabInfo.findAllSheetInformation();
		    
		  for(int i=0; i<listInfo.size(); i++) 
			 { 
			  if((listInfo.get(i).getCtpFolders().getMatricule().equals(matricule)) && ( listInfo.get(i).getType().equals("Aptitudelanguage"))&&(listInfo.get(i).getQuestion().equals("français")))
				{   
				     
				 
					resultat=listInfo.get(i).getVote();
				}
		 
			  
			 }
		  return resultat;
		  	  
		
		
	}
	

	public Integer listInformationSelonAptitudeLanguageAnglais(String matricule) {

		  List<SheetInformation> res = new ArrayList();
		  List<SheetInformation> listInfo = new ArrayList();
		   Integer resultat=0;
		  SheetInformation var = new SheetInformation();
		  SheetInformationBusiness tabInfo = new SheetInformationBusiness();		  
		  listInfo= tabInfo.findAllSheetInformation();
		    
		  for(int i=0; i<listInfo.size(); i++) 
			 { 
			  if((listInfo.get(i).getCtpFolders().getMatricule().equals(matricule)) && ( listInfo.get(i).getType().equals("Aptitudelanguage"))&&(listInfo.get(i).getQuestion().equals("anglais")))
				{   
				     
				 
					resultat=listInfo.get(i).getVote();
				}
		 
			  
			 }
		  return resultat;
		
	}
	
	
	
	
	
	public List<SheetInformation> listInformationSelonVieAssociative(String matricule) {
		
		  List<SheetInformation> res = new ArrayList();
		  List<SheetInformation> listInfo = new ArrayList();
		  List<SheetInformation> listReponceCtpCurrent = new ArrayList();
		  SheetInformation var = new SheetInformation();
		  SheetInformationBusiness tabInfo = new SheetInformationBusiness();		  
		  listInfo= tabInfo.findAllSheetInformation();
		    
		  for(int i=0; i<listInfo.size(); i++) 
			 { 
			  if((listInfo.get(i).getCtpFolders().getMatricule().equals(matricule)) && ( listInfo.get(i).getType().equals("vieAssociative")))
				{   
				    var.setDateStart(listInfo.get(i).getDateStart());
					var.setDateEnd(listInfo.get(i).getDateEnd());
					var.setAssociation(listInfo.get(i).getAssociation());
					var.setSector(listInfo.get(i).getSector());
					var.setPost(listInfo.get(i).getPost());
					 
					
					listReponceCtpCurrent.add(var);
					var =new SheetInformation();
				}
		 
			  
			 }
		  return listReponceCtpCurrent;
		 
		
	}
	
	
	
	

	public List<SheetInformation> listInformationSelontypeQuestion(String matricule) {

		  List<SheetInformation> res = new ArrayList();
		  List<SheetInformation> listInfo = new ArrayList();
		  List<SheetInformation> listReponceCtpCurrent = new ArrayList();
		  SheetInformation var = new SheetInformation();
		  SheetInformationBusiness tabInfo = new SheetInformationBusiness();		  
		  listInfo= tabInfo.findAllSheetInformation();
		    
		  for(int i=0; i<listInfo.size(); i++) 
			 { 
			  if((listInfo.get(i).getCtpFolders().getMatricule().equals(matricule)) && ( listInfo.get(i).getType().equals("question")))
				{   
				    var.setQuestion(listInfo.get(i).getQuestion());
					var.setReponce(listInfo.get(i).getReponce());
					
					 
					
					listReponceCtpCurrent.add(var);
					var =new SheetInformation();
				}
			  
			 
		 
			  
			 }
 
		  return listReponceCtpCurrent;
		 
		
	}
	
	 
	
	public Boolean rechercheMatriculeDansSheetInformation(String matricule) {
		
		  List<SheetInformation> res = new ArrayList();
		  List<SheetInformation> listInfo = new ArrayList();
		  SheetInformation var = new SheetInformation();
		  Boolean resultat=false;
		  SheetInformationBusiness tabInfo = new SheetInformationBusiness();		  
		  listInfo= tabInfo.findAllSheetInformation();
		 
		int i=0;
	 
		while( (i<listInfo.size()) && (resultat==false))
		  
			 {  
			  if((listInfo.get(i).getCtpFolders().getMatricule().equals(matricule))      )
				{   
				    resultat=true;
					
					 
				}
			  i=i+1;
			  
			 }
		 
		  return resultat;
	 	
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
	
	
 
 
		  
	 
		
	
	
	
	
	
	

	public List<CtpFolders> listCtpSortant() {
		SimpleDateFormat formaterAn = null;	
		SimpleDateFormat formaterMon = null;	
		SimpleDateFormat formaterJ = null;	
		
		List<CtpFolders> res = new ArrayList();
		  List<CtpFolders> listInfo = new ArrayList();
		  List<CtpFolders> listCtpSortant = new ArrayList();
		  CtpFolders var = new CtpFolders();
		  CtpFoldersBusiness tabInfo = new CtpFoldersBusiness();
		  Candidates c= new Candidates();
		  formaterAn = new SimpleDateFormat("yyyy");		 
			formaterMon = new SimpleDateFormat("MM");
			formaterJ = new SimpleDateFormat("dd");
		  	int b,cc;
		  	String Sdd,Scc;
		  listInfo= tabInfo.findAllCtpFolders();
		   AdditionalCandidates ad = new AdditionalCandidates();
		   
		  Date d=new Date();
		  Sdd=  formaterAn.format(d) +formaterMon.format(d) +formaterJ.format(d) ;
		     
		 int dd=Integer.parseInt(Sdd);
		    
		  for(int i=0; i<listInfo.size(); i++) 
			  
			 {
			  if(listInfo.get(i).getExitDate()!=null)
			  {
				  
				  b=Integer.parseInt(formaterAn.format(listInfo.get(i).getExitDate()))+Integer.parseInt(formaterMon.format(listInfo.get(i).getExitDate()))+Integer.parseInt(formaterJ.format(listInfo.get(i).getExitDate()));
				 	
			  }
			  else{
				  b=999999999;
			  }
			  Scc= formaterAn.format(listInfo.get(i).getEndContractDate())+formaterMon.format(listInfo.get(i).getEndContractDate()) +formaterJ.format(listInfo.get(i).getEndContractDate()) ;
				 
			  cc=Integer.parseInt(Scc);
				 
			  System.out.println("i = "+i+" cc = "+cc+"  dd = "+dd+" b ="+b);
			 
			  if(cc<dd || b<dd  )
				{ c=new Candidates();
				ad = new AdditionalCandidates();
				   
				  c.setLastName(listInfo.get(i).getCandidates().getLastName());
				  c.setFirstName(listInfo.get(i).getCandidates().getFirstName());
				  c.setAddress(listInfo.get(i).getCandidates().getAddress());
				  c.setSexe(listInfo.get(i).getCandidates().getSexe());
				  c.setTel(listInfo.get(i).getCandidates().getTel());				  
				  c.setDateAdd(listInfo.get(i).getCandidates().getDateAdd());
				  c.setCin(listInfo.get(i).getCandidates().getCin());
				  c.setCinIssued(listInfo.get(i).getCandidates().getCinIssued());
				  c.setBirthday(listInfo.get(i).getCandidates().getBirthday());
				  c.setNationality(listInfo.get(i).getCandidates().getNationality());				  
				  c.setPassportNumber(listInfo.get(i).getCandidates().getPassportNumber());
				  c.setFamilySituation(listInfo.get(i).getCandidates().getFamilySituation());
				  c.setChildNumber(listInfo.get(i).getCandidates().getChildNumber());
				  c.setEtatCandidature(listInfo.get(i).getCandidates().getEtatCandidature());
				  c.setNationality(listInfo.get(i).getCandidates().getNationality());  
				  c.setEmail(listInfo.get(i).getCandidates().getEmail());
				  
				  
				  ad.setIdAdditionalCandidates(listInfo.get(i).getCandidates().getAdditionalCandidates().getIdAdditionalCandidates());
				  ad.setCv(listInfo.get(i).getCandidates().getAdditionalCandidates().getCv());
				  ad.setLdm(listInfo.get(i).getCandidates().getAdditionalCandidates().getLdm());
				  ad.setDurationTraineeship(listInfo.get(i).getCandidates().getAdditionalCandidates().getDurationTraineeship());
				  ad.setDurationExpPro(listInfo.get(i).getCandidates().getAdditionalCandidates().getDurationExpPro());
				  ad.setDiploma(listInfo.get(i).getCandidates().getAdditionalCandidates().getDiploma());
				  ad.setSpecialty(listInfo.get(i).getCandidates().getAdditionalCandidates().getSpecialty());
				  ad.setNote(listInfo.get(i).getCandidates().getAdditionalCandidates().getNote());
				  ad.setMeetingDate(listInfo.get(i).getCandidates().getAdditionalCandidates().getMeetingDate());			  
				  ad.setPost(listInfo.get(i).getCandidates().getAdditionalCandidates().getPost());
				  ad.setDepartement(listInfo.get(i).getCandidates().getAdditionalCandidates().getDepartement());
				  
				  c.setAdditionalCandidates(ad);
				  
				    var.setCandidates(c);				    
				    var.setCtpSituation(listInfo.get(i).getCtpSituation());
				    var.setObservation(listInfo.get(i).getObservation());
				    var.setMatricule(listInfo.get(i).getMatricule());
				    var.setHiringDate(listInfo.get(i).getHiringDate());
					var.setExitDate(listInfo.get(i).getExitDate());					
					var.setEndContractDate(listInfo.get(i).getEndContractDate());
					var.setCertificat(listInfo.get(i).getCertificat());	
					var.setRib(listInfo.get(i).getRib());	
					var.setCtpSituation(listInfo.get(i).getCtpSituation());	
					var.setContrat(listInfo.get(i).getContrat());					
					var.setInitialCv(listInfo.get(i).getInitialCv());	
					var.setCustomCv(listInfo.get(i).getCustomCv());					
					var.setLicensePhoto(listInfo.get(i).getLicensePhoto());	
					var.setInternalRules(listInfo.get(i).getInternalRules());					
					var.setAssuranceCopy(listInfo.get(i).getAssuranceCopy());	
					var.setCinCopy(listInfo.get(i).getCinCopy());					
					var.setTestEvalution(listInfo.get(i).getTestEvalution());	
					var.setCinCopy(listInfo.get(i).getCinCopy());				
					var.setDiplomaCopy(listInfo.get(i).getDiplomaCopy());	
					var.setAttestationJob(listInfo.get(i).getAttestationJob());					
					var.setPhoto(listInfo.get(i).getPhoto());	
					var.setObservation(listInfo.get(i).getObservation());				
					
					listCtpSortant.add(var);
					var =new CtpFolders();
				}
			 
			  
			 }
		  return listCtpSortant;
		  
		 
		
	}
	
	
	
	
	
	public List<CtpFolders> listCtpActuelle() {
		SimpleDateFormat formaterAn = null;	
		SimpleDateFormat formaterMon = null;	
		SimpleDateFormat formaterJ = null;	
		
		List<CtpFolders> res = new ArrayList();
		  List<CtpFolders> listInfo = new ArrayList();
		  List<CtpFolders> listCtpSortant = new ArrayList();
		  CtpFolders var = new CtpFolders();
		  CtpFoldersBusiness tabInfo = new CtpFoldersBusiness();
		  Candidates c= new Candidates();
		  formaterAn = new SimpleDateFormat("yyyy");		 
			formaterMon = new SimpleDateFormat("MM");
			formaterJ = new SimpleDateFormat("dd");
		  	int b,cc;
		  	String Sdd,Scc;
		  listInfo= tabInfo.findAllCtpFolders();
		   AdditionalCandidates ad = new AdditionalCandidates();
		  Date d=new Date();
		  Sdd=  formaterAn.format(d) +formaterMon.format(d) +formaterJ.format(d) ;
		     
			 int dd=Integer.parseInt(Sdd);
		  for(int i=0; i<listInfo.size(); i++) 
			  
			 {
			  
			  if(listInfo.get(i).getExitDate()==null)
			  {
			  if(listInfo.get(i).getExitDate()!=null)
			  {
				  b=Integer.parseInt(formaterAn.format(listInfo.get(i).getExitDate()))+Integer.parseInt(formaterMon.format(listInfo.get(i).getExitDate()))+Integer.parseInt(formaterJ.format(listInfo.get(i).getExitDate()));
				 	
			  }
			  else{
				  b=999999999;
			  }
			  Scc= formaterAn.format(listInfo.get(i).getEndContractDate())+formaterMon.format(listInfo.get(i).getEndContractDate()) +formaterJ.format(listInfo.get(i).getEndContractDate()) ;
				 
			  cc=Integer.parseInt(Scc);
			 
			 
			  if(cc>dd || b>dd  )
				{ c=new Candidates();
				ad = new AdditionalCandidates();
				   
				  c.setLastName(listInfo.get(i).getCandidates().getLastName());
				  c.setFirstName(listInfo.get(i).getCandidates().getFirstName());
				  c.setAddress(listInfo.get(i).getCandidates().getAddress());
				  c.setSexe(listInfo.get(i).getCandidates().getSexe());
				  c.setTel(listInfo.get(i).getCandidates().getTel());				  
				  c.setDateAdd(listInfo.get(i).getCandidates().getDateAdd());
				  c.setCin(listInfo.get(i).getCandidates().getCin());
				  c.setCinIssued(listInfo.get(i).getCandidates().getCinIssued());
				  c.setBirthday(listInfo.get(i).getCandidates().getBirthday());
				  c.setNationality(listInfo.get(i).getCandidates().getNationality());				  
				  c.setPassportNumber(listInfo.get(i).getCandidates().getPassportNumber());
				  c.setFamilySituation(listInfo.get(i).getCandidates().getFamilySituation());
				  c.setChildNumber(listInfo.get(i).getCandidates().getChildNumber());
				  c.setEtatCandidature(listInfo.get(i).getCandidates().getEtatCandidature());
				  c.setNationality(listInfo.get(i).getCandidates().getNationality());  
				  c.setEmail(listInfo.get(i).getCandidates().getEmail());
				  
				  
				  ad.setIdAdditionalCandidates(listInfo.get(i).getCandidates().getAdditionalCandidates().getIdAdditionalCandidates());
				  ad.setCv(listInfo.get(i).getCandidates().getAdditionalCandidates().getCv());
				  ad.setLdm(listInfo.get(i).getCandidates().getAdditionalCandidates().getLdm());
				  ad.setDurationTraineeship(listInfo.get(i).getCandidates().getAdditionalCandidates().getDurationTraineeship());
				  ad.setDurationExpPro(listInfo.get(i).getCandidates().getAdditionalCandidates().getDurationExpPro());
				  ad.setDiploma(listInfo.get(i).getCandidates().getAdditionalCandidates().getDiploma());
				  ad.setSpecialty(listInfo.get(i).getCandidates().getAdditionalCandidates().getSpecialty());
				  ad.setNote(listInfo.get(i).getCandidates().getAdditionalCandidates().getNote());
				  ad.setMeetingDate(listInfo.get(i).getCandidates().getAdditionalCandidates().getMeetingDate());			  
				  ad.setPost(listInfo.get(i).getCandidates().getAdditionalCandidates().getPost());
				  ad.setDepartement(listInfo.get(i).getCandidates().getAdditionalCandidates().getDepartement());
				  
				  c.setAdditionalCandidates(ad);
				  
				    var.setCandidates(c);				    
				    var.setCtpSituation(listInfo.get(i).getCtpSituation());
				    var.setObservation(listInfo.get(i).getObservation());
				    var.setMatricule(listInfo.get(i).getMatricule());
				    var.setHiringDate(listInfo.get(i).getHiringDate());
					var.setExitDate(listInfo.get(i).getExitDate());					
					var.setEndContractDate(listInfo.get(i).getEndContractDate());
					var.setCertificat(listInfo.get(i).getCertificat());	
					var.setRib(listInfo.get(i).getRib());	
					var.setCtpSituation(listInfo.get(i).getCtpSituation());	
					var.setContrat(listInfo.get(i).getContrat());					
					var.setInitialCv(listInfo.get(i).getInitialCv());	
					var.setCustomCv(listInfo.get(i).getCustomCv());					
					var.setLicensePhoto(listInfo.get(i).getLicensePhoto());	
					var.setInternalRules(listInfo.get(i).getInternalRules());					
					var.setAssuranceCopy(listInfo.get(i).getAssuranceCopy());	
					var.setCinCopy(listInfo.get(i).getCinCopy());					
					var.setTestEvalution(listInfo.get(i).getTestEvalution());	
					var.setCinCopy(listInfo.get(i).getCinCopy());				
					var.setDiplomaCopy(listInfo.get(i).getDiplomaCopy());	
					var.setAttestationJob(listInfo.get(i).getAttestationJob());					
					var.setPhoto(listInfo.get(i).getPhoto());	
					var.setObservation(listInfo.get(i).getObservation());				
					
					listCtpSortant.add(var);
					var =new CtpFolders();
				}
			  }
			  
			 }
		  return listCtpSortant;
		  
		 
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//////////// couleur 
	
	
	public String  coleurString(String var) {
		 
		String varChange=var;
		
		if (varChange.equals("true")||varChange.equals("Oui"))
			{varChange="Lime";}
		
		else if (varChange.equals("false")||varChange.equals("Non")||varChange==null)
		{varChange="Red";}
		  else
			{varChange="Red";}
		
		return  varChange;
 
	}
	
	public String  coleurBoolean(Boolean var) {
 
		  
		String res;
		if (var==true)
			{res="Lime";}
		
		else if (var==false)
		{res="Red";}
		  else
			{res="Red";}
		
		return  res;

	}




	 
	 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
