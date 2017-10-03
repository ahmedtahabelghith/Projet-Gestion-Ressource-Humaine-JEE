package com.beans;

 
 
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.business.CtpFoldersBusiness;
import com.business.SheetInformationBusiness;
import com.dao.CtpFoldersDao;
import com.dao.impl.CtpFoldersDaoImp;
import com.model.CtpFolders;
import com.model.SheetInformation;
@ManagedBean
@SessionScoped
public class Statistique {

	private int currentYears;
	private CtpFoldersDao CtpDao = new CtpFoldersDaoImp();
	private CtpFoldersBusiness Ctp = new CtpFoldersBusiness();
	private CtpFolders  currentCtp=new CtpFolders();
	private List<CtpFolders> listCtpFolders = new ArrayList();
	  
	

	 
	
	
	public int somme(int a,int b ,int c,int d ) {
		return a+b+c+d;
	}
	
	public int sommeMois(int a,int b ,int c,int d ,int e,int f ,int g,int h ,int i,int j ,int k,int l ) {
		return a+b+c+d+d+e+f+g+h+i+k+l;
	}
	
		
	public String purcentage(float a,float totale ) {
		DecimalFormat df = new DecimalFormat("###.00"); 
		return df.format((a/totale)*100) ;
		 
	}
	
	
	
	public List<String>  listAnne( ) {
			String a;
		  List<String> listAnnee = new ArrayList();
		  int curYear = Calendar.getInstance().get(Calendar.YEAR);
		   
		  for(int i=2010;i<=curYear;i++)
		  { a=""+i;
			  listAnnee.add(a);
			  
		  }
		  
	 
		return listAnnee;
		 
	}
	
	 
	
	
	public int rechercheNomberCTPHomme() {
		int  nbrHomme=0;
		listCtpFolders=Ctp.findAllCtpFolders();
		   
		  for(int i=0; i<listCtpFolders.size(); i++) 
			 { 
			  
			  if( listCtpFolders.get(i).getCandidates().getSexe()!=null)
		  	  {
		  	  if(((listCtpFolders.get(i).getCandidates().getSexe().equals("H"))|| (listCtpFolders.get(i).getCandidates().getSexe().equals("h")))   )
		  	  {
		  		  nbrHomme=nbrHomme+1;
		  	  }
		  	  }
			 }
		  	  return nbrHomme;
	
	
	}
	

	public int rechercheNomberCTPHommeSelonAn(String year) {
		int  nbrHomme=0;
		 
		SimpleDateFormat formater = null;		
		Date aujourdhui = new Date();
		formater = new SimpleDateFormat("yyyy");		 
		 String var ;
		

		listCtpFolders=Ctp.findAllCtpFolders();
		   
		  for(int i=0; i<listCtpFolders.size(); i++) 
			 { 
			  if( listCtpFolders.get(i).getCtpSituation()!=null)
		  	  {	 
				  if (listCtpFolders.get(i).getExitDate()== null)
				  {
					  var="0000";
				  }
				  else{
					  var=formater.format(listCtpFolders.get(i).getExitDate());
				  }
		 
				  if(((listCtpFolders.get(i).getCandidates().getSexe().equals("H"))|| (listCtpFolders.get(i).getCandidates().getSexe().equals("h")) ) && ((formater.format(listCtpFolders.get(i).getHiringDate()).equals(year))|| (var.equals(year))|| (formater.format(listCtpFolders.get(i).getEndContractDate()).equals(year))) )
				  	  {
		  		  nbrHomme=nbrHomme+1;
		  	  }
		
			 }
			 }
		  	  return nbrHomme;
			 }
	
	public int rechercheNomberCTPFemme() {
		int  nbrFemme=0;
		listCtpFolders=Ctp.findAllCtpFolders();
		   
		  for(int i=0; i<listCtpFolders.size(); i++) 
			 { 
			  if( listCtpFolders.get(i).getCtpSituation()!=null)
		  	  {
		  
		  	  if((listCtpFolders.get(i).getCandidates().getSexe().equals("F"))|| (listCtpFolders.get(i).getCandidates().getSexe().equals("f")) )
		  	  {
		  		  nbrFemme=nbrFemme+1;
		  	  }
		
			 }
			 }
		  	  return nbrFemme;
			 }
	
	
	
