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
import com.dao.QuestionEvaluationDao;
import com.dao.impl.QuestionEvaluationDaoImp;
import com.model.AdditionalCandidates;
import com.model.Candidates;
import com.model.CtpFolders;
import com.model.EvaluationExperience;
import com.model.QuestionEvaluation;
import com.model.SheetInformation;
import com.model.Users;

 

@ManagedBean
@SessionScoped
public class questionEvaluationBean {
 
	private QuestionEvaluationDao QuestionEvaluationDao = new QuestionEvaluationDaoImp();

	private QuestionEvaluation QuestionEvaluation = new QuestionEvaluation();

	private QuestionEvaluation  currentQuestionEvaluation = new QuestionEvaluation(); 

	private List<QuestionEvaluation> listQuestionEvaluation = new ArrayList();

	
	
	private QuestionEvaluation questionEval1= new QuestionEvaluation();
	private QuestionEvaluation questionEval2= new QuestionEvaluation();
	private QuestionEvaluation questionEval3= new QuestionEvaluation();
	private QuestionEvaluation questionEval4= new QuestionEvaluation();
	private QuestionEvaluation questionEval5= new QuestionEvaluation();
	private QuestionEvaluation questionEval6= new QuestionEvaluation();
	private QuestionEvaluation questionEval7= new QuestionEvaluation();
	private QuestionEvaluation questionEval8= new QuestionEvaluation();
	private QuestionEvaluation questionEval9= new QuestionEvaluation();
	private QuestionEvaluation questionEval10= new QuestionEvaluation();
	private QuestionEvaluation questionEval11= new QuestionEvaluation();
	private QuestionEvaluation questionEval12= new QuestionEvaluation();
	private QuestionEvaluation questionEval13= new QuestionEvaluation();
	private QuestionEvaluation questionEval14= new QuestionEvaluation();
	private QuestionEvaluation questionEval15= new QuestionEvaluation();
	private QuestionEvaluation questionEval16= new QuestionEvaluation();
	private QuestionEvaluation questionEval17= new QuestionEvaluation();
	private QuestionEvaluation questionEval18= new QuestionEvaluation();
	private QuestionEvaluation questionEval19= new QuestionEvaluation();
	private QuestionEvaluation questionEval20= new QuestionEvaluation();
	private QuestionEvaluation questionEval21= new QuestionEvaluation();
	private QuestionEvaluation questionEval22= new QuestionEvaluation();
	private QuestionEvaluation questionEval23= new QuestionEvaluation();
	private QuestionEvaluation questionEval24= new QuestionEvaluation();
	private QuestionEvaluation questionEval25= new QuestionEvaluation();
	private QuestionEvaluation questionEval26= new QuestionEvaluation();
	private QuestionEvaluation questionEval27= new QuestionEvaluation();
	private QuestionEvaluation questionEval28= new QuestionEvaluation();
	
	private QuestionEvaluationBusiness QuestionEvaluationBus = new QuestionEvaluationBusiness(); 
	 
	private CtpFoldersBusiness ctpFolders= new CtpFoldersBusiness();
 
	
	private EvaluationExperience evaluation=new EvaluationExperience();
	private int idEvaluation;
	
 	
	
 	
 	
 	
 	 
