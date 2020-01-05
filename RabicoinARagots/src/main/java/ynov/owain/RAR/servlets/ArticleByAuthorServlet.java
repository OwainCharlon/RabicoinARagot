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

public class ArticleByAuthorServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		DAOFactory factory = new DAOFactory();
		DAOArticle daoArticle = factory.getDaoArticle();  //Instanciation d'un DAOArticle.
		
		String authorName = req.getParameter("searchedAuthor");  //R�cuperation du nom de l'auteur recherch� dans l'url.
		final String separator = "_";
		String words[] = authorName.split(separator);
		List<Article> articleList = daoArticle.getArticlesByAuthor(words[0], words[1]);  //Appelle de la fonction qui renvoie les artilces d'un auteur.
		
		
		Boolean articlesByAuthor = true;  
		req.setAttribute("articlesByAuthor", articlesByAuthor );  //Envoie d'un booleen vers la jsp afin de lui pr�ciser quel type de page elle affiche. 
		req.setAttribute("articleList", articleList );  //Envoie de la liste des articles r�up�r�e.
		req.setAttribute("authorFirstname", words[0] );  //Envoie du prenom de l'auteur.
		req.setAttribute("authorLastname", words[1] );   //Envoie du nom de l'auteur.
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/manage&ListByAuthor.jsp").forward(req, resp);
	}
	
}