	public int rechercheNomberCTPFemmeSelonAn(String year) {
		int  nbrFemme=0;
		
		SimpleDateFormat formater = null;		
	  String var;
		formater = new SimpleDateFormat("yyyy");		 
		 

		listCtpFolders=Ctp.findAllCtpFolders();
		   
		  for(int i=0; i<listCtpFolders.size(); i++) 
			 { 
			  if( listCtpFolders.get(i).getCtpSituation()!=null  )
		  	  {	 
				  if (listCtpFolders.get(i).getExitDate()== null)
				  {
					  var="0000";
				  }
				  else{
					  var=formater.format(listCtpFolders.get(i).getExitDate());
				  }
				  
		  	  if(((listCtpFolders.get(i).getCandidates().getSexe().equals("F"))|| (listCtpFolders.get(i).getCandidates().getSexe().equals("f")) ) && ((formater.format(listCtpFolders.get(i).getHiringDate()).equals(year))|| (var.equals(year))|| (formater.format(listCtpFolders.get(i).getEndContractDate()).equals(year))) )
		  	  {
		  		  nbrFemme=nbrFemme+1;
		  	  }
		
			 }
			 }
		  	  return nbrFemme;
			 }
	
	
	public int rechercheNomberCTPFemmeSelonAnMon(String year,String month) {
		int  nbrFemme=0; 
		SimpleDateFormat formaterAn = null;		
		SimpleDateFormat formaterMon = null;	
		formaterAn = new SimpleDateFormat("yyyy");		 
		formaterMon = new SimpleDateFormat("MM");
String varA ,varM;
		listCtpFolders=Ctp.findAllCtpFolders();
		   
		  for(int i=0; i<listCtpFolders.size(); i++) 
			 { 
			  if( listCtpFolders.get(i).getCtpSituation()!=null)
		  	  {	  
				  if (listCtpFolders.get(i).getExitDate()== null)
				  {
					  varA="0000";
					  varM="00";
				  }
				  else{
					  varA=formaterAn.format(listCtpFolders.get(i).getExitDate());
					  varM=formaterMon.format(listCtpFolders.get(i).getExitDate());
				  }
				  
				  if(((listCtpFolders.get(i).getCandidates().getSexe().equals("F"))|| (listCtpFolders.get(i).getCandidates().getSexe().equals("f")) ) && ((formaterAn.format(listCtpFolders.get(i).getHiringDate()).equals(year) && formaterMon.format(listCtpFolders.get(i).getHiringDate()).equals(month))|| varA.equals(year)&& (varM.equals(month))|| (formaterAn.format(listCtpFolders.get(i).getEndContractDate()).equals(year)&&formaterMon.format(listCtpFolders.get(i).getEndContractDate()).equals(month)) || (Integer.parseInt(year+month)<Integer.parseInt(varA+varM) && year.equals("0000")==false && month.equals("0000")==false && (Integer.parseInt(varA)==Integer.parseInt(year) ||Integer.parseInt(varA)==(Integer.parseInt(year)+1)))) )	  	
					  		   		  { 
		  		  nbrFemme=nbrFemme+1;
		  	  }
		
			 }
			 }
		  	  return nbrFemme;
			 }
	
	public int rechercheNomberCTPHommeSelonAnMon(String year,String month) {
		int  nbrFemme=0;
		 
		SimpleDateFormat formaterAn = null;		
		SimpleDateFormat formaterMon = null;	
		formaterAn = new SimpleDateFormat("yyyy");		 
		formaterMon = new SimpleDateFormat("MM");
 
		listCtpFolders=Ctp.findAllCtpFolders();
		   
		  for(int i=0; i<listCtpFolders.size(); i++) 
			 { 
			  if( listCtpFolders.get(i).getCtpSituation()!=null)
		  	  {	 
				  
				  if(((listCtpFolders.get(i).getCandidates().getSexe().equals("H"))|| (listCtpFolders.get(i).getCandidates().getSexe().equals("h")) ) && ((formaterAn.format(listCtpFolders.get(i).getHiringDate()).equals(year) && formaterMon.format(listCtpFolders.get(i).getHiringDate()).equals(month))|| (formaterAn.format(listCtpFolders.get(i).getExitDate()).equals(year)&&formaterMon.format(listCtpFolders.get(i).getExitDate()).equals(month))|| (formaterAn.format(listCtpFolders.get(i).getEndContractDate()).equals(year)&&formaterMon.format(listCtpFolders.get(i).getEndContractDate()).equals(month)) || (Integer.parseInt(year+month)<Integer.parseInt(formaterAn.format(listCtpFolders.get(i).getExitDate())+formaterMon.format(listCtpFolders.get(i).getExitDate())) && year.equals("0000")==false && month.equals("0000")==false && (Integer.parseInt(formaterAn.format(listCtpFolders.get(i).getExitDate()))==Integer.parseInt(year) ||Integer.parseInt(formaterAn.format(listCtpFolders.get(i).getExitDate()))==(Integer.parseInt(year)+1)))) )	  	
						{
		  		  nbrFemme=nbrFemme+1;
		  	  }
		
			 }
			 }
		  	  return nbrFemme;
			 }
	
	public int embaucheCTPHomme() {
		int  nbrHomme=0;
		listCtpFolders=Ctp.findAllCtpFolders();
		   
		  for(int i=0; i<listCtpFolders.size(); i++) 
			 { 
			  
			  if( listCtpFolders.get(i).getCtpSituation()!=null)
		  	  {
		  	  if(((listCtpFolders.get(i).getCandidates().getSexe().equals("H"))|| (listCtpFolders.get(i).getCandidates().getSexe().equals("h")))&&( listCtpFolders.get(i).getCtpSituation().equals("embauche") ))
		  	  {
		  		  nbrHomme=nbrHomme+1;
		  	  }
		
			 }
			 }
	 
		  	  return nbrHomme;
			 }
	
	 
	
	public int embaucheCTPFemme() {
		int  nbrFemme=0;
		listCtpFolders=Ctp.findAllCtpFolders();
	
		  for(int i=0; i<listCtpFolders.size(); i++) 
			 { 
			  if( listCtpFolders.get(i).getCtpSituation()!=null)
		  	  {
		  
		  	  if(((listCtpFolders.get(i).getCandidates().getSexe().equals("F"))|| (listCtpFolders.get(i).getCandidates().getSexe().equals("f")))&& listCtpFolders.get(i).getCtpSituation().equals("embauche"))
		  	  {
		  		 
		  		  nbrFemme=nbrFemme+1;
		  	  }
		  	  }
			 }
		 
		  	  return nbrFemme;
			 }
	
	
	public int embaucheCTPFemmeSelanAn(String year) {
		int  nbrFemme=0;

		SimpleDateFormat formater = null;		
	 
		formater = new SimpleDateFormat("yyyy");
		listCtpFolders=Ctp.findAllCtpFolders();
	
		  for(int i=0; i<listCtpFolders.size(); i++) 
			 {  
			  if( listCtpFolders.get(i).getCtpSituation().equals("embauche"))
		  	  {
		  
		  	  if((((listCtpFolders.get(i).getCandidates().getSexe().equals("F"))|| (listCtpFolders.get(i).getCandidates().getSexe().equals("f")))&& formater.format(listCtpFolders.get(i).getExitDate()).equals(year)) )
		  	  {
		  		 
		  		  nbrFemme=nbrFemme+1;
		  	  }
		  	  }
			 }
		 
		  	  return nbrFemme;
			 }
	
