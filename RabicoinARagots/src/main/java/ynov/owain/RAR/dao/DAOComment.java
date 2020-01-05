package ynov.owain.RAR.dao;

import java.util.List;

import ynov.owain.RAR.dao.model.Comment;

public interface DAOComment {
	
	public Comment getComment(Integer id);  //Fonction qui retourne le commentaire demand� via son ID.
	
	public List<Comment> getAllComments(Integer articleID);  //Fonction qui retourne la Liste de l'ensemble des commentaires de l'article plac� en prama�tre.
	
	public List<Comment> getAllCommentsByAuthor(Integer authorID);  //Fonction qui retourne la Liste des commentaires d'un auteur entr� en param�tre.
	
	public void addComment(Comment comment, Integer authorID, Integer articleID);  //Fonction qui ajoute le commentaire plac� en param�tre en BDD, en prenant en compte l'auteur de ce dernier et l'article auquel il est li�.
	
	public void updateComment(Comment comment);  //Fonction qui met � jour en BDD le commentaire plac� en param�tre.
	
	public void deleteComment(Comment comment);  //Fonction qui supprime de la BDD le commentaire plac� en param�tre.
}
