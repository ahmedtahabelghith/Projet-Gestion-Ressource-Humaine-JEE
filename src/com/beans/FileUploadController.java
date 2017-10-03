package com.beans;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
 

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
 









import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import com.business.CtpFoldersBusiness;
import com.dao.CtpFoldersDao;
import com.dao.impl.CtpFoldersDaoImp;
import com.model.AdditionalCandidates;
import com.model.Candidates;
import com.model.CtpFolders;
  
@ManagedBean
@SessionScoped
public class FileUploadController implements Serializable{
	private UploadedFile file1=null;
	private UploadedFile file2=null;
	private UploadedFile file3=null;
	private UploadedFile file4=null;
	private UploadedFile file5=null;
	private UploadedFile file6=null;
	private UploadedFile file7=null;
 
	private CtpFoldersDao CtpDao = new CtpFoldersDaoImp();
	private  CtpFoldersBusiness c = new CtpFoldersBusiness();
	private  AdditionalCandidates ad = new AdditionalCandidates();
	private  Candidates can = new Candidates();
	
	public String uploadCvInitial(CtpFolders curent) {
		   
			    if(file1 != null) {  
			  	  System.out.println("the file is" +file1);
			        FacesMessage msg = new FacesMessage("Succesful" + file1.getFileName() + " is uploaded.");  
			        FacesContext.getCurrentInstance().addMessage(null, msg);  

			        try {
			        	String ext = file1.getFileName().substring(file1.getFileName().lastIndexOf("."));
			        	new File("E:\\env_dev\\workspace\\AppGestionRH\\WebContent\\cvCTP\\cvinitial"+curent.getCandidates().getFirstName()+curent.getCandidates().getLastName()+ext).delete();
					       copyFileCv("cvinitial"+curent.getCandidates().getFirstName()+curent.getCandidates().getLastName()+ext, file1.getInputstream());
					       
					    
					        
					       curent.setInitialCv(curent.getCandidates().getFirstName()+curent.getCandidates().getLastName()+ext);
					        
					       			       
					       
					       
					       CtpDao.saveOrUpdate(curent);  
							CtpDao.saveOrUpdate(curent.getCandidates());   
					       
					       
			} catch (IOException y) {
			    y.printStackTrace();
			  }
			    }
			    System.out.println("uploaf finished");
			    return "modifierDossierCTP.xhtml";
			}  
	
	
	
	
	
	public String uploadCvModifier(CtpFolders curent) {
		   
	    if(file2 != null) {  
	  	  System.out.println("the file is" +file2);
	        FacesMessage msg = new FacesMessage("Succesful" + file2.getFileName() + " is uploaded.");  
	        FacesContext.getCurrentInstance().addMessage(null, msg);  

	        try {
	        	String ext = file2.getFileName().substring(file2.getFileName().lastIndexOf("."));
	        	new File("E:\\env_dev\\workspace\\AppGestionRH\\WebContent\\cvCTP\\cvmodifie"+curent.getCandidates().getFirstName()+curent.getCandidates().getLastName()+ext).delete();
			       copyFileCv("cvmodifie"+curent.getCandidates().getFirstName()+curent.getCandidates().getLastName()+ext, file2.getInputstream());
			       
			       curent.setCustomCv(curent.getCandidates().getFirstName()+curent.getCandidates().getLastName()+ext);

			       CtpDao.saveOrUpdate(curent);  
				   CtpDao.saveOrUpdate(curent.getCandidates());   
	} catch (IOException y) {
	    y.printStackTrace();
	  }
	    }
	    return "modifierDossierCTP.xhtml";
	     
	}  
	
	
	
	
	public String uploadAssurance(CtpFolders curent) {
		   
	    if(file3 != null) {  
	  	  System.out.println("the file is" +file3);
	        FacesMessage msg = new FacesMessage("Succesful" + file3.getFileName() + " is uploaded.");  
	        FacesContext.getCurrentInstance().addMessage(null, msg);  

	        try {
	        	String ext = file3.getFileName().substring(file3.getFileName().lastIndexOf("."));
	        	new File("E:\\env_dev\\workspace\\AppGestionRH\\WebContent\\assurancesCTP\\assurance"+curent.getCandidates().getFirstName()+curent.getCandidates().getLastName()+ext).delete();
			       copyFileAssurance("assurance"+curent.getCandidates().getFirstName()+curent.getCandidates().getLastName()+ext, file3.getInputstream());
			       
			       
			       curent.setAssuranceCopy(curent.getCandidates().getFirstName()+curent.getCandidates().getLastName()+ext);
			       CtpDao.saveOrUpdate(curent);  
				   CtpDao.saveOrUpdate(curent.getCandidates());
			       
	} catch (IOException y) {
	    y.printStackTrace();
	  }
	    }
	    System.out.println("uploaf finished");
	    return "modifierDossierCTP.xhtml";
	}  
	
	
	
	
	public String uploadCIN(CtpFolders curent) {
		   
	    if(file4 != null) {  
	  	  System.out.println("the file is" +file4);
	        FacesMessage msg = new FacesMessage("Succesful" + file4.getFileName() + " is uploaded.");  
	        FacesContext.getCurrentInstance().addMessage(null, msg);  

	        try {
	        	String ext = file4.getFileName().substring(file4.getFileName().lastIndexOf("."));
	        	new File("E:\\env_dev\\workspace\\AppGestionRH\\WebContent\\cinCTP\\cin"+curent.getCandidates().getFirstName()+curent.getCandidates().getLastName()+ext).delete();
			       copyFileCin("cin"+curent.getCandidates().getFirstName()+curent.getCandidates().getLastName()+ext, file4.getInputstream());
			       
			       curent.setCinCopy(curent.getCandidates().getFirstName()+curent.getCandidates().getLastName()+ext);
			       CtpDao.saveOrUpdate(curent);  
				   CtpDao.saveOrUpdate(curent.getCandidates());
			       
	} catch (IOException y) {
	    y.printStackTrace();
	  }
	    }
	    System.out.println("uploaf finished");
	    return "modifierDossierCTP.xhtml";
	}  
	
	
	
	
	public String uploadEvaluationTestPresProfile(CtpFolders curent) {
		   
	    if(file5 != null) {  
	  	  System.out.println("the file is" +file5);
	        FacesMessage msg = new FacesMessage("Succesful" + file5.getFileName() + " is uploaded.");  
	        FacesContext.getCurrentInstance().addMessage(null, msg);  

	        try {
	        	String ext = file5.getFileName().substring(file5.getFileName().lastIndexOf("."));
	        	new File("E:\\env_dev\\workspace\\AppGestionRH\\WebContent\\evaluationTestPresProfileCTP\\testprofil"+curent.getCandidates().getFirstName()+curent.getCandidates().getLastName()+ext).delete();
			       copyFileEvaluationTestPresProfile("testprofil"+curent.getCandidates().getFirstName()+curent.getCandidates().getLastName()+ext, file5.getInputstream());
			      
			       curent.setEvaluationTestPresProfile(curent.getCandidates().getFirstName()+curent.getCandidates().getLastName()+ext);
			       CtpDao.saveOrUpdate(curent);  
				   CtpDao.saveOrUpdate(curent.getCandidates());
	        } catch (IOException y) {
	    y.printStackTrace();
	  }
	    }
	    System.out.println("uploaf finished");
	    return "modifierDossierCTP.xhtml";
	} 
	
	