	public int embaucheCTPFemmeSelanAnMon(String year, String month) {
		int  nbrFemme=0;
		SimpleDateFormat formaterAn = null;		
		SimpleDateFormat formaterMon = null;	
		formaterAn = new SimpleDateFormat("yyyy");		 
		formaterMon = new SimpleDateFormat("MM");
		 	
	  
		listCtpFolders=Ctp.findAllCtpFolders();
	
		  for(int i=0; i<listCtpFolders.size(); i++) 
			 {  
			  if( listCtpFolders.get(i).getCtpSituation().equals("embauche"))
		  	  {
		  
		  	  if((((listCtpFolders.get(i).getCandidates().getSexe().equals("F"))|| (listCtpFolders.get(i).getCandidates().getSexe().equals("f")))&& (formaterAn.format(listCtpFolders.get(i).getExitDate()).equals(year)||formaterMon.format(listCtpFolders.get(i).getExitDate()).equals(month))) )
		  	  {
		  		 
		  		  nbrFemme=nbrFemme+1;
		  	  }
		  	  }
			 }
		 
		  	  return nbrFemme;
			 }
	
	public int embaucheCTPHommeSelanAnMon(String year, String month) {
		int  nbrFemme=0;
		SimpleDateFormat formaterAn = null;		
		SimpleDateFormat formaterMon = null;	
		formaterAn = new SimpleDateFormat("yyyy");		 
		formaterMon = new SimpleDateFormat("MM");
		 	
	  
		listCtpFolders=Ctp.findAllCtpFolders();
	
		  for(int i=0; i<listCtpFolders.size(); i++) 
			 {  
			  if( listCtpFolders.get(i).getCtpSituation().equals("embauche"))
		  	  {
		  
		  	  if((((listCtpFolders.get(i).getCandidates().getSexe().equals("H"))|| (listCtpFolders.get(i).getCandidates().getSexe().equals("h")))&& (formaterAn.format(listCtpFolders.get(i).getExitDate()).equals(year)||formaterMon.format(listCtpFolders.get(i).getExitDate()).equals(month))) )
		  	  {
		  		 
		  		  nbrFemme=nbrFemme+1;
		  	  }
		  	  }
			 }
		 
		  	  return nbrFemme;
			 }
	
	public int embaucheCTPHommeSelanAn(String year) {
		int  nbrHomme=0;

		SimpleDateFormat formater = null;			 
		formater = new SimpleDateFormat("yyyy");
		listCtpFolders=Ctp.findAllCtpFolders();
	
		  for(int i=0; i<listCtpFolders.size(); i++) 
			 {  
			  if( (listCtpFolders.get(i).getCtpSituation().equals("embauche")) )
		  	  {
		  
		  	  if((((listCtpFolders.get(i).getCandidates().getSexe().equals("H"))|| (listCtpFolders.get(i).getCandidates().getSexe().equals("h")))&& formater.format(listCtpFolders.get(i).getExitDate()).equals(year)) )
		  	  {
		  		 
		  		  nbrHomme=nbrHomme+1;
		  	  }
		  	  }
			 }
		 
		  	  return nbrHomme;
			 }
	
	
	
	public int arretAvantTermeHomme() {
		int  nbrHomme=0;
		listCtpFolders=Ctp.findAllCtpFolders();
		   
		  for(int i=0; i<listCtpFolders.size(); i++) 
			 { 
			  if( listCtpFolders.get(i).getCtpSituation()!=null)
		  	  {
		  
		  	  if(((listCtpFolders.get(i).getCandidates().getSexe().equals("H"))|| (listCtpFolders.get(i).getCandidates().getSexe().equals("h")))&& listCtpFolders.get(i).getCtpSituation().equals("arret avant terme"))
		  	  {
	  		  
		  	nbrHomme=nbrHomme+1;
		  	  }
		
			 }
			 }
		  	  return nbrHomme;
			 }	
	
	
	
	
	public int arretAvantTermeHommeSelonAn(String year) {
		SimpleDateFormat formater = null;		
		 
		formater = new SimpleDateFormat("yyyy");
		int  nbrHomme=0;
		listCtpFolders=Ctp.findAllCtpFolders();
		   
		  for(int i=0; i<listCtpFolders.size(); i++) 
			 { 
			  if( listCtpFolders.get(i).getExitDate()!=null)
		  	  {
		  
		  	  if((((listCtpFolders.get(i).getCandidates().getSexe().equals("H"))|| (listCtpFolders.get(i).getCandidates().getSexe().equals("h")))&& listCtpFolders.get(i).getCtpSituation().equals("arret avant terme"))&& (formater.format(listCtpFolders.get(i).getExitDate()).equals(year))) 
		  	  {
	  		  
		  	nbrHomme=nbrHomme+1;
		  	  }
		
			 }
			 }
		  	  return nbrHomme;
			 }	
	
	
	public int arretAvantTermeFemme() {
		int  nbrFemme=0;
		listCtpFolders=Ctp.findAllCtpFolders();
		   
		  for(int i=0; i<listCtpFolders.size(); i++) 
			 { 
			  
			  if( listCtpFolders.get(i).getCtpSituation()!=null)
		  	  {
		  	  if(((listCtpFolders.get(i).getCandidates().getSexe().equals("F"))|| (listCtpFolders.get(i).getCandidates().getSexe().equals("f")))&& listCtpFolders.get(i).getCtpSituation().equals("arret avant terme"))
		  	  {
	  		  
		  		nbrFemme=nbrFemme+1;
		  	  }
		
			 }
			 }
		 
		  	  return nbrFemme;
			 }	
	
	
	
	
	
