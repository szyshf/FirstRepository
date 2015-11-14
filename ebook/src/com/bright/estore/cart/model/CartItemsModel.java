package com.bright.estore.cart.model;

import java.io.Serializable;

import com.bright.estore.product.model.BookModel;

public class CartItemsModel implements Serializable {

	private BookModel bookModel;

	private int qty;

	public CartItemsModel(BookModel bookModel, int i) {
		// TODO Auto-generated constructor stub
		this.bookModel = bookModel;
		this.qty = i;
	}

	public BookModel getBookModel() {
		return bookModel;
	}

	public void setBookModel(BookModel bookModel) {
		this.bookModel = bookModel;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}
}
