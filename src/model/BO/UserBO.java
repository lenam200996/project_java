package model.BO;

import model.DAO.UserDAO;
import model.bean.User;

public class UserBO {
	UserDAO u = new UserDAO();
	
	public boolean checkLogin(String us, String pw) {
		return u.checkLogin(us, pw);
	}
	
	public User getUser() {
		return u.getUser();
	}
	public boolean editProfile(String username, String fullname) {
		return u.editProfile(username, fullname);
	}
}
