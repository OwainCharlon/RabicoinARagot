package ynov.owain.RAR.dao;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class MySQLManager {
	
	private Statement statement = null;
    private Connection connection = null;
    private String url = "jdbc:mysql://localhost:3306/RabicoinARagots";
    private String utilisateur = "root";
    private String motDePasse = "";
    
    static MySQLManager instance;  
    
    
    public Connection getConnection() 
    {
		return connection;
	}
    
    
    public static synchronized MySQLManager getInstance()
	{
		if(instance == null)
		{
			instance = new MySQLManager();
		}	
		return instance;
	}
    
    
    private MySQLManager() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(url, utilisateur, motDePasse);
            this.statement = this.connection.createStatement();
            }
        
        catch(ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        catch(SQLException e) {
        	System.out.println(e.getMessage());
        }      
    }
    
    
    @Override
    protected void finalize() throws Throwable 
    {
    	super.finalize();
    	// TODO Auto-generated method stub
    	if(connection != null) {
            try {
                connection.close();
            }
            catch (SQLException e) {
                //Ignore.
            }
        }
    }
}
