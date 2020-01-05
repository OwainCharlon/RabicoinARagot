package ynov.owain.RAR.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ynov.owain.RAR.dao.DAOFactory;
import ynov.owain.RAR.dao.DAOUser;
import ynov.owain.RAR.dao.model.User;

public class LoginServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DAOFactory factory = new DAOFactory();
		DAOUser daoUser = factory.getDaoUser();
		
		String login = req.getParameter("login");
		String password = req.getParameter("password");
		
		User user = daoUser.login(login, password);
		
		if(user.getUserID() != null)  //S'il y a un utilisateur qui est retourné, on créér une session.
		{
			HttpSession session = req.getSession();
			session.setAttribute("userID", user.getUserID());
			session.setAttribute("firstname", user.getFirstname());
			session.setAttribute("Lastname", user.getLastname());
			
			resp.sendRedirect("/RabicoinARagots/");
		}
		else
		{
			resp.sendRedirect("/RabicoinARagots/login");
		}
	}
}
