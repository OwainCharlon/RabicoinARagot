package ynov.owain.RAR.dao;

import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ynov.owain.RAR.dao.model.Comment;

public class DAOCommentImpl implements DAOComment{
	
	private Connection connection;
	
	
	public DAOCommentImpl(Connection co) 
	{
		// TODO Auto-generated constructor stub
		this.connection = co;
	}
	
	
	public Comment getComment(Integer commentID)
    {
		Comment comment = new Comment();
		try
    	{
    		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM COMMENT JOIN USER ON COMMENT.USER_ID=USER.USER_ID AND COMMENT_ID=?;");
    		preparedStatement.setInt(1, commentID);
    		
    		ResultSet result = preparedStatement.executeQuery();
    		while(result.next())
    		{
    			comment.setCommentID(result.getInt("COMMENT_ID"));
    			comment.setCommentContent(result.getString("COMMENT_CONTENT"));
    			comment.setCommentDate(result.getDate("COMMENT_DATE"));
    			comment.setUserID(result.getInt("USER_ID"));
    			comment.setArticleID(result.getInt("ARTICLE_ID"));
    			comment.setAuthorFirstname(result.getString("FIRSTNAME"));
    			comment.setAuthorLastname(result.getString("LASTNAME"));
    		}
    	}
    	catch(SQLException e)
    	{
    		e.printStackTrace();
    	}
		return comment;
    }
	
	
	public List<Comment> getAllComments(Integer articleID)
    {
		List<Comment> list = new ArrayList<Comment>();

			try
	    	{
				PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM COMMENT JOIN USER ON COMMENT.USER_ID=USER.USER_ID AND COMMENT.ARTICLE_ID = ?;");
				preparedStatement.setInt(1, articleID);
				ResultSet result = preparedStatement.executeQuery();
	    		while(result.next())
	    		{
	    			Comment comment = new Comment();
	    			comment.setCommentID(result.getInt("COMMENT_ID"));
	    			comment.setCommentContent(result.getString("COMMENT_CONTENT"));
	    			comment.setCommentDate(result.getDate("COMMENT_DATE"));
	    			comment.setUserID(result.getInt("USER_ID"));
	    			comment.setArticleID(result.getInt("ARTICLE_ID"));
	    			comment.setAuthorFirstname(result.getString("FIRSTNAME"));
	    			comment.setAuthorLastname(result.getString("LASTNAME"));
	    			list.add(comment);
	    		}
	    	}
			catch(SQLException e)
	    	{
	    		e.printStackTrace();
	    	}
		return list;
    }
	
	
	public List<Comment> getAllCommentsByAuthor(Integer authorID)
    {
		List<Comment> list = new ArrayList<Comment>();

			try
	    	{
				PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM COMMENT JOIN USER ON COMMENT.USER_ID=USER.USER_ID AND COMMENT.USER_ID = ?;");
				preparedStatement.setInt(1, authorID);
				ResultSet result = preparedStatement.executeQuery();
	    		while(result.next())
	    		{
	    			Comment comment = new Comment();
	    			comment.setCommentID(result.getInt("COMMENT_ID"));
	    			comment.setCommentContent(result.getString("COMMENT_CONTENT"));
	    			comment.setCommentDate(result.getDate("COMMENT_DATE"));
	    			comment.setAuthorFirstname(result.getString("FIRSTNAME"));
	    			comment.setAuthorLastname(result.getString("LASTNAME"));
	    			list.add(comment);
	    		}
	    	}
			catch(SQLException e)
	    	{
	    		e.printStackTrace();
	    	}
		return list;
    }
	
	
	public void addComment(Comment comment, Integer authorID, Integer articleID)
	{
		try
    	{
    		PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO COMMENT (COMMENT_CONTENT, COMMENT_DATE, ARTICLE_ID, USER_ID) VALUES(?, CURDATE(), ?, ?);");
    		preparedStatement.setString(1, comment.getCommentContent());
    		preparedStatement.setInt(2, articleID);
    		preparedStatement.setInt(3, authorID);
    		int statut = preparedStatement.executeUpdate();
    		
    		System.out.println(statut);
    	}
    	catch(SQLException e)
    	{
    		e.printStackTrace();
    	}
	}
	
	
	public void updateComment(Comment comment)
	{
		try
    	{
    		PreparedStatement preparedStatement = connection.prepareStatement("UPDATE COMMENT SET COMMENT_CONTENT = ?, COMMENT_DATE = CURDATE() WHERE COMMENT_ID = ?;");
    		preparedStatement.setString(1, comment.getCommentContent());
    		preparedStatement.setInt(2, comment.getCommentID());
    		int statut = preparedStatement.executeUpdate();
  
    		System.out.println(statut);
    	}
    	catch(SQLException e)
    	{
    		e.printStackTrace();
    	}
	}
	
	
	public void deleteComment(Comment comment)
	{
		try
    	{
    		PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM COMMENT WHERE COMMENT_ID = ?;");
    		preparedStatement.setInt(1, comment.getCommentID());
    		int statut = preparedStatement.executeUpdate();
    		
    		System.out.println(statut);
    	}
    	catch(SQLException e)
    	{
    		e.printStackTrace();
    	}
	}
}
