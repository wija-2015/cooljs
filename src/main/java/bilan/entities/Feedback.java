package bilan.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Collection;
import java.util.Date;


@Entity
public class Feedback implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idFeedback;
	private String role;
	private int nbJours;
	private Date dateDebut;
	private Date dateFin;
	private String commentaire;
	private int nbThemes;
	private int totalPoints;
	private float noteGlobale;

	//bi-directional many-to-one association to Collaborateur
	@ManyToOne
	@JoinColumn(name="idCollaborateur")
	private Collaborateur collaborateur;

	//bi-directional many-to-one association to Encadrant
	@ManyToOne
	@JoinColumn(name="idEncadrant")
	private Encadrant encadrant;

	//bi-directional many-to-one association to Projet
	@ManyToOne
	@JoinColumn(name="idProjet")
	private Projet projet;

	//bi-directional many-to-one association to Qualification
	@OneToMany(mappedBy="feedback")
	private Collection<Qualification> qualifications;

	public Feedback() {
	}

	public Feedback(int idFeedback, String role, int nbJours, Date dateDebut,
			Date dateFin, String commentaire, int nbThemes, int totalPoints,
			float noteGlobale, Collaborateur collaborateur,
			Encadrant encadrant, Projet projet,
			Collection<Qualification> qualifications) {
		super();
		this.idFeedback = idFeedback;
		this.role = role;
		this.nbJours = nbJours;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.commentaire = commentaire;
		this.nbThemes = nbThemes;
		this.totalPoints = totalPoints;
		this.noteGlobale = noteGlobale;
		this.collaborateur = collaborateur;
		this.encadrant = encadrant;
		this.projet = projet;
		this.qualifications = qualifications;
	}

	public int getIdFeedback() {
		return idFeedback;
	}

	public void setIdFeedback(int idFeedback) {
		this.idFeedback = idFeedback;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getNbJours() {
		return nbJours;
	}

	public void setNbJours(int nbJours) {
		this.nbJours = nbJours;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public int getNbThemes() {
		return nbThemes;
	}

	public void setNbThemes(int nbThemes) {
		this.nbThemes = nbThemes;
	}

	public int getTotalPoints() {
		return totalPoints;
	}

	public void setTotalPoints(int totalPoints) {
		this.totalPoints = totalPoints;
	}

	public float getNoteGlobale() {
		return noteGlobale;
	}

	public void setNoteGlobale(float noteGlobale) {
		this.noteGlobale = noteGlobale;
	}

	public Collaborateur getCollaborateur() {
		return this.collaborateur;
	}

	public void setCollaborateur(Collaborateur collaborateur) {
		this.collaborateur = collaborateur;
	}

	public Encadrant getEncadrant() {
		return this.encadrant;
	}

	public void setEncadrant(Encadrant encadrant) {
		this.encadrant = encadrant;
	}

	public Projet getProjet() {
		return this.projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	public Collection<Qualification> getQualifications() {
		return this.qualifications;
	}

	public void setQualifications(Collection<Qualification> qualifications) {
		this.qualifications = qualifications;
	}

}