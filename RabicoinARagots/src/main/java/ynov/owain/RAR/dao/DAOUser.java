package ynov.owain.RAR.dao;


import ynov.owain.RAR.dao.model.User;

public interface DAOUser {

	public User getUser(Integer id);  //Fonction qui retourne l'utilisateur demand� via son ID.
	
	public User login(String login, String password);  //Fonction qui test la connexion d'un utilisateur via les informations en param�tre.
	
	public void addUser(User user);  //Fonction qui ajoute l'utilisateur plac� en param�tre en BDDr.
}
