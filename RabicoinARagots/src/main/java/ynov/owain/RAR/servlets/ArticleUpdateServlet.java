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

public class ArticleUpdateServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = req.getSession();
		
		if (session.getAttribute("userID") != null)  //Test si l'utilisateur est connecté.
		{
			DAOFactory factory = new DAOFactory();
			DAOArticle daoArticle = factory.getDaoArticle();
			
			Integer id = Integer.parseInt(req.getParameter("id"));
			
			Article article = daoArticle.getArticle(id);
			
			req.setAttribute("article", article ); //Récuperation des informations de l'article pour pré-remplir le formulaire. 
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/add&UpdateArticles.jsp").forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		DAOFactory factory = new DAOFactory();
		DAOArticle daoArticle = factory.getDaoArticle();
		
		Integer id = Integer.parseInt(req.getParameter("id"));
		
		Article updatedArticle = new Article();
		updatedArticle.setArticleID(id);
		updatedArticle.setTitle(req.getParameter("newArticleTitle"));
		updatedArticle.setArticleDescription(req.getParameter("newArticleDescription"));
		updatedArticle.setArticleContent(req.getParameter("newArticleContent"));	
        
		daoArticle.updateArticle(updatedArticle);  //Mise à jour du commentaire.
		
		resp.sendRedirect("/RabicoinARagots/article/manage");
	}
	
	
}
