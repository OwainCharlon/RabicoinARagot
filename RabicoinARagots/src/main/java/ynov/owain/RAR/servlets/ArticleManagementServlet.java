package ynov.owain.RAR.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ynov.owain.RAR.dao.DAOFactory;
import ynov.owain.RAR.dao.DAOArticle;
import ynov.owain.RAR.dao.model.Article;
import ynov.owain.RAR.dao.DAOComment;
import ynov.owain.RAR.dao.model.Comment;

public class ArticleManagementServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = req.getSession();  //R�cuperation de la session en cours.
		
		if (session.getAttribute("userID") != null)  //Si un utilisateur est conenct�, il peut acc�der � cette page.
		{
			DAOFactory factory = new DAOFactory();
			DAOArticle daoArticle = factory.getDaoArticle();
			DAOComment daoComment = factory.getDaoComment();  //Instanciation d'un DAOArticle et d'un DAOCOmment.
			
			Integer authorID = (Integer) session.getAttribute("userID");  //R�cuperation de l'id de l'utilisateur connect�.
			
			List<Article> articleList = daoArticle.getAllArticles(authorID);  //R�cuperation de la liste des articles de l'auteur connect�.
			List<Comment> commentList = daoComment.getAllCommentsByAuthor(authorID);  //R�cuperation de la liste des commentaires de l'auteur connect�.
			
			req.setAttribute("articleList", articleList );  
			req.setAttribute("commentList", commentList );  //Envoie de la liste des articles et comme,ntaires de cet auteur vers la JSP.
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/manage&ListByAuthor.jsp").forward(req, resp);
		}
	}
}