	public int arretAvantTermeFemmeSelonAn(String year) {
		SimpleDateFormat formater = null;			 
		formater = new SimpleDateFormat("yyyy");
		int  nbrFemme=0;
		listCtpFolders=Ctp.findAllCtpFolders();
		   
		  for(int i=0; i<listCtpFolders.size(); i++) 
			 { 
			  
			  if( listCtpFolders.get(i).getExitDate()!=null)
		  	  {
		  	  if((((listCtpFolders.get(i).getCandidates().getSexe().equals("F"))|| (listCtpFolders.get(i).getCandidates().getSexe().equals("f")))&& listCtpFolders.get(i).getCtpSituation().equals("arret avant terme"))&& formater.format(listCtpFolders.get(i).getExitDate()).equals(year))
		  	  {  
	  		  
		  		nbrFemme=nbrFemme+1;
		  	  }
		
			 }
			 }
		 
		  	  return nbrFemme;
			 }	
	
	
	

	public int arretAvantTermeFemmeSelonAnMon(String year , String month) {
		SimpleDateFormat formaterAn = null;		
		SimpleDateFormat formaterMon = null;	
		formaterAn = new SimpleDateFormat("yyyy");		 
		formaterMon = new SimpleDateFormat("MM");
		int  nbrFemme=0;
		listCtpFolders=Ctp.findAllCtpFolders();
		   
		  for(int i=0; i<listCtpFolders.size(); i++) 
			 { 
			  
			  if( listCtpFolders.get(i).getExitDate()!=null)
		  	  {
		  	  if((((listCtpFolders.get(i).getCandidates().getSexe().equals("F"))|| (listCtpFolders.get(i).getCandidates().getSexe().equals("f")))&& (listCtpFolders.get(i).getCtpSituation().equals("arret avant terme"))&& ((formaterAn.format(listCtpFolders.get(i).getExitDate()).equals(year)&& formaterMon.format(listCtpFolders.get(i).getExitDate()).equals(month) ))))
		  	  {  
	  		  
		  		nbrFemme=nbrFemme+1;
		  	  }
		
			 }
			 }
		 
		  	  return nbrFemme;
			 }	
	
	
	
	public int arretAvantTermeHommeSelonAnMon(String year , String month) {
		SimpleDateFormat formaterAn = null;		
		SimpleDateFormat formaterMon = null;	
		formaterAn = new SimpleDateFormat("yyyy");		 
		formaterMon = new SimpleDateFormat("MM");
		int  nbrFemme=0;
		listCtpFolders=Ctp.findAllCtpFolders();
		   
		  for(int i=0; i<listCtpFolders.size(); i++) 
			 { 
			  
			  if( listCtpFolders.get(i).getExitDate()!=null)
		  	  {
		  	  if((((listCtpFolders.get(i).getCandidates().getSexe().equals("H"))|| (listCtpFolders.get(i).getCandidates().getSexe().equals("h")))&& (listCtpFolders.get(i).getCtpSituation().equals("arret avant terme"))&& ((formaterAn.format(listCtpFolders.get(i).getExitDate()).equals(year)&& formaterMon.format(listCtpFolders.get(i).getExitDate()).equals(month) ))))
		  	  {  
	  		  
		  		nbrFemme=nbrFemme+1;
		  	  }
		
			 }
			 }
		 
		  	  return nbrFemme;
			 }	
	
	
	
	
	
	
	public int OccupationPES() {
		int  nbr=0;
		listCtpFolders=Ctp.findAllCtpFolders();
		   
		  for(int i=0; i<listCtpFolders.size(); i++) 
			 { 
			  
		  
		  	  if(((listCtpFolders.get(i).getCandidates().getSexe().equals("f"))|| (listCtpFolders.get(i).getCandidates().getSexe().equals("f")))&& listCtpFolders.get(i).getCtpSituation().equals("arret avant terme"))
		  	  {
	  		  
		  		nbr=+1;
		  	  }
		
			 }
		 
		  	  return nbr;
			 }	
	
	
	
	
	
	
	
	
	
	
	
	
	public int situationEmbauche() {
		int  nbr=0;
		listCtpFolders=Ctp.findAllCtpFolders();
		   
		  for(int i=0; i<listCtpFolders.size(); i++) 
			 { 
			  
			  if( listCtpFolders.get(i).getCtpSituation()!=null)
		  	  {
		  	  if(listCtpFolders.get(i).getCtpSituation().equals("embauche"))
		  	  {
	  		  
		  		nbr=nbr+1;
		  	  }
		  	  }
			 }
		 
		  	  return nbr;
			 }
	
