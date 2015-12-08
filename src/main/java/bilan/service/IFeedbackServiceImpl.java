package bilan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bilan.dao.ICollabRepository;
import bilan.dao.IEvaluationObjectifRepository;
import bilan.dao.IFeedbackRepository;
import bilan.dao.IProjetRepository;
import bilan.dtos.FeedbackDTO;
import bilan.entities.Collaborateur;
import bilan.entities.Feedback;
import bilan.entities.Projet;

@Service
@Transactional
public class IFeedbackServiceImpl implements IFeedbackService {
	
	@Autowired
	private IFeedbackRepository feedbackRepository;
	@Autowired
	private ICollabRepository collabRepository;
	@Autowired
	private IProjetRepository projetRepository;
	
	@Override
	public Feedback trouverFeedback(int idC, int idE) {
		// TODO Auto-generated method stub
		return feedbackRepository.findFeedback(idC, idE);
	}
	@Override
	public Feedback ajouterFeedback(FeedbackDTO f) {
		Feedback feed=new Feedback();
		feed.setRole(f.getRole());
		feed.setNbJours(f.getNbJours());
		feed.setDateDebut(f.getDateDebut());
		feed.setDateFin(f.getDateFin());
		Collaborateur collab=new Collaborateur();
		collab=collabRepository.findCollab(f.getIdCollaborateur());
		feed.setCollaborateur(collab);
		Projet proj=new Projet();
		proj=projetRepository.findProjet(f.getIdProjet());
		feed.setProjet(proj);
		return feedbackRepository.save(feed);
	}
	public IFeedbackRepository getFeedbackRepository() {
		return feedbackRepository;
	}


	public void setFeedbackRepository(IFeedbackRepository feedbackRepository) {
		this.feedbackRepository = feedbackRepository;
	}


}
