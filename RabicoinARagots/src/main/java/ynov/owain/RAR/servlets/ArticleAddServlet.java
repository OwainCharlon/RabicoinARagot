package ynov.owain.RAR.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ynov.owain.RAR.dao.DAOArticle;
import ynov.owain.RAR.dao.DAOFactory;
import ynov.owain.RAR.dao.model.Article;

public class ArticleAddServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = req.getSession();  //Récuperation de la session en cours.
		
		if (session.getAttribute("userID") != null)  //Teste s'il y a une session active.
		{
			Boolean addArticleForm = true;  
			req.setAttribute("addArticleForm", addArticleForm );  //Envoie un booléan permettant à la jsp de savoir quel formualire afficher.
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/add&UpdateArticles.jsp").forward(req, resp);
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = req.getSession();  //Récuperation de la session en cours.
		
		Integer authorID = (Integer) session.getAttribute("userID");  //Récuperation de l'id de l'auteur dont la session est active.
		
		DAOFactory factory = new DAOFactory();
		DAOArticle daoArticle = factory.getDaoArticle();  //Instanciation d'un DAOArticle.
		
		Article newArticle = new Article();
		newArticle.setTitle(req.getParameter("newArticleTitle"));  //Récuperation des données du formulaire et attribtuion de leur valeur dans notre article.
		newArticle.setArticleDescription(req.getParameter("newArticleDescription"));
		newArticle.setArticleContent(req.getParameter("newArticleContent"));	
		daoArticle.addArticle(newArticle, authorID);  //Appelle de la méthode d'ajout d'article.
		
		resp.sendRedirect("/RabicoinARagots/");  //Redirection vers l'index du site.
	}
}