	public int situationEmbaucheSelonAn(String year) {
		SimpleDateFormat formater = null;			 
		formater = new SimpleDateFormat("yyyy");
		int  nbr=0;
		listCtpFolders=Ctp.findAllCtpFolders();
		   
		  for(int i=0; i<listCtpFolders.size(); i++) 
			 { 
			  
			  if( listCtpFolders.get(i).getCtpSituation()!=null)
		  	  { 
		  	  if((listCtpFolders.get(i).getCtpSituation().equals("embauche"))&& (formater.format(listCtpFolders.get(i).getExitDate()).equals(year)||formater.format(listCtpFolders.get(i).getHiringDate()).equals(year)))
		  	  {
	  		  
		  		nbr=nbr+1;
		  	  }
		  	  }
			 }
		 
		  	  return nbr;
			 }
	
	
	
	
	public int situationEmbaucheSelonAnMon(String year, String month) {
		SimpleDateFormat formaterAn = null;		
		SimpleDateFormat formaterMon = null;	
		formaterAn = new SimpleDateFormat("yyyy");		 
		formaterMon = new SimpleDateFormat("MM");
		
		int  nbr=0;
		listCtpFolders=Ctp.findAllCtpFolders();
		   
		  for(int i=0; i<listCtpFolders.size(); i++) 
			 { 
			  
			  if( listCtpFolders.get(i).getCtpSituation()!=null)
		  	  { 
		  	  if((listCtpFolders.get(i).getCtpSituation().equals("embauche"))&& (formaterAn.format(listCtpFolders.get(i).getExitDate()).equals(year) && formaterMon.format(listCtpFolders.get(i).getExitDate()).equals(month)))
		  	  {
	  		  
		  		nbr=nbr+1;
		  	  }
		  	  }
			 }
		 
		  	  return nbr;
			 }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public int situationRecherchEmploi() {
		int  nbr=0;
		listCtpFolders=Ctp.findAllCtpFolders();
		   
		  for(int i=0; i<listCtpFolders.size(); i++) 
			 { 
			  
			  if( listCtpFolders.get(i).getCtpSituation()!=null)
		  	  {
		  	  if(listCtpFolders.get(i).getCtpSituation().equals("recherche emploi"))
		  	  {
	  		  
		  		nbr=nbr+1;
		  	  }
		  	  }
			 }
		 
		  	  return nbr;
			 }
	
	
	public int situationRecherchEmploiSelonAn(String year) {
		SimpleDateFormat formater = null;			 
		formater = new SimpleDateFormat("yyyy");
		int  nbr=0;
		listCtpFolders=Ctp.findAllCtpFolders();
		   
		  for(int i=0; i<listCtpFolders.size(); i++) 
			 { 
			  
			  if( listCtpFolders.get(i).getCtpSituation()!=null)
		  	  { 
		  	  if((listCtpFolders.get(i).getCtpSituation().equals("recherche emploi"))&& (formater.format(listCtpFolders.get(i).getExitDate()).equals(year)||formater.format(listCtpFolders.get(i).getHiringDate()).equals(year) ))
		  	  {
	  		  
		  		nbr=nbr+1;
		  	  }
		  	  }
			 }
		 
		  	  return nbr;
			 }
 
	
	
	public int situationRecherchEmploiSelonAnMon(String year, String month) {
		SimpleDateFormat formaterAn = null;		
		SimpleDateFormat formaterMon = null;	
		formaterAn = new SimpleDateFormat("yyyy");		 
		formaterMon = new SimpleDateFormat("MM");
		int  nbr=0;
		listCtpFolders=Ctp.findAllCtpFolders();
		   
		  for(int i=0; i<listCtpFolders.size(); i++) 
			 { 
			  
			  if( listCtpFolders.get(i).getCtpSituation()!=null)
		  	  { 
		  	  if((listCtpFolders.get(i).getCtpSituation().equals("recherche emploi"))&& (formaterAn.format(listCtpFolders.get(i).getExitDate()).equals(year)&& formaterMon.format(listCtpFolders.get(i).getExitDate()).equals(month)))
		  	  {
	  		  
		  		nbr=nbr+1;
		  	  }
		  	  }
			 }
		 
		  	  return nbr;
			 }
	
	
	public int situationArretAvantTerme() {
		int  nbr=0;
		listCtpFolders=Ctp.findAllCtpFolders();
		   
		  for(int i=0; i<listCtpFolders.size(); i++) 
			 { 
			  
		  
		  	  if( listCtpFolders.get(i).getCtpSituation().equals("arret avant terme"))
		  	  {
	  		  
		  		nbr=nbr+1;
		  	  }
		
			 }
		 
		  	  return nbr;
			 }	
	
		
	
	
	public int situationArretAvantTermeSelonAn(String year) {
		SimpleDateFormat formater = null;			 
		formater = new SimpleDateFormat("yyyy");
		int  nbr=0;
		listCtpFolders=Ctp.findAllCtpFolders();
		   
		  for(int i=0; i<listCtpFolders.size(); i++) 
			 { 
			  
			  if( listCtpFolders.get(i).getCtpSituation()!=null)
		  	  { 
		  	  if( (listCtpFolders.get(i).getCtpSituation().equals("arret avant terme"))&& (formater.format(listCtpFolders.get(i).getExitDate()).equals(year)|| formater.format(listCtpFolders.get(i).getHiringDate()).equals(year)))
		  	  {
	  		  
		  		nbr=nbr+1;
		  	  }
		
			 }
			 }
		  	  return nbr;
			 }	

	public int situationArretAvantTermeSelonAnMon(String year,String month) {
		SimpleDateFormat formaterAn = null;		
		SimpleDateFormat formaterMon = null;	
		formaterAn = new SimpleDateFormat("yyyy");		 
		formaterMon = new SimpleDateFormat("MM");
		int  nbr=0;
		listCtpFolders=Ctp.findAllCtpFolders();
		   
		  for(int i=0; i<listCtpFolders.size(); i++) 
			 { 
			  
			  if( listCtpFolders.get(i).getCtpSituation()!=null)
		  	  { 
		  	  if( (listCtpFolders.get(i).getCtpSituation().equals("arret avant terme"))&& (formaterAn.format(listCtpFolders.get(i).getExitDate()).equals(year) && formaterMon.format(listCtpFolders.get(i).getExitDate()).equals(month)))
		  	  {
	  		  
		  		nbr=nbr+1;
		  	  }
		
			 }
			 }
		  	  return nbr;
			 }	
	
	
	

