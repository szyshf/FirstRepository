package com.bright.estore.product.model;

import java.io.Serializable;

public class BookModel implements Serializable {
	 
	 private String isbn;
	 private String titles;
	 private int editionNumber;
	 private String copyright;
	 private int publisherID;
	 private String imageFile;
	 private double price;
	public String getCopyright() {
		return copyright;
	}
	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}
	public int getEditionNumber() {
		return editionNumber;
	}
	public void setEditionNumber(int editionNumber) {
		this.editionNumber = editionNumber;
	}
	public String getImageFile() {
		return imageFile;
	}
	public void setImageFile(String imageFile) {
		this.imageFile = imageFile;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getPublisherID() {
		return publisherID;
	}
	public void setPublisherID(int publisherID) {
		this.publisherID = publisherID;
	}
	public String getTitles() {
		return titles;
	}
	public void setTitles(String titles) {
		this.titles = titles;
	}
	 
}
