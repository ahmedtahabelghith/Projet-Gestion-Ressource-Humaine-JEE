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

 










import com.business.ContenuValidacBusiness;
import com.business.QuestionEvaluationBusiness;
import com.business.SheetInformationBusiness;
import com.business.ValidacsBusiness;
import com.dao.ContenuValidacDao;
import com.dao.impl.ValidacsDaoImp;
import com.model.ContenuValidac;
import com.model.CtpFolders;
import com.model.QuestionEvaluation;
import com.model.SheetInformation;
import com.model.Validacs;

 

@ManagedBean
@SessionScoped
public class ContenuValidacBean {
 
	private ValidacsDaoImp ValidacsDao = new ValidacsDaoImp();

	private Validacs validacs = new Validacs();

	private Validacs  currentValidacs = new Validacs(); 
	private ContenuValidacBusiness  validacB = new ContenuValidacBusiness(); 
	private List<Validacs> listValidacs = new ArrayList();

	
	
	private ContenuValidac validac1= new ContenuValidac();
	private ContenuValidac validac2= new ContenuValidac();
	private ContenuValidac validac3= new ContenuValidac();
	private ContenuValidac validac4= new ContenuValidac();
	private ContenuValidac validac5= new ContenuValidac();
	private ContenuValidac validac6= new ContenuValidac();
	private ContenuValidac validac7= new ContenuValidac();
	private ContenuValidac validac8= new ContenuValidac();
	private ContenuValidac validac9= new ContenuValidac();
	private ContenuValidac validac10= new ContenuValidac();
	
	 private 	Validacs v = new Validacs();
	 private CtpFolders ctpValidac = new CtpFolders();
	 private ContenuValidacBusiness qe =new ContenuValidacBusiness();
	 private List<ContenuValidac> lst = new ArrayList();
 
	 
	private int idValidac=0;
	
 	private ContenuValidac p = new ContenuValidac();
 	private Validacs t=new Validacs();
	
 	
 	
 	
 	public Boolean rechercheValidacDansContenuValidac(int id) {

		  List<ContenuValidac> res = new ArrayList();		 
		  ContenuValidacBusiness var = new ContenuValidacBusiness();
		  Boolean resultat=false;
		  	  
		  res= var.findAllContenuValidacs();
		 
		int i=0;
	 
		while( (i<res.size()) && (resultat==false) )
		  
			 {  
			  if(res.get(i).getValidacs().getIdValidac().equals(id)==true )
				{   
				    resultat=true;
					
					 
				}
			 
			  i=i+1;
			  
			 }
	
	 System.out.println(resultat);
		  return resultat;
	 	
	}
 	 
 	public void saveValidacCandidat() { 
 		FacesContext facesContext = FacesContext.getCurrentInstance();
 		lst=qe.findAllContenuValidacs(); 	
 		v.setIdValidac(idValidac);
 	
  		for(int i=0;i<lst.size();i++)
  		{  
  			if((lst.get(i).getValidacs().getIdValidac()==idValidac) && (lst.get(i).getActeur().equals("candidat")) )
  			{
  				ValidacsDao.delete(lst.get(i));  				 
  				 
  			}
  		
  		}
  		


  		validac1.setValidacs(v);
  		validac1.setActeur("candidat");
  		ValidacsDao.saveOrUpdate(validac1); 
  		
  		validac2.setValidacs(v); 		
  		validac2.setActeur("candidat");
  		ValidacsDao.saveOrUpdate(validac2); 
  		
  		validac3.setValidacs(v); 		
  		validac3.setActeur("candidat");
  		ValidacsDao.saveOrUpdate(validac3); 
  		
  		validac4.setValidacs(v); 	
  		validac4.setActeur("candidat");
  		ValidacsDao.saveOrUpdate(validac4); 
  		
  		validac5.setValidacs(v); 		
  		validac5.setActeur("candidat");
  		ValidacsDao.saveOrUpdate(validac5);  
  		
  		
  		try {
			
			facesContext.getExternalContext().redirect("sousMenuCandidat.xhtml");
		}
		 catch (Exception e) {
			e.printStackTrace();
		}
 	}
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	 
 	public List<ContenuValidac> rechercheContenuValidacCandidat(CtpFolders c) { 
  
 		   List<ContenuValidac> res = new ArrayList();
 		
 		
 		lst=qe.findAllContenuValidacs(); 	
 		v.setIdValidac(idValidac);
 	
  		for(int i=0;i<lst.size();i++)
  		{  
  			if(lst.get(i).getActeur().equals("candidat") && c.getValidacs().getIdValidac().equals(lst.get(i).getValidacs().getIdValidac()) )
  			{
  				res.add(lst.get(i))  ;				 
  				 
  			}
  		
  		}
  		
  		
		while(res.size()<5)
 		{	p.setObjectif("vide");
 		p.setActeur("coach");
 		p.setDemontre("vide");
 		p.setInitiale("vide");
 		p.setPratique("vide");
 		p.setPerfectione("vide");
 		p.setValidacs(t);
 			res.add(p);
 		}
		
		
  		return res;
 	
 	
 	}
 	
	 
	public List<ContenuValidac> rechercheContenuValidacCoach(CtpFolders c) { 
 
		   List<ContenuValidac> res = new ArrayList();
	
		lst=qe.findAllContenuValidacs(); 	
		v.setIdValidac(idValidac);
	
 		for(int i=0;i<lst.size();i++)
 		{  
 			if(lst.get(i).getActeur().equals("coach") && c.getValidacs().getIdValidac().equals(lst.get(i).getValidacs().getIdValidac()) )
 			{
 				res.add(lst.get(i))  ;				 
 				 
 			}
 		
 		}
 		 
 		while(res.size()<5)
 		{	p.setObjectif("vide");
 		p.setActeur("coach");
 		p.setDemontre("vide");
 		p.setInitiale("vide");
 		p.setPratique("vide");
 		p.setPerfectione("vide");
 		p.setValidacs(t);
 			res.add(p);
 		}
  		return res;
	
	
	}
	
 	
 	
