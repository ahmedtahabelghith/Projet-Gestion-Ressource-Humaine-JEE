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
 * EmailsTrackings generated by hbm2java
 */
@Entity
@Table(name = "emails_trackings", catalog = "management_resource_human_database")
public class EmailsTrackings implements java.io.Serializable {

	private Integer idEmailsTrackings;
	private Boolean confirmCandidate;
	private Boolean meetingEmail;
	private Boolean hiringEmail;
	private Boolean rejectEmail;
	private Set<Candidates> candidateses = new HashSet<Candidates>(0);

	public EmailsTrackings() {
	}

	public EmailsTrackings(Boolean confirmCandidate, Boolean meetingEmail,
			Boolean hiringEmail, Boolean rejectEmail,
			Set<Candidates> candidateses) {
		this.confirmCandidate = confirmCandidate;
		this.meetingEmail = meetingEmail;
		this.hiringEmail = hiringEmail;
		this.rejectEmail = rejectEmail;
		this.candidateses = candidateses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_emails_trackings", unique = true, nullable = false)
	public Integer getIdEmailsTrackings() {
		return this.idEmailsTrackings;
	}

	public void setIdEmailsTrackings(Integer idEmailsTrackings) {
		this.idEmailsTrackings = idEmailsTrackings;
	}

	@Column(name = "confirm_candidate")
	public Boolean getConfirmCandidate() {
		return this.confirmCandidate;
	}

	public void setConfirmCandidate(Boolean confirmCandidate) {
		this.confirmCandidate = confirmCandidate;
	}

	@Column(name = "meeting_email")
	public Boolean getMeetingEmail() {
		return this.meetingEmail;
	}

	public void setMeetingEmail(Boolean meetingEmail) {
		this.meetingEmail = meetingEmail;
	}

	@Column(name = "hiring_email")
	public Boolean getHiringEmail() {
		return this.hiringEmail;
	}

	public void setHiringEmail(Boolean hiringEmail) {
		this.hiringEmail = hiringEmail;
	}

	@Column(name = "reject_email")
	public Boolean getRejectEmail() {
		return this.rejectEmail;
	}

	public void setRejectEmail(Boolean rejectEmail) {
		this.rejectEmail = rejectEmail;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "emailsTrackings")
	public Set<Candidates> getCandidateses() {
		return this.candidateses;
	}

	public void setCandidateses(Set<Candidates> candidateses) {
		this.candidateses = candidateses;
	}

}
