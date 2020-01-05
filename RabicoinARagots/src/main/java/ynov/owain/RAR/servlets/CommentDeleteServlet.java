package ynov.owain.RAR.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ynov.owain.RAR.dao.DAOComment;
import ynov.owain.RAR.dao.DAOFactory;
import ynov.owain.RAR.dao.model.Comment;

public class CommentDeleteServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();  //Meme fonctionnement que pour la gestion d'article.
		
		if (session.getAttribute("userID") != null)
		{
			DAOFactory factory = new DAOFactory();
			DAOComment daoComment = factory.getDaoComment();
			
			Integer id = Integer.parseInt(req.getParameter("id"));
			
			Comment commentToDelete = daoComment.getComment(id);
			
			daoComment.deleteComment(commentToDelete);
			
			resp.sendRedirect("/RabicoinARagots/article/manage");
		}
	}
}
