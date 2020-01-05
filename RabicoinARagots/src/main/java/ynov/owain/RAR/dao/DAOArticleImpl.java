package ynov.owain.RAR.dao;

import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ynov.owain.RAR.dao.model.Article;

public class DAOArticleImpl implements DAOArticle{
	
	private Connection connection;
	
	
	public DAOArticleImpl(Connection co) 
	{
		// TODO Auto-generated constructor stub
		this.connection = co;
	}

	
	public Article getArticle(Integer articleID)
    {
		Article article = new Article();
		try
    	{
    		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM ARTICLE JOIN USER ON ARTICLE.USER_ID=USER.USER_ID WHERE ARTICLE_ID=?;");
    		preparedStatement.setInt(1, articleID);
    		
    		ResultSet result = preparedStatement.executeQuery();
    		while(result.next())
    		{
    			article.setArticleID(result.getInt("ARTICLE_ID"));
    			article.setArticleAuthorFirstname(result.getString("FIRSTNAME"));
    			article.setArticleAuthorLastname(result.getString("LASTNAME"));
    			article.setTitle(result.getString("TITLE"));
    			article.setArticleDescription(result.getString("ARTICLE_DESCRIPTION"));
    			article.setArticleContent(result.getString("ARTICLE_CONTENT"));
    			article.setArticleDate(result.getDate("ARTICLE_DATE"));
    		}
    	}
    	catch(SQLException e)
    	{
    		e.printStackTrace();
    	}
		return article;
    }
	
	
	public List<Article> getTwoLastestArticles()
    {
		List<Article> list = new ArrayList<Article>();
		try
    	{
    		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM ARTICLE JOIN USER ON ARTICLE.USER_ID=USER.USER_ID ORDER BY ARTICLE_ID DESC LIMIT 2;");
    		
    		ResultSet result = preparedStatement.executeQuery();
    		while(result.next())
    		{
    			Article article = new Article();
    			article.setArticleID(result.getInt("ARTICLE_ID"));
    			article.setArticleAuthorFirstname(result.getString("FIRSTNAME"));
    			article.setArticleAuthorLastname(result.getString("LASTNAME"));
    			article.setTitle(result.getString("TITLE"));
    			article.setArticleDescription(result.getString("ARTICLE_DESCRIPTION"));
    			article.setArticleContent(result.getString("ARTICLE_CONTENT"));
    			article.setArticleDate(result.getDate("ARTICLE_DATE"));
    			list.add(article);
    		}
    	}
    	catch(SQLException e)
    	{
    		e.printStackTrace();
    	}
		
		return list;
    }
	
	
	public List<Article> getAllArticles(Integer authorID)
    {
		List<Article> list = new ArrayList<Article>();
			try
	    	{
				PreparedStatement preparedStatement;
				
				if(authorID == null)
				{
					preparedStatement = connection.prepareStatement("SELECT * FROM ARTICLE JOIN USER ON ARTICLE.USER_ID=USER.USER_ID;");
				}
				else
				{
					preparedStatement = connection.prepareStatement("SELECT * FROM ARTICLE JOIN USER ON ARTICLE.USER_ID=USER.USER_ID AND ARTICLE.USER_ID = ?;");
					preparedStatement.setInt(1, authorID);
				}
				
	    		ResultSet result = preparedStatement.executeQuery();
	    		while(result.next())
	    		{
	    			Article article = new Article();
	    			article.setArticleID(result.getInt("ARTICLE_ID"));
	    			article.setArticleAuthorFirstname(result.getString("FIRSTNAME"));
	    			article.setArticleAuthorLastname(result.getString("LASTNAME"));
	    			article.setTitle(result.getString("TITLE"));
	    			article.setArticleDescription(result.getString("ARTICLE_DESCRIPTION"));
	    			article.setArticleContent(result.getString("ARTICLE_CONTENT"));
	    			article.setArticleDate(result.getDate("ARTICLE_DATE"));
	    			list.add(article);
	    		}
	    	}
			catch(SQLException e)
	    	{
	    		e.printStackTrace();
	    	}
		return list;
    }
	
	
	public List<Article> getArticlesByAuthor(String authorFirstname, String authorLastname)
    {
		List<Article> list = new ArrayList<Article>();
		try
    	{
    		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM ARTICLE JOIN USER ON ARTICLE.USER_ID=USER.USER_ID WHERE FIRSTNAME LIKE ? AND LASTNAME LIKE ?;");
    		preparedStatement.setString(1, authorFirstname);
    		preparedStatement.setString(2, authorLastname);
    		
    		ResultSet result = preparedStatement.executeQuery();
    		while(result.next())
    		{
    			Article article = new Article();
    			article.setArticleID(result.getInt("ARTICLE_ID"));
    			article.setArticleAuthorFirstname(result.getString("FIRSTNAME"));
    			article.setArticleAuthorLastname(result.getString("LASTNAME"));
    			article.setTitle(result.getString("TITLE"));
    			article.setArticleDescription(result.getString("ARTICLE_DESCRIPTION"));
    			article.setArticleContent(result.getString("ARTICLE_CONTENT"));
    			article.setArticleDate(result.getDate("ARTICLE_DATE"));
    			list.add(article);
    			
    		}
    	}
    	catch(SQLException e)
    	{
    		e.printStackTrace();
    	}
		
		return list;
    }
	
	
	public void addArticle(Article article, Integer authorID)
	{
		try
    	{
    		PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO ARTICLE (USER_ID, TITLE, ARTICLE_DESCRIPTION, ARTICLE_CONTENT, ARTICLE_DATE) VALUES(?, ?, ?, ?, CURDATE());");
    		preparedStatement.setInt(1, authorID);
    		preparedStatement.setString(2, article.getTitle());
    		preparedStatement.setString(3, article.getArticleDescription());
    		preparedStatement.setString(4, article.getArticleContent());
    		int statut = preparedStatement.executeUpdate();
    		
    		System.out.println(statut);
    	}
    	catch(SQLException e)
    	{
    		e.printStackTrace();
    	}
	}
	
	
	public void updateArticle(Article article)
	{
		try
    	{
    		PreparedStatement preparedStatement = connection.prepareStatement("UPDATE ARTICLE SET TITLE = ?, ARTICLE_DESCRIPTION = ?, ARTICLE_CONTENT = ?, ARTICLE_DATE = CURDATE() WHERE ARTICLE_ID = ?;");
    		preparedStatement.setString(1, article.getTitle());
    		preparedStatement.setString(2, article.getArticleDescription());
    		preparedStatement.setString(3, article.getArticleContent());
    		preparedStatement.setInt(4, article.getArticleID());
    		int statut = preparedStatement.executeUpdate();
    		
    		System.out.println(statut);
    	}
    	catch(SQLException e)
    	{
    		e.printStackTrace();
    	}
	}
	
	
	public void deleteArticle(Article article)
	{
		try
    	{
    		PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM ARTICLE WHERE ARTICLE_ID = ?;");
    		preparedStatement.setInt(1, article.getArticleID());
    		int statut = preparedStatement.executeUpdate();
    		
    		System.out.println(statut);
    	}
    	catch(SQLException e)
    	{
    		e.printStackTrace();
    	}
	}

}