 	public void saveEvaluation() { 
 		FacesContext facesContext = FacesContext.getCurrentInstance();
 		QuestionEvaluationBusiness qe =new QuestionEvaluationBusiness();
 		List<QuestionEvaluation> lst = new ArrayList();
 		lst=qe.findAllQuestionEvaluation();
 		
 		for(int i=0;i<lst.size();i++)
 		{
 			if(lst.get(i).getEvaluationExperience().getIdEvaluation()==idEvaluation)
 			{
 				QuestionEvaluationDao.delete(lst.get(i));
 				 
 			}
 		
 		}
 	
 		
 		evaluation.setIdEvaluation(this.idEvaluation);
 
 
 
   		questionEval1.setEvaluationExperience(evaluation);
   		questionEval1.setQuestion("Votre expérience en entreprise d'entrainement vous a-t-elle globalement convenu ?");
   		QuestionEvaluationDao.saveOrUpdate(questionEval1); 
   		
   		questionEval2.setEvaluationExperience(evaluation);
   		questionEval2.setQuestion("Quels étaient les points forts de cette expérience, qu’avez-vous le plus apprécié ?");
   		QuestionEvaluationDao.saveOrUpdate(questionEval2); 
   		
   		questionEval3.setEvaluationExperience(evaluation);
   		questionEval3.setQuestion("Et qu’avez-vous le moins apprécié ?");
   		QuestionEvaluationDao.saveOrUpdate(questionEval3); 
   		
   		questionEval4.setEvaluationExperience(evaluation);
   		questionEval4.setQuestion("Durée (3 mois)");
   		QuestionEvaluationDao.saveOrUpdate(questionEval4); 
   		
   		questionEval5.setEvaluationExperience(evaluation);
   		questionEval5.setQuestion("Réponse à vos besoins");
   		QuestionEvaluationDao.saveOrUpdate(questionEval5); 
   		
   		questionEval6.setEvaluationExperience(evaluation);
   		questionEval6.setQuestion("Equipements et espace de travail");
   		QuestionEvaluationDao.saveOrUpdate(questionEval6); 
   		
   		questionEval7.setEvaluationExperience(evaluation);
   		questionEval7.setQuestion("Organisation et rigueur du travail");
   		QuestionEvaluationDao.saveOrUpdate(questionEval7); 
   		
   		questionEval8.setEvaluationExperience(evaluation);
   		questionEval8.setQuestion("Ambiance du groupe et climat de travail");
   		QuestionEvaluationDao.saveOrUpdate(questionEval8); 
   		
   		questionEval9.setEvaluationExperience(evaluation);
   		questionEval9.setQuestion("Rythme, horaires et volume de travail");
   		QuestionEvaluationDao.saveOrUpdate(questionEval9); 
   		
   		questionEval10.setEvaluationExperience(evaluation);
   		questionEval10.setQuestion("Niveau d’exigence");
   		QuestionEvaluationDao.saveOrUpdate(questionEval10); 
   		
   		questionEval11.setEvaluationExperience(evaluation);
   		questionEval11.setQuestion("Qualité de l’encadrement");
   		QuestionEvaluationDao.saveOrUpdate(questionEval11); 
   		
   		questionEval12.setEvaluationExperience(evaluation);
   		questionEval12.setQuestion("Fréquence et intérêt des réunions de coordination");
   		QuestionEvaluationDao.saveOrUpdate(questionEval12); 
   		
   		questionEval13.setEvaluationExperience(evaluation);
   		questionEval13.setQuestion("Accompagnement pour la recherche d'emploi");
   		QuestionEvaluationDao.saveOrUpdate(questionEval13); 
   		
   		questionEval14.setEvaluationExperience(evaluation);
   		questionEval14.setQuestion("Les objectifs de formation ont-ils été définis avec vous ?");
   		QuestionEvaluationDao.saveOrUpdate(questionEval14); 
   		
   		questionEval15.setEvaluationExperience(evaluation);
   		questionEval15.setQuestion("Les objectifs de formation ont-ils été atteints ?");
   		QuestionEvaluationDao.saveOrUpdate(questionEval15); 
   		
   		questionEval16.setEvaluationExperience(evaluation);
   		questionEval16.setQuestion("Les tâches qui vous ont été attribuées étaient-elles adaptées à vos compétences ?");
   		QuestionEvaluationDao.saveOrUpdate(questionEval16); 
   		
   		questionEval17.setEvaluationExperience(evaluation);
   		questionEval17.setQuestion("Etes-vous satisfaits des compétences que vous avez acquises ?");
   		QuestionEvaluationDao.saveOrUpdate(questionEval17); 
   		
   		questionEval18.setEvaluationExperience(evaluation);
   		questionEval18.setQuestion("Les encadrants savent-ils mobiliser les ETP ? (donnent envie d'apprendre, font participer,...)");
   		QuestionEvaluationDao.saveOrUpdate(questionEval18); 
   		
   		questionEval19.setEvaluationExperience(evaluation);
   		questionEval19.setQuestion("Les encadrants savent-ils s'adapter à vos demandes ?");
   		QuestionEvaluationDao.saveOrUpdate(questionEval19); 
   		
   		questionEval20.setEvaluationExperience(evaluation);
   		questionEval20.setQuestion("Estimez-vous que cette formation vous aidera à être plus performant dans votre futur travail ?");
   		QuestionEvaluationDao.saveOrUpdate(questionEval20); 
   		
   		questionEval21.setEvaluationExperience(evaluation);
   		questionEval21.setQuestion("Cette expérience vous ouvre-t-elle de nouvelles perspectives ?");
   		QuestionEvaluationDao.saveOrUpdate(questionEval21); 
   		
   		questionEval22.setEvaluationExperience(evaluation);
   		questionEval22.setQuestion("Avez-vous l'impression que cette formation va changer quelque chose dans votre comportement ou dans votre compréhension (que ce soit dans le domaine professionnel, la vie privée, etc.) ?");
   		QuestionEvaluationDao.saveOrUpdate(questionEval22); 
   		
   		questionEval23.setEvaluationExperience(evaluation);
   		questionEval23.setQuestion("Que comptez-vous faire immédiatement après la formation pour valoriser ce que vous avez appris ?");
   		QuestionEvaluationDao.saveOrUpdate(questionEval23); 
   		
   		questionEval24.setEvaluationExperience(evaluation);
   		questionEval24.setQuestion("Seriez-vous prêt à contribuer financièrement pour suivre une telle formation ?");
   		QuestionEvaluationDao.saveOrUpdate(questionEval24); 
   		
   		questionEval25.setEvaluationExperience(evaluation);
   		questionEval25.setQuestion("Conseillerez-vous cette expérience à d'autres personnes ?");
   		QuestionEvaluationDao.saveOrUpdate(questionEval25); 
   		
   		questionEval26.setEvaluationExperience(evaluation);
   		questionEval26.setQuestion("Si vous deviez suivre à nouveau cette formation, que proposeriez-vous pour l'améliorer ?");
   		QuestionEvaluationDao.saveOrUpdate(questionEval26); 
   		
   		questionEval27.setEvaluationExperience(evaluation);
   		questionEval27.setQuestion("Etes-vous intéressés à rester en contact avec d’autres ETP, avec les encadrants et/ou les ee en général ?");
   		QuestionEvaluationDao.saveOrUpdate(questionEval27); 
   		
   		questionEval28.setEvaluationExperience(evaluation);
   		questionEval28.setQuestion("Souhaitez-vous ajouter quelque chose ?");
   		QuestionEvaluationDao.saveOrUpdate(questionEval28);  
   		
try {
			
			facesContext.getExternalContext().redirect("sousMenuCandidat.xhtml");
		}
		 catch (Exception e) {
			e.printStackTrace();
		} 
    
 	}
 	
 	
 	
 	
 	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public QuestionEvaluation getQuestionEval1() {
		System.out.println("get");
		return questionEval1;
	}
	public void setQuestionEval1(QuestionEvaluation questionEval1) {
		System.out.println("set");
		this.questionEval1 = questionEval1;
	}
	 
