package ynov.owain.RAR.servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ynov.owain.RAR.dao.DAOArticle;
import ynov.owain.RAR.dao.DAOFactory;
import ynov.owain.RAR.dao.model.Article;

public class IndexServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = req.getSession();
		DAOFactory factory = new DAOFactory();
		DAOArticle daoArticle = factory.getDaoArticle();
		
		Boolean index = true;  //Indique à la jsp quel type de page affiché.
		
		List<Article> articleList = daoArticle.getTwoLastestArticles();
		
		req.setAttribute("index", index );
		req.setAttribute("articleList", articleList );
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String searchedAuthor = req.getParameter("searchedAuthor");
		String newSearchedAuthor = searchedAuthor.replace(" ", "_");
		
		resp.sendRedirect("/RabicoinARagots/article/byAuthor?searchedAuthor=" + newSearchedAuthor);
	}
	
}
