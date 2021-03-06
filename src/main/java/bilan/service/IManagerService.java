package bilan.service;

import java.util.List;

import bilan.entities.Collaborateur;
import bilan.entities.Managerrh;

public interface IManagerService {
	
	public List<Managerrh> toutsManagers();

	public Managerrh ajouterManager(Managerrh c);
	
	public Managerrh trouverManager(int id);
	
	public int supprimerManager(int id);
	
	public int modifierManager(String nom, String prenom,int id);
	
	public List<Collaborateur> trouverManagerCollabs(int id);
	
	

}