	public int certificationEligible() {
		int  nbr=0;
		listCtpFolders=Ctp.findAllCtpFolders();
		   
		  for(int i=0; i<listCtpFolders.size(); i++) 
			 { 
			
			  if( listCtpFolders.get(i).getCertificat()!=null)
		  	  { 
		  	  if( listCtpFolders.get(i).getCertificat()==true)
		  	  { 
	  		  
		  		nbr=nbr+1;
		  	  }
		
		 	  
		  	  }
			 }
		 
		  	  return nbr;
			 }	
	
	
	public int certificationEligibleSelonAn(String year) {
		SimpleDateFormat formater = null;			 
		formater = new SimpleDateFormat("yyyy");
		int  nbr=0;
		String var ;
		listCtpFolders=Ctp.findAllCtpFolders();
		   
		  for(int i=0; i<listCtpFolders.size(); i++) 
			 { 
			
			  if( listCtpFolders.get(i).getCertificat()!=null)
		  	  {
				  if (listCtpFolders.get(i).getExitDate()== null)
				  {
					  var="0000";
				  }
				  else{
					  var=formater.format(listCtpFolders.get(i).getExitDate());
				  }
				  
		  	  if( (listCtpFolders.get(i).getCertificat()==true)&& (var.equals(year)|| formater.format(listCtpFolders.get(i).getEndContractDate()).equals(year)))
		  	  {
	  		  
		  		nbr=nbr+1;
		  	  }
		
		 	  
		  	  }
			 }
		 
		  	  return nbr;
			 }	
	
	
	
	
	
	public int certificationEligibleSelonAnMon(String year, String  month) {
		SimpleDateFormat formaterAn = null;		
		SimpleDateFormat formaterMon = null;	
		formaterAn = new SimpleDateFormat("yyyy");		 
		formaterMon = new SimpleDateFormat("MM");
		int  nbr=0;
		listCtpFolders=Ctp.findAllCtpFolders();
		   
		  for(int i=0; i<listCtpFolders.size(); i++) 
			 { 
			
			  if( listCtpFolders.get(i).getCertificat()!=null)
		  	  {
		  	  if( (listCtpFolders.get(i).getCertificat()==true)&& ((formaterAn.format(listCtpFolders.get(i).getExitDate()).equals(year) && formaterMon.format(listCtpFolders.get(i).getExitDate()).equals(month))|| (formaterAn.format(listCtpFolders.get(i).getEndContractDate()).equals(year) && formaterMon.format(listCtpFolders.get(i).getEndContractDate()).equals(month))))
		  	  {
	  		  
		  		nbr=nbr+1;
		  	  }
		
		 	  
		  	  }
			 }
		 
		  	  return nbr;
			 }	
	
	
	
	
	
	
	
	
	
	
	
	public int certificationNonEligible() {
		int  nbr=0;
		listCtpFolders=Ctp.findAllCtpFolders();
		   
		  for(int i=0; i<listCtpFolders.size(); i++) 
			 { 
			  if( listCtpFolders.get(i).getCertificat()!=null)
		  	  {
		  
		  	  if( listCtpFolders.get(i).getCertificat()==false)
		  	  {
	  		  
		  		nbr=nbr+1;
		  	  }
		  	 
		  	  }
			 }
		 
		  	  return nbr;
			 }	
	
	public int certificationNonEligibleSelonAn(String year) {
		SimpleDateFormat formater = null;			 
		formater = new SimpleDateFormat("yyyy");
		int  nbr=0;
		String var ;
		listCtpFolders=Ctp.findAllCtpFolders();
		   
		  for(int i=0; i<listCtpFolders.size(); i++) 
			 { 
			  if( listCtpFolders.get(i).getCertificat()!=null)
		  	  {
				  if (listCtpFolders.get(i).getExitDate()== null)
				  {
					  var="0000";
				  }
				  else{
					  var=formater.format(listCtpFolders.get(i).getExitDate());
				  }
		  
		  	  if(( listCtpFolders.get(i).getCertificat()==false)&&(var.equals(year)|| formater.format(listCtpFolders.get(i).getEndContractDate()).equals(year)))
		  	  {
	  		  
		  		nbr=nbr+1;
		  	  }
		  	 
		  	  }
			 }
		 
		  	  return nbr;
			 }	
	
	
	
	public int certificationNonEligibleSelonAnMon(String year , String month) {
		SimpleDateFormat formaterAn = null;		
		SimpleDateFormat formaterMon = null;	
		formaterAn = new SimpleDateFormat("yyyy");		 
		formaterMon = new SimpleDateFormat("MM");
		int  nbr=0;
		String varA,varM;
		listCtpFolders=Ctp.findAllCtpFolders();
		   
		  for(int i=0; i<listCtpFolders.size(); i++) 
			 { 
			  if( listCtpFolders.get(i).getCertificat()!=null)
		  	  {
				  if (listCtpFolders.get(i).getExitDate()== null)
				  {
					  varA="0000";
					  varM="00";
				  }
				  else{
					  varA=formaterAn.format(listCtpFolders.get(i).getExitDate());
					  varM=formaterAn.format(listCtpFolders.get(i).getExitDate());
				  }
				  if( (listCtpFolders.get(i).getCertificat()==false)&& ((varA.equals(year) && varM.equals(month))|| (formaterAn.format(listCtpFolders.get(i).getEndContractDate()).equals(year) && formaterMon.format(listCtpFolders.get(i).getEndContractDate()).equals(month))))
					  	   {
	  		  
		  		nbr=nbr+1;
		  	  }
		  	 
		  	  }
			 }
		 
		  	  return nbr;
			 }	
	
	
	
	
	
	
	
	
	
