package bilan.service;

import bilan.dtos.FeedbackDTO;
import bilan.entities.Feedback;

public interface IFeedbackService {
	
	public Feedback trouverFeedback(int idC,int idE);

	public Feedback ajouterFeedback(FeedbackDTO f);


}
