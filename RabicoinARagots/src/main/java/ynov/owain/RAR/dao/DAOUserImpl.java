package ynov.owain.RAR.dao;

import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;

import ynov.owain.RAR.dao.model.User;

public class DAOUserImpl implements DAOUser{

	
	private Connection connection;
	
	
	public DAOUserImpl(Connection co) {
		// TODO Auto-generated constructor stub
		this.connection = co;
	}
	
	
	public User getUser(Integer userID)
    {
		User user = new User();
		try
    	{
    		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM USER WHERE USER_ID=?;");
    		preparedStatement.setInt(1, userID);
    		
    		ResultSet result = preparedStatement.executeQuery();
    		while(result.next())
    		{
    			user.setUserID(result.getInt("USER_ID"));
    			user.setFirstname(result.getString("FIRSTNAME"));
    			user.setLastname(result.getString("LASTNAME"));
    			user.setLogin(result.getString("LOGIN"));
    			user.setPassword(result.getString("PASSWORD"));
    		}
    	}
    	catch(SQLException e)
    	{
    		e.printStackTrace();
    	}
		return user;
    }
	
	
	public User login(String login, String password)
    {
		User user = new User();
		try
    	{
    		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM USER WHERE LOGIN = ? AND PASSWORD = ?;");
    		preparedStatement.setString(1, login);
    		preparedStatement.setString(2, password);
    		
    		ResultSet result = preparedStatement.executeQuery();
    		while(result.next())
    		{
    			user.setUserID(result.getInt("USER_ID"));
    			user.setFirstname(result.getString("FIRSTNAME"));
    			user.setLastname(result.getString("LASTNAME"));
    			user.setLogin(result.getString("LOGIN"));
    			user.setPassword(result.getString("PASSWORD"));
    		}
    	}
    	catch(SQLException e)
    	{
    		e.printStackTrace();
    	}
		
		return user;
    }
	
	
	public void addUser(User user)
	{
		try
    	{
    		PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO USER (FIRSTNAME, LASTNAME, LOGIN, PASSWORD) VALUES(?, ?, ?, ?);");
    		preparedStatement.setString(1, user.getFirstname());
    		preparedStatement.setString(2, user.getLastname());
    		preparedStatement.setString(3, user.getLogin());
    		preparedStatement.setString(4, user.getPassword());
    		int statut = preparedStatement.executeUpdate();
    		
    		System.out.println(statut);
    	}
    	catch(SQLException e)
    	{
    		e.printStackTrace();
    	}
	}
	
}
