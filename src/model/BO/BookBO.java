package model.BO;

import java.util.ArrayList;

import model.DAO.BookDAO;
import model.bean.Book;

public class BookBO {
	BookDAO b = new BookDAO();
	public ArrayList<Book> getList(String username){
		return b.getList(username);
	}
}