	public String uploadDiplomeCTP(CtpFolders curent) {
		 
	    if(file6 != null) {  
	 System.out.println(file6.getFileName()+" jjjj");
	  	  System.out.println("the file is" +file6);
	        FacesMessage msg = new FacesMessage("Succesful" + file6.getFileName() + " is uploaded.");  
	        FacesContext.getCurrentInstance().addMessage(null, msg);  

	        try {   	
	        	String ext = file6.getFileName().substring(file6.getFileName().lastIndexOf("."));
	        	System.out.println(ext);
	        	new File("E:\\env_dev\\workspace\\AppGestionRH\\WebContent\\diplomeCTP\\diplome"+curent.getCandidates().getFirstName()+curent.getCandidates().getLastName()+ext).delete();
	        	 
			       copyFileDiplomeCTP("diplome"+curent.getCandidates().getFirstName()+curent.getCandidates().getLastName()+ext, file6.getInputstream());
			       curent.setDiplomaCopy(curent.getCandidates().getFirstName()+curent.getCandidates().getLastName()+ext);
			       CtpDao.saveOrUpdate(curent);  
				   CtpDao.saveOrUpdate(curent.getCandidates());
			       
			       
	} catch (IOException y) {
	    y.printStackTrace();
	  }
	    }
	    System.out.println("uploaf finished");
	    return "modifierDossierCTP.xhtml";
	} 
	
	
	

	public String uploadPhoto(CtpFolders curent) {
		   
	    if(file7 != null) {  
	    	 System.out.println(file6.getFileName()+" jjjj");
	  	  System.out.println("the file is" +file7);
	        FacesMessage msg = new FacesMessage("Succesful" + file7.getFileName() + " is uploaded.");  
	        FacesContext.getCurrentInstance().addMessage(null, msg);  

	        try {
	        	String ext = file7.getFileName().substring(file7.getFileName().lastIndexOf("."));
	        	
	        	new File("E:\\env_dev\\workspace\\AppGestionRH\\WebContent\\images\\imagesCTP\\"+curent.getCandidates().getFirstName()+curent.getCandidates().getLastName()+ext).delete();
			       copyFilePhoto(curent.getCandidates().getFirstName()+curent.getCandidates().getLastName()+ext, file7.getInputstream());
			     
			        curent.setPhoto(curent.getCandidates().getFirstName()+curent.getCandidates().getLastName()+ext);
			        
			        CtpDao.saveOrUpdate(curent);  
					   CtpDao.saveOrUpdate(curent.getCandidates());
	} catch (IOException y) {
	    y.printStackTrace();
	  }
	    }
	    System.out.println("uploaf finished");
	    return "modifierDossierCTP.xhtml";
	 
	} 
	

	
	
	
	
	
	
	
	
//------------------------------------------------------------------------------------------------------------------------------------------------------
 	
