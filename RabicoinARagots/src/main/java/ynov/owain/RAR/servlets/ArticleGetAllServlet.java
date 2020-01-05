package ynov.owain.RAR.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ynov.owain.RAR.dao.DAOArticle;
import ynov.owain.RAR.dao.DAOFactory;
import ynov.owain.RAR.dao.model.Article;

public class ArticleGetAllServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DAOFactory factory = new DAOFactory();
		DAOArticle daoArticle = factory.getDaoArticle();  //Instanciation d'un DAOArticle.
		
		Integer authorID = null;  
		
		List<Article> articleList = daoArticle.getAllArticles(authorID);  //Appelle de la méthode de récuperation de tout les articles (sans auteur particulier).
		
		req.setAttribute("articleList", articleList );  //Envoie de la liste des articles récuperé vers la JSP.
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
	}
}
