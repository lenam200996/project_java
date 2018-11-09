package model.BO;

import model.DAO.UserDAO;

public class UserBO {
	private UserDAO myUserDAO = new UserDAO();
	public boolean checkLogin(String us, String pw) {
		return myUserDAO.checkLogin(us, pw);
	}
	
}
