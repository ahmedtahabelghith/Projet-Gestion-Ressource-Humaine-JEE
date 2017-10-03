package com.business;

import java.util.ArrayList; 
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.beans.questionEvaluationBean;
import com.dao.QuestionEvaluationDao;
import com.dao.impl.QuestionEvaluationDaoImp;
import com.model.QuestionEvaluation;

 

@ManagedBean
@SessionScoped

public class QuestionEvaluationBusiness {

	private QuestionEvaluationDao QuestionEvaluationDao = new QuestionEvaluationDaoImp();

	private QuestionEvaluation QuestionEvaluation = new QuestionEvaluation();

	private QuestionEvaluation  currentQuestionEvaluation = new QuestionEvaluation(); 

	private List<QuestionEvaluation> listQuestionEvaluation = new ArrayList();

 
	
	

	public QuestionEvaluationBusiness() {
		 
	} 
	 
	
	
  
	public void saveQuestionEvaluation() {  
		QuestionEvaluationDao.saveOrUpdate(currentQuestionEvaluation); 
		currentQuestionEvaluation =  new QuestionEvaluation();
 
	}
	
	
	public void deleteQuestionEvaluation(){ 
		QuestionEvaluationDao.delete(currentQuestionEvaluation);
	}

	public void clear() {
		QuestionEvaluation = new QuestionEvaluation();
		currentQuestionEvaluation = new QuestionEvaluation(); 
	}

	public void loadQuestionEvaluation() {
		this.QuestionEvaluation = currentQuestionEvaluation;
	}

	public void quitter() {
		;
	}

	public List<QuestionEvaluation> findAllQuestionEvaluation() {

		listQuestionEvaluation = QuestionEvaluationDao.findAll(QuestionEvaluation.class);
		return listQuestionEvaluation;
	}
 
	 
 

	public List<QuestionEvaluation> getlistQuestionEvaluation() {
		
		listQuestionEvaluation = QuestionEvaluationDao.findAll(QuestionEvaluation.class); 
		return listQuestionEvaluation;
	}

	public void setlistQuestionEvaluation(List<QuestionEvaluation> listQuestionEvaluation) {
		this.listQuestionEvaluation = listQuestionEvaluation;
	}




	public QuestionEvaluationDao getQuestionEvaluationDao() {
		return QuestionEvaluationDao;
	}




	public void setQuestionEvaluationDao(QuestionEvaluationDao QuestionEvaluationDao) {
		this.QuestionEvaluationDao = QuestionEvaluationDao;
	}




	public QuestionEvaluation getUtil() {
		return QuestionEvaluation;
	}




	public void setUtil(QuestionEvaluation QuestionEvaluation) {
		QuestionEvaluation = QuestionEvaluation;
	}



	public void setcurrentQuestionEvaluation(QuestionEvaluation currentQuestionEvaluation) { 
		 
		this.currentQuestionEvaluation = currentQuestionEvaluation;
	}
	



	public QuestionEvaluation getcurrentQuestionEvaluation() {
		return currentQuestionEvaluation;
	}

 

	
 

	 

}
