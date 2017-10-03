package com.model;

// Generated 21 sept. 2016 11:14:47 by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * CtpFolders generated by hbm2java
 */
@Entity
@Table(name = "ctp_folders", catalog = "management_resource_human_database")
public class CtpFolders implements java.io.Serializable {

	private String matricule;
	private Candidates candidates;
	private EvaluationExperience evaluationExperience;
	private Validacs validacs;
	private Date hiringDate;
	private Date endContractDate;
	private Date exitDate;
	private String initialCv;
	private String customCv;
	private Boolean contrat;
	private Boolean licensePhoto;
	private Boolean internalRules;
	private String assuranceCopy;
	private String cinCopy;
	private String testEvalution;
	private Integer rib;
	private String diplomaCopy;
	private Boolean attestationJob;
	private Boolean certificat;
	private String photo;
	private String ctpSituation;
	private String observation;
	private Boolean noteReet;
	private String evaluationTestPresProfile;
	private Set<SheetInformation> sheetInformations = new HashSet<SheetInformation>(
			0);
	private Set<StatesCandidates> statesCandidateses = new HashSet<StatesCandidates>(
			0);

	public CtpFolders() {
	}

	public CtpFolders(String matricule) {
		this.matricule = matricule;
	}

	public CtpFolders(String matricule, Candidates candidates,
			EvaluationExperience evaluationExperience, Validacs validacs,
			Date hiringDate, Date endContractDate, Date exitDate,
			String initialCv, String customCv, Boolean contrat,
			Boolean licensePhoto, Boolean internalRules, String assuranceCopy,
			String cinCopy, String testEvalution, Integer rib,
			String diplomaCopy, Boolean attestationJob, Boolean certificat,
			String photo, String ctpSituation, String observation,
			Boolean noteReet, String evaluationTestPresProfile,
			Set<SheetInformation> sheetInformations,
			Set<StatesCandidates> statesCandidateses) {
		this.matricule = matricule;
		this.candidates = candidates;
		this.evaluationExperience = evaluationExperience;
		this.validacs = validacs;
		this.hiringDate = hiringDate;
		this.endContractDate = endContractDate;
		this.exitDate = exitDate;
		this.initialCv = initialCv;
		this.customCv = customCv;
		this.contrat = contrat;
		this.licensePhoto = licensePhoto;
		this.internalRules = internalRules;
		this.assuranceCopy = assuranceCopy;
		this.cinCopy = cinCopy;
		this.testEvalution = testEvalution;
		this.rib = rib;
		this.diplomaCopy = diplomaCopy;
		this.attestationJob = attestationJob;
		this.certificat = certificat;
		this.photo = photo;
		this.ctpSituation = ctpSituation;
		this.observation = observation;
		this.noteReet = noteReet;
		this.evaluationTestPresProfile = evaluationTestPresProfile;
		this.sheetInformations = sheetInformations;
		this.statesCandidateses = statesCandidateses;
	}

	@Id
	@Column(name = "matricule", unique = true, nullable = false, length = 10)
	public String getMatricule() {
		return this.matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "email")
	public Candidates getCandidates() {
		return this.candidates;
	}