	public void setQuestionEval2(QuestionEvaluation questionEval2) {
		this.questionEval2 = questionEval2;
	}
	
	public QuestionEvaluation getQuestionEval2() {
		return questionEval2;
	}


	public QuestionEvaluation getQuestionEval3() {
		return questionEval3;
	}
	public void setQuestionEval3(QuestionEvaluation questionEval3) {
		this.questionEval3 = questionEval3;
	}
	public QuestionEvaluation getQuestionEval4() {
		return questionEval4;
	}
	public void setQuestionEval4(QuestionEvaluation questionEval4) {
		this.questionEval4 = questionEval4;
	}
	public QuestionEvaluation getQuestionEval5() {
		return questionEval5;
	}
	public void setQuestionEval5(QuestionEvaluation questionEval5) {
		this.questionEval5 = questionEval5;
	}
	public QuestionEvaluation getQuestionEval6() {
		return questionEval6;
	}
	public void setQuestionEval6(QuestionEvaluation questionEval6) {
		this.questionEval6 = questionEval6;
	}
	public QuestionEvaluation getQuestionEval7() {
		return questionEval7;
	}
	public void setQuestionEval7(QuestionEvaluation questionEval7) {
		this.questionEval7 = questionEval7;
	}
	public QuestionEvaluation getQuestionEval8() {
		return questionEval8;
	}
	public void setQuestionEval8(QuestionEvaluation questionEval8) {
		this.questionEval8 = questionEval8;
	}
	public QuestionEvaluation getQuestionEval9() {
		return questionEval9;
	}
	public void setQuestionEval9(QuestionEvaluation questionEval9) {
		this.questionEval9 = questionEval9;
	}
	public QuestionEvaluation getQuestionEval10() {
		return questionEval10;
	}
	public void setQuestionEval10(QuestionEvaluation questionEval10) {
		this.questionEval10 = questionEval10;
	}
	public QuestionEvaluation getQuestionEval11() {
		return questionEval11;
	}
	public void setQuestionEval11(QuestionEvaluation questionEval11) {
		this.questionEval11 = questionEval11;
	}
	public QuestionEvaluation getQuestionEval12() {
		return questionEval12;
	}
	public void setQuestionEval12(QuestionEvaluation questionEval12) {
		this.questionEval12 = questionEval12;
	}
	public QuestionEvaluation getQuestionEval13() {
		return questionEval13;
	}
	public void setQuestionEval13(QuestionEvaluation questionEval13) {
		this.questionEval13 = questionEval13;
	}
	public QuestionEvaluation getQuestionEval14() {
		return questionEval14;
	}
	public void setQuestionEval14(QuestionEvaluation questionEval14) {
		this.questionEval14 = questionEval14;
	}
	public QuestionEvaluation getQuestionEval15() {
		return questionEval15;
	}
	public void setQuestionEval15(QuestionEvaluation questionEval15) {
		this.questionEval15 = questionEval15;
	}
	public QuestionEvaluation getQuestionEval16() {
		return questionEval16;
	}
	public void setQuestionEval16(QuestionEvaluation questionEval16) {
		this.questionEval16 = questionEval16;
	}
	public QuestionEvaluation getQuestionEval17() {
		return questionEval17;
	}
	public void setQuestionEval17(QuestionEvaluation questionEval17) {
		this.questionEval17 = questionEval17;
	}
	public QuestionEvaluation getQuestionEval18() {
		return questionEval18;
	}
	public void setQuestionEval18(QuestionEvaluation questionEval18) {
		this.questionEval18 = questionEval18;
	}
	public QuestionEvaluation getQuestionEval19() {
		return questionEval19;
	}
	public void setQuestionEval19(QuestionEvaluation questionEval19) {
		this.questionEval19 = questionEval19;
	}
	public QuestionEvaluation getQuestionEval20() {
		return questionEval20;
	}
	public void setQuestionEval20(QuestionEvaluation questionEval20) {
		this.questionEval20 = questionEval20;
	}
	public QuestionEvaluation getQuestionEval21() {
		return questionEval21;
	}
	public void setQuestionEval21(QuestionEvaluation questionEval21) {
		this.questionEval21 = questionEval21;
	}
	public QuestionEvaluation getQuestionEval22() {
		return questionEval22;
	}
	public void setQuestionEval22(QuestionEvaluation questionEval22) {
		this.questionEval22 = questionEval22;
	}
	public QuestionEvaluation getQuestionEval23() {
		return questionEval23;
	}
	public void setQuestionEval23(QuestionEvaluation questionEval23) {
		this.questionEval23 = questionEval23;
	}
	public QuestionEvaluation getQuestionEval24() {
		return questionEval24;
	}
	public void setQuestionEval24(QuestionEvaluation questionEval24) {
		this.questionEval24 = questionEval24;
	}
	public QuestionEvaluation getQuestionEval25() {
		return questionEval25;
	}
	public void setQuestionEval25(QuestionEvaluation questionEval25) {
		this.questionEval25 = questionEval25;
	}
	public QuestionEvaluation getQuestionEval26() {
		return questionEval26;
	}
	public void setQuestionEval26(QuestionEvaluation questionEval26) {
		this.questionEval26 = questionEval26;
	}
	public QuestionEvaluation getQuestionEval27() {
		return questionEval27;
	}
	public void setQuestionEval27(QuestionEvaluation questionEval27) {
		this.questionEval27 = questionEval27;
	}
	public QuestionEvaluation getQuestionEval28() {
		return questionEval28;
	}
	public void setQuestionEval28(QuestionEvaluation questionEval28) {
		this.questionEval28 = questionEval28;
	}
















 





	public int getIdEvaluation() {
		return idEvaluation;
	}
  
	public void setIdEvaluation(int idEvaluation) {
		this.idEvaluation = idEvaluation;
	}


 




 
	 
	
	

}
