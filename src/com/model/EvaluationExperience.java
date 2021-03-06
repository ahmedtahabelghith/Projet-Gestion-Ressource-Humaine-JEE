package com.model;

// Generated 21 sept. 2016 11:14:47 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * EvaluationExperience generated by hbm2java
 */
@Entity
@Table(name = "evaluation_experience", catalog = "management_resource_human_database")
public class EvaluationExperience implements java.io.Serializable {

	private Integer idEvaluation;
	private String identificatioCode;
	private Set<QuestionEvaluation> questionEvaluations = new HashSet<QuestionEvaluation>(
			0);
	private Set<CtpFolders> ctpFolderses = new HashSet<CtpFolders>(0);

	public EvaluationExperience() {
	}

	public EvaluationExperience(String identificatioCode,
			Set<QuestionEvaluation> questionEvaluations,
			Set<CtpFolders> ctpFolderses) {
		this.identificatioCode = identificatioCode;
		this.questionEvaluations = questionEvaluations;
		this.ctpFolderses = ctpFolderses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_evaluation", unique = true, nullable = false)
	public Integer getIdEvaluation() {
		return this.idEvaluation;
	}

	public void setIdEvaluation(Integer idEvaluation) {
		this.idEvaluation = idEvaluation;
	}

	@Column(name = "identificatio_code", length = 30)
	public String getIdentificatioCode() {
		return this.identificatioCode;
	}

	public void setIdentificatioCode(String identificatioCode) {
		this.identificatioCode = identificatioCode;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "evaluationExperience")
	public Set<QuestionEvaluation> getQuestionEvaluations() {
		return this.questionEvaluations;
	}

	public void setQuestionEvaluations(
			Set<QuestionEvaluation> questionEvaluations) {
		this.questionEvaluations = questionEvaluations;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "evaluationExperience")
	public Set<CtpFolders> getCtpFolderses() {
		return this.ctpFolderses;
	}

	public void setCtpFolderses(Set<CtpFolders> ctpFolderses) {
		this.ctpFolderses = ctpFolderses;
	}

}
