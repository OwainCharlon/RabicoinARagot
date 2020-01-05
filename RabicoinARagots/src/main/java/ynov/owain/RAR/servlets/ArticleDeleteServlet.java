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

public class ArticleDeleteServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = req.getSession();  //R�cuperation de la session en cours.
		
		if (session.getAttribute("userID") != null)  //Si un utilisateur est connect�, il peut bien acc�der � la page de suppression d'un article.
		{
			DAOFactory factory = new DAOFactory();
			DAOArticle daoArticle = factory.getDaoArticle();  //Instanciation d'un DAOArticle.
			
			Integer articleID = Integer.parseInt(req.getParameter("id"));
			Article articleToDelete = daoArticle.getArticle(articleID);  //R�cuperation de l'article � supprimer.
			
			daoArticle.deleteArticle(articleToDelete);  //Appelle de la m�thode de suppresion d'un article avec son ID en param�tre.
			
			resp.sendRedirect("/RabicoinARagots/article/manage");  //REdirection vers la page de gestion du contenu de l'utilisateur connect�.
		}
	}
}
