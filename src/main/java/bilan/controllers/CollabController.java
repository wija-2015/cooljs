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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import bilan.dao.ICollabRepository;
import bilan.dtos.CollaborateurDTO;
import bilan.entities.Collaborateur;
import bilan.entities.Managerrh;
import bilan.service.ICollabService;
import bilan.service.IManagerService;

@RestController
@RequestMapping("collaborateurs")
public class CollabController {

@Autowired
private ICollabService collabService;
@Autowired
private IManagerService managerService ;

@ResponseBody
@RequestMapping(value="findAll", method = RequestMethod.GET)
public List<Collaborateur> getCollabs(){
return  collabService.toutsCollabs();
}
@RequestMapping(value="save", method = RequestMethod.POST,consumes={"application/json"},produces ={"application/json"})
public Collaborateur saveCollab(@RequestBody CollaborateurDTO c,HttpServletResponse response){
	//c.getManagerrh().getMatriculeUser()
	//Managerrh Manager = new Managerrh();
	//c.setManagerrh(new Managerrh());
	//Manager = managerService.trouverManager(c.getManagerrh().getIdManagerrh());
	//c.setManagerrh(Manager);
//	c.getManagerrh().getIdManagerrh()
	Collaborateur collab=new Collaborateur();
	collab.setNomUser(c.getNomUser());
	collab.setMailUser(c.getMailUser());
	collab.setMatriculeUser(c.getMatriculeUser());
	collab.setDateRecrutement(c.getDateRecrutement());
	Managerrh Manager = new Managerrh();
	Manager = managerService.trouverManager(c.getIdManagerrh()) ;
	collab.setManagerrh(Manager);
	return collabService.ajouterCollab(collab) ;
}
@RequestMapping(value="/{id}", method = RequestMethod.GET)
public Collaborateur findCollab(@PathVariable("id") int id){
	return collabService.trouverCollab(id);
}
@RequestMapping(value="/update/{id}/{nom}/{prenom}", method = RequestMethod.PUT)
public int updateCollab(@PathVariable("nom") String nom,@PathVariable("prenom") String prenom,@PathVariable("id") int id){
	 return collabService.modifierCollab(nom, prenom, id);
}
@RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
public int deleteCollab(@PathVariable("id") int id){
   return collabService.supprimerCollab(id);
}
/*@RequestMapping(value="/add")
public Client addClient(ClientDTO clientDTO)
{
	Client c  = new Client();
	c.setNomClient(clientDTO.getNom());
	c.setPrenomClient(clientDTO.getPrenom());

	//c = clientService.save(c);
	return c;
	
}*/

/*
@RequestMapping("/produits")
public Page<Produit> getProduits(int page){
return produitRepository.findAll(new PageRequest(page, 5));
}
@RequestMapping("/produitsParMC")
public Page<Produit> getProduits(String mc,int page){
return produitRepository.produitParMC("%"+mc+"%", new PageRequest(page, 5));
}
@RequestMapping("/get")
public Produit getProduit(Long ref){
return produitRepository.findOne(ref);
}
@RequestMapping("/delete")
public boolean delete(Long ref){
produitRepository.delete(ref);
return true;
}
@RequestMapping("/update")
public Produit update(Produit p){
produitRepository.saveAndFlush(p);
return p;
}*/
public ICollabService getCollabService() {
	return collabService;
}
public void setCollabService(ICollabService collabService) {
	this.collabService = collabService;
}

}

