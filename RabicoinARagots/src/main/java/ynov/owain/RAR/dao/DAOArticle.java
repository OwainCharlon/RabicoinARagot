package ynov.owain.RAR.dao;

import java.util.List;

import ynov.owain.RAR.dao.model.Article;

public interface DAOArticle {
	
	public Article getArticle(Integer id);  //Fonction qui retourne l'article demand� via son ID.
	
	public List<Article> getTwoLastestArticles();  //Fonction qui retourne les deux articles les plus r�cents du blog (utilis� pour l'index du Blog).
	
	public List<Article> getAllArticles(Integer authorID);  //Fonction qui retourne la Liste de l'ensemble des articles du Blog.
	
	public List<Article> getArticlesByAuthor(String authorFirstname, String authorLastname);  //Fonction qui retourne la Liste d'article d'un auteur entr� en param�tre.
	
	public void addArticle(Article article, Integer authorID);  //Fonction qui ajoute l'article plac� en param�tre en BDD, en prenant en compte l'auteur de ce dernier.
	
	public void updateArticle(Article article);  //Fonction qui met � jour en BDD l'article plac� en param�tre.
	
	public void deleteArticle(Article article);  //Fonction qui supprime de la BDD l'article plac� en param�tre.
}
