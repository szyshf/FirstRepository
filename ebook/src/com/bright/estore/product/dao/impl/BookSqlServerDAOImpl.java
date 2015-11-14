package com.bright.estore.product.dao.impl;

import java.util.*;

import com.bright.estore.product.dao.IBookDAO;
import com.bright.estore.product.model.BookModel;
import com.bright.util.Utils;

import java.sql.*;

public class BookSqlServerDAOImpl implements IBookDAO {

	public List getAllBooks() {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		List bookList = new ArrayList();
		try {
			conn = Utils.getConnection();
			String sql = "select * from titles";
			pstmt = conn.prepareStatement(sql);
			rst = pstmt.executeQuery();
			BookModel bookModel = null;
			while (rst.next()) {
				bookModel = new BookModel();
				bookModel.setIsbn(rst.getString("isbn"));
				bookModel.setCopyright(rst.getString("copyright"));
				bookModel.setEditionNumber(rst.getInt("editionNumber"));
				bookModel.setImageFile(rst.getString("imageFile"));
				bookModel.setPrice(rst.getDouble("price"));
				bookModel.setPublisherID(rst.getInt("publisherID"));
				bookModel.setTitles(rst.getString("title"));
				bookList.add(bookModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Utils.close(rst,pstmt,conn);
		}
		return bookList;
	}

	public List getBookByIsbn(String isbn) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		List bookList = new ArrayList();
		try {
			conn = Utils.getConnection();
			String sql = "select * from titles where isbn = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, isbn);
			rst = pstmt.executeQuery();
			BookModel bookModel = null;
			while (rst.next()) {
				bookModel = new BookModel();
				bookModel.setIsbn(rst.getString("isbn"));
				bookModel.setCopyright(rst.getString("copyright"));
				bookModel.setEditionNumber(rst.getInt("editionNumber"));
				bookModel.setImageFile(rst.getString("imageFile"));
				bookModel.setPrice(rst.getDouble("price"));
				bookModel.setPublisherID(rst.getInt("publisherID"));
				bookModel.setTitles(rst.getString("title"));
				bookList.add(bookModel);

			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			Utils.close(rst, pstmt, conn);
		}
		return bookList;
	}
}