	public int statistiqueELanSelonPoste(String poste) {
	 
		int  nbr=0;
		listCtpFolders=Ctp.findAllCtpFolders();
		   
		  for(int i=0; i<listCtpFolders.size(); i++) 
			 { 
			  
		  
		  	  if( listCtpFolders.get(i).getCandidates().getAdditionalCandidates().getPost().equals(poste))
		  	  {
	  		  
		  		nbr=nbr+1;
		  	  }
		
			 }
		 
		  	  return nbr;
			 }	
	
	
	public int statistiqueELanSelonPosteSelonAn(String poste , String year) {
		SimpleDateFormat formater = null;			 
		formater = new SimpleDateFormat("yyyy");
		int  nbr=0;
		listCtpFolders=Ctp.findAllCtpFolders();
		   
		  for(int i=0; i<listCtpFolders.size(); i++) 
			 { 
			  
		  
		  	  if( (listCtpFolders.get(i).getCandidates().getAdditionalCandidates().getPost().equals(poste))&& ((formater.format(listCtpFolders.get(i).getExitDate()).equals(year))||(formater.format(listCtpFolders.get(i).getHiringDate()).equals(year))))
		  	  {
	  		  
		  		nbr=nbr+1;
		  	  }
		
			 }
		 
		  	  return nbr;
			 }	
	
	
	public int statistiquePesSelonPoste(String poste) {
		int  nbr=0;
		listCtpFolders=Ctp.findAllCtpFolders();
		   
		  for(int i=0; i<listCtpFolders.size(); i++) 
			 { 
			  
		  
		  	  if( listCtpFolders.get(i).getCandidates().getAdditionalCandidates().getPost().equals(poste))
		  	  {
	  		  
		  		nbr=nbr+1;
		  	  }
		
			 }
		 
		  	  return nbr;
			 }	
	
	
	public int statistiquePESSelonPosteSelonAn(String poste , String year) {
		SimpleDateFormat formater = null;			 
		formater = new SimpleDateFormat("yyyy");
		int  nbr=0;
		String var;
		listCtpFolders=Ctp.findAllCtpFolders();
		   
		  for(int i=0; i<listCtpFolders.size(); i++) 
			 { 
			  
			  if( listCtpFolders.get(i).getCertificat()!=null)
		  	  {
				  if (listCtpFolders.get(i).getExitDate()== null)
				  {
					  var="0000"; 
				  }
				  else{
					  var=formater.format(listCtpFolders.get(i).getExitDate());
					   
				  }
		  	  if( (listCtpFolders.get(i).getCandidates().getAdditionalCandidates().getPost().equals(poste))&& ((var.equals(year))||(formater.format(listCtpFolders.get(i).getHiringDate()).equals(year))))
		  	  {
	  		  
		  		nbr=nbr+1;
		  	  }
		
			 }
			 }
		 
		  	  return nbr;
			 }	
	
	
	
	
	public int statistiquePESSelonPosteSelonAnMon(String poste , String year , String month)  {
	 
		SimpleDateFormat formaterAn = null;	 SimpleDateFormat formaterMon = null; SimpleDateFormat formaterDd = null;	
		formaterMon = new SimpleDateFormat("MM");	
		formaterAn = new SimpleDateFormat("yyyy");
		formaterDd = new SimpleDateFormat("dd");
  String d =year+month+"00";
  int k= Integer.parseInt(d); 
  String df =year+month+"31";
  int kl= Integer.parseInt(df);    
 
 String gg ,ss,bb;
   
		int  nbr=0;
		listCtpFolders=Ctp.findAllCtpFolders();
		  
		  for(int i=0; i<listCtpFolders.size(); i++) 
			 { 
			gg=formaterAn.format(listCtpFolders.get(i).getHiringDate())+formaterMon.format(listCtpFolders.get(i).getHiringDate())+formaterDd.format(listCtpFolders.get(i).getHiringDate());
			ss=formaterAn.format(listCtpFolders.get(i).getEndContractDate())+formaterMon.format(listCtpFolders.get(i).getEndContractDate())+formaterDd.format(listCtpFolders.get(i).getEndContractDate());
			
			 if (listCtpFolders.get(i).getExitDate()== null)
			  {
				  bb="000000"; 
			  }
			  else{
				  bb=formaterAn.format(listCtpFolders.get(i).getExitDate())+formaterMon.format(listCtpFolders.get(i).getExitDate())+formaterDd.format(listCtpFolders.get(i).getExitDate());
						
				   
			  }
			
		  
		    	  if(listCtpFolders.get(i).getCandidates().getAdditionalCandidates().getPost().equals(poste)&& kl>=Integer.parseInt(gg)  && k <=Integer.parseInt(ss) && k<=Integer.parseInt(bb)  && Integer.parseInt(bb)<=Integer.parseInt(ss) )
		  	  {
	  		  
		  		nbr=nbr+1;
		  	  }
		
			 }
		 
		  	  return nbr;
			 }	
	
	
	
	

