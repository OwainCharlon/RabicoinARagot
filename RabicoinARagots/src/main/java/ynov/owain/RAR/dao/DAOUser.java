package ynov.owain.RAR.dao;


import ynov.owain.RAR.dao.model.User;

public interface DAOUser {

	public User getUser(Integer id);  //Fonction qui retourne l'utilisateur demandé via son ID.
	
	public User login(String login, String password);  //Fonction qui test la connexion d'un utilisateur via les informations en paramètre.
	
	public void addUser(User user);  //Fonction qui ajoute l'utilisateur placé en paramètre en BDDr.
}
