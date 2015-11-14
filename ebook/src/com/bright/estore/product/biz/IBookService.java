package com.bright.estore.product.biz;

import java.util.List;

public interface IBookService {
	
	public List getAllBooks();

	public List getBookByIsbn(String isbn);
	
}
