package ynov.owain.RAR.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ynov.owain.RAR.dao.DAOArticle;
import ynov.owain.RAR.dao.DAOComment;
import ynov.owain.RAR.dao.DAOFactory;
import ynov.owain.RAR.dao.model.Article;
import ynov.owain.RAR.dao.model.Comment;

public class CommentUpdateServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Meme fonctionnement que pour la gestion d'article.
		
		HttpSession session = req.getSession();
		
		if (session.getAttribute("userID") != null)
		{
			DAOFactory factory = new DAOFactory();
			DAOComment daoComment = factory.getDaoComment();
			
			Integer id = Integer.parseInt(req.getParameter("id"));
			
			System.out.print(id);
			
			Comment comment = daoComment.getComment(id);
			
			req.setAttribute("comment", comment );
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/updateComments.jsp").forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Meme fonctionnement que pour la gestion d'article.
		
		DAOFactory factory = new DAOFactory();
		DAOComment daoComment = factory.getDaoComment();
		
		Integer id = Integer.parseInt(req.getParameter("id"));
		
		Comment updatedComment = new Comment();
		updatedComment.setCommentID(id);
		updatedComment.setCommentContent(req.getParameter("newCommentContent"));
        
		daoComment.updateComment(updatedComment);
		
		resp.sendRedirect("/RabicoinARagots/article/manage");
	}
}
