package com.bright.estore.product.dao;

import java.util.List;

public interface IBookDAO {
	
	public List getAllBooks();

	public List getBookByIsbn(String isbn);
	
}
