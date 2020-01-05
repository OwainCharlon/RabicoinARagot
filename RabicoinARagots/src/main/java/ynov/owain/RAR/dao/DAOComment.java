package ynov.owain.RAR.dao;

import java.util.List;

import ynov.owain.RAR.dao.model.Comment;

public interface DAOComment {
	
	public Comment getComment(Integer id);  //Fonction qui retourne le commentaire demandé via son ID.
	
	public List<Comment> getAllComments(Integer articleID);  //Fonction qui retourne la Liste de l'ensemble des commentaires de l'article placé en pramaètre.
	
	public List<Comment> getAllCommentsByAuthor(Integer authorID);  //Fonction qui retourne la Liste des commentaires d'un auteur entré en paramètre.
	
	public void addComment(Comment comment, Integer authorID, Integer articleID);  //Fonction qui ajoute le commentaire placé en paramètre en BDD, en prenant en compte l'auteur de ce dernier et l'article auquel il est lié.
	
	public void updateComment(Comment comment);  //Fonction qui met à jour en BDD le commentaire placé en paramètre.
	
	public void deleteComment(Comment comment);  //Fonction qui supprime de la BDD le commentaire placé en paramètre.
}
