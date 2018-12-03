package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.bean.User;

public class UserDAO {
	private String url = "jdbc:sqlserver://localhost:1433;databaseName=Data076";
	private String username ="sa";
	private String password ="123456";
	public Connection myC;
	User u = new User();
	public void connect() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			myC = DriverManager.getConnection(url,username,password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean checkLogin(String us, String pw) {
		connect();
		String sql = "select * from Users where username = '"+us.trim()+"' and password = '"+pw.trim()+"'";
		try {
			Statement st = myC.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) {
				u.setUsername(us);
				u.setPassword(pw);
				u.setFullname(rs.getString("fullname"));
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return false;
		
	}
	
	public User getUser() {
		return u;
	}
	
	public boolean editProfile(String username, String fullname) {
		connect();
		String sql = "update Users set fullname ='"+fullname.trim()+"' where username = '"+username.trim()+"'";
		try {
			Statement st = myC.createStatement();
			int rs = st.executeUpdate(sql);
			if(rs > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return false;
		
	}
}
