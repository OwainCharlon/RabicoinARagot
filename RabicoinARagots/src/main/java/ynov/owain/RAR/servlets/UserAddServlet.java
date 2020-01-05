package ynov.owain.RAR.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ynov.owain.RAR.dao.DAOUser;
import ynov.owain.RAR.dao.DAOFactory;
import ynov.owain.RAR.dao.model.User;

public class UserAddServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher("/WEB-INF/addUser.jsp").forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Meme fonctionnement que pour la création d'article.
		
		DAOFactory factory = new DAOFactory();
		DAOUser daoUser = factory.getDaoUser();
		
		User newUser = new User();
		newUser.setFirstname(req.getParameter("firstname"));
		newUser.setLastname(req.getParameter("lastname"));	
		newUser.setLogin(req.getParameter("login"));
		newUser.setPassword(req.getParameter("password"));
		daoUser.addUser(newUser);
		
		resp.sendRedirect("/RabicoinARagots/");
	}
}
