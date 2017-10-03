package com.beans;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.application.NavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.business.CtpFoldersBusiness;
import com.business.UsersBusiness;
import com.dao.CtpFoldersDao;
import com.dao.impl.CtpFoldersDaoImp;
import com.model.CtpFolders;
import com.model.Users;
@ManagedBean
@SessionScoped
public class connexion {
	 
 
	private String mdp="";
	private String login="";

	private CtpFoldersDao CtpDao = new CtpFoldersDaoImp();
	private CtpFolders Ctp = new CtpFolders();
	private CtpFoldersBusiness CtpB = new CtpFoldersBusiness();
	private UsersBusiness UsersB = new UsersBusiness();
	private CtpFolders  currentCtp=new CtpFolders();
	private List<CtpFolders> listCtpFolders = new ArrayList();
	private Users users = new Users();
	private CtpFolders userConnecte=new CtpFolders();
	int i = 0;



	

	public void connexionUser(String role) {  
		
		FacesContext facesContext = FacesContext.getCurrentInstance();
		List<Users> lst = UsersB.findAllUsers(); 
		boolean test=false;

		int i = 0;
		 
			while (i <= lst.size() && test==false) { 
		 
					  
			if(lst.get(i).getLogin().equals(login) && lst.get(i).getPassword().equals(mdp) && lst.get(i).getRole().equals(role) )
				{test=true;
				
					 }
			else
				i++;
			 
		}
		
			if (test==true && role.equals("RRH"))
			{	
			
			try {
			
				facesContext.getExternalContext().redirect("RRH/tableauEtatCTP.xhtml");
			}
			 catch (Exception e) {
				e.printStackTrace();
			}
			
	}
			
			else if (test==true && role.equals("coach"))
			{	
			
			try {
			
				facesContext.getExternalContext().redirect("coach/tableauEtatCTP.xhtml");
			}
			 catch (Exception e) {
				e.printStackTrace();
			}
			
	}
			
			
			else if (test==true && role.equals("candidate"))
			{	
			
			try {
			
				facesContext.getExternalContext().redirect("candidat/sousMenuCandidat.xhtml");
			}
			 catch (Exception e) {
				e.printStackTrace();
			}
			
	}		
			
			
			else if (test==true && role.equals("visitor"))
			{	
			
			try {
			
				facesContext.getExternalContext().redirect("visitor/tableauEtatCTP.xhtml");
			}
			 catch (Exception e) {
				e.printStackTrace();
			}
			
	}			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		 
				FacesMessage message = new FacesMessage("password invalides");
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage(null, message);
			}
	 			 
			
  
 



	public String getMdp() {
		return mdp;
	}



	public void setMdp(String mdp) {
		this.mdp = mdp;
	}







	public String getLogin() {
		return login;
	}







	public void setLogin(String login) {
		this.login = login;
	}


 
	
	
	
	}
 
	
	
	



	
	
	 