	public void setCandidates(Candidates candidates) {
		this.candidates = candidates;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_evaluation")
	public EvaluationExperience getEvaluationExperience() {
		return this.evaluationExperience;
	}

	public void setEvaluationExperience(
			EvaluationExperience evaluationExperience) {
		this.evaluationExperience = evaluationExperience;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_validac")
	public Validacs getValidacs() {
		return this.validacs;
	}

	public void setValidacs(Validacs validacs) {
		this.validacs = validacs;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "hiring_date", length = 10)
	public Date getHiringDate() {
		return this.hiringDate;
	}

	public void setHiringDate(Date hiringDate) {
		this.hiringDate = hiringDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "end_contract_date", length = 10)
	public Date getEndContractDate() {
		return this.endContractDate;
	}

	public void setEndContractDate(Date endContractDate) {
		this.endContractDate = endContractDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "exit_date", length = 10)
	public Date getExitDate() {
		return this.exitDate;
	}

	public void setExitDate(Date exitDate) {
		this.exitDate = exitDate;
	}

	@Column(name = "initial_cv", length = 500)
	public String getInitialCv() {
		return this.initialCv;
	}

	public void setInitialCv(String initialCv) {
		this.initialCv = initialCv;
	}

	@Column(name = "custom_cv", length = 500)
	public String getCustomCv() {
		return this.customCv;
	}

	public void setCustomCv(String customCv) {
		this.customCv = customCv;
	}

	@Column(name = "contrat")
	public Boolean getContrat() {
		return this.contrat;
	}

	public void setContrat(Boolean contrat) {
		this.contrat = contrat;
	}

	@Column(name = "license_photo")
	public Boolean getLicensePhoto() {
		return this.licensePhoto;
	}

	public void setLicensePhoto(Boolean licensePhoto) {
		this.licensePhoto = licensePhoto;
	}

	@Column(name = "internal_rules")
	public Boolean getInternalRules() {
		return this.internalRules;
	}

	public void setInternalRules(Boolean internalRules) {
		this.internalRules = internalRules;
	}

	@Column(name = "assurance_copy", length = 500)
	public String getAssuranceCopy() {
		return this.assuranceCopy;
	}

	public void setAssuranceCopy(String assuranceCopy) {
		this.assuranceCopy = assuranceCopy;
	}

	@Column(name = "cin_copy", length = 500)
	public String getCinCopy() {
		return this.cinCopy;
	}

	public void setCinCopy(String cinCopy) {
		this.cinCopy = cinCopy;
	}

	@Column(name = "test_evalution", length = 500)
	public String getTestEvalution() {
		return this.testEvalution;
	}

	public void setTestEvalution(String testEvalution) {
		this.testEvalution = testEvalution;
	}

	@Column(name = "rib")
	public Integer getRib() {
		return this.rib;
	}

	public void setRib(Integer rib) {
		this.rib = rib;
	}

	@Column(name = "diploma_copy", length = 500)
	public String getDiplomaCopy() {
		return this.diplomaCopy;
	}

	public void setDiplomaCopy(String diplomaCopy) {
		this.diplomaCopy = diplomaCopy;
	}

	@Column(name = "attestation_job")
	public Boolean getAttestationJob() {
		return this.attestationJob;
	}

	public void setAttestationJob(Boolean attestationJob) {
		this.attestationJob = attestationJob;
	}

	@Column(name = "certificat")
	public Boolean getCertificat() {
		return this.certificat;
	}

	public void setCertificat(Boolean certificat) {
		this.certificat = certificat;
	}

	@Column(name = "photo", length = 500)
	public String getPhoto() {
		return this.photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Column(name = "ctp_situation", length = 100)
	public String getCtpSituation() { 
		return this.ctpSituation;
		
	}

	public void setCtpSituation(String ctpSituation) {
		this.ctpSituation = ctpSituation;
	 
	}

	@Column(name = "observation", length = 100)
	public String getObservation() {
		return this.observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	@Column(name = "note_reet")
	public Boolean getNoteReet() {
		return this.noteReet;
	}

	public void setNoteReet(Boolean noteReet) {
		this.noteReet = noteReet;
	}

	@Column(name = "evaluation_test_pres_profile", length = 25)
	public String getEvaluationTestPresProfile() {
		return this.evaluationTestPresProfile;
	}

	public void setEvaluationTestPresProfile(String evaluationTestPresProfile) {
		this.evaluationTestPresProfile = evaluationTestPresProfile;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "ctpFolders")
	public Set<SheetInformation> getSheetInformations() {
		return this.sheetInformations;
	}

	public void setSheetInformations(Set<SheetInformation> sheetInformations) {
		this.sheetInformations = sheetInformations;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "ctpFolders")
	public Set<StatesCandidates> getStatesCandidateses() {
		return this.statesCandidateses;
	}

	public void setStatesCandidateses(Set<StatesCandidates> statesCandidateses) {
		this.statesCandidateses = statesCandidateses;
	}

}
