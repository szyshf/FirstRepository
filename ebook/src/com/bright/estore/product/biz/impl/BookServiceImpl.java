package com.bright.estore.product.biz.impl;

import java.util.List;

import com.bright.estore.product.biz.IBookService;
import com.bright.estore.product.dao.IBookDAO;
import com.bright.estore.product.dao.impl.BookSqlServerDAOImpl;

public class BookServiceImpl implements IBookService {

	public List getAllBooks() {
		// TODO Auto-generated method stub
		IBookDAO bookDAO = new BookSqlServerDAOImpl();
		return bookDAO.getAllBooks();
	}

	public List getBookByIsbn(String isbn) {
		// TODO Auto-generated method stub
		IBookDAO bookDAO = new BookSqlServerDAOImpl();
		return bookDAO.getBookByIsbn(isbn);
	}

}
