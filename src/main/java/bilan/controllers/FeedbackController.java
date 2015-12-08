package bilan.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bilan.dtos.CollaborateurDTO;
import bilan.dtos.FeedbackDTO;
import bilan.entities.Collaborateur;
import bilan.entities.Feedback;
import bilan.entities.Managerrh;
import bilan.entities.Projet;
import bilan.service.ICollabService;
import bilan.service.IFeedbackService;
import bilan.service.IProjetService;

@RestController
@RequestMapping("feedbacks")
public class FeedbackController {

@Autowired
private IFeedbackService feedbackService;
@Autowired
private ICollabService collabService;
@Autowired
private IProjetService projetService;

@RequestMapping(value="save", method = RequestMethod.POST,consumes={"application/json"},produces ={"application/json"})
public Feedback saveFeedback(@RequestBody FeedbackDTO f,HttpServletResponse response){
	return feedbackService.ajouterFeedback(f) ;
}




public IFeedbackService getFeedbackService() {
	return feedbackService;
}


public void setFeedbackService(IFeedbackService feedbackService) {
	feedbackService = feedbackService;
}



}