	public void copyFileCv(String fileName, InputStream in) { try {

        // write the inputStream to a FileOutputStream
         OutputStream out = new FileOutputStream(new File("E:\\env_dev\\workspace\\AppGestionRH\\WebContent\\cvCTP\\" + fileName));

      int read = 0;
    byte[] bytes = new byte[1024];

     while ((read = in.read(bytes)) != -1) {
          out.write(bytes, 0, read);
      }

      in.close();
    out.flush();
      out.close();

 System.out.println("New file created!");
     } catch (IOException e) {
   System.out.println(e.getMessage());
   }
}
	
	
	
	
	public void copyFileAssurance(String fileName, InputStream in) { try {

        // write the inputStream to a FileOutputStream
         OutputStream out = new FileOutputStream(new File("E:\\env_dev\\workspace\\AppGestionRH\\WebContent\\assurancesCTP\\" + fileName));

      int read = 0;
    byte[] bytes = new byte[1024];

     while ((read = in.read(bytes)) != -1) {
          out.write(bytes, 0, read);
      }

      in.close();
    out.flush();
      out.close();

 System.out.println("New file created!");
     } catch (IOException e) {
   System.out.println(e.getMessage());
   }
}
	
	
	public void copyFileCin(String fileName, InputStream in) { try {

        // write the inputStream to a FileOutputStream
         OutputStream out = new FileOutputStream(new File("E:\\env_dev\\workspace\\AppGestionRH\\WebContent\\cinCTP\\" + fileName));

      int read = 0;
    byte[] bytes = new byte[1024];

     while ((read = in.read(bytes)) != -1) {
          out.write(bytes, 0, read);
      }

      in.close();
    out.flush();
      out.close();

 System.out.println("New file created!");
     } catch (IOException e) {
   System.out.println(e.getMessage());
   }
}
	
	public void copyFileEvaluationTestPresProfile(String fileName, InputStream in) { try {

        // write the inputStream to a FileOutputStream
         OutputStream out = new FileOutputStream(new File("E:\\env_dev\\workspace\\AppGestionRH\\WebContent\\evaluationTestPresProfileCTP\\" + fileName));

      int read = 0;
    byte[] bytes = new byte[1024];

     while ((read = in.read(bytes)) != -1) {
          out.write(bytes, 0, read);
      }

      in.close();
    out.flush();
      out.close();

 System.out.println("New file created!");
     } catch (IOException e) {
   System.out.println(e.getMessage());
   }
}
	
	
	
	public void copyFileDiplomeCTP(String fileName, InputStream in) { try {

        // write the inputStream to a FileOutputStream
         OutputStream out = new FileOutputStream(new File("E:\\env_dev\\workspace\\AppGestionRH\\WebContent\\diplomeCTP\\" + fileName));

      int read = 0;
    byte[] bytes = new byte[1024];

     while ((read = in.read(bytes)) != -1) {
          out.write(bytes, 0, read);
      }

      in.close();
    out.flush();
      out.close();

 System.out.println("New file created!");
     } catch (IOException e) {
   System.out.println(e.getMessage());
   }
}
	
	

	
	public void copyFilePhoto(String fileName, InputStream in) { try {

        // write the inputStream to a FileOutputStream
         OutputStream out = new FileOutputStream(new File("E:\\env_dev\\workspace\\AppGestionRH\\WebContent\\images\\imagesCTP\\" + fileName));

      int read = 0;
    byte[] bytes = new byte[1024];

     while ((read = in.read(bytes)) != -1) {
          out.write(bytes, 0, read);
      }

      in.close();
    out.flush();
      out.close();

 System.out.println("New file created!");
     } catch (IOException e) {
   System.out.println(e.getMessage());
   }
}





	public UploadedFile getFile1() {
		return file1;
	}





	public void setFile1(UploadedFile file1) {
		this.file1 = file1;
	}





	public UploadedFile getFile2() {
		return file2;
	}





	public void setFile2(UploadedFile file2) {
		this.file2 = file2;
	}





	public UploadedFile getFile3() {
		return file3;
	}





	public void setFile3(UploadedFile file3) {
		this.file3 = file3;
	}





	public UploadedFile getFile4() {
		return file4;
	}





	public void setFile4(UploadedFile file4) {
		this.file4 = file4;
	}





	public UploadedFile getFile5() {
		return file5;
	}





	public void setFile5(UploadedFile file5) {
		this.file5 = file5;
	}





	public UploadedFile getFile6() {
		return file6;
	}





	public void setFile6(UploadedFile file6) {
		this.file6 = file6;
	}





	public UploadedFile getFile7() {
		return file7;
	}





	public void setFile7(UploadedFile file7) {
		this.file7 = file7;
	}




 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
 
	
	
	
	
	
	
	
	
}