	public int statistiqueElanSelonPosteSelonAnMon(String poste , String year , String month)  {
	 
		SimpleDateFormat formaterAn = null;	 SimpleDateFormat formaterMon = null; SimpleDateFormat formaterDd = null;	
		formaterMon = new SimpleDateFormat("MM");	
		formaterAn = new SimpleDateFormat("yyyy");
		formaterDd = new SimpleDateFormat("dd");
  String d =year+month+"00";
  int k= Integer.parseInt(d); 
  String df =year+month+"31";
  int kl= Integer.parseInt(df);    
 
 String gg ,ss,bb;
  int  pp;
		int  nbr=0;
		listCtpFolders=Ctp.findAllCtpFolders();
		  
		  for(int i=0; i<listCtpFolders.size(); i++) 
			 { 
			gg=formaterAn.format(listCtpFolders.get(i).getHiringDate())+formaterMon.format(listCtpFolders.get(i).getHiringDate())+formaterDd.format(listCtpFolders.get(i).getHiringDate());
			ss=formaterAn.format(listCtpFolders.get(i).getEndContractDate())+formaterMon.format(listCtpFolders.get(i).getEndContractDate())+formaterDd.format(listCtpFolders.get(i).getEndContractDate());
			
			 if (listCtpFolders.get(i).getExitDate()== null)
			  {
				  bb="000000"; 
			  }
			  else{
				  bb=formaterAn.format(listCtpFolders.get(i).getExitDate())+formaterMon.format(listCtpFolders.get(i).getExitDate())+formaterDd.format(listCtpFolders.get(i).getExitDate());
					
				   
			  }
			
		  
		    	  if(listCtpFolders.get(i).getCandidates().getAdditionalCandidates().getPost().equals(poste)&& kl>=Integer.parseInt(gg)  && k <=Integer.parseInt(ss) && k<=Integer.parseInt(bb)  && Integer.parseInt(bb)<=Integer.parseInt(ss) )
		  	  {
	  		  
		  		nbr=nbr+1;
		  	  }
		
			 }
		 
		  	  return nbr;
			 }	
	
	
	 
	
	public int tauxOccupationElanSelonAnMon(String nbrMoi , String post , String year) {

		SimpleDateFormat formaterAn = null;	 SimpleDateFormat formaterMon = null; SimpleDateFormat formaterDd = null;	
		formaterMon = new SimpleDateFormat("MM");	
		formaterAn = new SimpleDateFormat("yyyy");
		formaterDd = new SimpleDateFormat("dd");
		 
  String d =year+nbrMoi+"00";
  int k= Integer.parseInt(d); 
  String df =year+nbrMoi+"31";
  int kl= Integer.parseInt(df);   
  String gg ,ss,bb;
		int  nbr=0;
	 
		listCtpFolders=Ctp.findAllCtpFolders();
			
		  for(int i=0; i<listCtpFolders.size(); i++) 
			 {		 
			  gg=formaterAn.format(listCtpFolders.get(i).getHiringDate())+formaterMon.format(listCtpFolders.get(i).getHiringDate())+formaterDd.format(listCtpFolders.get(i).getHiringDate());
				ss=formaterAn.format(listCtpFolders.get(i).getEndContractDate())+formaterMon.format(listCtpFolders.get(i).getEndContractDate())+formaterDd.format(listCtpFolders.get(i).getEndContractDate());
				  if( listCtpFolders.get(i).getCertificat()!=null)
			  	  {
					  if (listCtpFolders.get(i).getExitDate()== null)
					  {
						  bb="000000"; 
					  }
					  else{
						  bb=formaterAn.format(listCtpFolders.get(i).getExitDate())+formaterMon.format(listCtpFolders.get(i).getExitDate())+formaterDd.format(listCtpFolders.get(i).getExitDate());
							
						   
					  }
				
				
			  
			    	  if(( listCtpFolders.get(i).getMatricule().lastIndexOf(post) !=-1)&& kl>=Integer.parseInt(gg)  && k <=Integer.parseInt(ss) && k<=Integer.parseInt(bb)  && Integer.parseInt(bb)<=Integer.parseInt(ss) )
			  	  
		  	    {  
		  	 
		  		nbr=nbr+1;
		  	  }
		
			 }
			 }
		  	  return nbr;
			 }
	
	
	
	public int tauxOccupationPESSelonAnMon(String nbrMoi , String post , String year) {

		SimpleDateFormat formaterAn = null;	 SimpleDateFormat formaterMon = null; SimpleDateFormat formaterDd = null;	
		formaterMon = new SimpleDateFormat("MM");	
		formaterAn = new SimpleDateFormat("yyyy");
		formaterDd = new SimpleDateFormat("dd");
  String d =year+nbrMoi+"00";
  int k= Integer.parseInt(d); 
  String df =year+nbrMoi+"31";
  int kl= Integer.parseInt(df);   
  String gg ,ss,bb;
		int  nbr=0;
	 
		listCtpFolders=Ctp.findAllCtpFolders();
			
		  for(int i=0; i<listCtpFolders.size(); i++) 
			  
			 {		 
			   
			  gg=formaterAn.format(listCtpFolders.get(i).getHiringDate())+formaterMon.format(listCtpFolders.get(i).getHiringDate())+formaterDd.format(listCtpFolders.get(i).getHiringDate());
				ss=formaterAn.format(listCtpFolders.get(i).getEndContractDate())+formaterMon.format(listCtpFolders.get(i).getEndContractDate())+formaterDd.format(listCtpFolders.get(i).getEndContractDate());
				  if (listCtpFolders.get(i).getExitDate()== null)
				  {
					  bb="000000"; 
				  }
				  else{
					  bb=formaterAn.format(listCtpFolders.get(i).getExitDate())+formaterMon.format(listCtpFolders.get(i).getExitDate())+formaterDd.format(listCtpFolders.get(i).getExitDate());
						
					   
				  }
				
				
			  
			    	  if(( listCtpFolders.get(i).getMatricule().lastIndexOf(post) !=-1)&& kl>=Integer.parseInt(gg)  && k <=Integer.parseInt(ss) && k<=Integer.parseInt(bb)  && Integer.parseInt(bb)<=Integer.parseInt(ss) )
			  	  
		  	    {  
		  	 
		  		nbr=nbr+1;
		  	  }
		
			 }
		 
		  	  return nbr;
			 }
	
	
	
	
	
	
	
	
	
	public int getCurrentYears() {
		 
		return currentYears;
	}

	public void setCurrentYears(int currentYears) {
		 
		this.currentYears = currentYears;
	}

	public CtpFolders getCurrentCtp() {
		return currentCtp;
	}

	public void setCurrentCtp(CtpFolders currentCtp) {
		this.currentCtp = currentCtp;
	}	
	
	
}
