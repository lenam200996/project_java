package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.Book;



public class BookDAO {
	private String url = "jdbc:sqlserver://localhost:1433;databaseName=Data076";
	private String username ="sa";
	private String password ="123456";
	public Connection myC;
	ArrayList<Book> arr = new ArrayList<>();
	public void connect() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			myC = DriverManager.getConnection(url,username,password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public ArrayList<Book> getList(String username){
		connect();
		String sql = "select * from Books join Users on Books.UserID = Users.UserID where username='"+username+"'";
		try {
			Statement st = myC.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				Book b = new Book();
				b.setTensach(rs.getString("tensach"));
				b.setNamsx(rs.getString("namsx"));
				b.setNhaxb(rs.getString("nhasx"));
				b.setSoluong(rs.getInt("soluong"));
				
				arr.add(b);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arr;
	}
	
}