	public List<ContenuValidac> rechercheContenuValidacCoach() { 
		  
		   List<ContenuValidac> res = new ArrayList();
		
		
		lst=qe.findAllContenuValidacs(); 	
		v.setIdValidac(idValidac);
	
		for(int i=0;i<lst.size();i++)
		{  
			if(lst.get(i).getActeur().equals("coach"))
			{
				res.add(lst.get(i))  ;				 
				 
			}
		
		}
		return res;
	
	
	}
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	public void saveValidacCoach(CtpFolders c) { 
 		   
 		lst=qe.findAllContenuValidacs(); 	
 		v.setIdValidac(c.getValidacs().getIdValidac());
  
 		
 			for(int i=0;i<lst.size();i++)
  		{  
  		
  		 System.out.println(lst.get(i).getActeur().equals("coach"));
  			if((lst.get(i).getValidacs().getIdValidac().equals(c.getValidacs().getIdValidac()))&& (lst.get(i).getActeur().equals("coach")))
  			{ System.out.println("jjjj");
  				ValidacsDao.delete(lst.get(i));  				 
  				 
  			}
  		
  		}
  		
  		
  	  		 
  		validac6.setValidacs(v); 	
  		validac6.setActeur("coach");
  		ValidacsDao.saveOrUpdate(validac6); 
  		
  		validac7.setValidacs(v); 	
  		validac7.setActeur("coach");
  		ValidacsDao.saveOrUpdate(validac7); 
  		
  		validac8.setValidacs(v); 		
  		validac8.setActeur("coach");
  		ValidacsDao.saveOrUpdate(validac8); 
  		
  		validac9.setValidacs(v); 
  		validac9.setActeur("coach");
  		ValidacsDao.saveOrUpdate(validac9); 
  		
  		validac10.setValidacs(v); 	
  		validac10.setActeur("coach");
  		ValidacsDao.saveOrUpdate(validac10);  
    
 	}
 	
 	 


	public ValidacsDaoImp getValidacsDao() {
		return ValidacsDao;
	}
  


	public void setValidacsDao(ValidacsDaoImp validacsDao) {
		ValidacsDao = validacsDao;
	}
 
 
 
	public int getIdValidac() {
		return idValidac;
	}
 


	public void setIdValidac(int idValidac) {

		this.idValidac = idValidac;
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





	public List<Validacs> getListValidacs() {
		return listValidacs;
	}





	public void setListValidacs(List<Validacs> listValidacs) {
		this.listValidacs = listValidacs;
	}





	public ContenuValidac getValidac1() {
		return validac1;
	}





	public void setValidac1(ContenuValidac validac1) {
		this.validac1 = validac1;
	}





	public ContenuValidac getValidac2() {
		return validac2;
	}





	public void setValidac2(ContenuValidac validac2) {
		this.validac2 = validac2;
	}





	public ContenuValidac getValidac3() {
		return validac3;
	}





	public void setValidac3(ContenuValidac validac3) {
		this.validac3 = validac3;
	}





	public ContenuValidac getValidac4() {
		return validac4;
	}





	public void setValidac4(ContenuValidac validac4) {
		this.validac4 = validac4;
	}





	public ContenuValidac getValidac5() {
		return validac5;
	}





	public void setValidac5(ContenuValidac validac5) {
		this.validac5 = validac5;
	}

 

	public CtpFolders getCtpValidac() {
		return ctpValidac;
	}





	public void setCtpValidac(CtpFolders ctpValidac) {
		this.ctpValidac = ctpValidac;
	}





	public ContenuValidac getValidac6() {
		return validac6;
	}





	public void setValidac6(ContenuValidac validac6) {
		this.validac6 = validac6;
	}





	public ContenuValidac getValidac7() {
		return validac7;
	}





	public void setValidac7(ContenuValidac validac7) {
		this.validac7 = validac7;
	}





	public ContenuValidac getValidac8() {
		return validac8;
	}





	public void setValidac8(ContenuValidac validac8) {
		this.validac8 = validac8;
	}





	public ContenuValidac getValidac9() {
		return validac9;
	}





	public void setValidac9(ContenuValidac validac9) {
		this.validac9 = validac9;
	}





	public ContenuValidac getValidac10() {
		return validac10;
	}





	public void setValidac10(ContenuValidac validac10) {
		this.validac10 = validac10;
	}


 
	

}
