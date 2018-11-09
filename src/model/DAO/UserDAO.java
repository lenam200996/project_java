package model.DAO;

import java.sql.Statement;

import model.bean.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
	private String user = "sa";
	private String password = "1";
	private String url = "jdbc:sqlserver://localhost:1433;databaseName=DATA076";
	Connection myConnection;
	private User myUser;
	public void connect()
	{
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			myConnection  = DriverManager.getConnection(url, user, password);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean checkLogin(String us, String pw) {
		connect();
		String sqlSelect = "select * from users where username = '"+us+"' and password ='"+pw+"'";
		Statement myStatement = null ;
		try {
			myStatement = myConnection.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ResultSet myResultSet = null;
		
		try {
			myResultSet = myStatement.executeQuery(sqlSelect);
			if(myResultSet.next()) {
				String fullname = myResultSet.getString(4);
				String username = myResultSet.getString(2);
				String password = myResultSet.getString(3);
				 myUser= new User(username, password, fullname);
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
}
