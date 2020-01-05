package ynov.owain.RAR.servlets;

import java.util.List;
import java.io.IOException;

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

public class ArticleServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		DAOFactory factory = new DAOFactory();
		DAOArticle daoArticle = factory.getDaoArticle();
		DAOComment daoComment = factory.getDaoComment();  //Instanciation d'un DAOArtcile et d'un DAOComment.
		
		Integer articleID = Integer.parseInt(req.getParameter("id"));  //Récuperation de l'id de l'article dans l'url.
		
		HttpSession session = req.getSession();  //Récuperation de la session en cours.
		session.setAttribute("actualArticleID", articleID);  //Mise à jour de l'article en cours de visionnage de cette session.
			
		Article article = daoArticle.getArticle(articleID);  //Récuperattion de l'article à afficher en fonction de son id.
		
		List<Comment> commentList = daoComment.getAllComments(articleID);  //Récuperation des commentaires liés à cette article.
			
		req.setAttribute("article", article );  //Envoie de l'article.
		req.setAttribute("commentList", commentList);  //Envoie de la liste des commentaires liés à cet article.
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/readArticle.jsp").forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		DAOFactory factory = new DAOFactory();
		DAOComment daoComment = factory.getDaoComment();  //Instanciation d'un DAOComment.
		
		HttpSession session = req.getSession();
		Integer authorID = (Integer) session.getAttribute("userID");
		Integer articleID = (Integer) session.getAttribute("actualArticleID");  //Récuperation de la session en cours, de l'id de l'article et de l'auteur.
		
		Comment newComment = new Comment();
		newComment.setCommentContent(req.getParameter("newComment"));
		daoComment.addComment(newComment, authorID, articleID);  //Ajout du commentaire en BDD.
		
		resp.sendRedirect("/RabicoinARagots/");
	}
}
